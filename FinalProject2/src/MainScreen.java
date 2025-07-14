//import GUI.ConfirmationWindow;
import GUI.PayrollButton;
import GUI.PayrollFrame;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainScreen {


        public static void main (String[]args){


            ArrayList<Employee> employeeList = new ArrayList<>();
            PayrollFrame payrollFrame = new PayrollFrame("ABC Solutions - Employee Payslip (2025)");
            JLabel banner = new JLabel("ABC Payroll");

            payrollFrame.add(banner);
            banner.setFont(new Font("Arial", Font.BOLD, 28));
            banner.setForeground(Color.decode(PayrollButton.CREAM));
            banner.setBounds(380, 50, 500, 60);

            final String yellow = "#E2A54D";
            PayrollButton generatePayslipButton = new PayrollButton("Generate Payslip", yellow, 0);
            generatePayslipButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GeneratePayslipFrame generatePayslipFrame = new GeneratePayslipFrame();
                    generatePayslipFrame.setVisible(true);
                }
            });
            payrollFrame.add(generatePayslipButton);

            final String green = "#2D5652";
            PayrollButton addEmployeeButton = new PayrollButton("Add Employee", green, 50);
            addEmployeeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddEmployeeFrame addEmployeeFrame = new AddEmployeeFrame(employeeList);
                    addEmployeeFrame.setVisible(true);
                }
            });
            payrollFrame.add(addEmployeeButton);

            final String red = "#A0381B";
            PayrollButton removeEmployeeButton = new PayrollButton("Remove Employee", red, 100);
            removeEmployeeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RemoveEmployeeFrame removeEmployeeFrame = new RemoveEmployeeFrame(employeeList);
                    removeEmployeeFrame.setVisible(true);
                }
            });
            payrollFrame.add(removeEmployeeButton);

            payrollFrame.setLayout(null);
            payrollFrame.setVisible(true);
        }
    }


/*
private ArrayList<Employee> processedEmployees;

processedEmployees = new ArrayList<>();

String empId = employeeIdField.getText().trim();
String name = fullNameField.getText().trim();
String dept = departmentField.getText().trim();
double salary = Double.parseDouble(basicSalaryField.getText().trim());
double otHours = Double.parseDouble(overtimeHoursField.getText().trim());

currentEmployee = new Employee(empId, name, dept, salary, otHours);

        processedEmployees.add(currentEmployee); // Adding of employees

        System.out.println("Employees List");
        for (Employee emp : processedEmployees) {
        System.out.println("ID: " + emp.getEmployeeId() + ", Name: " + emp.getFullName());
        }

 */