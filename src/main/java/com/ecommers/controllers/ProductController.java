package com.ecommers.controllers;

import com.ecommers.dto.ProductDTO;
import com.ecommers.entities.ProductEntity;
import com.ecommers.services.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var products = productService.findAll(page, pageSize);
        return Response.ok(products).build();
    }

    @POST
    @Transactional
    public Response createProduct(@Valid ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(Double.parseDouble(productDTO.getPrice()));
        productEntity.setQuantity(Integer.parseInt(productDTO.getQuantity()));

        return Response.ok(productService.createProduct(productEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateProduct(@PathParam("id") Long productId, ProductEntity productEntity) {
        return Response.ok(productService.updateProduct(productId, productEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long productId) {
        return Response.ok(productService.findById(productId)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletProduct(@PathParam("id") Long productId) {
        productService.deletById(productId);
        return Response.noContent().build();
    }
}
