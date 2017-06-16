package gui10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrayausgabeFrame extends JFrame {

    private JPanel contentPane;
    private JTextField tfAnzahl;
    private JTextField tfZahl;
    private int anzahl, n;
    private int[] zahlen;
    private JLabel lblZahl;
    private JButton btnEingabeZahl;
    private JLabel lblAusgabeVorwaerts;
    private JLabel lblAusgabeRueckwaerts;
    private JButton btnNeueEingabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ArrayausgabeFrame frame = new ArrayausgabeFrame();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public ArrayausgabeFrame() {
    	setTitle("Arrayausgabe");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 529, 224);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblWievieleZahlen = new JLabel("Wieviele Zahlen sollen eingegeben werden?");
	lblWievieleZahlen.setBounds(10, 11, 286, 14);
	contentPane.add(lblWievieleZahlen);
	
	tfAnzahl = new JTextField();
	tfAnzahl.setBounds(309, 8, 63, 20);
	contentPane.add(tfAnzahl);
	tfAnzahl.setColumns(10);
	
	JButton btnEingabeAnzahl = new JButton("OK");
	btnEingabeAnzahl.setBounds(395, 7, 89, 23);
	contentPane.add(btnEingabeAnzahl);
	
	lblZahl = new JLabel("Zahl");
	lblZahl.setBounds(10, 54, 63, 14);
	contentPane.add(lblZahl);
	
	tfZahl = new JTextField();
	tfZahl.setBounds(10, 69, 86, 20);
	contentPane.add(tfZahl);
	tfZahl.setColumns(10);
	
	btnEingabeZahl = new JButton("OK");
	btnEingabeZahl.setBounds(117, 68, 89, 23);
	contentPane.add(btnEingabeZahl);
	
	btnNeueEingabe = new JButton("Neue Eingabe");
	btnNeueEingabe.setBounds(259, 68, 134, 23);
	contentPane.add(btnNeueEingabe);
	
	lblAusgabeVorwaerts = new JLabel("Ausgabe vorw\u00E4rts");
	lblAusgabeVorwaerts.setBounds(10, 130, 474, 14);
	contentPane.add(lblAusgabeVorwaerts);
	
	lblAusgabeRueckwaerts = new JLabel("Ausgabe r\u00FCckw\u00E4rts");
	lblAusgabeRueckwaerts.setBounds(10, 155, 474, 14);
	contentPane.add(lblAusgabeRueckwaerts);
    }

}
