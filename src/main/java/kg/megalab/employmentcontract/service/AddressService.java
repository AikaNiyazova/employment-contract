package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.AddressDto;
import kg.megalab.employmentcontract.model.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    AddressDto find(Long id);
    AddressDto update(AddressDto addressDto);
    void save(Address address);
}
