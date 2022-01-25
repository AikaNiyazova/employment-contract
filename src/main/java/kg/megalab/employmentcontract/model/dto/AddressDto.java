package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto {

    Long id;
    String country;
    String city;
    String street;
    String house;
    Integer apartment;
    Long postcode;
    EmployeeDto employee;

}
