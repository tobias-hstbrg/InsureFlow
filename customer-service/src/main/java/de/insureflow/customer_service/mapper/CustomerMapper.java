package de.insureflow.customer_service.mapper;

import de.insureflow.customer_service.DTOs.AddressRequest;
import de.insureflow.customer_service.DTOs.AddressResponse;
import de.insureflow.customer_service.DTOs.CustomerRequest;
import de.insureflow.customer_service.DTOs.CustomerResponse;
import de.insureflow.customer_service.domain.Address;
import de.insureflow.customer_service.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
    public CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(customer.getInsuranceId(),
                customer.getSurname(),
                customer.getForename(),
                customer.getEmailAddress(),
                customer.getAddress().stream()
                        .map(this::toResponse).toList(),
                customer.getBirthdate()
        );
    }

    public AddressResponse toResponse(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getStreetname(),
                address.getHouseNumber(),
                address.getPostcode(),
                address.getCity(),
                address.getCountry()
        );
    }

    public Customer toEntity(CustomerRequest request) {
        List<Address> addresses = request.address().stream()
                .map(this::toEntity)
                .toList();

        return Customer.builder()
                .surname(request.surname())
                .forename(request.forename())
                .emailAddress(request.emailAddress())
                .birthdate(request.birthdate())
                .address(addresses)
                .build();
    }

    public Address toEntity(AddressRequest request) {
        return Address.builder()
                .streetname(request.streetname())
                .houseNumber(request.houseNumber())
                .postcode(request.postcode())
                .city(request.city())
                .country(request.country())
                .build();
    }
}
