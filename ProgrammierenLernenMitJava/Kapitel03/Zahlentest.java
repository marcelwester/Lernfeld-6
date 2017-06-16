/* Zahlentest
 * Nach der Eingabe einer Zahl wird geprüft,
 * ob die Zahl positiv oder negativ ist.
 * Das Ergebnis wird in einem MessageDialog ausgegeben.
 * Hans-Peter Habelitz
 * 2011-12-11
 */

import javax.swing.JOptionPane;

public class Zahlentest {

    public static void main(String[] args) {
	double zahl;

	zahl = Double.parseDouble(JOptionPane
		.showInputDialog("Geben Sie eine Zahl ein:"));
	if (zahl < 0) {
	    JOptionPane.showMessageDialog(null, "Die Zahl ist negativ!");
	} else {
	    JOptionPane.showMessageDialog(null, "Die Zahl ist positiv!");
	}
    }

}
