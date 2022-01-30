package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaryDto {

    Long id;
    EmployeeDto employee;
    BigDecimal amount;
    LocalDate startDate;
    LocalDate endDate;
    Boolean isActive;

}
