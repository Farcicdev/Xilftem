package com.xilften.controller.response;

import lombok.Builder;

@Builder
public record UsersResponse(
        Long id,
        String name,
        String email
) {
}
