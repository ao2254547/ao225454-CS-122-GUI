package GUI;

import javax.swing.*;
import java.awt.*;

public class SmallGreenButton extends JButton {
    final String mintGreen = "#97CA90";
    public SmallGreenButton(String buttonName) {
        setText(buttonName);
        setFont(new Font("Arial", Font.BOLD, 12));
        setPreferredSize(new Dimension(100, 25));
        setBackground(Color.decode(mintGreen));
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(false); // Optional, for clean look
    }
}