package kg.megalab.employmentcontract.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateSalaryRequest {
    Long employeeId;
    BigDecimal amount;
}
