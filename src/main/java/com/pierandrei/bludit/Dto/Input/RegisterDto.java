package com.pierandrei.bludit.Dto.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record RegisterDto(
        @NotBlank @Size(max = 256, message = "ERRO with in your email!")
        String email,

        @NotBlank @Size(min = 3, max = 40, message = "Must contain 3 to 40 characters!")
        String username,

        @NotBlank @Size(min = 8, max = 30, message = "Must contain 8 to 30 characters!")
        String password,

        @NotBlank @Size(max = 14, message = "ERRO with in your phone!")
        String phone,

        @NotNull
        LocalDateTime dateBorn









) {
}
