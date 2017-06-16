/* Programm Summation zur Veranschaulichung von
 *  Gültigkeitsbereichen
 *  Hans-Peter Habelitz
 *  2011-12-13
 */
public class Summation {
    public static void main(String[] args) {
	int n = 100;
	int summe = 0;
	int z = 0;
	while (z < n) {
	    int quadrat = z * z;
	    z++;
	    summe = summe + quadrat;
	}
	System.out.println(summe);
    }
}