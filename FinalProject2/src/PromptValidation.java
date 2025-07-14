import java.util.Scanner;

/**
 * Handles user input and validation for employee payroll data.
 * <p>
 * Provides a method to prompt the user for employee details and
 * validate each field (such as ID, name, department, salary, and overtime hours),
 * and return a populated {@link Payroll} object if all inputs are valid.
 */
public class PromptValidation {
    /**
     * Collects and validates employee payroll input from the user.
     * <p>
     * Prompts for:
     * <ul>
     *     <li>Employee ID (format: EMP-XXXX)</li>
     *     <li>Full Name</li>
     *     <li>Department</li>
     *     <li>Basic Monthly Salary</li>
     *     <li>Overtime Hours Worked</li>
     * </ul>
     * After validation, returns a {@link Payroll} object with the captured values.
     *
     * @param scanner the {@code Scanner} object used to read input from the console.
     * @return a new {@code Payroll} object populated with validated input.
     * @throws IllegalArgumentException if any input fails validation.
     */
    public static Payroll collectInput(Scanner scanner) {
        System.out.print("Enter Employee ID (format: EMP-XXXX): ");
        String employeeId = scanner.nextLine();
        validateEmployeeId(employeeId);

        System.out.print("Enter Full Name: ");
        String employeeName = scanner.nextLine();
        validateEmployeeName(employeeName);

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        validateDepartment(department);

        System.out.print("Enter Basic Monthly Salary (₱): ");
        double basicMonthlySalary = scanner.nextDouble();
        validateMonthlySalary(basicMonthlySalary);

        System.out.print("Enter Overtime Hours Worked: ");
        double overtimeHours = scanner.nextDouble();
        validateOvertimeHours(overtimeHours);

        scanner.nextLine();
        return new Payroll(employeeId, employeeName, department, basicMonthlySalary, overtimeHours);
    }
    /**
     * Validates the employee ID format.
     * <p>
     * The ID must follow the format "EMP-XXXX" where X is a digit.
     *
     * @param employeeId the employee ID to validate.
     * @throws IllegalArgumentException if the ID is null, blank, or does not match the format.
     */
    private static void validateEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.isBlank())
            throw new IllegalArgumentException("Employee ID should not be empty!");
        if (!employeeId.matches("^EMP-\\d{4}$"))
            throw new IllegalArgumentException("Invalid Employee ID format!\nUse \"EMP-XXXX\" where \'X\' is a digit.");
    }

    /**
     * Validates the employee's name to ensure it is not blank and contains only valid characters.
     * <p>
     * The name must:
     * <ul>
     *   <li>Not be {@code null}, "null", or blank</li>
     *   <li>Contain only letters (a–z, A–Z), spaces, apostrophes ('), or hyphens (-)</li>
     * </ul>
     *
     * @param employeeName the employee's name to validate
     * @throws IllegalArgumentException if the name is blank or contains invalid characters
     */
    private static void validateEmployeeName(String employeeName) {
        if (employeeName == null || employeeName.isBlank() || employeeName.equalsIgnoreCase("null"))
            throw new IllegalArgumentException("Employee name should not be blank!");
        if (!employeeName.matches("[a-zA-Z '\\-]+"))
            throw new IllegalArgumentException("Employee name should only contain letters!");
    }

    /**
     * Validates the employee's department.
     * <p>
     * Department must:
     * <ul>
     *     <li>Not be {@code null}, "null", or blank</li>
     *     <li>Contain only alphabetic characters and spaces</li>
     * </ul>
     *
     * @param department the department name to validate.
     * @throws IllegalArgumentException if the department name is invalid.
     */
    private static void validateDepartment(String department ) {
        if (department == null || department.isBlank() || department.equalsIgnoreCase("null"))
            throw new IllegalArgumentException("Department should not be empty!");
        if (!department.matches("[a-zA-Z ]+"))
            throw new IllegalArgumentException("Department should only contain letters!");
    }

    /**
     * Validates the employee's basic monthly salary.
     * <p>
     * Salary must be a positive number.
     *
     * @param basicMonthlySalary the salary to validate.
     * @throws IllegalArgumentException if salary is less than or equal to zero.
     */
    private static void validateMonthlySalary(double basicMonthlySalary) {
        if (basicMonthlySalary <= 0)
            throw new IllegalArgumentException("Salary cannot be negative or zero!");
    }

    /**
     * Validates the employee's overtime hours.
     * <p>
     * Overtime hours must be zero or greater.
     *
     * @param overtimeHours the number of overtime hours.
     * @throws IllegalArgumentException if the overtime hours are negative.
     */
    private static void validateOvertimeHours(double overtimeHours) {
        if (overtimeHours < 0)
            throw new IllegalArgumentException("Overtime hour(s) should not be zero!");
    }
}