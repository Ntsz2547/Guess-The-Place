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
    int totalImages = 18;

    private JFrame window;

    Tour(JFrame window) {
        this.window = window;
        // create exut to quiz button
        ImageIcon exitIcon = new ImageIcon("./image/Start_GameBtn.jpg");
        exit = new JButton("Quiz Start", exitIcon);
        exit.setBounds(580, 570, 415, 70);
        exit.addActionListener((ActionEvent e) -> {
            WelcomePage.go = true;
            setVisible(false);
        });

    }

    void showTourPage() {
        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);

        JLabel bg = new JLabel(new ImageIcon("./image/1.jpg"));
        JLabel dialoglLabel = new JLabel(new ImageIcon("./image/Tour1_dia.jpg"));
        bg.setBounds(0, 0, getWidth(), getHeight());
        dialoglLabel.setBounds(0, getHeight(), 1280, 150);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                index++;
                if (index > totalImages) {
                    add(exit);
                    remove(bg);
                    remove(dialoglLabel);

                } else {
                    bg.setIcon(new ImageIcon("./image/" + index + ".jpg"));
                    dialoglLabel.setIcon(new ImageIcon("./image/Tour" + index + "_dia.jpg"));
                    dialoglLabel.setLocation(0, getHeight());
                    move(dialoglLabel, 0, -150, 2);

                }
            }
        });
        add(dialoglLabel);
        add(bg);
        move(dialoglLabel, 0, -189, 2);
        window.setContentPane(this);
        window.setVisible(true);
    }

    public static void move(JLabel frame, int deltaX, int deltaY, int time) {
        int xMoveBy = deltaX > 0 ? 4 : -4;
        int yMoveBy = deltaY > 0 ? 4 : -4;
        int targetX = frame.getX() + deltaX;
        int targetY = frame.getY() + deltaY;
        Timer timer = new Timer(time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int frameX = frame.getX();
                int frameY = frame.getY();
                if (deltaX == 0) {
                } else if (deltaX > 0) {
                    frameX = Math.min(targetX, frameX + xMoveBy);
                } else {
                    frameX = Math.max(targetX, frameX + xMoveBy);
                }

                if (deltaY == 0) {
                } else if (deltaY > 0) {
                    frameY = Math.min(targetY, frameY + yMoveBy);
                } else {
                    frameY = Math.max(targetY, frameY + yMoveBy);
                }
                frame.setLocation(frameX, frameY);
                if (frameX == targetX && frameY == targetY) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
}
