package gui14;

/*
 * Programm Stundenplan3
 * Das Programm speichert den eingegebenen Stundenplan beim
 * Beenden des Programms in der Datei stundenplan.dat.
 * Beim Programmstart wird geprüft, ob eine Stundenplandatei
 * existiert. Ist dies der Fall, werden die Stundenplandaten in
 * die Tabelle eingelesen.
 * Es können zusätzlich eine Spalte für den Samstag und
 * zusätzliche Zeilen für mehr Stunden pro Tag angelegt werden.
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stundenplan3 extends JFrame {

    private JPanel contentPane;
    private JTable tableStundenplan;
    private String dateiname = "." + File.separator + "stundenplanV2.dat";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Stundenplan3 frame = new Stundenplan3();
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
    public Stundenplan3() {
	addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
		BufferedWriter out = null;
		try {
		    out = new BufferedWriter(new FileWriter(dateiname));
		    out.write(String.valueOf(tableStundenplan.getModel().getRowCount()));
		    out.newLine();
		    out.write(String.valueOf(tableStundenplan.getModel().getColumnCount()));
		    out.newLine();
		    for (int i = 0; i < tableStundenplan.getModel()
			    .getRowCount(); i++) {
			for (int j = 0; j < tableStundenplan.getModel()
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
	setTitle("Stundenplan3");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[grow][]"));

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
		"Freitag" }));
	scrollPane.setViewportView(tableStundenplan);

	JButton btnNeueZeile = new JButton("Neue Zeile");
	btnNeueZeile.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		int neuezeilenzahl = tableStundenplan.getModel().getRowCount() + 1;
		DefaultTableModel model = (DefaultTableModel) tableStundenplan
			.getModel();
		model.addRow(new String[] { String.valueOf(neuezeilenzahl) });
	    }
	});
	contentPane.add(btnNeueZeile, "flowx,cell 0 1,alignx center");

	JButton btnSamstagErgaenzen = new JButton("Samstag erg\u00E4nzen");
	btnSamstagErgaenzen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		((DefaultTableModel) tableStundenplan.getModel())
			.addColumn(new String("Samstag"));
		btnSamstagErgaenzen.setEnabled(false);
	    }
	});
	contentPane.add(btnSamstagErgaenzen, "cell 0 1");
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
		eintrag = in.readLine();
		int zeilen = Integer.parseInt(eintrag);
		eintrag = in.readLine();
		int spalten = Integer.parseInt(eintrag);
		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) tableStundenplan.getModel();
		if (spalten == 7) {
		    model.addColumn(new String("Samstag"));
		    btnSamstagErgaenzen.setEnabled(false);
		}
		for (int i = 0; i < zeilen; i++) {
		    if (i > 9) {
			model.addRow(new String[] { String.valueOf(i + 1) });
		    }
		    for (int j = 0; j < spalten; j++) {
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
