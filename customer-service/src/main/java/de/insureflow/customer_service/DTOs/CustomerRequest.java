package de.insureflow.customer_service.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

public record CustomerRequest(
        @Schema(description = "Customers lastname", example = "Doe")
        String surname,
        @Schema(description = "Customers firstname", example = "John")
        String forename,
        @Schema(description = "Customers unique email address", example = "john.doe@example.com")
        String emailAddress,
        @Schema(description = "List of addresses connected to a user")
        List<AddressRequest> address,
        @Schema(description = "Date of birth", example = "1990-03-22")
        LocalDate birthdate
) {}
