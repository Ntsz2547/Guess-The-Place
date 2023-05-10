import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.nio.file.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

class scorePane extends JPanel {

    // declare Playername as a member variable
    JTextField Playername;

    JButton playAgain,
            Savebtn,
            exit;

    JLabel scoreLabel,
            playerNameLabel,
            latestLabel;

    int score;
    static boolean again = false;

    scorePane(JFrame window, int score, int nbrQ) {

        this.score = score; // initialize score in the constructor
        Font BTNfont = new Font("Tahoma", Font.BOLD, 16);
        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);

        playerNameLabel = new JLabel("Player Name");
        playerNameLabel.setHorizontalAlignment(JLabel.CENTER);
        playerNameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        playerNameLabel.setForeground(Color.white);
        playerNameLabel.setBorder(new LineBorder(Color.white, 1, true));
        playerNameLabel.setBounds(535, 320, 200, 50);
        add(playerNameLabel);

        // initialize Playername as a member variable
        Playername = new JTextField();
        Playername.setBounds(440, 380, 400, 50);
        Playername.setToolTipText("ํ NAME");
        Playername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Playername.setHorizontalAlignment(JTextField.CENTER);
        add(Playername);

        Savebtn = new JButton("SAVE");
        Savebtn.setBackground(new Color(255, 255, 255));
        Savebtn.setFont(BTNfont);
        Savebtn.setBounds(490, 472, 300, 50);
        add(Savebtn);

        playAgain = new JButton("Back To Menu");
        playAgain.setBackground(new Color(255, 255, 255));
        playAgain.setFont(BTNfont);
        playAgain.setBounds(290, 598, 300, 50);
        add(playAgain);

        exit = new JButton("Exit");
        exit.setBackground(new Color(255, 255, 255));
        exit.setFont(BTNfont);
        exit.setBounds(690, 598, 300, 50);
        add(exit);

        scoreLabel = new JLabel("You got : " + score + "/" + nbrQ + " points");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setBorder(new LineBorder(Color.white, 2, true));
        scoreLabel.setBounds(215, 30, 850, 150);
        add(scoreLabel);

        latestLabel = new JLabel();
        latestLabel.setHorizontalAlignment(JLabel.CENTER);
        latestLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        latestLabel.setForeground(Color.white);
        latestLabel.setBorder(new LineBorder(Color.white, 2, true));
        latestLabel.setBounds(390, 192, 500, 60);
        add(latestLabel);

        // อ่านไฟล์ PlayerScore.txt เพื่อแสดงผลคะแนนที่ผู้เล่นคนล่าสุดทำได้
        Path path = Paths.get("Playerscore.txt");
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (lines.size() > 0) {
                String latestScore = lines.get(lines.size() - 1); // get the latest score
                String[] tokens = latestScore.split(" ");
                if (tokens[0] == " ") {
                    latestLabel.setText("Latest score by : " + "Noname" + " Got " + tokens[1] + "/" + nbrQ + " points");
                } else {
                    latestLabel
                            .setText("Latest score by : " + tokens[0] + " Got " + tokens[1] + "/" + nbrQ + " points");
                }
            } else {
                latestLabel.setText("No more score yet");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }

        window.setVisible(true);

    }

    void choose() {
        Savebtn.addActionListener((ActionEvent e) -> {
            // บันทึก Playername และ score ใน PlayerScore.txt
            String playerName = Playername.getText();
            String scoreString = Integer.toString(score);
            try {
                FileWriter fw = new FileWriter("Playerscore.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(playerName + " " + scoreString); // use scoreString instead of score
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                System.out.println("Error writing to file");
            }
            again = true;
        });

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