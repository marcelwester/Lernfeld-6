package gui14;

/*
 * Programm DBZugriffDerby1
 * Das Programm kann als Schablone für den Datenbankzugriff verwendet werden.
 * Das Programm fragt Buchdaten (ID, Titel, Autorname und Vorname) aus der Derby-Datenbank Buecherei ab.
 * Die Daten werden zeilenweise in der Console ausgegeben.
 * 
 *  
 * Hans-Peter Habelitz
 * 2013-12-23
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBZugriffDerby1 {
	static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	static String connectURL = "jdbc:derby:./derbydbs/Buecherei;create=true";
	static Connection conn = null;

	public static void main(String Args[]) {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(connectURL);
			Statement stmt = conn.createStatement();
			// Datenabfrage aufbereiten
			String query = "select Buecher.ID as BuchID, Buecher.Titel as Buchtitel, Autoren.Name as Autorname, Autoren.Vorname as Autorvorname from Buecher, Autoren where Buecher.AutorId=Autoren.ID";
			// Schritt 3: Datenabfrage ausführen
			ResultSet rs = stmt.executeQuery(query);
			// Schritt 4: Ergebnismenge verarbeiten
			System.out.println("ID\t\tTitel\t\tAutorname\t\tAutorvorname");
			System.out
					.println("-----------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getString("BuchID") + "\t"
						+ rs.getString("Buchtitel") + "\t"
						+ rs.getString("Autorname") + "\t"
						+ rs.getString("Autorvorname"));
			}
			;
			// ResultSet und Statement schließen
			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.err.println("Keine Verbindung möglich.");
			e.printStackTrace();
			System.exit(-1);
		} finally {
			if (conn != null) {
                              // Verbindung schließen
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}