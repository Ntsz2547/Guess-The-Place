import javax.swing.*;

public class namePane {
    private String name;
    private JButton okButton;

    public namePane() {
        name = JOptionPane.showInputDialog(null, "Enter your name:", "Name Enter", JOptionPane.PLAIN_MESSAGE);
        okButton = new JButton("OK");
        okButton.setVisible(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JButton getOkButton() {
        return okButton;
    }

}