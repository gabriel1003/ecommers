package com.ecommers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductRequestDTO(
        @NotBlank(message = "O nome não pode ser nulo.")
        String name,
        @Positive(message = "A quantidade deve ser maior que zero.")
        Integer quantity
) {
}
