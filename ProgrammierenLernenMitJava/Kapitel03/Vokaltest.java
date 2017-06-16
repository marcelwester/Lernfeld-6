/* Vokaltest mit if - else
 * Nach der Eingabe eines Zeichens wird geprüft,
 * ob es sich um einen Vokal handelt.
 * Das Ergebnis wird in einem MessageDialog ausgegeben.
 * Hans-Peter Habelitz
 * 2011-12-11
 */

import javax.swing.JOptionPane;

public class Vokaltest {
    public static void main(String[] args) {
	String eingabe;
	char c;
	boolean istVokal;
	char nochmal = 'j';
	
	while (nochmal == 'j'){
	eingabe = JOptionPane
		.showInputDialog("Geben Sie einen Buchstaben ein: ");
	c = eingabe.charAt(0);
	if (c == 'a')
	    istVokal = true;
	else if (c == 'e')
	    istVokal = true;
	else if (c == 'i')
	    istVokal = true;
	else if (c == 'o')
	    istVokal = true;
	else if (c == 'u')
	    istVokal = true;
	else
	    istVokal = false;
	if (istVokal == true) {
	    JOptionPane.showMessageDialog(null, c + " ist ein Vokal!");
	} else {
	    JOptionPane.showMessageDialog(null, c + " ist kein Vokal!");
	}
	
	
	nochmal = JOptionPane.showInputDialog("Nochmal? ").charAt(0);
	}
    }

}