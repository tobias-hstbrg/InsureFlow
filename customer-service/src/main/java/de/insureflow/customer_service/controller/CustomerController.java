package de.insureflow.customer_service.controller;

import de.insureflow.customer_service.DTOs.CustomerRequest;
import de.insureflow.customer_service.DTOs.CustomerResponse;
import de.insureflow.customer_service.domain.Customer;
import de.insureflow.customer_service.mapper.CustomerMapper;
import de.insureflow.customer_service.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer Controller", description = "CRUD operations for customers")
public class CustomerController {

    private final CustomerService service;
    private final CustomerMapper mapper;
    CustomerController(CustomerService service, CustomerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all customers")
    @GetMapping
    List<CustomerResponse> getAllCustomers() {
        return service.fetchAllCustomers().stream().map(mapper::toResponse).toList();
    }

    @Operation(summary = "Get customer by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customer found"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<CustomerResponse> getCustomerById(@PathVariable UUID id) {
        return service.fetchCustomerById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 customer not found
    }

    @Operation(summary = "Create a new customer")
    @ApiResponse(responseCode = "201", description = "Customer created")
    @ApiResponse(responseCode = "409", description = "Email already exists")
    @PostMapping
    ResponseEntity<CustomerResponse> createNewCustomer(@RequestBody CustomerRequest customer) {
        Customer created = service.addNewCustomer(mapper.toEntity(customer));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));
    }
}
