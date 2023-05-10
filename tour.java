import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.nio.file.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.annotation.Generated;

public class Tour extends JPanel {

    JButton exit;
    static boolean end = false;

    private JFrame window;

    Tour(JFrame window) {
        this.window = window;

        exit = new JButton("Quiz Start");
        exit.setBounds(380, 550, 500, 64);
        exit.addActionListener((ActionEvent e) -> {
            WelcomePage.go = true;
            setVisible(false);
            setVisible(false);
        });
        add(exit);
    }

    void showTourPage() {
        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);
        setBackground(Color.pink);
        window.setContentPane(this);
        window.setVisible(true);
    }
}