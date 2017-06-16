import javax.swing.JOptionPane;

/* Programm zur Berechnung der Mehrwertsteuer
 * Hans-Peter Habelitz
 * 2011-12-11
 */
public class Mehrwertsteuer {

    public static void main(String[] args) {
	double betrag;
	double mwstsatz = 19;
	double mwst;

	betrag = Integer.parseInt(JOptionPane
		.showInputDialog("Geben Sie den Rechnungsbetrag in € ein: "));

	mwst = mwstsatz / 100 * betrag;
	System.out.println("Mehrwertsteuer: " + mwst + " €");

    }

}
