import javax.swing.JOptionPane;

/* Schaltjahr
 * Nach der Eingabe einer Jahreszahl wird geprüft,
 * ob es sich bei dem Jahr um ein Schaltjahr handelt.
 * Das Ergebnis wird in einem MessageDialog ausgegeben.
 * Hans-Peter Habelitz
 * 2011-12-11
 */
public class Schaltjahr {

    public static void main(String[] args) {
	int jahr;

	jahr = Integer.parseInt(JOptionPane
		.showInputDialog("Geben Sie eine Jahreszahl ein:"));
	if ((jahr % 400) == 0) {
	    JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
		    + " ist ein Schaltjahr!");
	} else {
	    if ((jahr % 100) == 0) {
		JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
			+ " ist kein Schaltjahr!");
	    } else {
		if ((jahr % 4) == 0) {
		    JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
			    + " ist ein Schaltjahr!");
		} else {
		    JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
			    + " ist kein Schaltjahr!");
		}
	    }
	}
    }

}
