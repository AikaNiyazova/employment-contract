package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.EmployeesInProjectsDto;
import kg.megalab.employmentcontract.model.entity.EmployeesInProjects;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeesInProjectsMapper extends BaseMapper<EmployeesInProjects, EmployeesInProjectsDto> {
    EmployeesInProjectsMapper INSTANCE = Mappers.getMapper(EmployeesInProjectsMapper.class);

}
