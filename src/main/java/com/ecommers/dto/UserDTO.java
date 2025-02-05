package com.ecommers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public class UserDTO {

@NotBlank(message = "O nome do usuário não pode ser nulo.")
    private String name;

@NotBlank(message = "O CPF é obrigatório.")
@CPF(message = "O CPF é inválido.")
    private String cpf;

@NotBlank(message = "O Email é obrigatório.")
@Email(message = "O Email é inválido.")
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
