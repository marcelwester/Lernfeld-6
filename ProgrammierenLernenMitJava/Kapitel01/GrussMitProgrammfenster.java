/* Beispiel mit Programmfenster
 * Datum: 2011-11-30
 * Hans-Peter Habelitz
 */



import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class GrussMitProgrammfenster extends JFrame {
    public GrussMitProgrammfenster() {
        super("Hallo");

        Icon icon = new ImageIcon("java-logo.jpg");
        JLabel label1 = new JLabel("Viel Erfolg beim", JLabel.CENTER);
        JLabel label2 = new JLabel("Programmieren mit Java!", JLabel.CENTER);
        JLabel label3 = new JLabel(icon);

        Font schrift = new Font("SansSerif", Font.BOLD, 24);
        label1.setFont(schrift);
        label1.setForeground(Color.red);
        label2.setFont(schrift);
        label2.setForeground(Color.red);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);
        c.add(label1);
        c.add(label2);
        c.add(label3);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,250);
        setVisible(true);
    }

    public static void main(String [] args) {
        new GrussMitProgrammfenster();
    }
}