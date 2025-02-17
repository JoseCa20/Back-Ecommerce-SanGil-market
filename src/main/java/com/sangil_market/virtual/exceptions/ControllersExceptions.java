package com.sangil_market.virtual.exceptions;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllersExceptions {

    @ExceptionHandler({PasswordIncorrectException.class, EmailValidationException.class, InvalidInputException.class,
    OperationNotAllowedException.class, ResourceNotFoundException.class, UserNotFoundException.class, ResourceAlreadyExists.class})
    public ProblemDetail badRequestException(RuntimeException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({UnauthorizedException.class, AuthenticationException.class, JWTVerificationException.class})
    public ProblemDetail unauthorizedException(AuthenticationException authenticationException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, authenticationException.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail accessDeniedException(AccessDeniedException accessDeniedException) {
        return 	ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, accessDeniedException.getMessage());
    }



}
