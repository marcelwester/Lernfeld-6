package gui14;

/*Programm DBZugriffDerby2
 * Das Programm kann als Schablone für den Datenbankzugriff mit graphischer Oberfläche verwendet werden.
 * Das Programm fragt Buchdaten (ID, Titel, Autorname und Vorname) aus der Derby-Datenbank Buecherei ab.
 * Die Daten werden in einer JTable-Komponente ausgegeben.
 * 
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBZugriffDerby2 extends JFrame {

    private JPanel contentPane;
    private JTable tableBuecher;
    
    static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    static String connectURL = "jdbc:derby:./derbydbs/Buecherei;create=true";
    static Connection conn = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    DBZugriffDerby2 frame = new DBZugriffDerby2();
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
    public DBZugriffDerby2() {
    	setTitle("DBZugriffDerby2");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[grow][]"));
	
	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 0,grow");
	
	tableBuecher = new JTable();
	TableModel tableModel = new DefaultTableModel(
		new String[][] {}, new String[] { "Buchid",
				"Titel", "Autorname", "Autorvorname" });
	tableBuecher.setModel(tableModel);
	scrollPane.setViewportView(tableBuecher);
	
	JButton btnDatenAusDatenbank = new JButton("Daten aus Datenbank laden");
	btnDatenAusDatenbank.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    DefaultTableModel model = (DefaultTableModel) tableBuecher.getModel();
			// alte Einträge aus der Tabelle löschen, damit bei weiteren
			// Ladevorgängen keine doppelten Einträge entstehen
			int anzahl = model.getRowCount();
			for (int i = 0; i < anzahl; i++) {
				model.removeRow(0);
			}
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(connectURL);
				Statement stmt = conn.createStatement();
				System.out.println("Verbindung zur Datenbank aufgebaut!");
				// Datenabfrage aufbereiten
				String query = "SELECT Buecher.ID AS BuchID, Buecher.Titel AS Buchtitel, Autoren.Name AS Autorname, Autoren.Vorname AS Autorvorname FROM Buecher, Autoren WHERE Buecher.AutorId=Autoren.ID";
				// Schritt 3: Datenabfrage ausführen
				ResultSet rs = stmt.executeQuery(query);
				// Schritt 4: Ergebnismenge verarbeiten
				while (rs.next()) {
					model.addRow(new String[] { rs.getString("BuchID"),
							rs.getString("Buchtitel"), rs.getString("Autorname"),
							rs.getString("Autorvorname") });
				}

				tableBuecher.sizeColumnsToFit(0);
				// ResultSet und Statement schließen
				rs.close();
				System.out.println("Verbindung zur Datenbank geschlossen!");
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
	contentPane.add(btnDatenAusDatenbank, "cell 0 1,growx");
    }

}
