package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByIdAndIsActiveTrue(Long id);
}
