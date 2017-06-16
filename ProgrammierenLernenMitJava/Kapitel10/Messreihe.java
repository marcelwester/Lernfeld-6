package gui10;

/*
 * Programm Messreihe zur Erfassung von Messdaten
 * 
 * Hans-Peter Habelitz
 * 2014-08-31
 */

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

public class Messreihe extends JFrame {

    private JPanel contentPane;
    private JTextField tfAnzahl;
    private JTextField tfMesswert;
    private JTextField tfIndexEingabe;
    private JTextField tfWert;
    private JLabel lblWievieleMesswerte;
    private JLabel lblMesswert;
    private JButton btnEingabeMesswert;
    private JLabel lblMesswerte;
    private JButton btnBearbeiten;
    private JButton btnMessreiheAuswerten;
    private JLabel lblMesswertindex;
    private JButton btnSpeichern;
    private JLabel lblWert;
    private JLabel lblMaximalwert;
    private JLabel lblMinimalwert;
    private JLabel lblMittelwert;
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
		    Messreihe frame = new Messreihe();
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
    public Messreihe() {
    	setTitle("Messreihe");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 540, 343);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	lblWievieleMesswerte = new JLabel("Wieviele Messwerte sollen eingegeben werden?");
	lblWievieleMesswerte.setBounds(10, 11, 284, 14);
	contentPane.add(lblWievieleMesswerte);
	
	tfAnzahl = new JTextField();
	tfAnzahl.setBounds(304, 8, 70, 20);
	contentPane.add(tfAnzahl);
	tfAnzahl.setColumns(10);
	
