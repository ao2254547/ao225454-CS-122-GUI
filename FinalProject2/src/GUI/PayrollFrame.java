package GUI;
import javax.swing.*;
import java.awt.*;

public class PayrollFrame extends JFrame {
    private final short WIDTH = 900;
    private final short HEIGHT = 700;
    private final String backgroundColor = "#D3C7BB";

    public PayrollFrame(String title) {
        this.setTitle(title);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.decode(backgroundColor));
    }


    public PayrollFrame(String title, int width, int height, String backgroundColor) {
        this.setTitle(title);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.decode(backgroundColor));
    }

}