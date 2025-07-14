package GUI;

import javax.swing.*;
import java.awt.*;

public class PayrollButton extends JButton {
    public static final String CREAM = "#2C365A";

    public PayrollButton(String buttonName, String color, int bottomPixels) {
        setText(buttonName);
        setFont(new Font("Arial", Font.BOLD, 15));
        setForeground(Color.decode("#EEE8DF")); // Cream
        setBackground(Color.decode(color));
        setBounds(230,250 + bottomPixels,450,45);
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(false); // Optional, for clean look
    }
}