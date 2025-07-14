package GUI;


import javax.swing.*;
import java.awt.*;

public class MediumFrame extends JFrame {
    private final String backgroundColor = "#EFEAE4";

    public MediumFrame(String title) {
        setTitle(title);
        setSize(650, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode(backgroundColor));

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 50, 10));
//        formPanel.setBackground(Color.decode(backgroundColor));
        formPanel.setBackground(Color.cyan);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel header = new JLabel("ADD EMPLOYEE");
        header.setFont(new Font("Arial", Font.BOLD, 25));
        headerPanel.add(header);
        headerPanel.setBackground(Color.decode(backgroundColor));
        formPanel.add(headerPanel, BorderLayout.NORTH);
    }
}