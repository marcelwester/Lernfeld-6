package gui14;

/*Programm Write2DerbyBuechereiDB
 * Das Programm schreibt zwei Beispieldatensätze in die Derby-Datenbank Buecherei2.
 * In die Tabelle Buecher werden ID, Titel und als Schlüssel für die Tabelle Autoren
 * die AutorID geschrieben. In die Tabelle Autoren werden AutorID und Vor- und Nachname
 * des Autors geschrieben.
 *  
 * Hans-Peter Habelitz
 * 2013-12-23
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Write2DerbyBuechereiDB {

    /**
     * @param args
     */

    /**
     * Verbindung zur Datenbank
     */
    static Connection derbyconn = null;

    /**
     * JDBC-Treiber-Name. Muss im Klassenpfad sein.
     */
    static final String derbyDriver = "org.apache.derby.jdbc.EmbeddedDriver";

    /**
     * Verbindungs-URL. Erstellt beim ersten Aufruf eine neue Datenbank.
     */
    static final String derbyConnectURL = "jdbc:derby:./derbydbs/Buecherei;create=true";

    static String derbyquery;
    static Statement derbystmt = null;

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// Derby-Treiber laden
	try {
	    Class.forName(derbyDriver).newInstance();
	} catch (Exception ex) {
	    System.out.println("Der JDBC-Treiber für Derby konnte nicht "
		    + "geladen werden." + " Die Fehlermeldung lautet: "
		    + ex.getMessage());
	    System.exit(1);
	}
	// Derby-Verbindung herstellen
	try {
	    derbyconn = DriverManager.getConnection(derbyConnectURL);
	} catch (SQLException ex) {
	    System.out.println("Die Verbindung zur Derby-Datenbank konnte "
		    + "nicht hergestellt werden. "
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	try {
	    derbystmt = derbyconn.createStatement();
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Erstellen des Statements."
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	derbyquery = "INSERT INTO Buecher (Titel, AutorID) VALUES ('Die schwarze Laterne', 1)";
	try {
	    derbystmt.executeUpdate(derbyquery);
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Schreiben in die Tabelle Buecher."
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	derbyquery = "INSERT INTO Autoren (Name, Vorname) VALUES ('Bayley', 'Viola')";
	try {
	    derbystmt.executeUpdate(derbyquery);
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Schreiben in die Tabelle Autoren."
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	derbyquery = "INSERT INTO Buecher (Titel, AutorID) VALUES ('Schwarze Vögel', 2)";
	try {
	    derbystmt.executeUpdate(derbyquery);
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Schreiben in die Tabelle Buecher."
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	derbyquery = "INSERT INTO Autoren (Name, Vorname) VALUES ('Bahl', 'Franz')";
	try {
	    derbystmt.executeUpdate(derbyquery);
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Schreiben in die Tabelle Autoren."
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	try {
	    if (derbystmt != null && !derbystmt.isClosed()) {
		derbystmt.close();
		derbystmt = null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Die Derby-Verbindung zur Datenbank "
		    + "konnte nicht geschlossen werden. "
		    + "Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	try {
	    if (derbyconn != null && !derbyconn.isClosed()) {
		derbyconn.close();
		derbyconn = null;
	    }
	} catch (SQLException ex) {
	    System.out.println("Die Derby-Verbindung zur Datenbank "
		    + "konnte nicht geschlossen werden. "
		    + "Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	System.out
		.println("Zwei Datensätze wurden in die Datenbank geschrieben.");
    }

}