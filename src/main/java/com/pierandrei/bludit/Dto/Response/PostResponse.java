package com.pierandrei.bludit.Dto.Response;

import java.time.LocalDateTime;

public record PostResponse(String usernameOwner, String title, LocalDateTime acceptAt, String content) {
}
