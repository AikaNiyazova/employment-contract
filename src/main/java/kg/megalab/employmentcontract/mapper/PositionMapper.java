package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.PositionDto;
import kg.megalab.employmentcontract.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PositionMapper extends BaseMapper<Position, PositionDto> {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);
}
