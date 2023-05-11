import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    int index = 1;
    int totalImages = 17;

    private JFrame window;

    Tour(JFrame window) {
        this.window = window;
        // create exut to quiz button
        exit = new JButton("Quiz Start");
        exit.setBounds(543, 570, 300, 60);
        exit.addActionListener((ActionEvent e) -> {
            WelcomePage.go = true;
            setVisible(false);
        });

    }

    void showTourPage() {
        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);

        JLabel bg = new JLabel(new ImageIcon("./image/1.jpg"));
        bg.setBounds(0, 0, getWidth(), getHeight());

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                index++;
                if (index >= totalImages) {
                    remove(bg);
                    add(exit);
                } else {
                    bg.setIcon(new ImageIcon("./image/" + index + ".jpg"));
                }
            }
        });
        add(bg);
        window.setContentPane(this);
        window.setVisible(true);
    }
}
