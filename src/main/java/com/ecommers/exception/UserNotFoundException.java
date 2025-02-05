package com.ecommers.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class UserNotFoundException extends WebApplicationException {

    public UserNotFoundException() {
        super(Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado.").type("text/plain").build());
    }

    public UserNotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND).entity(message).type("text/plain").build());
    }
}
