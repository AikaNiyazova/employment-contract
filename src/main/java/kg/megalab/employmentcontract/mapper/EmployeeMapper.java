package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDto> {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
}
