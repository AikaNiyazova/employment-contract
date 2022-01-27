package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.SalaryDto;
import kg.megalab.employmentcontract.model.entity.Salary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalaryMapper extends BaseMapper<Salary, SalaryDto> {
    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);
}
