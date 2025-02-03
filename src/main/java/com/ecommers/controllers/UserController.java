package com.ecommers.controllers;

import com.ecommers.entities.UserEntity;
import com.ecommers.services.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var users = usuarioService.findAll(page, pageSize);
        return Response.ok(users).build();
    }

    @POST
    @Transactional
    public Response createUser(UserEntity userEntity) {
        return Response.ok(usuarioService.createUser(userEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long userId, UserEntity userEntity) {
        return Response.ok(usuarioService.updateUser(userId, userEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long userId) {
        return Response.ok(usuarioService.findById(userId)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long userId) {
        usuarioService.deleteById(userId);
        return Response.noContent().build();
    }
}
