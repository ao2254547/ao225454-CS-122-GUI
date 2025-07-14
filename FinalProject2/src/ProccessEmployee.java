/* import GUI.ConfirmationWindow;

import javax.swing.*;
import java.util.ArrayList;

public class ProceessEmployee {

    private final String backgroundColor = "#EFEAE4";
    public static final String SECONDARY_BG_COLOR = "#EFEAE4";
    private ArrayList<Payroll> employeeList1;

    private final JTextField employeeIdField = new JTextField(20);
    private final JTextField fullNameField = new JTextField(20);
    private final JTextField departmentField = new JTextField(20);
    private final JTextField basicSalaryField = new JTextField(20);
    private final JTextField overtimeHoursField = new JTextField(20);

    private void processEmployee() {
        this.employeeList1 = employeeList1;
        try {

            String empId = employeeIdField.getText().trim();
            String name = fullNameField.getText().trim();
            String dept = departmentField.getText().trim();
            double salary = Double.parseDouble(basicSalaryField.getText().trim());
            double otHours = Double.parseDouble(overtimeHoursField.getText().trim());

            if (empId.isEmpty() || name.isEmpty() || dept.isEmpty()) {
                throw new IllegalArgumentException("All fields must be filled.");
            }

            Payroll currentEmployee = new Payroll(empId, name, dept, salary, otHours);
            employeeList1.add(currentEmployee);


            System.out.println("Employee added: " + currentEmployee.getEmployeeId() + " - " + currentEmployee.getEmployeeName());

            ConfirmationWindow success = new ConfirmationWindow();
            success.setVisible(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for salary and overtime hours.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}

 */