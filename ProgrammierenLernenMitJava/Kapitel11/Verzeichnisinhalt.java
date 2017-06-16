package gui11;

/*
 * Programm Verzeichnisinhalt
 * Es wird der Inhalt eines Ordners getrennt nach Verzeichnissen und Dateien
 * in zwei Listen angezeigt. Das jeweils anzuzeigende Verzeichnis wird in einem
 * Textfeld vorgegeben.
 * 
 * Hans-Peter Habelitz
 * 2014-09-02
 */

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Verzeichnisinhalt extends JFrame {

    private JPanel contentPane;
    private JTextField tfVerzeichnis;
    private File verzeichnis;
    private DefaultListModel<String> verzeichnisseModel, dateienModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Verzeichnisinhalt frame = new Verzeichnisinhalt();
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
    public Verzeichnisinhalt() {
    	setTitle("Verzeichnisinhalt");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 308);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblVerzeichnis = new JLabel("Verzeichnis");
	lblVerzeichnis.setBounds(10, 11, 161, 14);
	contentPane.add(lblVerzeichnis);
	
	tfVerzeichnis = new JTextField();
	tfVerzeichnis.setBounds(10, 25, 414, 20);
	contentPane.add(tfVerzeichnis);
	tfVerzeichnis.setColumns(10);
	
	JButton btnInhaltAnzeigen = new JButton("Inhalt anzeigen");
	btnInhaltAnzeigen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		verzeichnisseModel.clear();
		dateienModel.clear();
		if (tfVerzeichnis.getText().isEmpty()) {
		    JOptionPane.showMessageDialog(null,
			    "Verzeichnisname fehlt!");
		} else {
		    verzeichnis = new File(tfVerzeichnis.getText());
		    if (verzeichnis.exists() && verzeichnis.isDirectory()) {
			String[] inhalt = verzeichnis.list();
			for (String eintrag : inhalt) {
			    File f = new File(verzeichnis, eintrag);
			    if (f.isDirectory()) {
				verzeichnisseModel.addElement(eintrag);
			    } else {
				dateienModel.addElement(eintrag);
			    }
			}
		    } else {
			JOptionPane.showMessageDialog(null,
				"Verzeichnis existiert nicht!");
		    }
		}
	    }
	});
	btnInhaltAnzeigen.setBounds(10, 56, 161, 23);
	contentPane.add(btnInhaltAnzeigen);
	
	JLabel lblVerzeichnisse = new JLabel("Verzeichnisse");
	lblVerzeichnisse.setBounds(10, 90, 161, 14);
	contentPane.add(lblVerzeichnisse);
	
	JLabel lblDateien = new JLabel("Dateien");
	lblDateien.setBounds(229, 90, 133, 14);
	contentPane.add(lblDateien);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 105, 193, 125);
	contentPane.add(scrollPane);
	
	JList<String> listVerzeichnisse = new JList<String>();
	scrollPane.setViewportView(listVerzeichnisse);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(229, 105, 195, 125);
	contentPane.add(scrollPane_1);
	
	JList<String> listDateien = new JList<String>();
	scrollPane_1.setViewportView(listDateien);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(173, 241, 89, 23);
	contentPane.add(btnEnde);
	verzeichnisseModel = new DefaultListModel<String>();
	listVerzeichnisse.setModel(verzeichnisseModel);
	dateienModel = new DefaultListModel<String>();
	listDateien.setModel(dateienModel);
    }
}
