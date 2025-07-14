import GUI.SmallGreenButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class AddEmployeeFrame extends JFrame {

    private final String backgroundColor = "#EFEAE4";
    public static final String SECONDARY_BG_COLOR = "#EFEAE4";
    private final ArrayList<Employee> employeeList;

    private final JTextField employeeIdField = new JTextField(20);
    private final JTextField fullNameField = new JTextField(20);
    private final JTextField departmentField = new JTextField(20);
    private final JTextField basicSalaryField = new JTextField(20);
    private final JTextField overtimeHoursField = new JTextField(20);

    public AddEmployeeFrame(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;

        setTitle("Add Employee");
        setSize(650, 350);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode(backgroundColor));

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 50, 10));
        formPanel.setBackground(Color.decode(backgroundColor));

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel header = new JLabel("ADD EMPLOYEE");
        header.setFont(new Font("Arial", Font.BOLD, 25));
        headerPanel.add(header);
        headerPanel.setBackground(Color.decode(backgroundColor));
        formPanel.add(headerPanel, BorderLayout.NORTH);


        setupPlaceholder(employeeIdField, "Enter Employee ID");
        setupPlaceholder(fullNameField, "Enter Full Name");
        setupPlaceholder(departmentField, "Enter Department");
        setupPlaceholder(basicSalaryField, "Enter Basic Salary (₱)");
        setupPlaceholder(overtimeHoursField, "Enter Overtime Hours Worked");

        JPanel fieldsPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        fieldsPanel.add(employeeIdField);
        fieldsPanel.add(fullNameField);
        fieldsPanel.add(departmentField);
        fieldsPanel.add(basicSalaryField);
        fieldsPanel.add(overtimeHoursField);
        fieldsPanel.setBackground(Color.decode(backgroundColor));
        formPanel.add(fieldsPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        SmallGreenButton confirmButton = new SmallGreenButton("CONFIRM");
        buttonPanel.setBackground(Color.decode(backgroundColor));
        buttonPanel.add(confirmButton);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(formPanel);

        confirmButton.addActionListener(e -> {
//            processEmployee();
            ConfirmationFrame success = new ConfirmationFrame(employeeList);
            success.setVisible(true);
        });


    }

    private void setupPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        textField.setHorizontalAlignment(JTextField.LEFT);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

//    private void processEmployee() {
//
//            String empId = employeeIdField.getText().trim();
//            String name = fullNameField.getText().trim();
//            String dept = departmentField.getText().trim();
//            double salary = Double.parseDouble(basicSalaryField.getText().trim());
//            double otHours = Double.parseDouble(overtimeHoursField.getText().trim());
//
//            if (empId.isEmpty() || name.isEmpty() || dept.isEmpty()) {
//                throw new IllegalArgumentException("All fields must be filled.");
//            }
//
//            Employee currentEmployee = new Employee(empId, name, dept, salary, otHours);
//            employeeList.add(currentEmployee);
//
//            ConfirmationFrame confirmation = new ConfirmationFrame(employeeList);
//            confirmation.setVisible(true);
//            System.out.println("Employee added: \n" +
//                    "Employee Id: "+ currentEmployee.getEmployeeId() +
//                    "\nName: " + currentEmployee.getFullName() +
//                    "\nDepartment: " + currentEmployee.getDepartment() +
//                    "\nSalary: " + currentEmployee.getBasicSalary() +
//                    "\nTime Hours: " + currentEmployee.getOvertimeHours());
//
//
//    }
}
