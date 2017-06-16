/* Programm zur Berechnung von Kreisumfang und Kreisfläche
 * unter Verwendung von JOptionPane
 * Datum: 2011-11-30
 * Hans-Peter Habelitz
 */

import javax.swing.JOptionPane;
	
public class Kreisberechnung4JOptionPane {
    public static void main(String[] args) {
	double radius, umfang, flaeche;
	String einheit, eingabe;
	eingabe = JOptionPane.showInputDialog("Geben Sie den Kreisradius ein: ");
	radius = Double.parseDouble(eingabe);
	System.out.print("Geben Sie die Einheit ein: ");
	eingabe = JOptionPane.showInputDialog(
                            "Geben Sie die Einheit ein: ");
	einheit = eingabe;
	umfang = 2.0 * 3.1415926 * radius;
	flaeche = 3.1415926 * radius * radius;
	JOptionPane.showMessageDialog(
                  null,"Umfang: " + umfang + " "
                  + einheit + "\nFläche: " + flaeche + " "
                  + einheit + '\u00b2');
    }
}
