/**
 * Calculates employee's mandatory government contribution and income tax.
 * <p>
 * Provides methods that computes for SSS, PhilHealth, income tax, and net income.
 * and applies to the given {@link Payroll} object.
 */

public class StatutoryDeductions {
    /**
     * Calculates and sets the deductions-related values for the given payroll records.
     *
     * @param employee the payroll record to update with SSS, PhilHealth, income tax and deductions.
     */
    public void calculateAll(Payroll employee) {
        double sss = calculateSSS(employee);
        employee.setSssContribution(sss);

        double philHealth = calculatePhilHealth(employee);
        employee.setPhilHealthContribution(philHealth);

        double incomeTax = calculateIncomeTax(employee);
        employee.setIncomeTax(incomeTax);

        double totalDeduction = employee.getSssContribution() +
                employee.getPhilHealthContribution() +
                employee.getPagIbigContribution() +
                employee.getIncomeTax();
        employee.setTotalDeductions(totalDeduction);

        double netIncome = calculateNetIncome(employee);
        employee.setNetIncome(netIncome);
    }

    /**
     * Calculates the employee's net income.
     *
     * @param employee the payroll record containing gross income and total deductions.
     * @return employee's net income.
     */
    private double calculateNetIncome(Payroll employee) {
        return employee.getGrossIncome() - employee.getTotalDeductions();
    }

    /**
     * Calculates the employee's income tax based from the BIR Tax Rate Table.
     *
     * @param employee the payroll record that accesses the gross income.
     * @return the monthly income tax.
     */
    private double calculateIncomeTax(Payroll employee) {
        final byte MONTHS_IN_YEAR = 12;

        double annualIncomeTax = employee.getGrossIncome() * MONTHS_IN_YEAR;

        if (annualIncomeTax <= 250_000)
            annualIncomeTax = 0.0;
        else if (annualIncomeTax <= 400_000)
            annualIncomeTax = (annualIncomeTax - 250_000) * 0.15;
        else if (annualIncomeTax <= 800_000)
            annualIncomeTax = 22_500 + ((annualIncomeTax - 400_000) * 0.20);
        else if (annualIncomeTax <= 2_000_000)
            annualIncomeTax = 102_500 + (annualIncomeTax - 800_000) * 0.25;
        else if (annualIncomeTax <= 8_000_000)
            annualIncomeTax = 402_500 + (annualIncomeTax - 2_000_000) * 0.3;
        else if (annualIncomeTax >= 8_000_000)
            annualIncomeTax = 2_202_500 + (annualIncomeTax - 8_000_000) * 0.35;

        return annualIncomeTax / MONTHS_IN_YEAR;
    }


    /**
     * Calculate the employee's SSS monthly contribution.
     *
     * @param employee gets the basic salary from the payroll record.
     * @return the SSS contribution.
     */
    private double calculateSSS(Payroll employee) {
        double salary = employee.getBasicSalary();
        if (salary <= 5_249.99) return 500;
        if (salary >= 29_750) return 3_000;

        double bracketStart = 5_250;
        double bracketSize = 500;
        double baseContribution = 550;

        int bracketIndex = (int) ((salary - bracketStart) / bracketSize);
        return baseContribution + (bracketIndex * 50);
    }

    /**
     * Calculates the employee's PhilHealth monthly contribution.
     *
     * @param employee We need to get the basic salary from the payroll record.
     * @return the monthly PhilHealth contribution.
     */
    private double calculatePhilHealth(Payroll employee) {
        double salary = employee.getBasicSalary();

        if (salary <= 10_000) return 250;
        else if (salary >= 100_000) return 2_500;
        else if (salary >= 50_000) return 1_250;
        else return 250 + ((salary - 10_000) / 40_000) * 1_000;
    }
}