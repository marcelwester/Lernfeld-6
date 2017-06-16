package gui14;

/*
 * Programm Stundenplan2
 * Das Programm speichert den eingegebenen Stundenplan beim
 * Beenden des Programms in der Datei stundenplan.dat.
 * Beim Programmstart wird geprüft, ob eine Stundenplandatei
 * existiert. Ist dies der Fall, werden die Stundenplandaten in
 * die Tabelle eingelesen.
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Stundenplan2 extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableStundenplan;
    private String dateiname = "." + File.separator + "stundenplan.dat";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Stundenplan2 frame = new Stundenplan2();
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
    public Stundenplan2() {
	addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
		BufferedWriter out = null;
		try {
		    out = new BufferedWriter(new FileWriter(dateiname));
		    for (int i = 0; i < tableStundenplan.getModel()
			    .getRowCount(); i++) {
			for (int j = 1; j < tableStundenplan.getModel()
				.getColumnCount(); j++) {
			    if (tableStundenplan.getModel().getValueAt(i, j) != null) {
				out.write(tableStundenplan.getModel()
					.getValueAt(i, j).toString());
			    } else {
				out.write("");
			    }

			    out.newLine();
			}
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
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
	});
	setTitle("Stundenplan");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));

	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 0,grow");

	tableStundenplan = new JTable();
	tableStundenplan.setModel(new DefaultTableModel(new Object[][] {
		{ "1", null, null, null, null, null },
		{ "2", null, null, null, null, null },
		{ "3", null, null, null, null, null },
		{ "4", null, null, null, null, null },
		{ "5", null, null, null, null, null },
		{ "6", null, null, null, null, null },
		{ "7", null, null, null, null, null },
		{ "8", null, null, null, null, null },
		{ "9", null, null, null, null, null },
		{ "10", null, null, null, null, null }, }, new String[] {
		"Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag",
		"Freitag" }) {
	    /**
		     * 
		     */
	    private static final long serialVersionUID = 1L;
	    Class[] columnTypes = new Class[] { String.class, String.class,
		    String.class, String.class, String.class, String.class };

	    public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	    }
	});
	scrollPane.setViewportView(tableStundenplan);
	// Einlesen der Stundenplandaten
	BufferedReader in = null;
	File datei = new File(dateiname);
	if (!datei.exists()) {
	    try {
		datei.createNewFile();
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }
	} else {
	    try {
		String eintrag;
		in = new BufferedReader(new FileReader(dateiname));
		for (int i = 0; i < tableStundenplan.getModel().getRowCount(); i++) {
		    for (int j = 1; j < tableStundenplan.getModel()
			    .getColumnCount(); j++) {
			eintrag = in.readLine();
			tableStundenplan.getModel().setValueAt(eintrag, i, j);
		    }
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    } finally {
		if (in != null) {
		    try {
			in.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		}
	    }
	}

    }

}
