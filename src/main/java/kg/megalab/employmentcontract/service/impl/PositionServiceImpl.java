package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.PositionNotFoundException;
import kg.megalab.employmentcontract.mapper.PositionMapper;
import kg.megalab.employmentcontract.model.dto.PositionDto;
import kg.megalab.employmentcontract.model.entity.Position;
import kg.megalab.employmentcontract.model.request.CreatePositionRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import kg.megalab.employmentcontract.repository.PositionRepository;
import kg.megalab.employmentcontract.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    public final PositionRepository positionRepository;

    @Override
    public PositionDto create(CreatePositionRequest request) {
        Position position = Position
                .builder()
                .positionTitle(request.getPositionTitle())
                .isActive(true)
                .build();

        return PositionMapper.INSTANCE.toDto
                (positionRepository.save(position));
    }

    @Override
    public PositionDto find(Long id) {
        return PositionMapper.INSTANCE.toDto
                (positionRepository.findById(id)
                        .orElseThrow(() -> new PositionNotFoundException
                                ("Position with id=" + id + " not found")));
    }

    @Override
    public PositionDto update(PositionDto positionDto) {
        return positionRepository
                .findById(positionDto.getId())
                .map(position -> {
                    position.setPositionTitle(positionDto.getPositionTitle());
                    positionRepository.save(position);
                    return PositionMapper.INSTANCE.toDto(position);
                })
                .orElseThrow(() -> new PositionNotFoundException
                        ("Position with id=" + positionDto.getId() + " not found"));
    }

    @Override
    public MessageResponse delete(Long id) {
        return positionRepository
                .findById(id)
                .map(position -> {
                    position.setIsActive(false);
                    positionRepository.save(position);
                    return new MessageResponse("Position with id=" + id + " deleted");
                }).orElseThrow(() -> new PositionNotFoundException
                        ("Position with id=" + id + " not found"));
    }
}
