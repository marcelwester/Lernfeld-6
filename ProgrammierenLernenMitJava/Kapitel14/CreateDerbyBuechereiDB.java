package gui14;

/*Programm CreateDerbyBuechereiDB
 * Das Programm erstellt eine Derby-Datenbank mit dem Namen Buecherei2.
 * Es wird eine Tabelle Buecher erstellt. Die Tabelle enthält die BuchID als INT,
 * der Buchtitel als VARCHAR(100) und eine AutorID, als Schlüssel für die Tabelle Autoren.
 * Die Tabelle Autoren enthält die AutorID als INT und Name und Vorname des Autors jeweils als VARCHAR(50).
 *  
 * Hans-Peter Habelitz
 * 2013-12-23
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDerbyBuechereiDB {

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
	derbyquery = "CREATE TABLE Buecher (ID INT NOT Null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), Titel VARCHAR(100), AutorID INT, CONSTRAINT primary_key PRIMARY KEY (ID))";
	try {
	    derbystmt = derbyconn.createStatement();
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Erzeugen des Statements."
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}
	try {
	    derbystmt.executeUpdate(derbyquery);
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Erstellen der Tabelle Buecher."
		    + " Die Fehlermeldung lautet: " + ex.getMessage());
	    System.exit(1);
	}

	derbyquery = "CREATE TABLE Autoren (ID INT NOT Null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), Name VARCHAR(50), Vorname VARCHAR(50), PRIMARY KEY (ID))";
	try {
	    derbystmt.executeUpdate(derbyquery);
	} catch (SQLException ex) {
	    System.out.println("Fehler beim Erstellen der Tabelle Autoren."
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
		.println("Datenbank mit den Tabellen Buecher und Autoren wurde erstellt.");
    }

}
