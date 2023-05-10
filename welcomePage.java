import java.awt.event.ActionEvent;
import javax.annotation.Generated;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class WelcomePage extends JPanel {
    JButton title,
            play,
            tour,
            exit;
    static boolean go = false;

    private Tour tourPanel;
    public String name;

    WelcomePage(JFrame window) {

        setSize(1280, 720);
        setLayout(null);
        window.setContentPane(this);

        // Create game title label
        JLabel bg = new JLabel(new ImageIcon("./image/background.jpg"));
        bg.setBounds(0, 0, getWidth(), getHeight());

        // Create game title label
        JLabel gameTitleLabel = new JLabel(new ImageIcon("./image/gificon.gif"));
        gameTitleLabel.setBounds(384, 124, 520, 115);

        // Add game title label to the frame
        add(gameTitleLabel);

        // Add buttons to JPanel after waiting for backgroundLabel to fully display
        ImageIcon tourIcon = new ImageIcon("./image/swutour_icon1.png");
        tour = new JButton("SWU TOUR", tourIcon);
        tour.setBounds(380, 354, 500, 64);
        add(tour);

        ImageIcon quizIcon = new ImageIcon("./image/quiz_icon1.png");
        play = new JButton("Guess The Place", quizIcon);
        play.setBounds(380, 452, 500, 64);
        add(play);

        ImageIcon exitIcon = new ImageIcon("./image/exit_icon1.png");
        exit = new JButton("Exit", exitIcon);
        exit.setBounds(380, 550, 500, 64);
        add(exit);

        add(bg);
        window.setVisible(true);

        tourPanel = new Tour(window);
    }

    void choose(int time) {
        tour.addActionListener((ActionEvent e) -> {
            setVisible(false);
            tourPanel.showTourPage();
        });

        play.addActionListener((ActionEvent e) -> {
            go = true;
            setVisible(false);
        });

        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        while (!go) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
            }
        }

        go = false;
    }
}
