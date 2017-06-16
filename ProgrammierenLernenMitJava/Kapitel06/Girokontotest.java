package uebung06;

/*
 * Programm Girokontotest zum Testen der Klasse Girokonto
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class Girokontotest {
    public static void main(String args[]) {
	Girokonto gk = new Girokonto("0000000001", 10000.0, 1000.0);
	gk.auszahlen(11000.0);
	System.out.println("Kontostand: " + gk.getKontostand());
	gk.einzahlen(11000.0);
	gk.auszahlen(11001.0);
	System.out.println("Kontostand: " + gk.getKontostand());
    }
}
