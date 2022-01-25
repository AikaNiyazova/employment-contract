package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDto {

    Long id;
    String projectName;
    Date startDate;
    Date endDate;
    List<EmployeesInProjectsDto> employeesInProjectsDto;

}
