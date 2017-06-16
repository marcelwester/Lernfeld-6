package gui14;

/*
 * Programm Stundenplan
 * Das Programm demonstriert die Erstellung einer Tabelle mit
 * Spalten- und Zeilenbeschriftung.
 * Es wird eine Tabelle zur Erstellung eines Stundenplans erstellt.
 * Die Zellen sind bereits editierbar, so dass der Stundenplan aus-
 * gefüllt werden kann.
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Stundenplan extends JFrame {

    private JPanel contentPane;
    private JTable tableStundenplan;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Stundenplan frame = new Stundenplan();
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
    public Stundenplan() {
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
	tableStundenplan.setModel(new DefaultTableModel(
		new Object[][] {
			{"1", null, null, null, null, null},
			{"2", null, null, null, null, null},
			{"3", null, null, null, null, null},
			{"4", null, null, null, null, null},
			{"5", null, null, null, null, null},
			{"6", null, null, null, null, null},
			{"7", null, null, null, null, null},
			{"8", null, null, null, null, null},
			{"9", null, null, null, null, null},
			{"10", null, null, null, null, null},
		},
		new String[] {
			"Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"
		}
	) {
		Class[] columnTypes = new Class[] {
			String.class, String.class, String.class, String.class, String.class, String.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	});
	scrollPane.setViewportView(tableStundenplan);


    }

}
