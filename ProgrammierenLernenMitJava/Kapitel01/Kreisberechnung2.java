/* Kreisberechnung2: Für einen Kreis werden der Umfang
 * und der Flächeninhalt berechnet.
 * Der Radius des Kreises wird dem Programm als Parameter
 * übergeben.
 * Datum: 2011-11-30
 * Hans-Peter Habelitz
 */


public class Kreisberechnung2 {
  public static void main(String[] args) {
    double radius, umfang, inhalt;
    radius = Double.parseDouble(args[0]);
    umfang = 2.0 * 3.1415926 * radius;
    inhalt = 3.1415926 * radius * radius;
    System.out.print("Umfang: ");
    System.out.println(umfang);
    System.out.print("Flaeche: ");
    System.out.println(inhalt);
  }
}