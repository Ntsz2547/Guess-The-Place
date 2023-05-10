import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Quiz {

  public static void main(String[] args) throws InterruptedException {

    JFrame window = new JFrame("SWU TOUR");
    window.setSize(1280, 720);
    window.setLocationRelativeTo(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    while (true) {

      int number = 0, score = 0, m = 0, s = 0;
      int time = 60; // sec

      WelcomePage welcome = new WelcomePage(window);
      welcome.choose(time);

      quizdatabase[] qObj = {
          new quizdatabase("Where is this", "ตึก16", "ตึก17", "ตึก18", "ตึก19", "ตึก19", "ตึก00010011",
              "./image/q1.jpg"),
          new quizdatabase("Where is this", "หอสมุด", "หอจดหมายเหตุ", "ที่ดู Netflix", "หอนาฬิกา", "หอสมุด",
              "ดูNETFLIX ได้",
              "./image/q2.jpg"),
          new quizdatabase("Where is this", "โรงอาหาร(ร้อน)", "โรงสมุด", "โรงอาหาร(เย็น)", "โรงเรือน", "โรงอาหาร(เย็น)",
              "แอร์จริง", "./image/q3.jpg"),
          new quizdatabase("Where is this", "ตึก300", "ตึก350", "ตึก400", "ตึก450", "ตึก300", "มีStarbucks",
              "./image/q4.jpg"),
          new quizdatabase("Where is this", "ตึกไข่ดาว", "ตึกไข่เจียว", "ตึกไข่คน", "ตึกไข่ต้ม", "ตึกไข่ดาว",
              "Fried Egg",
              "./image/q5.jpg"),
          new quizdatabase("Where is this", "ลานเล่นเบรค", "ลานเล่นล้อ", "ลานเล่นกระจก", "ลานเล่นยาง", "ลานเล่นล้อ",
              "ลลล",
              "./image/q6.jpg"),
          new quizdatabase("Where is this", "โรงอาหาร(เย็น)", "โรงเรือน", "โรงสมุด", "โรงอาหาร(ร้อน)", "โรงอาหาร(ร้อน)",
              "แอร์ทิพย์", "./image/q7.jpg"),
          new quizdatabase("Where is this", "อาคารเรียนแยก", "โรงอาหาร(เย็น)", "อาคารเรียนรวม", "โรงอาหาร(ร้อน)",
              "อาคารเรียนรวม",
              "เรียน swu", "./image/q8.jpg")
      };

      while (number != qObj.length && s < time) {
        questions quiz = new questions(qObj[number], window);
        quiz.getAnswer(time);
        m = quiz.getTime().M;
        s = quiz.getTime().S;
        score = quiz.getScore();
        if (number == qObj.length - 1 || (s == time))
          quiz.Reset();
        number++;
      }

      int numberQ = qObj.length;
      scorePane scorePane = new scorePane(window, score, numberQ);
      scorePane.choose();

    }

  }
}