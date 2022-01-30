package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.EmployeeNotFoundException;
import kg.megalab.employmentcontract.mapper.EmployeeMapper;
import kg.megalab.employmentcontract.mapper.PositionMapper;
import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.dto.PositionDto;
import kg.megalab.employmentcontract.model.entity.Address;
import kg.megalab.employmentcontract.model.entity.Characteristics;
import kg.megalab.employmentcontract.model.entity.Employee;
import kg.megalab.employmentcontract.model.request.CreateEmployeeRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import kg.megalab.employmentcontract.repository.EmployeeRepository;
import kg.megalab.employmentcontract.service.AddressService;
import kg.megalab.employmentcontract.service.CharacteristicsService;
import kg.megalab.employmentcontract.service.EmployeeService;
import kg.megalab.employmentcontract.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    public final EmployeeRepository employeeRepository;
    public final CharacteristicsService characteristicsService;
    public final AddressService addressService;
    public final PositionService positionService;

    @Override
    public EmployeeDto create(CreateEmployeeRequest request) {

        PositionDto positionDto = positionService.find(request.getPositionId());

        Characteristics characteristics = Characteristics
                .builder()
                .hardSkills(new ArrayList<>())
                .softSkills(new ArrayList<>())
                .languages(new ArrayList<>())
                .build();
        characteristicsService.save(characteristics);

        Address address = Address
                .builder()
                .country("N/A")
                .city("N/A")
                .street("N/A")
                .house("N/A")
//                .apartment(null)
//                .postcode(null)
                .build();
        addressService.save(address);

        Employee employee = Employee
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .position(PositionMapper.INSTANCE.toEntity(positionDto))
                .characteristics(characteristics)
                .address(address)
                .isActive(true)
                .build();

        return EmployeeMapper.INSTANCE.toDto
                (employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto find(Long id) {
        return EmployeeMapper.INSTANCE.toDto
                (employeeRepository.findById(id)
                        .orElseThrow(() -> new EmployeeNotFoundException
                                ("Employee with id=" + id + " not found")));
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeRepository
                .findByIdAndIsActiveTrue(employeeDto.getId())
                .map(employee -> {
                    employee.setLastName(employeeDto.getLastName());
                    employee.setPosition(PositionMapper.INSTANCE.toEntity(employeeDto.getPosition()));
                    employeeRepository.save(employee);
                    return EmployeeMapper.INSTANCE.toDto(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException
                        ("Employee with id=" + employeeDto.getId() + " not found"));
    }

    @Override
    public MessageResponse delete(Long id) {
        return employeeRepository
                .findByIdAndIsActiveTrue(id)
                .map(employee -> {
                    employee.setIsActive(false);
                    employeeRepository.save(employee);
                    return new MessageResponse("Employee with id=" + id + " deleted");
        }).orElseThrow(() -> new EmployeeNotFoundException
                        ("Employee with id=" + id + " not found"));
    }

    @Override
    public Boolean existsByIdAndIsActiveTrue(Long id) {
        return employeeRepository.existsByIdAndIsActiveTrue(id);
    }
}
