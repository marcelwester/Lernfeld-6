package uebung05;

/*
 * Programm Bruchtest1 zum Testen der Klasse Bruch
 * Hans-Peter Habelitz
 * 2011-12-21
 */

public class Bruchtest1 {
    public static void main(String[] args) {
	Bruch a = new Bruch();
	Bruch b = new Bruch(3, 12);

	System.out.println(a.zaehler);
	b.zaehler = 3;
	b.nenner = 12;
	b.ausgeben();

	System.out.print("\nUnd nach dem K�rzen: ");
	b.kuerzen();
	b.ausgeben();
    }

}
