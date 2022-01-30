package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.ProjectNotFoundException;
import kg.megalab.employmentcontract.mapper.ProjectMapper;
import kg.megalab.employmentcontract.model.dto.ProjectDto;
import kg.megalab.employmentcontract.model.entity.Project;
import kg.megalab.employmentcontract.model.request.CreateProjectRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import kg.megalab.employmentcontract.repository.ProjectRepository;
import kg.megalab.employmentcontract.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    public final ProjectRepository projectRepository;

    @Override
    public ProjectDto create(CreateProjectRequest request) {
        Project project = Project
                .builder()
                .projectName(request.getProjectName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(true)
                .build();

        return ProjectMapper.INSTANCE.toDto
                (projectRepository.save(project));
    }

    @Override
    public ProjectDto find(Long id) {
        return ProjectMapper.INSTANCE.toDto
                (projectRepository.findById(id)
                        .orElseThrow(() -> new ProjectNotFoundException
                                ("Project with id=" + id + " not found")));
    }

    @Override
    public ProjectDto update(ProjectDto projectDto) {
        return projectRepository
                .findByIdAndIsActiveTrue(projectDto.getId())
                .map(project -> {
                    project.setProjectName(projectDto.getProjectName());
                    project.setStartDate(projectDto.getStartDate());
                    project.setEndDate(projectDto.getEndDate());
                    projectRepository.save(project);
                    return ProjectMapper.INSTANCE.toDto(project);
                })
                .orElseThrow(() -> new ProjectNotFoundException
                        ("Project with id=" + projectDto.getId() + " not found"));
    }

    @Override
    public MessageResponse delete(Long id) {
        return projectRepository
                .findByIdAndIsActiveTrue(id)
                .map(project -> {
                    project.setIsActive(false);
                    projectRepository.save(project);
                    return new MessageResponse("Project with id=" + id + " deleted");
                }).orElseThrow(() -> new ProjectNotFoundException
                        ("Project with id=" + id + " not found"));
    }

    @Override
    public Boolean existsByIdAndIsActiveTrue(Long id) {
        return projectRepository.existsByIdAndIsActiveTrue(id);
    }
}
