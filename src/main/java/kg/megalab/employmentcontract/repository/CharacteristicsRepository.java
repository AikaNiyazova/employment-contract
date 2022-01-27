package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.Characteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicsRepository extends JpaRepository<Characteristics, Long> {
}
