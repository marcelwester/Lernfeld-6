/* Zahlraten mit switch - case
 * Nach der Eingabe einer Zahl werden unterschiedliche
 * Hinweise ausgegeben.
 * Die Hinweise werden in einem MessageDialog ausgegeben.
 * Hans-Peter Habelitz
 * 2011-12-11
 */

import javax.swing.JOptionPane;

public class Zahlraten {

    public static void main(String[] args) {
	int zahl = 6;

	int eingabezahl = Integer.parseInt(JOptionPane
		.showInputDialog("Erraten Sie eine Zahl zwischen 1 und 10: "));
	switch (eingabezahl) {
	case 6:
	    JOptionPane.showMessageDialog(null, "Treffer!");
	    break;
	case 4:
	case 5:
	case 7:
	case 8:
	    JOptionPane.showMessageDialog(null, "Knapp daneben!");
	    break;
	default:
	    JOptionPane.showMessageDialog(null, "Daneben!");
	}
    }

}
