package com.ecommers.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {

@NotBlank(message = "O nome do usuário não pode ser nulo.")
    private String name;
    private String cpf;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
