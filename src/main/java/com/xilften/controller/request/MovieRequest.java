package com.xilften.controller.request;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        String title,
        String description,
        double ratting,
        LocalDate releaseDate,
        List<Long> categories,
        List<Long> streamings
) {
}
