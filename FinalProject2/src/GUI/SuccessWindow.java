package GUI;


import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;

public class SuccessWindow extends JFrame {
    public SuccessWindow() {


        setTitle("Success");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(224, 216, 200));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 216, 200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ImageIcon icon = new ImageIcon("resources/check.png");
        Image scaledImage = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel checkIcon = new JLabel(new ImageIcon(scaledImage));
        checkIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(checkIcon);

        JLabel successLabel = new JLabel("SUCCESSFULLY ADDED!", SwingConstants.CENTER);
        successLabel.setFont(new Font("Arial", Font.BOLD, 18));
        successLabel.setForeground(new Color(76, 175, 80));
        successLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(successLabel);

        add(panel, BorderLayout.CENTER);
    }
}