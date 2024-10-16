package com.pierandrei.bludit.Dto.Response;

import com.pierandrei.bludit.Enum.Roles;

public record LoginResponse(String token, String username, Roles role) {
}
