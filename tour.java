import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.nio.file.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Tour extends JPanel {

    static boolean end = false;

    Tour(JFrame window) {

        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);
        setBackground(Color.pink);
        window.setContentPane(this);
        setVisible(true);

    }

    void choose() {
        while (!end) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
            }
        }

        end = false;
    }

}