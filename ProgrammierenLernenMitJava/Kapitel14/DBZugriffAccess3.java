package gui14;

/*Programm DBZugriffAccess3
 * Das Programm kann als Schablone für den Datenbankzugriff mit graphischer Oberfläche verwendet werden.
 * Das Programm fragt die Autordaten (ID, Autorname und Vorname) aus der Access-Datenbank Buecherei.mdb ab.
 * Die Daten werden in einer JTable-Komponente ausgegeben.
 * Es können einzelne Datensätze gelöscht, ergänzt und überschrieben werden.
 *  
 * Hans-Peter Habelitz
 * 2011-12-28
 */

import java.awt.EventQueue;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

public class DBZugriffAccess3 extends JFrame {

    private JPanel contentPane;

    static String connectURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=."
	    + File.separator + "Buecherei.mdb; READONLY=false}";
    static String user = "";
    static String pw = "";
    static Connection conn = null;
    private JTextField tfName;
    private JTextField tfVorname;
    private JTable tableBuecher;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    DBZugriffAccess3 frame = new DBZugriffAccess3();
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
    public DBZugriffAccess3() {
	setTitle("DBZugriffAccess3");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 631, 355);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[141.00,grow][]"));

	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 0,grow");

	tableBuecher = new JTable();
	TableModel tableModel = new DefaultTableModel(new String[][] {},
		new String[] { "ID", "Autorname", "Autorvorname" });
	tableBuecher.setModel(tableModel);
	scrollPane.setViewportView(tableBuecher);

	JPanel panel = new JPanel();
	contentPane.add(panel, "cell 0 1,grow");
	panel.setLayout(new MigLayout("", "[][grow][][grow]", "[][][]"));

