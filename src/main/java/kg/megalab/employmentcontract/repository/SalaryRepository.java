package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    Boolean existsByIdAndIsActiveTrue(Long id);
    Optional<Salary> findByIdAndIsActiveTrue(Long id);
}
