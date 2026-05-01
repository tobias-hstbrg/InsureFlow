package de.insureflow.customer_service.service;

import de.insureflow.customer_service.domain.Address;
import de.insureflow.customer_service.domain.Customer;
import de.insureflow.customer_service.exceptions.CustomerWithEmailAddressExistsException;
import de.insureflow.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository repo;
    CustomerService(CustomerRepository repository)
    {
        this.repo = repository;
    }

    public List<Customer> fetchAllCustomers()
    {
        return repo.findAll();
    }

    public Optional<Customer> fetchCustomerById(UUID insuranceId) {
        return repo.findById(insuranceId);
    }

    public Customer addNewCustomer(Customer customer) {
        if(repo.existsByEmailAddress(customer.getEmailAddress()))
            throw new CustomerWithEmailAddressExistsException(customer.getEmailAddress());

        for (Address address : customer.getAddress()) {
            address.setCustomer(customer);
        }
        repo.save(customer);
        return customer;
    }
}
