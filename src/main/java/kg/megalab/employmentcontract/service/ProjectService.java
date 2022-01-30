package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.ProjectDto;
import kg.megalab.employmentcontract.model.request.CreateProjectRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    ProjectDto create(CreateProjectRequest request);
    ProjectDto find(Long id);
    ProjectDto update(ProjectDto projectDto);
    MessageResponse delete(Long id);
    Boolean existsByIdAndIsActiveTrue(Long id);
}
