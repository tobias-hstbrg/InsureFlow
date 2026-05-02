package de.insureflow.customer_service;

import de.insureflow.customer_service.domain.Address;
import de.insureflow.customer_service.domain.Customer;
import de.insureflow.customer_service.exceptions.CustomerWithEmailAddressExistsException;
import de.insureflow.customer_service.repository.CustomerRepository;
import de.insureflow.customer_service.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @Mock
    CustomerRepository repo;

    @InjectMocks
    CustomerService service;

    Customer testCustomer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        var testAddresses = List.of(
                Address.builder()
                        .streetname("Hauptstraße")
                        .houseNumber("15a")
                        .postcode("10115")
                        .city("Berlin")
                        .country("Germany")
                        .build()
        );

        testCustomer = Customer.builder()
                .insuranceId(UUID.randomUUID())
                .surname("Doe")
                .forename("Joe")
                .emailAddress("john.doe@example.com")
                .birthdate(LocalDate.of(1990, 5, 15))
                .address(testAddresses)
                .build();
    }

    @Test
    void addNewCustomer_shouldThrowException_whenEmailAlreadyExists() {
        // Arrange: set up the mock to return true
        when(repo.existsByEmailAddress("john.doe@example.com")).thenReturn(true);

        // Act & Assert
        assertThrows(CustomerWithEmailAddressExistsException.class, () -> service.addNewCustomer(testCustomer));
    }

    @Test
    void addNewCustomer_shouldSaveCustomer_whenEmailIsNew() {
        when(repo.existsByEmailAddress("john.doe@example.com")).thenReturn(false);

        service.addNewCustomer(testCustomer);

        verify(repo).save(testCustomer);
    }

    @Test
    void findCustomers_shouldBeTrue_whenMethodWorks() {
        when(repo.findAll()).thenReturn(List.of( testCustomer));

        List<Customer> result = service.fetchAllCustomers();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(testCustomer.getSurname(), result.getFirst().getSurname());
    }

    @Test
    void fetchCustomerById_shouldReturnCustomer_WhenIdIsFound() {
        when(repo.findById(testCustomer.getInsuranceId())).thenReturn(Optional.of(testCustomer));

        Optional<Customer> resultCustomer = service.fetchCustomerById(testCustomer.getInsuranceId());

        assertTrue(resultCustomer.isPresent());
        assertEquals(testCustomer, resultCustomer.get());
    }
}
