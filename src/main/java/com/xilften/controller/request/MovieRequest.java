package com.xilften.controller.request;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        String title,
        String description,
        double rating,
        LocalDate releaseDate,
        List<Long> categories,
        List<Long> streamings
) {
}
