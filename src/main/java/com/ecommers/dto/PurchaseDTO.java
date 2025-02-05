package com.ecommers.dto;

import java.util.List;

public class PurchaseDTO {

    private String cpf;
    private List<ProductRequestDTO> products;

    private int totalQuantity;

    public PurchaseDTO() {
    }

    public PurchaseDTO(String cpf, List<ProductRequestDTO> products, int totalQuantity) {
        this.cpf = cpf;
        this.products = products;
        this.totalQuantity = totalQuantity;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}