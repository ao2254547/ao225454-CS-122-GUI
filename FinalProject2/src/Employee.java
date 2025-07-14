public class Employee {
    private String employeeId;
    private String fullName;
    private String department;
    private double basicSalary;
    private double overtimeHours;

    public Employee(String employeeId, String fullName, String department, double basicSalary, double overtimeHours) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.basicSalary = basicSalary;
        this.overtimeHours = overtimeHours;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    // Add other getters as needed
}
