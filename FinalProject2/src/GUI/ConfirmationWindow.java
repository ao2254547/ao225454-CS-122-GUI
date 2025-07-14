/* package GUI;

import GUI.SuccessWindow;
import javax.swing.*;
import java.awt.*;

public class ConfirmationWindow extends JFrame {
    public ConfirmationWindow() {
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
            SuccessWindow success = new SuccessWindow();
            success.setVisible(true);
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


 */