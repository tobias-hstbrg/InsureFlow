package de.insureflow.customer_service.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CustomerResponse(
        @Schema(description = "Customers UUID", example = "6c6207be-5a3b-4546-a231-d238161f5153")
        UUID id,
        @Schema(description = "Customers lastname", example = "Doe")
        String surname,
        @Schema(description = "Customers firstname", example = "John")
        String forename,
        @Schema(description = "Customers unique email address", example = "john.doe@example.com")
        String emailAddress,
        @Schema(description = "List of addresses connected to a user")
        List<AddressResponse> address,
        @Schema(description = "Date of birth", example = "1990-03-22")
        LocalDate birthdate) {
}