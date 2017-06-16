/* Collatzfolge2
 * Nach der Eingabe einer Startzahl (ganze Zahl)
 * wird die zugehörige Collatzfolge bis zur
 * ersten 1 ausgegeben.
 * Hans-Peter Habelitz
 * 2011-12-11
 */

import javax.swing.JOptionPane;

public class Collatzfolge2 {
    public static void main(String[] args) {
	int n, maximum, anzahl;
	String eingabe;

	// Eingabedialog anzeigen
	eingabe = JOptionPane
		.showInputDialog("Geben Sie die Startzahl für die Collatzfolge ein: ");
	n = Integer.parseInt(eingabe);
	anzahl = 1;
	maximum = n;
	System.out.println(n);
	while (n != 1) {
	    if (n % 2 == 0)
		n /= 2;
	    else
		n = 3 * n + 1;
	    System.out.println(n);
	    anzahl++;
	    if (n > maximum) {
		maximum = n;
	    }
	}
	anzahl--;
	System.out.println("Länge der Collatzfolge: " + anzahl);
	System.out.println("Maximum der Collatzfolge: " + maximum);
    }
}