package com.ecommers.dto;

import java.util.List;

public class PurchaseDTO {

    private String cpf;
    private List<RequestProductDTO> products;

    public PurchaseDTO() {
    }

    public PurchaseDTO(String cpf, List<RequestProductDTO> products) {
        this.cpf = cpf;
        this.products = products;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<RequestProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<RequestProductDTO> products) {
        this.products = products;
    }
}
