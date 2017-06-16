/* Vokaltest mit switch - case
 * Nach der Eingabe eines Zeichens wird geprüft,
 * ob es sich um einen Vokal handelt.
 * Das Ergebnis wird in einem MessageDialog ausgegeben.
 * Hans-Peter Habelitz
 * 2011-12-11
 */

import javax.swing.JOptionPane;

public class VokaltestSwitchCase {
    public static void main(String[] args) {
	String eingabe;
	char c;
	eingabe = JOptionPane
		.showInputDialog("Geben Sie einen Buchstaben ein: ");
	c = eingabe.charAt(0);
	switch (c) {
	case 'a':
	case 'e':
	case 'i':
	case 'o':
	case 'u':
	    JOptionPane.showMessageDialog(null, c + " ist ein Vokal!");
	    break;
	default:
	    JOptionPane.showMessageDialog(null, c + " ist kein Vokal!");
	}
    }
}