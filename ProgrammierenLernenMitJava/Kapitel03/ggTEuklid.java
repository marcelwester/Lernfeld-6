import javax.swing.JOptionPane;

/* ggTEuklid mit while-Schleife
 * Das Programm berechnet den größten gemeinsamen Teiler nach
 * dem Algorithmus von Euklid.
 * Hans-Peter Habelitz
 * 2011-12-11
 */

public class ggTEuklid {

    public static void main(String[] args) {
	int m, n, r;
	String eingabe;

	eingabe = JOptionPane
		.showInputDialog("Geben Sie eine ganze Zahl für m ein: ");
	m = Integer.parseInt(eingabe);
	System.out.println("m = " + m);
	eingabe = JOptionPane
		.showInputDialog("Geben Sie eine ganze Zahl für n ein: ");
	n = Integer.parseInt(eingabe);
	System.out.println("n = " + n);
	r = m % n;

	while (r > 0) {
	    m = n;
	    n = r;
	    r = m % n;
	}
	System.out.println("ggT = " + n);
    }

}