	JButton btnDatenAusDatenbank = new JButton("Daten aus Datenbank laden");
	btnDatenAusDatenbank.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) tableBuecher
			.getModel();
		// alt Einträge aus der Tabelle löschen
		int anzahlZeilen = model.getRowCount();
		for (int i = 0; i < anzahlZeilen; i++) {
		    model.removeRow(0);
		}
		// Einträge aus der Datenbank holen und in die Tabelle eintragen
		try {
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
		    conn = DriverManager.getConnection(connectURL, user, pw);
		    Statement stmt = conn.createStatement();
		    System.out.println("Verbindung zur Datenbank aufgebaut!");
		    // Datenabfrage aufbereiten
		    String query = "SELECT ID, Name, Vorname FROM Autoren";
		    // Schritt 3: Datenabfrage ausführen
		    ResultSet rs = stmt.executeQuery(query);
		    // Schritt 4: Ergebnismenge verarbeiten
		    while (rs.next()) {
			model.addRow(new String[] { rs.getString("ID"),
				rs.getString("Name"), rs.getString("Vorname") });
		    }

		    tableBuecher.sizeColumnsToFit(0);
		    // ResultSet schließen
		    rs.close();
		    System.out.println("Verbindung zur Datenbank geschlossen!");
                    // Statement schließen
		    stmt.close();
		} catch (Exception ex) {
		    System.err.println(e);
		    ex.printStackTrace();
		} finally {
                    // Verbindung schließen
		    if (conn != null) {
			try {
			    conn.close();
			} catch (Exception ex) {
			    ex.printStackTrace();
			}
		    }
		}
	    }
	});
	panel.add(btnDatenAusDatenbank, "cell 1 0");

	JButton btnMarkiertenDatensatzLoeschen = new JButton(
		"markierten Datensatz l\u00F6schen");
	btnMarkiertenDatensatzLoeschen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// ID der markierten Zeile ermitteln
		int markierteZeile;
		String markierteID;
		DefaultTableModel model = (DefaultTableModel) tableBuecher
			.getModel();
		markierteZeile = tableBuecher.getSelectedRow();
		// Löschen des markierten Datensatzes, wenn eine Zeile markiert
		// ist
		if (markierteZeile >= 0) {
		    try {
			markierteID = (String) model.getValueAt(markierteZeile,
				0);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")
				.newInstance();
			conn = DriverManager
				.getConnection(connectURL, user, pw);
			Statement stmt = conn.createStatement();
			System.out
				.println("Verbindung zur Datenbank aufgebaut!");
			// Datenabfrage aufbereiten
			String query = "DELETE FROM Autoren WHERE ID = "
				+ markierteID;
			System.out.println(query);
			// Schritt 3: Datenabfrage ausführen
			int count = stmt.executeUpdate(query);
			tableBuecher.sizeColumnsToFit(0);
			System.out.println(count + " Datensätze gelöscht!");
			// Statement schließen
			System.out
				.println("Verbindung zur Datenbank geschlossen!");
			stmt.close();
			// Daten zur Synchronisation erneut aus der Datenbank
			// holen
			btnDatenAusDatenbank.doClick();
		    } catch (Exception ex) {
			ex.printStackTrace();
		    } finally {
                         // Verbindung schließen
			if (conn != null) {
			    try {
				conn.close();
			    } catch (Exception ex) {
				ex.printStackTrace();
			    }
			}
		    }
		}
	    }
	});
	panel.add(btnMarkiertenDatensatzLoeschen, "cell 3 0");

	JLabel lblName = new JLabel("Name:");
	panel.add(lblName, "cell 0 1,alignx trailing");

	tfName = new JTextField();
	panel.add(tfName, "cell 1 1,growx");
	tfName.setColumns(10);

	JLabel lblVorname = new JLabel("Vorname:");
	panel.add(lblVorname, "cell 2 1,alignx trailing");

	tfVorname = new JTextField();
	panel.add(tfVorname, "cell 3 1,growx");
	tfVorname.setColumns(10);

	JButton btnMarkiertenDatensatzUeberschreiben = new JButton(
		"markierten Datensatz \u00FCberschreiben");
	btnMarkiertenDatensatzUeberschreiben
		.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			// ID der markierten Zeile ermitteln
			int markierteZeile;
			String markierteID;
			DefaultTableModel model = (DefaultTableModel) tableBuecher
				.getModel();
			markierteZeile = tableBuecher.getSelectedRow();
			// Überschreiben des markierten Datensatzes, wenn eine
			// Zeile markiert
			// ist
			if (markierteZeile >= 0) {
			    markierteID = (String) model.getValueAt(
				    markierteZeile, 0);
			    try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")
					.newInstance();
				conn = DriverManager.getConnection(connectURL,
					user, pw);
				Statement stmt = conn.createStatement();
				System.out
					.println("Verbindung zur Datenbank aufgebaut!");
				// Datenabfrage aufbereiten
				String query = "UPDATE Autoren SET Name = '"
					+ tfName.getText() + "', Vorname = '"
					+ tfVorname.getText() + "' WHERE ID = "
					+ markierteID;
				// Schritt 3: Datenabfrage ausführen
				int count = stmt.executeUpdate(query);
				tableBuecher.sizeColumnsToFit(0);
				System.out.println(count
					+ " Datensätze eingefügt!");
				// Statement schließen schließen
				System.out
					.println("Verbindung zur Datenbank geschlossen!");
				stmt.close();
				btnDatenAusDatenbank.doClick();
			    } catch (Exception ex) {
				System.err.println(e);
				ex.printStackTrace();
			    } finally {
                            // Verbindung schließen
				if (conn != null) {
				    try {
					conn.close();
				    } catch (Exception ex) {
					ex.printStackTrace();
				    }
				}
			    }
			}
		    }
		});
	panel.add(btnMarkiertenDatensatzUeberschreiben, "cell 1 2");

	JButton btnAlsNeuenDatensatz = new JButton(
		"als neuen Datensatz \u00FCbernehmen");
	btnAlsNeuenDatensatz.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
		    conn = DriverManager.getConnection(connectURL, user, pw);
		    Statement stmt = conn.createStatement();
		    System.out.println("Verbindung zur Datenbank aufgebaut!");
		    // Datenabfrage aufbereiten
		    String query = "INSERT INTO Autoren (Name, Vorname) VALUES ('"
			    + tfName.getText()
			    + "', '"
			    + tfVorname.getText()
			    + "')";
		    // Schritt 3: Datenabfrage ausführen
		    int count = stmt.executeUpdate(query);
		    tableBuecher.sizeColumnsToFit(0);
		    System.out.println(count + " Datensätze eingefügt!");
		    // Verbindung schließen
		    System.out.println("Verbindung zur Datenbank geschlossen!");
		    stmt.close();
		    btnDatenAusDatenbank.doClick();
		} catch (Exception ex) {
		    System.err.println(ex);
		    ex.printStackTrace();
		} finally {
		    if (conn != null) {
			try {
			    conn.close();
			} catch (Exception ex) {
			    ex.printStackTrace();
			}
		    }
		}
	    }
	});
	panel.add(btnAlsNeuenDatensatz, "cell 3 2");
    }

}
