package kg.megalab.employmentcontract.model.dto;

import kg.megalab.employmentcontract.model.entity.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaryDto {

    Long id;
    Employee employee;
    BigDecimal amount;

}
