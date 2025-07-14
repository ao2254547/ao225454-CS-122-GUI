import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main entry point of the Payroll System.
 * <p>
 * This class coordinates the overall program flow:
 * <ol>
 *     <li>prompting the user for employee details</li>
 *     <li>calculating salary</li>
 *     <li>calculating government deductions; and</li>
 *     <li>displaying the final payslip.</li>
 * </ol>
 * It also handles common runtime input errors gracefully.
 */
public class Main {

    /**
     * Starts the Payroll System application.
     * <p>
     * The system follows this sequence:
     * <ol>
     *     <li>Collects validated input from the user</li>
     *     <li>Performs salary computations (hourly rate, overtime, gross income)</li>
     *     <li>Applies statutory deductions (SSS, PhilHealth, Pag-IBIG, income tax)</li>
     *     <li>Displays a formatted payslip</li>
     * </ol>
     * If an invalid input is provided, appropriate error messages are shown and
     * prompts the user again.
     *
     * @param args unused command-line arguments
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BOLD = "\u001B[1m";
        final String ANSI_BLUE = "\u001B[34m";

        System.out.println(ANSI_BOLD + ANSI_BLUE + "┌─────────────────────────────────────────────────────────────┐" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_BLUE + "│              Welcome to Group 7 Payroll System              │" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_BLUE + "└─────────────────────────────────────────────────────────────┘" + ANSI_RESET);

        do {
            try {
                Payroll employee = PromptValidation.collectInput(scanner);

                SalaryCalculation salaryCalc = new SalaryCalculation();
                salaryCalc.calculateAll(employee);

                StatutoryDeductions deductions = new StatutoryDeductions();
                deductions.calculateAll(employee);

//                PayslipPrinter printPayslip = new PayslipPrinter();
//                printPayslip.displayPayslip(employee);

                System.out.print("Do you want to generate a payslip? (y/n): ");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("y")) {
                    // Folder path inside your package/project
                    // String folderpath = "Group 7/Payslip/output"; // This creates another folder within a folder
                    String folderPath = "src/Payslip";

                    // Make sure folder exists
                    File folder = new File(folderPath);
                    if (!folder.exists()) {
                        folder.mkdirs(); // Create directories if they don't exist
                    }

                    // Create filename with employee name
                    String fileName = employee.getEmployeeName().replaceAll(" ", "_") + "_payslip.txt";

                    // Create full file path inside the output folder
                    File file = new File(folder, fileName);

                    try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                        PayslipPrinter printPayslip = new PayslipPrinter();
                        printPayslip.displayPayslip(employee, out); // This method must accept PrintWriter
                        System.out.println("Payslip has been written to: " + file.getAbsolutePath());
                    } catch (IOException ioe) {
                        System.out.println("Error writing to file: " + ioe.getMessage());
                    }

                } else if (response.equals("n")) {
                    System.out.println("Payslip generator skipped.");
                    continue;
                } else {
                    System.out.println("Invalid input. Please type 'y' to generate a payslip or 'n' to skip.");
                    continue;
                }



                scanner.close();
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Error: Enter a number!\n");
                scanner.nextLine();
            } catch (IllegalArgumentException iae) {
                System.out.println("Error: " + iae.getMessage() + "\n");
            }
        } while (true);
    }
}