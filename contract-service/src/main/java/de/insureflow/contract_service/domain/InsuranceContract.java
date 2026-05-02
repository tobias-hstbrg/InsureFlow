package de.insureflow.contract_service.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceContract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID contractId;
    UUID customerId;

    @Enumerated(EnumType.STRING)
    InsuranceProduct product;
    @Enumerated(EnumType.STRING)
    ContractStatus status;
    LocalDate startDate;
    LocalDate endDate;
    BigDecimal monthlyPremium;
    LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if(status == null) status = ContractStatus.PENDING;
    }
}
