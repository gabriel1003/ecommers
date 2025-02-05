package com.ecommers.dto;

import java.util.List;

public class PurchaseDTO {

    private String cpf;
    private List<ProductRequestDTO> products;

    public PurchaseDTO() {
    }

    public PurchaseDTO(String cpf, List<ProductRequestDTO> products) {
        this.cpf = cpf;
        this.products = products;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProductRequestDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRequestDTO> products) {
        this.products = products;
    }
}
