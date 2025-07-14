
import GUI.SuccessWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConfirmationFrame extends JFrame {
    private final String backgroundColor = "#EFEAE4";
    public static final String SECONDARY_BG_COLOR = "#EFEAE4";
    private ArrayList<Employee> employeeList1;

    private final JTextField employeeIdField = new JTextField(20);
    private final JTextField fullNameField = new JTextField(20);
    private final JTextField departmentField = new JTextField(20);
    private final JTextField basicSalaryField = new JTextField(20);
    private final JTextField overtimeHoursField = new JTextField(20);

//    private void processEmployee() {
//        this.employeeList1 = employeeList1;
//        try {
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
//            employeeList1.add(currentEmployee);
//
//            ConfirmationFrame confirmation = new ConfirmationFrame(employeeList1);
//            confirmation.setVisible(true);
//            System.out.println("Employee added: " + currentEmployee.getEmployeeId() + " - " + currentEmployee.getFullName());
//
//        } catch (NumberFormatException e) {
//            ValidNumbers valid = new ValidNumbers();
//            valid.setVisible(true);
//        }
//    }
    public ConfirmationFrame(ArrayList<Employee> employeeList) {
        setTitle("Confirm Action");
        setSize(400, 180);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(218, 210, 199));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(new Color(218, 210, 199));
        JLabel messageLabel = new JLabel("Do you want to proceed with adding this employee?");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        labelPanel.add(messageLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(218, 210, 199));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton yesButton = new JButton("YES");
        yesButton.setBackground(new Color(76, 175, 80)); // Green
        yesButton.setForeground(Color.BLACK);
        yesButton.setFocusPainted(false);


        JButton noButton = new JButton("NO");
        noButton.setBackground(new Color(198, 71, 60)); // Red
        noButton.setForeground(Color.BLACK);
        noButton.setFocusPainted(false);



        noButton.addActionListener(e -> {
            this.dispose();
        });

        yesButton.addActionListener(e -> {
            try {
                String empId = employeeIdField.getText().trim();
                String name = fullNameField.getText().trim();
                String dept = departmentField.getText().trim();
                double salary = Double.parseDouble(basicSalaryField.getText().trim());
                double otHours = Double.parseDouble(overtimeHoursField.getText().trim());

                if (empId.isEmpty() || name.isEmpty() || dept.isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled.");
                }

                Employee currentEmployee = new Employee(empId, name, dept, salary, otHours);
                employeeList.add(currentEmployee);

                ConfirmationFrame confirmation = new ConfirmationFrame(employeeList);
                System.out.println("Employee added: \n" +
                        "Employee Id: "+ currentEmployee.getEmployeeId() +
                        "\nName: " + currentEmployee.getFullName() +
                        "\nDepartment: " + currentEmployee.getDepartment() +
                        "\nSalary: " + currentEmployee.getBasicSalary() +
                        "\nTime Hours: " + currentEmployee.getOvertimeHours());
                confirmation.setVisible(true);

                SuccessWindow success = new SuccessWindow();
                success.setVisible(true);

            } catch (NumberFormatException exception) {

            }

            this.dispose();
        });

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        panel.add(Box.createVerticalStrut(20));
        panel.add(labelPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(buttonPanel);

        add(panel);
    }
}

