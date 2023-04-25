import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Quiz {
  public static void main(String[] args) throws InterruptedException {

    JFrame window = new JFrame("Quiz Game");
    window.setSize(1280, 720);
    window.setLocationRelativeTo(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);

    while (true) {

      int nbr = 0, score = 0, m = 0, s = 0;
      int time = 60; // sec

      welcomePage welcome = new welcomePage(window);
      welcome.choose(time);

      quiz2[] qObj = {
          new quiz2("Where is this", "ตึก16", "ตึก17", "ตึก18", "ตึก19", "ตึก19", "ตึก00010011", "q1.jpg"),
          new quiz2("Where is this", "หอสมุด", "หอจดหมายเหตุ", "ที่ดู Netflix", "หอนาฬิกา", "หอนาฬิกา", "ดูNETFLIX ได้",
              "q2.jpeg"),
          new quiz2("Where is this", "โรงอาหาร(ร้อน)", "โรงสมุด", "โรงอาหาร(เย็น)", "โรงเรือน", "โรงอาหาร(เย็น)",
              "แอร์จริง", "q3.jpeg"),
          new quiz2("Where is this", "ตึก300", "ตึก350", "ตึก400", "ตึก450", "ตึก300", "มีStarbucks", "q4.jpeg"),
          new quiz2("Where is this", "ตึกไข่ดาว", "ตึกไข่เจียว", "ตึกไข่คน", "ตึกไข่ต้ม", "ตึกไข่ดาว", "Fried Egg",
              "q5.jpeg"),
          new quiz2("Where is this", "ลานเล่นเบรค", "ลานเล่นล้อ", "ลานเล่นกระจก", "ลานเล่นยาง", "ลานเล่นล้อ", "ลลล",
              "q6.jpeg"),
          new quiz2("Where is this", "โรงอาหาร(เย็น)", "โรงเรือน", "โรงสมุด", "โรงอาหาร(ร้อน)", "โรงอาหาร(ร้อน)",
              "แอร์ทิพย์", "q7.jpg")
      };

      while (nbr != qObj.length && s < time) {
        questions quiz = new questions(qObj[nbr], window);
        quiz.getAnswer(time);
        m = quiz.getTime().M;
        s = quiz.getTime().S;
        score = quiz.getScore();
        if (nbr == qObj.length - 1 || (s == time))
          quiz.Reset();
        nbr++;
      }

      int nbrQ = qObj.length;
      scorePane scorePane = new scorePane(window, score, nbrQ);
      scorePane.choose();

    }

  }
}