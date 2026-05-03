package de.insureflow.contract_service.repository;

import de.insureflow.contract_service.domain.ContractStatus;
import de.insureflow.contract_service.domain.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Contract;

import java.util.List;
import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {
    List<Contract> findByStatus(ContractStatus status);
    boolean existsByContractId(UUID contractId);
    List<Contract> findByProduct(InsuranceProduct product );
}
