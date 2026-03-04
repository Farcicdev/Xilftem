package com.xilften.controller.request;

import jakarta.validation.constraints.*;

public record UsersRequest(
        @NotNull(message = "O nome não pode ser nulo")
        String name,

        @NotNull(message = "O e-mail não pode ser nulo")
        @NotEmpty(message = "O e-mail não pode ser vazio")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "A senha não pode ser vazia")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String password
) {
}
