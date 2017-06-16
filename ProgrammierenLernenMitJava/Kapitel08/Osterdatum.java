package gui;

/*
 * Programm Osterdatum berechnet aus der eingegebenen
 * Jahreszahl das zugehörige Osterdatum.
 * Hans-Peter Habelitz
 * 2014-08-24
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Osterdatum extends JFrame {

    private JPanel contentPane;
    private JTextField tfJahreszahl;
    private JLabel lblDatum;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Osterdatum frame = new Osterdatum();
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
    public Osterdatum() {
    	setTitle("Osterdatum");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 431, 209);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblJahr = new JLabel("Jahr");
	lblJahr.setBounds(10, 11, 84, 14);
	contentPane.add(lblJahr);
	
	tfJahreszahl = new JTextField();
	tfJahreszahl.setBounds(8, 26, 86, 20);
	contentPane.add(tfJahreszahl);
	tfJahreszahl.setColumns(10);
	
	JButton btnBerechnen = new JButton("Datum f\u00FCr Ostersonntag berechnen");
	btnBerechnen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    berechnen();
		}
	});
	btnBerechnen.setBounds(112, 25, 262, 23);
	contentPane.add(btnBerechnen);
	
	JLabel lblDatumOstersonntag = new JLabel("Datum f\u00FCr Ostersonntag:");
	lblDatumOstersonntag.setBounds(10, 86, 148, 14);
	contentPane.add(lblDatumOstersonntag);
	
	lblDatum = new JLabel("Berechnung nur f\u00FCr Jahreszahl > 1583");
	lblDatum.setBounds(167, 86, 238, 14);
	contentPane.add(lblDatum);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(204, 129, 89, 23);
	contentPane.add(btnEnde);
    }
    
    private void berechnen() {
	int y = Integer.parseInt(tfJahreszahl.getText());
	if (y > 1583) {
	    int g = y % 19;
	    int c = y / 100;
	    int h = (c - c / 4 - (8 * c + 13) / 25 + 19 * g + 15) % 30;
	    int i = h - (h / 28) * (1 - (29 / (h + 1)) * ((21 - g) / 11));
	    int j = (y + y / 4 + i + 2 - c + c / 4) % 7;
	    int l = i - j;
	    int m = 3 + (l + 40) / 44;
	    int d = l + 28 - 31 * (m / 4);
	    lblDatum.setText(d + "." + m + ".");
	} else {
	    lblDatum.setText("Berechnung nur für Jahreszahl > 1583");
	}
	tfJahreszahl.requestFocus();
	tfJahreszahl.selectAll();
    }

}
