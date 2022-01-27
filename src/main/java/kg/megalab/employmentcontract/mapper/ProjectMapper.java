package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.ProjectDto;
import kg.megalab.employmentcontract.model.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper extends BaseMapper<Project, ProjectDto> {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
}
