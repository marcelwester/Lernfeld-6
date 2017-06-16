package gui11;

/*
 * Programm Messreihe1
 * Programm zum Speichern von Messwerten (Kommazahlen) in einer Datei.
 * Der Dateiname kann �ber einen Dialog festgelegt werden.
 * 
 * Hans-Peter Habelitz
 * 2014-10-05
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Messreihe1 extends JFrame {

    private JPanel contentPane;
    private JTextField tfMesswert;
    private DefaultListModel<String> messwerteModel;
    private String dateiname;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Messreihe1 frame = new Messreihe1();
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
    public Messreihe1() {
	setTitle("Messreihe speichern");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblMesswert = new JLabel("Messwert");
	lblMesswert.setBounds(10, 11, 86, 14);
	contentPane.add(lblMesswert);

	tfMesswert = new JTextField();
	tfMesswert.setBounds(10, 27, 134, 20);
	contentPane.add(tfMesswert);
	tfMesswert.setColumns(10);

	JButton btnUebernehmen = new JButton("\u00DCbernehmen >>");
	btnUebernehmen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (tfMesswert.getText().isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Messwert fehlt!");
		} else {
		    try {
			messwerteModel.addElement(tfMesswert.getText());
			tfMesswert.setText("");
			tfMesswert.requestFocus();
		    } catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
				"ung�ltiges Zahlenformat!");
			ex.printStackTrace();
		    }
		}
	    }
	});
	btnUebernehmen.setBounds(10, 58, 134, 23);
	contentPane.add(btnUebernehmen);

	JLabel lblMessreihe = new JLabel("Messreihe");
	lblMessreihe.setBounds(193, 11, 112, 14);
	contentPane.add(lblMessreihe);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(193, 27, 231, 177);
	contentPane.add(scrollPane);

	JList<String> listMessreihe = new JList<String>();
	messwerteModel = new DefaultListModel<String>();
	listMessreihe.setModel(messwerteModel);
	scrollPane.setViewportView(listMessreihe);

	JButton btnSpeichern = new JButton("Messreihe speichern");
	btnSpeichern.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileFilter(new FileNameExtensionFilter(
			"Messwertdateien *.mwd", "mwd"));
		fc.setCurrentDirectory(new File("."));
		int status = fc.showSaveDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
		    String selFile = fc.getSelectedFile().getAbsolutePath();
		    int index = selFile.indexOf('.');
		    if (index >= 0) {
			dateiname = selFile.substring(0, index).concat(".mwd");
		    } else {
			dateiname = selFile.concat(".mwd");
		    }
		    try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
				dateiname));
			for (int i = 0; i < messwerteModel.getSize(); i++) {
			    out.write(messwerteModel.get(i).toString());
			    out.newLine();
			}
			out.close();
		    } catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
				"Fehler beim Speichern!");
		    }
		}
	    }
	});
	btnSpeichern.setBounds(235, 215, 154, 23);
	contentPane.add(btnSpeichern);
    }
}
