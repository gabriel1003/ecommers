package com.ecommers.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class InsufficientStockException extends WebApplicationException {

    public InsufficientStockException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST).entity(message).type("text/plain").build());
    }
}
