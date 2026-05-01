package de.insureflow.customer_service.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

public record AddressRequest(
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
