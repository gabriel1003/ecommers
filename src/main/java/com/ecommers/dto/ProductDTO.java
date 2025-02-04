package com.ecommers.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProductDTO {
    @NotBlank(message = "O nome do produto é obrigatório.")
    private String name;

    @Pattern(regexp = "^(?!0(\\.0+)?$)(\\d+(\\.\\d{1,2})?)$", message = "O preço não pode ser igual ou menor que zero e tem que ter duas casas decimais.")
    private String price;

    private int quantity;

    public ProductDTO() {
    }

    public ProductDTO(String name, String price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
