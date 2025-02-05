package com.ecommers.controllers;

import com.ecommers.dto.PurchaseDTO;
import com.ecommers.entities.PurchaseEntity;
import com.ecommers.services.PurchaseService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
    public Response createPurchase(@Valid PurchaseDTO purchaseDTO) {
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setTotalQuantity(purchaseDTO.getTotalQuantity());
        return Response.ok(purchaseService.createPurchase(purchaseDTO)).build();
    }
}
