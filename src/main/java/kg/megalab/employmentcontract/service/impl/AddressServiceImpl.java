package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.AddressNotFoundException;
import kg.megalab.employmentcontract.mapper.AddressMapper;
import kg.megalab.employmentcontract.model.dto.AddressDto;
import kg.megalab.employmentcontract.model.entity.Address;
import kg.megalab.employmentcontract.repository.AddressRepository;
import kg.megalab.employmentcontract.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    public final AddressRepository addressRepository;

    @Override
    public AddressDto find(Long id) {
        return AddressMapper.INSTANCE.toDto
                (addressRepository.findById(id)
                        .orElseThrow(() -> new AddressNotFoundException
                                ("Address with id=" + id + " not found")));
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        return addressRepository
                .findById(addressDto.getId())
                .map(address -> {
                    address.setCountry(addressDto.getCountry());
                    address.setCity(addressDto.getCity());
                    address.setStreet(addressDto.getStreet());
                    address.setHouse(addressDto.getHouse());
                    address.setApartment(addressDto.getApartment());
                    address.setPostcode(addressDto.getPostcode());
                    addressRepository.save(address);
                    return AddressMapper.INSTANCE.toDto(address);
                })
                .orElseThrow(() -> new AddressNotFoundException
                        ("Address with id=" + addressDto.getId() + " not found"));
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }
}
