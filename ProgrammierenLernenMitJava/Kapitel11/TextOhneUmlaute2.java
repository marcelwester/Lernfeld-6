package gui11;

/*
 * Programm TextOhneUmlaute2
 * Das Programm demonstriert das Ersetzen der Umlaute durch
 * die Nutzung des OhneUmlautWriters. Der Text, der in ein 
 * TextPane eingegeben wird, kann in einer Datei ohne die 
 * Umlaute gespeichert werden. 
 * TextohneUmlaute1 wurde so erweitert, dass der Text, aus dem
 * die Umlaute entfernt werden sollen aus einer Textdatei geladen
 * werden kann.
 * 
 * Hans-Peter Habelitz
 * 2014-10-19
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextOhneUmlaute2 extends JFrame {

    private JPanel contentPane;
    private String dateiname = "." + File.separator + "ohneumlaut.txt";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TextOhneUmlaute2 frame = new TextOhneUmlaute2();
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
    public TextOhneUmlaute2() {
    	setTitle("TextOhneUmlaute2");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[grow][]"));
	
	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 0,grow");
	
	JTextPane textPane = new JTextPane();
	scrollPane.setViewportView(textPane);
	
	JButton btnOeffnen = new JButton("\u00D6ffnen");
	btnOeffnen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setFileFilter(new FileNameExtensionFilter("Textdateien *.txt", "txt"));
			fc.setCurrentDirectory(new File("."));
			int status = fc.showOpenDialog(null);
			BufferedReader in = null;
			if (status == JFileChooser.APPROVE_OPTION) {
			    dateiname = fc.getSelectedFile().getAbsolutePath();
			    try {
				in = new BufferedReader(new FileReader(dateiname));
				int c;
				StringBuffer zeile = new StringBuffer();
				while ((c = in.read()) >= 0) {
				    zeile.append((char) c);
				}
				textPane.setText(zeile.toString());

			    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Fehler beim Lesen!");
			    } finally {
				if (in != null) {
				    try {
					in.close();
				    } catch (IOException ex) {
					ex.printStackTrace();
				    }
				}
			    }
			}
		}
	});
	contentPane.add(btnOeffnen, "flowx,cell 0 1,alignx center");
	
	JButton btnSpeichern = new JButton("Speichern");
	btnSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setFileFilter(new FileNameExtensionFilter("Textdateien *.txt", "txt"));
			fc.setCurrentDirectory(new File("."));
			int status = fc.showSaveDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
			    String selFile = fc.getSelectedFile().getAbsolutePath();
			    int index = selFile.indexOf('.');
			    if (index >= 0) {
				dateiname = selFile.substring(0, index).concat(".txt");
			    } else {
				dateiname = selFile.concat(".txt");
			    }
			    OhneUmlautWriter out = null;
			    try {
				out = new OhneUmlautWriter(new FileWriter(dateiname));
				out.write(textPane.getText());
			    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Fehler beim Speichern!");
			    } finally {
				if (out != null) {
				    try {
					out.close();
				    } catch (IOException ex) {
					ex.printStackTrace();
				    }
				}
			    }
			}
		}
	});
	contentPane.add(btnSpeichern, "cell 0 1, gapx 30 px,alignx center");
    }

}
