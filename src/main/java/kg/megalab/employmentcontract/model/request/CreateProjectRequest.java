package kg.megalab.employmentcontract.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProjectRequest {
    String projectName;
    Date startDate;
    Date endDate;
}
