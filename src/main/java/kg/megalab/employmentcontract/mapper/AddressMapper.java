package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.AddressDto;
import kg.megalab.employmentcontract.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper extends BaseMapper<Address, AddressDto> {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
}
