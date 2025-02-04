package com.ecommers.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProductDTO {
    @NotBlank(message = "O nome do produto é obrigatório.")
    private String name;

    @Pattern(regexp = "^(?!0(\\.0+)?$)([1.9]\\d*\\.\\d{2}|0\\.\\d{2})$", message = "O preço não pode ser igual ou menor que zero e tem que ter duas casas decimais.")
    private String price;

    @Pattern(regexp = "^[1-9]\\d*$", message = "A quantidade de produtos cadastrados tem que ser maior que zero.")
    private String quantity;

    public ProductDTO() {
    }

    public ProductDTO(String name, String price, String quantity) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
