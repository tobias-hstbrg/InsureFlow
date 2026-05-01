package de.insureflow.customer_service.DTOs;

public record AddressRequest(
        String streetname,
        String houseNumber,
        String postcode,
        String city,
        String country
) {}
