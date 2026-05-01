package de.insureflow.customer_service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerWithEmailAddressExistsException.class)
    public ResponseEntity<ErrorResponse> handleCustomerWithEmailExists(CustomerWithEmailAddressExistsException ex) {
      return ResponseEntity.status(409).body(new ErrorResponse(409, ex.getMessage()));
    }
}
