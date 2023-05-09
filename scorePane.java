import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class scorePane extends JPanel {

    JButton playAgain,
            exit;

    JLabel scoreLabel;

    static String name;

    static boolean again = false;

    scorePane(JFrame window, int score, int nbrQ) {

        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);

        playAgain = new JButton("Back To Menu");
        playAgain.setBackground(new Color(255, 255, 255));
        playAgain.setBounds(490, 370, 300, 50);
        add(playAgain);

        exit = new JButton("Exit");
        exit.setBackground(new Color(255, 255, 255));
        exit.setBounds(490, 497, 300, 50);
        add(exit);

        scoreLabel = new JLabel(/* Player name */ "Got : " + score + "/" + nbrQ + " points");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Verdana", Font.BOLD, 60));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setBorder(new LineBorder(Color.white, 2, true));
        scoreLabel.setBounds(215, 150, 850, 100);
        add(scoreLabel);

        window.setVisible(true);

    }

    void choose() {

        playAgain.addActionListener((ActionEvent e) -> {
            again = true;
        });

        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        while (!again) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
            }
        }

        again = false;

    }

}