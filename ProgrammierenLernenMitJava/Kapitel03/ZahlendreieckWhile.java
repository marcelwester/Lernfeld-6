/* Zahlendreieck mit while-Schleife
 * Hans-Peter Habelitz
 * 2011-12-11
 */
public class ZahlendreieckWhile {

    public static void main(String[] args) {
	int zahl = 0;
	String ausgabe = "";

	while (zahl < 10) {
	    ausgabe = ausgabe + zahl;
	    System.out.println(ausgabe);
	    zahl++;
	}
    }

}
