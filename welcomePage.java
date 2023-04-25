import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class welcomePage extends JPanel {

    JButton play, tour, exit;
    static boolean go = false;

    welcomePage(JFrame window) {

        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);

        tour = new JButton("SWU TOUR");
        tour.setBackground(new Color(255, 255, 255));
        tour.setBounds(300, 100, 400, 50);
        add(tour);

        play = new JButton("Guess The Place");
        play.setBackground(new Color(255, 255, 255));
        play.setBounds(300, 50, 400, 50);
        add(play);

        exit = new JButton("Exit");
        exit.setBackground(new Color(255, 255, 255));
        exit.setBounds(300, 350, 400, 50);
        add(exit);

        window.setVisible(true);

    }

    void choose(int time) {

        play.addActionListener((ActionEvent e) -> {
            namePane namePane = new namePane();
            int result = JOptionPane.showConfirmDialog(null, "Welcome " + namePane.getName(), "Enter Your Name",
                    JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String playerName = namePane.getName();
                scorePane scorePane = new scorePane(new JFrame(), 0, 0);
                scorePane.scoreLabel.setText("Player Name: " + playerName);
                scorePane.scoreLabel.setBounds(100, 50, 600, 100);
                scorePane.playAgain.setBounds(300, 250, 200, 50);
                scorePane.exit.setBounds(300, 350, 200, 50);
                scorePane.setVisible(true);
                go = true;
                setVisible(false);
            }
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
