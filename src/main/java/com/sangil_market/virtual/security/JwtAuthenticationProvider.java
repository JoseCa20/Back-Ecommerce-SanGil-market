package com.sangil_market.virtual.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sangil_market.virtual.domain.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class JwtAuthenticationProvider {

    @Value("${jwt.secret.key}")
    private String SecretKey;

    /**
     * lista blanca con los jwt creados
     */
    private HashMap<String, UserDto> listToken = new HashMap<>();

    public String createToken(UserDto userDtoJwt){

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);

        Algorithm algorithm = Algorithm.HMAC256(SecretKey);

        String tokenCreated = JWT.create()
                .withClaim("idCard", userDtoJwt.getIdCard())
                .withClaim("username", userDtoJwt.getUsername())
                .withClaim("phone", userDtoJwt.getPhone())
                .withClaim("address", userDtoJwt.getAddress())
                .withClaim("email", userDtoJwt.getEmail())
                .withClaim("role", userDtoJwt.getRole())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        listToken.put(tokenCreated, userDtoJwt);
        return tokenCreated;
    }

    public Authentication validateToken(String token) throws AuthenticationException {

        JWT.require(Algorithm.HMAC256(SecretKey)).build().verify(token);

        UserDto exists = listToken.get(token);
        if (exists == null){
            throw new BadCredentialsException("Usuario no registrado");
        }

        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_"+exists.getRole()));
        rolesAndAuthorities.add(new SimpleGrantedAuthority("WRITE_PRIVILEGE"));

        return new UsernamePasswordAuthenticationToken(exists, token, rolesAndAuthorities);
    }

    public String deleteToken(String jwt){
        if(!listToken.containsKey(jwt)){
            return "No existe token";
        }
        listToken.remove(jwt);
        return "Sesión cerrada exitosamente";
    }
}
