package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.PositionDto;
import kg.megalab.employmentcontract.model.request.CreatePositionRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {
    PositionDto create(CreatePositionRequest request);
    PositionDto find(Long id);
    PositionDto update(PositionDto positionDto);
    MessageResponse delete(Long id);
}
