package de.insureflow.customer_service.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID insuranceId;

    String surname;
    String forename;
    String emailAddress;
    LocalDate birthdate;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Address> address;
    LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
