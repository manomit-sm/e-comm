package com.bsolz.product.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record RequestBrand(
        @NotNull(message = "Name is required")
        @NotEmpty(message = "Name should not be empty")
        String name,
        @NotNull(message = "Description is required")
        @NotEmpty(message = "Description should not be empty")
        String description,
        @NotNull(message = "Image is required")
        MultipartFile image
) {
}
