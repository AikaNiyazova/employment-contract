package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDto {

    Long id;
    String projectName;
    LocalDate startDate;
    LocalDate endDate;
    Boolean isActive;
//    List<EmployeesInProjectsDto> employeesInProject;

}
