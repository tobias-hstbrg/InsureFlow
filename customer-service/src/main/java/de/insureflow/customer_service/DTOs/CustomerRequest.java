package de.insureflow.customer_service.DTOs;

import java.time.LocalDate;
import java.util.List;

public record CustomerRequest(
        String surname,
        String forename,
        String emailAddress,
        List<AddressRequest> address,
        LocalDate birthdate
) {}
