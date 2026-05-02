package de.insureflow.customer_service;

import de.insureflow.customer_service.DTOs.AddressRequest;
import de.insureflow.customer_service.DTOs.AddressResponse;
import de.insureflow.customer_service.DTOs.CustomerRequest;
import de.insureflow.customer_service.DTOs.CustomerResponse;
import de.insureflow.customer_service.domain.Address;
import de.insureflow.customer_service.domain.Customer;
import de.insureflow.customer_service.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMapperTest {
    CustomerMapper mapper = new CustomerMapper();

    @Test
    void toResponse_shouldMapCustomerToResponse() {
        List<Address> addresses = List.of(
                Address.builder()
                        .id(UUID.randomUUID())
                        .streetname("Hauptstraße")
                        .houseNumber("15a")
                        .postcode("10115")
                        .city("Berlin")
                        .country("Germany")
                        .build(),
                Address.builder()
                        .id(UUID.randomUUID())
                        .streetname("Freiheitsallee")
                        .houseNumber("523")
                        .postcode("80331")
                        .city("München")
                        .country("Germany")
                        .build()
        );

        Customer customer = Customer.builder()
                .insuranceId(UUID.randomUUID())
                .surname("Doe")
                .forename("Joe")
                .emailAddress("john.doe@example.com")
                .birthdate(LocalDate.of(1990,5,15))
                .address(addresses)
                .build();

        CustomerResponse response = mapper.toResponse(customer);

        assertEquals(customer.getSurname(), response.surname());
        assertEquals(customer.getForename(), response.forename());
        assertEquals(customer.getEmailAddress(), response.emailAddress());
        assertEquals(customer.getBirthdate(), response.birthdate());
        assertEquals(2, response.address().size());
    }

    @Test
    void toResponse_shouldMapAddressToResponse() {
        Address address =
                Address.builder()
                        .id(UUID.randomUUID())
                        .streetname("Hauptstraße")
                        .houseNumber("15a")
                        .postcode("10115")
                        .city("Berlin")
                        .country("Germany")
                        .build();

        AddressResponse response = mapper.toResponse(address);

        assertEquals(address.getStreetname(), response.streetname());
        assertEquals(address.getHouseNumber(), response.houseNumber());
        assertEquals(address.getPostcode(), response.postcode());
        assertEquals(address.getCity(), response.city());
        assertEquals(address.getCountry(), response.country());
    }

    @Test
    void toEntity_shouldMapCustomerRequestToEntity() {
        List<AddressRequest> addresses = List.of(
                new AddressRequest("Hauptstraße", "15a", "10115", "Berlin", "Germany"),
                new AddressRequest("Freiheitsallee", "523", "80331", "München", "Germany")
        );

        CustomerRequest customerReq = new CustomerRequest(
                "Doe",
                "John",
                "john.doe@example.com",
                addresses,
                LocalDate.of(1990, 5, 15));

        Customer customer = mapper.toEntity(customerReq);

        assertEquals(customerReq.surname(), customer.getSurname());
        assertEquals(customerReq.forename(), customer.getForename());
        assertEquals(customerReq.emailAddress(), customer.getEmailAddress());
        assertEquals(2, customer.getAddress().size());
        assertEquals(customerReq.birthdate(), customer.getBirthdate());
    }

    @Test
    void toEntity_shouldMapAddressRequestToEntity() {
        AddressRequest addressReq =
                new AddressRequest("Hauptstraße", "15a", "10115", "Berlin", "Germany");

        Address address = mapper.toEntity(addressReq);

        assertEquals(addressReq.streetname(), address.getStreetname());
        assertEquals(addressReq.houseNumber(), address.getHouseNumber());
        assertEquals(addressReq.postcode(), address.getPostcode());
        assertEquals(addressReq.city(), address.getCity());
        assertEquals(addressReq.country(), address.getCountry());
    }
}
