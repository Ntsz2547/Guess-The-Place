import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class quiz2 {
    String question, op1, op2, op3, op4, correct_answer, hint, imagePath; // เพิ่ม property imagePath

    quiz2(String q, String o1, String o2, String o3, String o4, String ans, String h, String imagePath) { // ส่ง
                                                                                                          // imagePath
                                                                                                          // มาให้
        question = q;
        op1 = o1;
        op2 = o2;
        op3 = o3;
        op4 = o4;
        correct_answer = ans;
        hint = h;
        this.imagePath = imagePath; // กำหนด imagePath
    }

}