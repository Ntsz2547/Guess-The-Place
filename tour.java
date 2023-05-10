import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class tour extends JPanel {

    void welcomePage(JFrame frame) {
        setSize(1280, 720);
        setLayout(null);
        frame.setContentPane(this);
        frame.setResizable(false); // ปรับขนาดหน้าต่างให้พอดีกับเนื้อที่ที่ได้กำหนดไว้
        frame.setLocationRelativeTo(null); // กำหนดให้หน้าต่างอยู่ตรงกลางจอ
        frame.setVisible(true); // แสดงหน้าต่าง

    }

}
