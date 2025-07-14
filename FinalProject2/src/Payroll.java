/**
 * Represents an employee's payroll record.
 * <p>
 * This class stores both input information (e.g., ID, department, salary)
 * and computed payroll data such as gross income, deductions, and net income.
 */

public class Payroll {
    private String employeeId;
    private String employeeName;
    private String department;
    private double basicSalary;
    private double overtimeHours;
    private double hourlyRate;
    private double overtimePay;
    private double grossIncome;
    private double sssContribution;
    private double philHealthContribution;
    private double incomeTax;
    private double totalDeductions;
    private double netIncome;

    /**
     * Creates a new Payroll record with default values.
     * All numeric values are initialized to 0, while all strings to an empty string ("").
     */
    public Payroll() {
        this.employeeId = "";
        this.employeeName = "";
        this.department = "";
        this.basicSalary = 0.0;
        this.overtimeHours = 0.0;
        this.hourlyRate = 0.0;
        this.overtimePay = 0.0;
        this.grossIncome = 0.0;
        this.sssContribution = 0.0;
        this.philHealthContribution = 0.0;
        this.incomeTax = 0.0;
        this.totalDeductions = 0.0;
        this.netIncome = 0.0;
    }

    /**
     * Creates a new Payroll record with the given employee details.
     *
     * @param employeeId the employee ID with the format "EMP-XXXX" where 'X' is a digit.
     * @param employeeName the employee's full name.
     * @param department the employee's department.
     * @param basicSalary the employee's basic monthly salary.
     * @param overtimeHours the employee's extra time worked beyond regular working hours.
     */
    public Payroll(String employeeId, String employeeName, String department,
                   double basicSalary, double overtimeHours) {
        this.employeeId = employeeId;
        setEmployeeName(employeeName);
        setDepartment(department);
        setBasicSalary(basicSalary);
        setOvertimeHours(overtimeHours);
    }

    /**
     * Gets the employee's ID number
     *
     * @return the employee's ID number
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets the employee's name.
     *
     * @return the employee's name.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the employee's name
     *
     * @param name the employee's name. It may include letters, spaces, apostrophes, or hyphens.
     */
    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    /**
     * Gets the employee's department.
     *
     * @return the employee's department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the employee's department.
     *
     * @param department the employee's department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the employee's basic monthly salary.
     *
     * @return the employee's basic monthly salary.
     */
    public double getBasicSalary() {
        return basicSalary;
    }

    /**
     * Sets the employee's basic monthly salary.
     *
     * @param basicSalary the employee's basic monthly salary. It should not accept negative numbers and letters.
     */
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * Gets the employee's overtime hours.
     *
     * @return the employee's overtime hours.
     */
    public double getOvertimeHours() {
        return overtimeHours;
    }

    /**
     * Sets the employee's overtime hours.
     *
     * @param overtimeHours The number of extra hours the employee worked beyond regular time.
     */
    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    /**
     * Gets the employee's hourly rate.
     *
     * @return the employee's hourly rate.
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Sets the employee's hourly rate.
     *
     * @param hourlyRate the employee's hourly rate.
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Gets the employee's overtime pay.
     *
     * @return the employee's overtime pay.
     */
    public double getOvertimePay() {
        return overtimePay;
    }

    /**
     * Sets the employee's overtime pay.
     *
     * @param overtimePay the employee's overtime pay.
     */
    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    /**
     * Gets the employee's gross income.
     *
     * @return the employee's gross income from the sum of basic monthly income and overtime pay.
     */
    public double getGrossIncome() {
        return grossIncome;
    }

    /**
     * Sets the employee's gross income.
     *
     * @param grossIncome the employee's gross income from the sum of basic monthly income and overtime pay.
     */
    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    /**
     * Gets the employee's SSS monthly contribution.
     *
     * @return the employee's SSS monthly contribution
     */
    public double getSssContribution() {
        return sssContribution;
    }

    /**
     * Sets the employee's SSS monthly contribution.
     *
     * @param sssContribution the employee's SSS monthly contribution from the latest SSS' contribution table.
     */
    public void setSssContribution(double sssContribution) {
        this.sssContribution = sssContribution;
    }

    /**
     * Gets the employee's monthly Philhealth contribution.
     *
     * @return the employee's monthly Philhealth contribution.
     */
    public double getPhilHealthContribution() {
        return philHealthContribution;
    }

    /**
     * Sets the employee's monthly Philhealth contribution.
     *
     * @param philHealthContribution the employee's monthly Philhealth contribution from its latest contribution table.
     */
    public void setPhilHealthContribution(double philHealthContribution) {
        this.philHealthContribution = philHealthContribution;
    }

    /**
     * Gets the employee's monthly Pag-IBIG contribution. <b>This is fixed at PHP 200 per month.</b>
     *
     * @return the fixed Pag-IBIG contribution.
     */
    public double getPagIbigContribution() {
        final double PAG_IBIG_RATE = 200;
        return PAG_IBIG_RATE;
    }

    /**
     * Gets the employee's monthly income tax.
     *
     * @return the employee's monthly income tax based from the latest annual BIR tax rate table.
     */
    public double getIncomeTax() {
        return incomeTax;
    }

    /**
     * Sets the employee's monthly income tax.
     *
     * @param incomeTax the employee's monthly income tax.
     */
    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    /**
     * Gets the total deductions from the sum of the government monthly contributions (SSS, Philhealth, Pag-IBIG) and income tax.
     *
     * @return the total deductions from the sum of the government monthly contributions (SSS, Philhealth, Pag-IBIG) and income tax.
     */
    public double getTotalDeductions() {
        return totalDeductions;
    }

    /**
     * Sets the total deductions from the sum of the government monthly contributions (SSS, Philhealth, Pag-IBIG) and income tax.
     *
     * @param totalDeductions the total deductions from the sum of the government monthly contributions (SSS, Philhealth, Pag-IBIG) and income tax.
     */
    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }


    /**
     * Gets the employee's net income.
     *
     * @return the employee's net income.
     */
    public double getNetIncome() {
        return netIncome;
    }


    /**
     * Sets the employee's net income.
     *
     * @param netIncome the employee's net income from the difference of gross income and total deductions.
     */
    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }
}