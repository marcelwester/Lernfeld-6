package gui10;

/*
 * Programm MessreiheArrayList zur Messdatenerfassung unter Verwendung
 * einer ArrayList
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
import java.util.ArrayList;

public class MessreiheArrayList extends JFrame {

    private JPanel contentPane;
    private JTextField tfMesswert;
    private JTextField tfIndexEingabe;
    private JTextField tfWert;
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
    private int anzahl, index;
    private ArrayList<Double> messwerte;
    private double messwert, summe, minimum, maximum, mittelwert;
    private JButton btnLoeschen;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MessreiheArrayList frame = new MessreiheArrayList();
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
    public MessreiheArrayList() {
    	setTitle("Messreihe");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 375, 312);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	lblMesswert = new JLabel("Messwert");
	lblMesswert.setBounds(10, 11, 100, 14);
	contentPane.add(lblMesswert);
	
	tfMesswert = new JTextField();
	tfMesswert.setBounds(10, 26, 111, 20);
	contentPane.add(tfMesswert);
	tfMesswert.setColumns(10);
	
	btnEingabeMesswert = new JButton("OK");
	btnEingabeMesswert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    messwerte.add(Double.parseDouble(tfMesswert.getText()));
			    anzahl++;
			    lblMesswert.setText(anzahl + 1 + ". Messwert:");
			    tfMesswert.setText("");
			    tfMesswert.requestFocus();
			    tfIndexEingabe.setVisible(true);
			    lblMesswertindex.setVisible(true);
			    btnBearbeiten.setVisible(true);
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(null, "Ungültige Zahlenangabe!");
			}
			lblMesswerte.setText("Messwerte:");
			for (double a : messwerte) {
			    lblMesswerte.setText(lblMesswerte.getText() + " " + a);
			}
			lblMesswerte.setVisible(true);
			lblMesswertindex.setVisible(true);
			tfIndexEingabe.setVisible(true);
			btnBearbeiten.setVisible(true);
			btnMessreiheAuswerten.setVisible(true);
		}
	});
	btnEingabeMesswert.setBounds(139, 25, 89, 23);
	contentPane.add(btnEingabeMesswert);
	
	lblMesswerte = new JLabel("Messwerte: ");
	lblMesswerte.setBounds(10, 57, 339, 14);
	contentPane.add(lblMesswerte);
	
	tfIndexEingabe = new JTextField();
	tfIndexEingabe.setVisible(false);
	tfIndexEingabe.setBounds(10, 82, 59, 20);
	contentPane.add(tfIndexEingabe);
	tfIndexEingabe.setColumns(10);
	
	lblMesswertindex = new JLabel(". Messwert");
	lblMesswertindex.setVisible(false);
	lblMesswertindex.setBounds(75, 85, 70, 14);
	contentPane.add(lblMesswertindex);
	
	btnBearbeiten = new JButton("Bearbeiten");
	btnBearbeiten.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    index = Integer.parseInt(tfIndexEingabe.getText());
			    index--;
			    if ((index >= 0) && (index < messwerte.size())) {
				messwert = messwerte.get(index);
				tfWert.setText(String.valueOf(messwert));
				lblWert.setVisible(true);
				tfWert.setVisible(true);
				btnSpeichern.setVisible(true);
				btnLoeschen.setVisible(true);
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
	btnBearbeiten.setBounds(155, 82, 111, 23);
	contentPane.add(btnBearbeiten);
	
	lblWert = new JLabel("Wert");
	lblWert.setVisible(false);
	lblWert.setBounds(10, 124, 46, 14);
	contentPane.add(lblWert);
	
	tfWert = new JTextField();
	tfWert.setVisible(false);
	tfWert.setBounds(10, 139, 111, 20);
	contentPane.add(tfWert);
	tfWert.setColumns(10);
	
	btnSpeichern = new JButton("Speichern");
	btnSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    messwert = Double.parseDouble(tfWert.getText());
			    messwerte.set(index, messwert);
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
	btnSpeichern.setBounds(131, 138, 111, 23);
	contentPane.add(btnSpeichern);
	
	btnMessreiheAuswerten = new JButton("Messreihe auswerten");
	btnMessreiheAuswerten.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		summe = 0;
		minimum = messwerte.get(0);
		maximum = messwerte.get(0);
		for (double mw : messwerte) {
		    if (minimum > mw) {
			minimum = mw;
		    }
		    if (maximum < mw) {
			maximum = mw;
		    }
		    summe = summe + mw;
		}
		mittelwert = summe / messwerte.size();
		lblMinimalwert.setText("Minimalwert: " + String.valueOf(minimum));
		lblMaximalwert.setText("Maximalwert: " + String.valueOf(maximum));
		lblMittelwert.setText("Mittelwert: " + String.valueOf(mittelwert));
	    }
	});
	btnMessreiheAuswerten.setVisible(false);
	btnMessreiheAuswerten.setBounds(10, 170, 176, 23);
	contentPane.add(btnMessreiheAuswerten);
	
	lblMaximalwert = new JLabel("Maximalwert");
	lblMaximalwert.setBounds(10, 204, 148, 14);
	contentPane.add(lblMaximalwert);
	
	lblMinimalwert = new JLabel("Minimalwert");
	lblMinimalwert.setBounds(10, 229, 148, 14);
	contentPane.add(lblMinimalwert);
	
	lblMittelwert = new JLabel("Mittelwert");
	lblMittelwert.setBounds(10, 254, 148, 14);
	contentPane.add(lblMittelwert);
	
	btnLoeschen = new JButton("L\u00F6schen");
	btnLoeschen.setVisible(false);
	btnLoeschen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    anzahl--;
			messwerte.remove(index);
			lblMesswerte.setText("Messwerte:");
			for (double a : messwerte) {
			    lblMesswerte.setText(lblMesswerte.getText() + " " + a);
			}
		}
	});
	btnLoeschen.setBounds(252, 138, 97, 23);
	contentPane.add(btnLoeschen);
	messwerte = new ArrayList<Double>();
	anzahl=0;
	lblMesswert.setText("1. Messwert:");
    }
}