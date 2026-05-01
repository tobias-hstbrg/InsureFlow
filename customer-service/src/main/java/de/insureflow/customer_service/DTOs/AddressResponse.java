package de.insureflow.customer_service.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record AddressResponse(
        @Schema(description = "Unique identifier for the address", example = "7d987057-1eaa-4727-bd86-54739beece4a")
        UUID id,
        @Schema(description = "streetname", example = "Lancaster Road")
        String streetname,
        @Schema(description = "housenumber", example = "256b")
        String houseNumber,
        @Schema(description = "postcode/zipcode", example = "LA1 1AE")
        String postcode,
        @Schema(description = "city name", example = "Lancaster")
        String city,
        @Schema(description = "country of address", example = "England")
        String country
) {}
