import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class questions extends JPanel {

  JLabel Q,
      hintLabel,
      imageLabel,
      imageIcon;

  JButton option1,
      option2,
      option3,
      option4;

  String correct_answer,
      hint;

  static boolean next = false;
  static int score = 0;

  static JLabel timer = new JLabel("00 : 00 : 000");
  static counter count = new counter();

  questions(quiz2 obj, JFrame window) {

    // สร้าง JLabel และ ImageIcon สำหรับแสดงรูปภาพตาม imagePath ที่ระบุใน quiz2

    JLabel imageLabel = new JLabel(new ImageIcon(obj.imagePath));
    // กำหนดขนาดและตำแหน่งของ JLabel สำหรับแสดงรูปภาพ
    imageLabel.setBounds(264, 27, 750, 306);
    imageLabel.setBorder(new LineBorder(Color.WHITE, 3));
    add(imageLabel);

    Q = new JLabel(obj.question);
    hintLabel = new JLabel("Hint");
    option1 = new JButton(obj.op1);
    option2 = new JButton(obj.op2);
    option3 = new JButton(obj.op3);
    option4 = new JButton(obj.op4);
    correct_answer = obj.correct_answer;
    hint = obj.hint;

    setLayout(null);
    setBackground(Color.darkGray);
    setBounds(0, 0, 1280, 720);
    setBorder(BorderFactory.createLineBorder(Color.black));
    window.setContentPane(this);

    JButton hintBTN = new JButton(new ImageIcon(getClass().getResource("./image/hint.png")));
    JButton half = new JButton(new ImageIcon(getClass().getResource("./image/50 50.png")));

    Font font = new Font("Tahoma", Font.BOLD, 16);
    Q.setBounds(440, 409, 400, 50);
    Q.setBorder(new LineBorder(Color.white, 2, true));
    Q.setHorizontalAlignment(JLabel.CENTER);
    Q.setForeground(Color.white);
    Q.setFont(font);
    option1.setBounds(228, 486, 400, 40);
    option1.setForeground(Color.WHITE);
    option1.setFont(font);
    option1.setBackground(new Color(226, 27, 60));
    option2.setBounds(228, 539, 400, 40);
    option2.setBackground(new Color(255, 192, 10));
    option2.setForeground(Color.WHITE);
    option2.setFont(font);
    option3.setBounds(652, 486, 400, 40);
    option3.setBackground(new Color(19, 104, 206));
    option3.setForeground(Color.WHITE);
    option3.setFont(font);
    option4.setBounds(652, 539, 400, 40);
    option4.setBackground(new Color(38, 137, 12));
    option4.setForeground(Color.WHITE);
    option4.setFont(font);
    option1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
    option2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
    option3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
    option4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

    timer.setBounds(540, 598, 200, 50);
    timer.setFont(new Font("Verdana", Font.BOLD, 20));
    timer.setHorizontalAlignment(JLabel.CENTER);
    timer.setBorder(BorderFactory.createLineBorder(Color.pink));
    timer.setForeground(Color.white);

    hintBTN.setBounds(350, 360, 80, 80);
    hintBTN.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
    half.setBounds(852, 360, 80, 80);
    half.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
    hintLabel.setBounds(440, 345, 400, 50);
    hintLabel.setHorizontalAlignment(JLabel.CENTER);
    hintLabel.setForeground(Color.white);
    hintLabel.setBorder(new LineBorder(Color.white, 2, true));
    hintLabel.setFont(font);

    hintBTN.addActionListener((ActionEvent e) -> {
      hintLabel.setText(hint);
    });

    add(Q);
    add(option1);
    add(option2);
    add(option3);
    add(option4);
    add(timer);
    add(hintBTN);
    add(half);
    add(hintLabel);

    half.addActionListener((ActionEvent e) -> {
      if (!option1.getText().equals(correct_answer)) {
        option1.setEnabled(false);
        option1.setBackground(Color.red);
      } else if (!option2.getText().equals(correct_answer)) {
        option2.setEnabled(false);
        option2.setBackground(Color.red);
      }
      if (!option3.getText().equals(correct_answer)) {
        option3.setEnabled(false);
        option3.setBackground(Color.red);
      } else if (!option4.getText().equals(correct_answer)) {
        option4.setEnabled(false);
        option4.setBackground(Color.red);
      }
    });

    window.setVisible(true);
  }

  void getAnswer(int time) throws InterruptedException {

    option1.addActionListener((ActionEvent e) -> {
      if (option1.getText().equals(correct_answer))
        score++;
      next = true;
    });

    option2.addActionListener((ActionEvent e) -> {
      if (option2.getText().equals(correct_answer))
        score++;
      next = true;
    });

    option3.addActionListener((ActionEvent e) -> {
      if (option3.getText().equals(correct_answer))
        score++;
      next = true;
    });

    option4.addActionListener((ActionEvent e) -> {
      if (option4.getText().equals(correct_answer))
        score++;
      next = true;
    });

    while (next == false) {

      timer.setText(String.format("%02d", count.M) + " : " + String.format("%02d", count.S) + " : "
          + String.format("%03d", count.Ms));
      count.Ms++;
      Thread.sleep(1);
      if (count.Ms == 999) {
        count.S++;
        count.Ms = 0;
      }
      if (count.S == 59) {
        count.M++;
        count.S = 0;
      }

      if ((count.S + count.M * 60) > time - 3) {

        timer.setForeground(Color.red);

        if ((count.S + count.M * 60) == time) {
          return;
        }
      }

    }

    next = false;

  }

  int getScore() {
    return score;
  }

  counter getTime() {
    return count;
  }

  void Reset() {

    count.M = 0;
    count.Ms = 0;
    count.S = 0;
    score = 0;

  }

}