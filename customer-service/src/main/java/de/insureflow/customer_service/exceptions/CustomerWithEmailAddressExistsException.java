package de.insureflow.customer_service.exceptions;

public class CustomerWithEmailAddressExistsException extends RuntimeException{
    public CustomerWithEmailAddressExistsException(String email) {
        super("Customer with email " + email + " already exists");
    }
}
