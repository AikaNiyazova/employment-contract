package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharacteristicsDto {

    Long id;
    List<String> hardSkills;
    List<String> softSkills;
    List<String> languages;
//    EmployeeDto employeeDto;

}
