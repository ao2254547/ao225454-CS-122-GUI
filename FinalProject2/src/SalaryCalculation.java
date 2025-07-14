/**
 * Calculates the employee's earnings based from the Payroll data.
 * <p>
 * Provides methods to compute hourly rate, overtime pay, and gross income.
 * and applies them to the given {@link Payroll} object.
 */

public class SalaryCalculation {
    /**
     * Calculates and sets all salary-related values for the given employee object.
     * <p>
     * This includes the hourly rate, overtime pay, and gross income.
     *
     * @param employee the {@code Payroll} object to update.
     */
    public void calculateAll(Payroll employee) {
        double hourlyRate = calculateHourlyRate(employee);
        employee.setHourlyRate(hourlyRate);

        double overtimePay = calculateOvertimePay(employee);
        employee.setOvertimePay(overtimePay);

        double grossIncome = calculateGrossIncome(employee);
        employee.setGrossIncome(grossIncome);
    }

    /**
     * Calculates the hourly rate from the employee's basic monthly salary.
     *
     * @param employee the payroll record containing basic monthly salary.
     * @return the hourly rate by dividing basic salary and 160 working hours
     */
    private double calculateHourlyRate(Payroll employee) {
        final int WORKING_HOURS_PER_MONTH = 160;

        if (employee.getOvertimeHours() == 0) return 0;
        return employee.getBasicSalary() / WORKING_HOURS_PER_MONTH;
    }

    /**
     * Calculates the employee object's overtime pay.
     *
     * @param employee the payroll record containing overtime hours and rate.
     * @return the product of overtime hours, hourly rate, and the 1.25 overtime pay multiplier.
     */
    private double calculateOvertimePay(Payroll employee) {
        final double OVERTIME_PAY_MULTIPLIER = 1.25;
        return (employee.getOvertimeHours() * employee.getHourlyRate() * OVERTIME_PAY_MULTIPLIER);
    }

    /**
     * Calculates the employee object's gross income.
     *
     * @param employee the payroll record containing the income details.
     * @return the sum of basic monthly salary and overtime pay.
     */
    private double calculateGrossIncome(Payroll employee) {
        return employee.getBasicSalary() + employee.getOvertimePay();
    }
}