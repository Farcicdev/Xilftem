package com.xilften.controller.response;

import lombok.Builder;

@Builder
public record StreamingResponse(String name, Long id) {
}
