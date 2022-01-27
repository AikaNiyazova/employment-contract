package kg.megalab.employmentcontract.exceptions;

public class EmployeeInProjectNotFoundException extends RuntimeException {
    public EmployeeInProjectNotFoundException(String message) {
        super(message);
    }
}
