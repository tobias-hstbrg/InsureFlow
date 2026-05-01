package de.insureflow.customer_service.DTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String surname,
        String forename,
        String emailAddress,
        List<AddressResponse> address,
        LocalDate birthdate) {
}