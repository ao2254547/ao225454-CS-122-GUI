import GUI.SmallGreenButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

    public class RemoveEmployeeFrame extends JFrame {
        private final ArrayList<Employee> employeeList;
        private final DefaultListModel<String> employeeListModel;
        private final String backgroundColor = "#EFEAE4";

        public RemoveEmployeeFrame(ArrayList<Employee> employeeList) {
            this.employeeList = employeeList;
            this.employeeListModel = new DefaultListModel<>();

            setTitle("Remove Employee");
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(500, 300);
            setLocationRelativeTo(null);
            getContentPane().setBackground(Color.decode(backgroundColor));
            setLayout(new BorderLayout());

            // Header
            JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel header = new JLabel("REMOVE EMPLOYEE");
            header.setFont(new Font("Arial", Font.BOLD, 25));
            headerPanel.add(header);
            headerPanel.setBackground(Color.decode(backgroundColor));
            add(headerPanel, BorderLayout.NORTH);

            // Center form
            JPanel wrapper = new JPanel();
            wrapper.setLayout(new FlowLayout());
            wrapper.setBackground(Color.decode(backgroundColor));

            JTextField searchField = createPlaceholderField("Search for Employee ID");
            wrapper.add(searchField);

            SmallGreenButton confirmButton = new SmallGreenButton("ENTER");
            wrapper.add(confirmButton);
            add(wrapper, BorderLayout.CENTER);

            // List display
            JList<String> employeeJList = new JList<>(employeeListModel);
            employeeJList.setBackground(new Color(255, 255, 255));
            employeeJList.setForeground(new Color(69, 47, 28));
            employeeJList.setFont(new Font("Arial", Font.PLAIN, 14));

            JScrollPane scrollPane = new JScrollPane(employeeJList);
            scrollPane.setBorder(BorderFactory.createTitledBorder("Current Employees"));
            add(scrollPane, BorderLayout.SOUTH);

            // Populate employee list
            refreshEmployeeList();




            // Button logic
            confirmButton.addActionListener(e -> {
                String searchId = searchField.getText().trim();
                boolean removed = employeeList.removeIf(emp -> emp.getEmployeeId().equalsIgnoreCase(searchId));
                if (removed) {
                    JOptionPane.showMessageDialog(this, "Employee removed.");
                    refreshEmployeeList();
                } else {
                    JOptionPane.showMessageDialog(this, "ID not found.");
                }
            });

            setVisible(true);
        }

        private void refreshEmployeeList() {
            employeeListModel.clear();
            for (Employee emp : employeeList) {
                employeeListModel.addElement(emp.getEmployeeId() +
                        " - " + emp.getFullName() +
                        " - " + emp.getDepartment() +
                        " - " + emp.getBasicSalary() +
                        " - " + emp.getOvertimeHours());
            }
        }

        private JTextField createPlaceholderField(String placeholder) {
            JTextField textField = new JTextField(20);
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

            return textField;
        }
    }

