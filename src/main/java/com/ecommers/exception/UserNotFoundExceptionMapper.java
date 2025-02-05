package com.ecommers.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    private static final String DEFAULT_MESSAGE = "Usuário não encontrado.";

    @Override
    public Response toResponse(UserNotFoundException exception) {
        String message = (exception.getMessage() != null && !exception.getMessage().isEmpty()) ?
                exception.getMessage() : DEFAULT_MESSAGE;

        return Response.status(Response.Status.NOT_FOUND)
                .entity(message)
                .type("text/plain")
                .build();
    }
}