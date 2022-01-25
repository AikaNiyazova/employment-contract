package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharacteristicsDto {

    Long id;
    String hardSkills;
    String softSkills;
    String languages;
//    EmployeeDto employeeDto;

}
