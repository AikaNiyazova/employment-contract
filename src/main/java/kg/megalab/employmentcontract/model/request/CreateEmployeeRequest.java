package kg.megalab.employmentcontract.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateEmployeeRequest {
    String firstName;
    String lastName;
    String patronymic;
    Long positionId;
}
