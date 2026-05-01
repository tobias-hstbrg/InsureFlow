package de.insureflow.customer_service.DTOs;

import java.util.UUID;

public record AddressResponse(
        UUID id,
        String streetname,
        String houseNumber,
        String postcode,
        String city,
        String country
) {}
