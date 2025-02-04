package com.ecommers.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class EmailAlreadyExistsException extends WebApplicationException {

    public EmailAlreadyExistsException(String message) {
        super(Response.status(Response.Status.CONFLICT).entity(message).type("text/plain").build());
    }
}
