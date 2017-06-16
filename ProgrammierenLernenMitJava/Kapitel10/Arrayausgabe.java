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

public class Arrayausgabe extends JFrame {

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
		    Arrayausgabe frame = new Arrayausgabe();
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
    public Arrayausgabe() {
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
	btnEingabeAnzahl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    anzahl = Integer.parseInt(tfAnzahl.getText());
			    lblWievieleZahlen.setVisible(false);
			    tfAnzahl.setVisible(false);
			    btnEingabeAnzahl.setVisible(false);
			    n++;
			    lblZahl.setText(n + ". Zahl:");
			    zahlen = new int[anzahl];
			    lblZahl.setVisible(true);
			    tfZahl.setVisible(true);
			    btnEingabeZahl.setVisible(true);
			    tfZahl.requestFocus();
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
			    tfAnzahl.requestFocus();
			}
		}
	});
	btnEingabeAnzahl.setBounds(395, 7, 89, 23);
	contentPane.add(btnEingabeAnzahl);
	
	lblZahl = new JLabel("Zahl");
	lblZahl.setVisible(false);
	lblZahl.setBounds(10, 54, 63, 14);
	contentPane.add(lblZahl);
	
	tfZahl = new JTextField();
	tfZahl.setVisible(false);
	tfZahl.setBounds(10, 69, 86, 20);
	contentPane.add(tfZahl);
	tfZahl.setColumns(10);
	
	btnEingabeZahl = new JButton("OK");
	btnEingabeZahl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (n <= anzahl) {
			    try {
				zahlen[n - 1] = Integer.parseInt(tfZahl.getText());
				n++;
				lblZahl.setText(n + ". Zahl:");
				tfZahl.setText("");
				tfZahl.requestFocus();
			    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ungültige Zahlenangabe!");
			    }
			}
			if (n > anzahl) {
			    lblAusgabeVorwaerts.setText("");
			    lblAusgabeRueckwaerts.setText("");
			    for (int a : zahlen) {
				lblAusgabeVorwaerts.setText(lblAusgabeVorwaerts.getText() + a
					+ " ");
			    }
			    for (int x = n - 2; x >= 0; x--) {
				lblAusgabeRueckwaerts.setText(lblAusgabeRueckwaerts.getText()
					+ zahlen[x] + " ");
			    }
			    lblAusgabeVorwaerts.setVisible(true);
			    lblAusgabeRueckwaerts.setVisible(true);
			    lblZahl.setVisible(false);
			    tfZahl.setVisible(false);
			    btnEingabeZahl.setVisible(false);
			    btnNeueEingabe.setVisible(true);
			}
		}
	});
	btnEingabeZahl.setVisible(false);
	btnEingabeZahl.setBounds(117, 68, 89, 23);
	contentPane.add(btnEingabeZahl);
	
	btnNeueEingabe = new JButton("Neue Eingabe");
	btnNeueEingabe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    lblAusgabeVorwaerts.setVisible(false);
			lblAusgabeRueckwaerts.setVisible(false);
			btnNeueEingabe.setVisible(false);
			lblWievieleZahlen.setVisible(true);
			tfAnzahl.setVisible(true);
			btnEingabeAnzahl.setVisible(true);
			n = 0;
			tfAnzahl.requestFocus();
		}
	});
	btnNeueEingabe.setVisible(false);
	btnNeueEingabe.setBounds(259, 68, 134, 23);
	contentPane.add(btnNeueEingabe);
	
	lblAusgabeVorwaerts = new JLabel("Ausgabe vorw\u00E4rts");
	lblAusgabeVorwaerts.setVisible(false);
	lblAusgabeVorwaerts.setBounds(10, 130, 474, 14);
	contentPane.add(lblAusgabeVorwaerts);
	
	lblAusgabeRueckwaerts = new JLabel("Ausgabe r\u00FCckw\u00E4rts");
	lblAusgabeRueckwaerts.setVisible(false);
	lblAusgabeRueckwaerts.setBounds(10, 155, 474, 14);
	contentPane.add(lblAusgabeRueckwaerts);
    }

}
