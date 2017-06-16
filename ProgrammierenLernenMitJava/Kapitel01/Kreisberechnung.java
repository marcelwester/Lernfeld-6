/* Kreisberechnung: Für einen Kreis mit dem Radius 5 cm
 * werden der Umfang und der Flächeninhalt berechnet.
 * Datum: 2011-11-30
 * Hans-Peter Habelitz
 */


public class Kreisberechnung {
    public static void main(String[] args) {
        double radius, umfang, inhalt;
        radius = 5.0;
        umfang = 2.0 * 3.1415926 * radius;
        inhalt = 3.1415926 * radius * radius;
        System.out.print("Umfang: ");
        System.out.println(umfang);
        System.out.print("Flaeche: ");
        System.out.println(inhalt);
    }
}