	JButton btnEingabeAnzahl = new JButton("OK");
	btnEingabeAnzahl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    anzahl = Integer.parseInt(tfAnzahl.getText());
			    lblWievieleMesswerte.setVisible(false);
			    tfAnzahl.setVisible(false);
			    btnEingabeAnzahl.setVisible(false);
			    n++;
			    lblMesswert.setText(n + ". Messwert:");
			    messwerte = new double[anzahl];
			    lblMesswert.setVisible(true);
			    tfMesswert.setVisible(true);
			    btnEingabeMesswert.setVisible(true);
			    tfMesswert.requestFocus();
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
			    tfAnzahl.requestFocus();
			}
		}
	});
	btnEingabeAnzahl.setBounds(394, 7, 89, 23);
	contentPane.add(btnEingabeAnzahl);
	
	lblMesswert = new JLabel("Messwert");
	lblMesswert.setVisible(false);
	lblMesswert.setBounds(10, 36, 100, 14);
	contentPane.add(lblMesswert);
	
	tfMesswert = new JTextField();
	tfMesswert.setVisible(false);
	tfMesswert.setBounds(10, 51, 111, 20);
	contentPane.add(tfMesswert);
	tfMesswert.setColumns(10);
	
	btnEingabeMesswert = new JButton("OK");
	btnEingabeMesswert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (n <= anzahl) {
			    try {
				messwerte[n - 1] = Double.parseDouble(tfMesswert.getText());
				n++;
				lblMesswert.setText(n + ". Messwert:");
				tfMesswert.setText("");
				tfMesswert.requestFocus();
			    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ungültige Zahlenangabe!");
			    }
			}
			if (n > anzahl) {
			    lblMesswerte.setText("Messwerte:");
			    for (double a : messwerte) {
				lblMesswerte.setText(lblMesswerte.getText() + " " + a);
			    }
			    lblMesswerte.setVisible(true);
			    lblMesswert.setVisible(false);
			    tfMesswert.setVisible(false);
			    btnEingabeMesswert.setVisible(false);
			    lblMesswertindex.setVisible(true);
			    tfIndexEingabe.setVisible(true);
			    btnBearbeiten.setVisible(true);
			    btnMessreiheAuswerten.setVisible(true);
			}
		}
	});
	btnEingabeMesswert.setVisible(false);
	btnEingabeMesswert.setBounds(139, 50, 89, 23);
	contentPane.add(btnEingabeMesswert);
	
	lblMesswerte = new JLabel("Messwerte: ");
	lblMesswerte.setBounds(10, 82, 504, 14);
	contentPane.add(lblMesswerte);
	
	tfIndexEingabe = new JTextField();
	tfIndexEingabe.setVisible(false);
	tfIndexEingabe.setBounds(10, 107, 59, 20);
	contentPane.add(tfIndexEingabe);
	tfIndexEingabe.setColumns(10);
	
	lblMesswertindex = new JLabel(". Messwert");
	lblMesswertindex.setVisible(false);
	lblMesswertindex.setBounds(75, 110, 70, 14);
	contentPane.add(lblMesswertindex);
	
	btnBearbeiten = new JButton("Bearbeiten");
	btnBearbeiten.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    index = Integer.parseInt(tfIndexEingabe.getText());
			    index--;
			    if ((index >= 0) && (index < messwerte.length)) {
				messwert = messwerte[index];
				tfWert.setText(String.valueOf(messwert));
				lblWert.setVisible(true);
				tfWert.setVisible(true);
				btnSpeichern.setVisible(true);
				tfWert.requestFocus();
			    } else {
				JOptionPane.showMessageDialog(null,
					"Index außerhalb der Messreihe!");
				tfIndexEingabe.requestFocus();
			    }

			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(null, "Ungültiges Zahlenformat!");
			    tfIndexEingabe.requestFocus();
			}
		}
	});
	btnBearbeiten.setVisible(false);
	btnBearbeiten.setBounds(155, 107, 111, 23);
	contentPane.add(btnBearbeiten);
	
	lblWert = new JLabel("Wert");
	lblWert.setVisible(false);
	lblWert.setBounds(10, 149, 46, 14);
	contentPane.add(lblWert);
	
	tfWert = new JTextField();
	tfWert.setVisible(false);
	tfWert.setBounds(10, 164, 111, 20);
	contentPane.add(tfWert);
	tfWert.setColumns(10);
	
	btnSpeichern = new JButton("Speichern");
	btnSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    messwert = Double.parseDouble(tfWert.getText());
			    messwerte[index] = messwert;
			    lblMesswerte.setText("Messwerte:");
			    for (double a : messwerte) {
				lblMesswerte.setText(lblMesswerte.getText() + " " + a);
			    }
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(null, "Ungültiges Zahlenformat!");
			    tfWert.requestFocus();
			}
		}
	});
	btnSpeichern.setVisible(false);
	btnSpeichern.setBounds(155, 163, 111, 23);
	contentPane.add(btnSpeichern);
	
	btnMessreiheAuswerten = new JButton("Messreihe auswerten");
	btnMessreiheAuswerten.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		summe = 0;
		minimum = messwerte[0];
		maximum = messwerte[0];
		for (double mw : messwerte) {
		    if (minimum > mw) {
			minimum = mw;
		    }
		    if (maximum < mw) {
			maximum = mw;
		    }
		    summe = summe + mw;
		}
		mittelwert = summe / messwerte.length;
		lblMinimalwert.setText("Minimalwert: " + String.valueOf(minimum));
		lblMaximalwert.setText("Maximalwert: " + String.valueOf(maximum));
		lblMittelwert.setText("Mittelwert: "
			+ String.valueOf(mittelwert));
	    }
	});
	btnMessreiheAuswerten.setVisible(false);
	btnMessreiheAuswerten.setBounds(10, 195, 176, 23);
	contentPane.add(btnMessreiheAuswerten);
	
	lblMaximalwert = new JLabel("Maximalwert");
	lblMaximalwert.setBounds(10, 229, 148, 14);
	contentPane.add(lblMaximalwert);
	
	lblMinimalwert = new JLabel("Minimalwert");
	lblMinimalwert.setBounds(10, 254, 148, 14);
	contentPane.add(lblMinimalwert);
	
	lblMittelwert = new JLabel("Mittelwert");
	lblMittelwert.setBounds(10, 279, 148, 14);
	contentPane.add(lblMittelwert);
    }

}