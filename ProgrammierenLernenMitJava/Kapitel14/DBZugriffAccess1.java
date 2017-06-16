package gui14;

/*
 * Programm DBZugriffAccess1
 * Das Programm kann als Schablone für den Datenbankzugriff verwendet werden.
 * Das Programm fragt Buchdaten (ID, Titel, Autorname und Vorname) aus der Access-Datenbank Buecherei.mdb ab.
 * Die Daten werden zeilenweise in der Console ausgegeben.
 * 
 *  
 * Hans-Peter Habelitz
 * 2011-12-28
 */

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBZugriffAccess1 {
    static String connectURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=."
	    + File.separator + "Buecherei.mdb; READONLY=false}";
    static String user = "";
    static String pw = "";
    static Connection conn = null;

    public static void main(String Args[]) {
	try {
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    conn = DriverManager.getConnection(connectURL, user, pw);
	    Statement stmt = conn.createStatement();
	    // Datenabfrage aufbereiten
	    String query = "SELECT Buecher.ID AS BuchID, Buecher.Titel AS Buchtitel, Autoren.Name AS Autorname, Autoren.Vorname AS Autorvorname FROM Buecher, Autoren WHERE Buecher.AutorId=Autoren.ID";
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
	    // Verbindung schließen
	    if (conn != null) {
		try {
		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
    }
}
