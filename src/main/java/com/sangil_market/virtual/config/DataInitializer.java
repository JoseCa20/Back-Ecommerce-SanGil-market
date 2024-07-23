package com.sangil_market.virtual.config;

import com.sangil_market.virtual.domain.dto.AdministratorDto;
import com.sangil_market.virtual.domain.repository.IAdministratorRepository;
import com.sangil_market.virtual.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final IAdministratorRepository iAdministratorRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${admin.default.username}")
    private String username;

    @Value("${admin.default.password}")
    private String password;

    @Value("${admin.default.email}")
    private String email;

    @Value("${admin.default.role}")
    private String role;

    @Override
    public void run(String... args) throws Exception {
        if (iAdministratorRepository.getAdministratorByRole(role).isEmpty()) {

            AdministratorDto admin = new AdministratorDto();
            admin.setRole(role);
            admin.setUsername(username);
            admin.setPassword(passwordEncoder.encode(password));
            iAdministratorRepository.save(admin);
        }

    }
}
