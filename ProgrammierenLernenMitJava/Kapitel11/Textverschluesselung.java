package gui11;

/*
 * Programm Textverschluesselung
 * Das Programm nutzt die Komponenten VerschluesseltWriter und
 * VerschluesseltReader zur verschlüsselten Speicherung von Text.
 * 
 * Hans-Peter Habelitz
 * 2014-09-06
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Textverschluesselung extends JFrame {

    private JPanel contentPane;
    private String dateiname = "." + File.separator + "verschluesselt.txt";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Textverschluesselung frame = new Textverschluesselung();
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
    public Textverschluesselung() {
	setTitle("Verschl\u00FCsselung");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblEingabe = new JLabel("Eingabe");
	lblEingabe.setBounds(10, 11, 92, 14);
	contentPane.add(lblEingabe);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 25, 414, 149);
	contentPane.add(scrollPane);

	JTextPane textPane = new JTextPane();
	scrollPane.setViewportView(textPane);

	JButton btnSpeichern = new JButton("Speichern");
	btnSpeichern.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		VerschluesseltWriter out = null;
		try {
		    out = new VerschluesseltWriter(new FileWriter(dateiname));
		    out.write(textPane.getText());
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null,
			    "Fehler beim Speichern.");
		} finally {
		    if (out != null) {
			try {
			    out.close();
			} catch (IOException ex) {
			    JOptionPane.showMessageDialog(null,
				    "Fehler beim Speichern.");
			}
		    }
		}
	    }
	});
	btnSpeichern.setBounds(13, 185, 103, 23);
	contentPane.add(btnSpeichern);

	JButton btnVerschluesseltoeffnen = new JButton(
		"verschl\u00FCsselt \u00F6ffnen");
	btnVerschluesseltoeffnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		BufferedReader in = null;
		try {
		    in = new BufferedReader(new FileReader(dateiname));
		    int c;
		    StringBuffer inhalt = new StringBuffer();
		    while ((c = in.read()) >= 0) {
			inhalt.append((char) c);
		    }
		    textPane.setText(inhalt.toString());
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "Fehler beim Lesen.");
		} finally {
		    if (in != null) {
			try {
			    in.close();
			} catch (IOException ex) {
			    JOptionPane.showMessageDialog(null,
				    "Fehler beim Lesen.");
			}
		    }
		}
	    }
	});
	btnVerschluesseltoeffnen.setBounds(170, 185, 212, 23);
	contentPane.add(btnVerschluesseltoeffnen);

	JButton btnUnverschluesseltoeffnen = new JButton(
		"unverschl\u00FCsselt \u00F6ffnen");
	btnUnverschluesseltoeffnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		BufferedReader in = null;
		try {
		    in = new BufferedReader(new VerschluesseltReader(new FileReader(dateiname)));
		    int c;
		    StringBuffer inhalt = new StringBuffer();
		    while ((c = in.read()) >= 0) {
			inhalt.append((char) c);
		    }
		    textPane.setText(inhalt.toString());
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "Fehler beim Lesen.");
		} finally {
		    if (in != null) {
			try {
			    in.close();
			} catch (IOException ex) {
			    JOptionPane.showMessageDialog(null,
				    "Fehler beim Lesen.");
			}
		    }
		}
	    }
	});
	btnUnverschluesseltoeffnen.setBounds(170, 219, 212, 23);
	contentPane.add(btnUnverschluesseltoeffnen);
    }
}
