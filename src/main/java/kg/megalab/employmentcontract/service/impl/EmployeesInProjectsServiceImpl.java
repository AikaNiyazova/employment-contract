package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.EmployeeInProjectNotFoundException;
import kg.megalab.employmentcontract.exceptions.EmployeeNotFoundException;
import kg.megalab.employmentcontract.exceptions.ProjectNotFoundException;
import kg.megalab.employmentcontract.mapper.EmployeeMapper;
import kg.megalab.employmentcontract.mapper.EmployeesInProjectsMapper;
import kg.megalab.employmentcontract.mapper.ProjectMapper;
import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.dto.EmployeesInProjectsDto;
import kg.megalab.employmentcontract.model.dto.ProjectDto;
import kg.megalab.employmentcontract.model.entity.EmployeesInProjects;
import kg.megalab.employmentcontract.model.request.CreateEmployeesInProjectsRequest;
import kg.megalab.employmentcontract.repository.EmployeesInProjectsRepository;
import kg.megalab.employmentcontract.service.EmployeeService;
import kg.megalab.employmentcontract.service.EmployeesInProjectsService;
import kg.megalab.employmentcontract.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeesInProjectsServiceImpl implements EmployeesInProjectsService {

    public final EmployeesInProjectsRepository employeesInProjectsRepository;
    public final EmployeeService employeeService;
    public final ProjectService projectService;

    @Override
    public EmployeesInProjectsDto create(CreateEmployeesInProjectsRequest request) {

        if (!employeeService.existsByIdAndIsActiveTrue(request.getEmployeeId())) {
            throw new EmployeeNotFoundException
                    ("Employee with id=" + request.getEmployeeId() + " doesn't exist");
        }

        if (!projectService.existsByIdAndIsActiveTrue(request.getProjectId())) {
            throw new ProjectNotFoundException
                    ("Project with id=" + request.getProjectId() + " doesn't exist");
        }

        EmployeeDto employeeDto = employeeService.find(request.getEmployeeId()); // findByIdAndIsActiveTrue ?
        ProjectDto projectDto = projectService.find(request.getProjectId()); // findByIdAndIsActiveTrue ?

        EmployeesInProjects employeesInProjects = EmployeesInProjects
                .builder()
                .employee(EmployeeMapper.INSTANCE.toEntity(employeeDto))
                .project(ProjectMapper.INSTANCE.toEntity(projectDto))
                .daysInProject(request.getDaysInProject())
                .build();

        return EmployeesInProjectsMapper.INSTANCE.toDto
                (employeesInProjectsRepository.save(employeesInProjects));
    }

    @Override
    public EmployeesInProjectsDto find(Long id) {
        return EmployeesInProjectsMapper.INSTANCE.toDto
                (employeesInProjectsRepository.findById(id)
                        .orElseThrow(() -> new EmployeeInProjectNotFoundException
                                ("Employee in project by id=" + id + " not found")));
    }

    @Override
    public EmployeesInProjectsDto update(EmployeesInProjectsDto employeesInProjectsDto) {
        return employeesInProjectsRepository
                .findById(employeesInProjectsDto.getId())
                .map(employeesInProjects -> {
                    employeesInProjects.setDaysInProject(employeesInProjectsDto.getDaysInProject());
                    employeesInProjectsRepository.save(employeesInProjects);
                    return EmployeesInProjectsMapper.INSTANCE.toDto(employeesInProjects);
                })
                .orElseThrow(() -> new EmployeeInProjectNotFoundException
                        ("Employee in project by id=" + employeesInProjectsDto.getId() + " not found"));
    }
}
