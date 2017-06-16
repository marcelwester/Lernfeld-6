package gui14;

/*
 * Programm DBZugriff2
 * Das Programm kann als Schablone für den Datenbankzugriff verwendet werden.
 * Das Programm fragt Buchdaten (Id und Titel) aus der mysql-Datenbank xxx ab.
 * Die Daten werden in einer JTable ausgegeben.
 *  
 * Hans-Peter Habelitz
 * 2014-10-23
 */

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBZugriff2 extends JFrame {

    private JPanel contentPane;
    private JTable tableBuecher;

    static String connectURL = "jdbc:mysql://SERVERADRESSE/xxx";
    static String user = "yyy";
    static String pw = "zzz";
    static Connection conn;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    DBZugriff2 frame = new DBZugriff2();
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
    public DBZugriff2() {
	setTitle("DBZugriff2");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[grow][][][]"));

	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 0,grow");

	tableBuecher = new JTable();
	scrollPane.setViewportView(tableBuecher);

	JButton btnDatenAusDatenbank = new JButton("Daten aus Datenbank laden");
	btnDatenAusDatenbank.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		    System.err.println("Treiber konnte nicht geladen werden!");
		    System.err.println(e);
		    ex.printStackTrace();
		    System.exit(-1);
		}
		System.out.println("Treiber wurde geladen!");
		try {
		    conn = DriverManager.getConnection(connectURL, user, pw);
		    Statement stmt = conn.createStatement();
		    System.out.println("Verbindung zur Datenbank aufgebaut!");
		    // Datenabfrage aufbereiten
		    String query = "SELECT ID, Titel FROM Buecher";
		    // Schritt 3: Datenabfrage ausführen
		    ResultSet rs = stmt.executeQuery(query);
		    // Schritt 4: Ergebnismenge verarbeiten
		    DefaultTableModel model = (DefaultTableModel) tableBuecher
			    .getModel();
		    while (rs.next()) {
			model.addRow(new String[] { rs.getString("ID"),
				rs.getString("Titel") });
		    }
		    ;
		    tableBuecher.sizeColumnsToFit(0);
		    // ResultSet und Statement schließen
		    rs.close();
		    stmt.close();
		} catch (SQLException ex) {
		    System.err.println("Verbindungsaufbau gescheitert.");
		    ex.printStackTrace();
		    System.err.println("SQLExecption: " + ex.getMessage());
		    System.err.println("SQLState: " + ex.getSQLState());
		    System.err.println("VendorError: " + ex.getErrorCode());
		    System.exit(-1);
		} finally {
                    // Verbindung schließen
		    if (conn != null) {
			try {
			    conn.close();
			} catch (SQLException ex) {
			    ex.printStackTrace();
			}
		    }
		}
	    }
	});
	contentPane.add(btnDatenAusDatenbank, "cell 0 1,growx");
    }

}
