package com.pierandrei.bludit.Dto.Response;

import com.pierandrei.bludit.Enum.Roles;

public record RegisterResponse(String token, String username, Roles role) {
}
