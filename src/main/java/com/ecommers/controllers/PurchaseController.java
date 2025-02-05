package com.ecommers.controllers;

import com.ecommers.dto.PurchaseDTO;
import com.ecommers.entities.PurchaseEntity;
import com.ecommers.services.PurchaseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/purchases")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseController {

    @Inject
    PurchaseService purchaseService;

            @POST
    public Response createPurchase(PurchaseDTO purchaseDTO) {
        try {
            PurchaseEntity purchase = purchaseService.createPurchase(purchaseDTO);
            return Response.status(Response.Status.CREATED).entity(purchase).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
            }
}
