/* Guthabenentwicklung
 * Nach der Eingabe eines Startguthabens und
 * eines Zinssatzes wird die Wertentwicklung
 * für 10 Jahre.
 * Hans-Peter Habelitz
 * 2011-12-11
 */

import javax.swing.JOptionPane;

public class Guthabenentwicklung {

    public static void main(String[] args) {
	double guthaben;
	double zinssatz;

	guthaben = Double.parseDouble(JOptionPane
		.showInputDialog("Geben Sie das Startguthaben ein: "));
	zinssatz = Double.parseDouble(JOptionPane
		.showInputDialog("Geben Sie den Zinssatz ein: "));
	for (int i = 1; i <= 10; i++) {
	    guthaben = guthaben * (1 + zinssatz / 100);
	    System.out.println("Guthaben nach " + i + " Jahren: " + guthaben
		    + " €");
	}
    }

}
