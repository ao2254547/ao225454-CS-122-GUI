import GUI.PayrollFrame;
import GUI.SmallGreenButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GeneratePayslipFrame extends JFrame {
    GeneratePayslipFrame() {
        setTitle("Generate Payslip");
        setSize(new Dimension(600, 200));
        setBackground(Color.decode(AddEmployeeFrame.SECONDARY_BG_COLOR));
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel header = new JLabel("GENERATE EMPLOYEE");
        header.setFont(new Font("Arial", Font.BOLD, 25));
        headerPanel.setBackground(Color.decode(AddEmployeeFrame.SECONDARY_BG_COLOR));
        headerPanel.add(header);
        add(headerPanel, BorderLayout.NORTH);


        this.add(createPlaceholderField("Search for Employee ID"));
//        JTextField textField = new JTextField();

        SmallGreenButton confirmButton = new SmallGreenButton("CONFIRM");
        add(confirmButton);
    }

    private JTextField createPlaceholderField(String placeholder) {
        JTextField textField = new JTextField(20);
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        textField.setHorizontalAlignment(JTextField.LEFT);//leading so that the text will be on the left side

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {//if the user clicks on the field
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {//if the user is not on the text field
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        return textField;
    }
}

