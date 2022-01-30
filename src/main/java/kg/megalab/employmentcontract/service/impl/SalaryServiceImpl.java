package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.EmployeeNotFoundException;
import kg.megalab.employmentcontract.exceptions.SalaryNotFoundException;
import kg.megalab.employmentcontract.mapper.EmployeeMapper;
import kg.megalab.employmentcontract.mapper.SalaryMapper;
import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.dto.SalaryDto;
import kg.megalab.employmentcontract.model.entity.Salary;
import kg.megalab.employmentcontract.model.request.CreateSalaryRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import kg.megalab.employmentcontract.repository.SalaryRepository;
import kg.megalab.employmentcontract.service.EmployeeService;
import kg.megalab.employmentcontract.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    public final SalaryRepository salaryRepository;
    public final EmployeeService employeeService;

    @Override
    public SalaryDto create(CreateSalaryRequest request) {

        EmployeeDto employeeDto = employeeService.find(request.getEmployeeId()); // Is order important?

        if (!employeeService.existsByIdAndIsActiveTrue(request.getEmployeeId())) {
            throw new EmployeeNotFoundException
                    ("Employee with id=" + request.getEmployeeId() + " doesn't exist");
        }

        if (salaryRepository.existsByIdAndIsActiveTrue(request.getEmployeeId())) {
            throw new RuntimeException
                    ("Employee with id=" + request.getEmployeeId() + " already has an assigned salary");
        }

        if (request.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException
                    ("Salary start date=" + request.getStartDate() + " cannot be earlier than today's date");
        }

        Salary salary = Salary
                .builder()
                .employee(EmployeeMapper.INSTANCE.toEntity(employeeDto))
                .amount(request.getAmount())
                .startDate(request.getStartDate())
                .endDate(LocalDate.of(2999, 12, 31))
                .isActive(true)
                .build();

        return SalaryMapper.INSTANCE.toDto
                (salaryRepository.save(salary));
    }

    @Override
    public SalaryDto find(Long id) {
        return SalaryMapper.INSTANCE.toDto
                (salaryRepository.findById(id)
                        .orElseThrow(() -> new SalaryNotFoundException
                                ("Salary with id=" + id + " not found")));
    }

    @Override
    public SalaryDto update(SalaryDto salaryDto) {
        return salaryRepository
                .findByIdAndIsActiveTrue(salaryDto.getId())
                .map(salary -> {
                    salary.setEndDate(salaryDto.getEndDate());
                    salaryRepository.save(salary);
                    return SalaryMapper.INSTANCE.toDto(salary);
                })
                .orElseThrow(() -> new SalaryNotFoundException
                        ("Salary with id=" + salaryDto.getId() + " not found"));
    }

    @Override
    public MessageResponse delete(Long id) {
        return salaryRepository
                .findByIdAndIsActiveTrue(id)
                .map(salary -> {
//                    salary.setEndDate(LocalDate.now());
                    salary.setIsActive(false);
                    salaryRepository.save(salary);
                    return new MessageResponse("Salary with id=" + id + " deleted");
                }).orElseThrow(() -> new SalaryNotFoundException
                        ("Salary with id=" + id + " not found"));
    }
}
