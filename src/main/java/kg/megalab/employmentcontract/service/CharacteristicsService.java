package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.CharacteristicsDto;
import kg.megalab.employmentcontract.model.entity.Characteristics;
import org.springframework.stereotype.Service;

@Service
public interface CharacteristicsService {
    CharacteristicsDto find(Long id);
    CharacteristicsDto update(CharacteristicsDto characteristicsDto);
    void save(Characteristics characteristics);
}
