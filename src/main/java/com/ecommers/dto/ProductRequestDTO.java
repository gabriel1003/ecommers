package com.ecommers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductRequestDTO {
        @NotBlank(message = "O nome não pode ser nulo.")
        private String name;

        @Positive(message = "A quantidade deve ser maior que zero.")
        private Integer quantity;

        public ProductRequestDTO() {
        }

        public ProductRequestDTO(String name, Integer quantity) {
                this.name = name;
                this.quantity = quantity;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getQuantity() {
                return quantity;
        }

        public void setQuantity(Integer quantity) {
                this.quantity = quantity;
        }
}