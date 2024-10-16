package com.pierandrei.bludit.Dto.Input;

import jakarta.validation.constraints.NotEmpty;

public record LoginDto(String email, @NotEmpty String password) {
}
