package GUI;

import javax.swing.*;
import java.awt.*;

public class SecondaryHeader extends JLabel {
    public SecondaryHeader(String headerText) {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        setText(headerText);
        setFont(new Font("Arial", Font.BOLD, 25));
        headerPanel.add(this);
        headerPanel.setBackground(Color.PINK);
//        formPanel.add(headerPanel, BorderLayout.NORTH);
    }
}