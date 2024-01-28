package view;

import javax.swing.*;
import java.awt.*;

public class PopupMessage extends JFrame {
    public PopupMessage() {
        setTitle("Number is present");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel(new BorderLayout());

        add(panel);
        setLocationRelativeTo(null);
    }

    public void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
