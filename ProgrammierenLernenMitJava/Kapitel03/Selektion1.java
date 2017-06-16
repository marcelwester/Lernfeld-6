/* Java-Programm mit if-Anweisung
 *
 * Hans-Peter Habelitz
 * 2011-12-11
 */

import javax.swing.JOptionPane;

public class Selektion1 {
    public static void main(String[] args) {
	double alter;
	String eingabe;
	eingabe = JOptionPane.showInputDialog("Geben Sie Ihr Alter ein: ");
	alter = Double.parseDouble(eingabe);
	if (alter < 18) {
	    JOptionPane
		    .showMessageDialog(null, "Sorry, noch nicht volljährig!");
	} else {
	    JOptionPane.showMessageDialog(null, "Glückwunsch! Sie sind volljährig!");
	}

    }
}