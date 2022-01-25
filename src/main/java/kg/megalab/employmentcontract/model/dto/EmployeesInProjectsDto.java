package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeesInProjectsDto {

    Long id;
    EmployeeDto employee;
    ProjectDto project;
    Integer daysInProject;

}
