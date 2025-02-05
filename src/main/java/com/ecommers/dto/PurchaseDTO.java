package com.ecommers.dto;

import java.util.List;

public class PurchaseDTO {

    private String cpf;
    private List<String> products;

    public PurchaseDTO() {
    }

    public PurchaseDTO(String cpf, List<String> products) {
        this.cpf = cpf;
        this.products = products;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
