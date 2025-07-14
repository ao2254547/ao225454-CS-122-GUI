import java.io.PrintWriter;

/**
 * Displays a formatted employee payslip in the console.
 * <p>
 * This class uses ANSI escape codes to enhance the <strong>visual presentation</strong> of
 * the printed output. It includes employee details, earnings, deductions,
 * and the calculated net income in a clean, organized layout.
 * </p>
 * <p>
 * The earnings section shows the basic salary, overtime pay, and gross income.
 * The deductions section includes contributions for SSS, PhilHealth, Pag-IBIG, and income tax.
 * The net income is displayed in a highlighted box for emphasis.
 * </p>
 */
public class PayslipPrinter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    /**
     * Prints the formatted payslip for a given employee to the console.
     * <p>
     * This includes employee details, earnings (basic salary, overtime pay, gross income),
     * deductions (SSS, PhilHealth, Pag-IBIG, income tax, total deductions),
     * and a boxed net income section.
     * </p>
     *
     * @param employee the {@link Payroll} object containing the computed payroll data.
     */
//    public void displayPayslip(Payroll employee) {
//        System.out.println(ANSI_BOLD + ANSI_BLUE + "┌─────────────────────────────────────────────────────────────┐" + ANSI_RESET);
//        System.out.println(ANSI_BOLD + ANSI_BLUE + "│           ABC Solutions - Employee Payslip (2025)           │" + ANSI_RESET);
//        System.out.println(ANSI_BOLD + ANSI_BLUE + "└─────────────────────────────────────────────────────────────┘" + ANSI_RESET);
//
//        System.out.printf("%-40s: %20s%n", "Employee ID", employee.getEmployeeId());
//        System.out.printf("%-40s: %20s%n", "Name", employee.getEmployeeName());
//        System.out.printf("%-40s: %20s%n", "Department", employee.getDepartment());
//        System.out.println();
//
//        System.out.println(ANSI_CYAN + ANSI_BOLD + "EARNINGS:" + ANSI_RESET);
//        System.out.printf("%-40s: %20s%n", "Basic Salary", String.format("₱%,.2f", employee.getBasicSalary()));
//        System.out.printf("%-40s: %20s%n",
//                String.format("Overtime Pay (%.1f hr(s) @ ₱%.2f/hr)", employee.getOvertimeHours(), employee.getHourlyRate()),
//                String.format("₱%,.2f", employee.getOvertimePay()));
//        System.out.printf("%-40s: %20s%n", "Gross Pay", String.format("₱%,.2f", employee.getGrossIncome()));
//        System.out.println();
//
//        System.out.println(ANSI_CYAN + ANSI_BOLD + "DEDUCTIONS: (2025 Rates)" + ANSI_RESET);
//        System.out.printf("%-40s: %20s%n", "SSS Contribution", String.format("₱%,.2f", employee.getSssContribution()));
//        System.out.printf("%-40s: %20s%n", "PhilHealth Contribution", String.format("₱%,.2f", employee.getPhilHealthContribution()));
//        System.out.printf("%-40s: %20s%n", "Pag-IBIG Contribution", String.format("₱%,.2f", employee.getPagIbigContribution()));
//        System.out.printf("%-40s: %20s%n", "Income Tax", String.format("₱%,.2f", employee.getIncomeTax()));
//        System.out.printf("%-40s: %20s%n", "Total Deductions", String.format("₱%,.2f", employee.getTotalDeductions()));
//
//        System.out.println(ANSI_BOLD + ANSI_BLUE + "┌─────────────────────────────────────────────────────────────┐" + ANSI_RESET);
//        System.out.printf(ANSI_BOLD + ANSI_BLUE + "│ %-59s │%n",
//                "NET INCOME: " + String.format("₱%,.2f", employee.getNetIncome()));
//        System.out.println(ANSI_BOLD + ANSI_BLUE + "└─────────────────────────────────────────────────────────────┘" + ANSI_RESET);
//    }
//}

    public void displayPayslip(Payroll employee, PrintWriter out) {
        out.println("┌─────────────────────────────────────────────────────────────┐");
        out.println("│           ABC Solutions - Employee Payslip (2025)           │");
        out.println("└─────────────────────────────────────────────────────────────┘");

        out.printf("%-40s: %20s%n", "Employee ID", employee.getEmployeeId());
        out.printf("%-40s: %20s%n", "Name", employee.getEmployeeName());
        out.printf("%-40s: %20s%n", "Department", employee.getDepartment());
        out.println();

        out.println("EARNINGS:");
        out.printf("%-40s: %20s%n", "Basic Salary", String.format("₱%,.2f", employee.getBasicSalary()));
        out.printf("%-40s: %20s%n",
                String.format("Overtime Pay (%.1f hr(s) @ ₱%,.2f/hr)", employee.getOvertimeHours(), employee.getHourlyRate()),
                String.format("₱%,.2f", employee.getOvertimePay()));
        out.printf("%-40s: %20s%n", "Gross Pay", String.format("₱%,.2f", employee.getGrossIncome()));
        out.println();

        out.println("DEDUCTIONS: (2025 Rates)");
        out.printf("%-40s: %20s%n", "SSS Contribution", String.format("₱%,.2f", employee.getSssContribution()));
        out.printf("%-40s: %20s%n", "PhilHealth Contribution", String.format("₱%,.2f", employee.getPhilHealthContribution()));
        out.printf("%-40s: %20s%n", "Pag-IBIG Contribution", String.format("₱%,.2f", employee.getPagIbigContribution()));
        out.printf("%-40s: %20s%n", "Income Tax", String.format("₱%,.2f", employee.getIncomeTax()));
        out.printf("%-40s: %20s%n", "Total Deductions", String.format("₱%,.2f", employee.getTotalDeductions()));

        out.println("┌─────────────────────────────────────────────────────────────┐");
        out.printf("│ %-59s │%n", "NET INCOME: " + String.format("₱%,.2f", employee.getNetIncome()));
        out.println("└─────────────────────────────────────────────────────────────┘");

        out.flush(); // Ensure everything is written
    }
}