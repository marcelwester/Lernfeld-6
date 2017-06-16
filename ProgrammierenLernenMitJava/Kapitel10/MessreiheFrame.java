package gui10;

/*
 * Framevorlage für das Programm Messreihe
 * 
 * Hans-Peter Habelitz
 * 2014-08-31
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MessreiheFrame extends JFrame {

    private JPanel contentPane;
    private JTextField tfAnzahl;
    private JTextField tfMesswert;
    private JTextField tfIndexEingabe;
    private JTextField tfWert;
    private int anzahl, n, index;
    private double[] messwerte;
    private double messwert, summe, minimum, maximum, mittelwert;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MessreiheFrame frame = new MessreiheFrame();
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
    public MessreiheFrame() {
    	setTitle("Messreihe");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 540, 343);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblWievieleMesswerte = new JLabel("Wieviele Messwerte sollen eingegeben werden?");
	lblWievieleMesswerte.setBounds(10, 11, 284, 14);
	contentPane.add(lblWievieleMesswerte);
	
	tfAnzahl = new JTextField();
	tfAnzahl.setBounds(304, 8, 70, 20);
	contentPane.add(tfAnzahl);
	tfAnzahl.setColumns(10);
	
	JButton btnEingabeAnzahl = new JButton("OK");
	btnEingabeAnzahl.setBounds(394, 7, 89, 23);
	contentPane.add(btnEingabeAnzahl);
	
	JLabel lblNewLabel = new JLabel("Messwert");
	lblNewLabel.setBounds(10, 36, 100, 14);
	contentPane.add(lblNewLabel);
	
	tfMesswert = new JTextField();
	tfMesswert.setBounds(10, 51, 111, 20);
	contentPane.add(tfMesswert);
	tfMesswert.setColumns(10);
	
	JButton btnEingabeMesswert = new JButton("OK");
	btnEingabeMesswert.setBounds(139, 50, 89, 23);
	contentPane.add(btnEingabeMesswert);
	
	JLabel lblMesswerte = new JLabel("Messwerte: ");
	lblMesswerte.setBounds(10, 82, 504, 14);
	contentPane.add(lblMesswerte);
	
	tfIndexEingabe = new JTextField();
	tfIndexEingabe.setBounds(10, 107, 59, 20);
	contentPane.add(tfIndexEingabe);
	tfIndexEingabe.setColumns(10);
	
	JLabel lblMesswertindex = new JLabel(". Messwert");
	lblMesswertindex.setBounds(75, 110, 70, 14);
	contentPane.add(lblMesswertindex);
	
	JButton btnBearbeiten = new JButton("Bearbeiten");
	btnBearbeiten.setBounds(155, 107, 89, 23);
	contentPane.add(btnBearbeiten);
	
	JLabel lblWert = new JLabel("Wert");
	lblWert.setBounds(10, 149, 46, 14);
	contentPane.add(lblWert);
	
	tfWert = new JTextField();
	tfWert.setBounds(10, 164, 111, 20);
	contentPane.add(tfWert);
	tfWert.setColumns(10);
	
	JButton btnSpeichern = new JButton("Speichern");
	btnSpeichern.setBounds(155, 163, 89, 23);
	contentPane.add(btnSpeichern);
	
	JButton btnMessreiheAuswerten = new JButton("Messreihe auswerten");
	btnMessreiheAuswerten.setBounds(10, 195, 148, 23);
	contentPane.add(btnMessreiheAuswerten);
	
	JLabel lblMaximalwert = new JLabel("Maximalwert");
	lblMaximalwert.setBounds(10, 229, 148, 14);
	contentPane.add(lblMaximalwert);
	
	JLabel lblMinimalwert = new JLabel("Minimalwert");
	lblMinimalwert.setBounds(10, 254, 148, 14);
	contentPane.add(lblMinimalwert);
	
	JLabel lblMittelwert = new JLabel("Mittelwert");
	lblMittelwert.setBounds(10, 279, 148, 14);
	contentPane.add(lblMittelwert);
    }

}
