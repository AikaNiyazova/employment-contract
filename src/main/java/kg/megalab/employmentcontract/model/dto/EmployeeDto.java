package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    Long id;
    String firstName;
    String lastName;
    String patronymic;
    PositionDto position;
    List<EmployeesInProjectsDto> employeesInProjectsDto;
    AddressDto address;
    Boolean isActive;

}
