package de.insureflow.customer_service.repository;

import de.insureflow.customer_service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    List<Customer> findBySurname(String surname);
    Optional<Customer> findByEmailAddress(String email);
    boolean existsByEmailAddress(String email);
}
