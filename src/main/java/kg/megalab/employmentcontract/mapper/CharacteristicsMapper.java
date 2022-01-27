package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.CharacteristicsDto;
import kg.megalab.employmentcontract.model.entity.Characteristics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacteristicsMapper extends BaseMapper<Characteristics, CharacteristicsDto> {
    CharacteristicsMapper INSTANCE = Mappers.getMapper(CharacteristicsMapper.class);

}
