package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.CharacteristicsNotFoundException;
import kg.megalab.employmentcontract.mapper.CharacteristicsMapper;
import kg.megalab.employmentcontract.model.dto.CharacteristicsDto;
import kg.megalab.employmentcontract.model.entity.Characteristics;
import kg.megalab.employmentcontract.repository.CharacteristicsRepository;
import kg.megalab.employmentcontract.service.CharacteristicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacteristicsServiceImpl implements CharacteristicsService {

    public final CharacteristicsRepository characteristicsRepository;

    @Override
    public CharacteristicsDto find(Long id) {
        return CharacteristicsMapper.INSTANCE.toDto
                (characteristicsRepository.findById(id)
                        .orElseThrow(() -> new CharacteristicsNotFoundException
                                ("Characteristics with id=" + id + " not found")));
    }

    @Override
    public CharacteristicsDto update(CharacteristicsDto characteristicsDto) {
        return characteristicsRepository
                .findById(characteristicsDto.getId())
                .map(characteristics -> {
                    characteristics.setHardSkills(characteristicsDto.getHardSkills());
                    characteristics.setSoftSkills(characteristicsDto.getSoftSkills());
                    characteristics.setLanguages(characteristicsDto.getLanguages());
                    characteristicsRepository.save(characteristics);
                    return CharacteristicsMapper.INSTANCE.toDto(characteristics);
                })
                .orElseThrow(() -> new CharacteristicsNotFoundException
                        ("Characteristics with id=" + characteristicsDto.getId() + " not found"));
    }

    @Override
    public void save(Characteristics characteristics) {
        characteristicsRepository.save(characteristics);
    }
}
