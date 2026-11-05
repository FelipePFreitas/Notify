package com.felipefreitas.notify.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(

        @NotBlank(message = "O nome não pode ser nulo ou vazio")
        String nome,
        @NotBlank(message = "O email não pode ser nulo ou vazio")
        String email
) {
}
