package uebung06;

/*
 * Klasse Girokonto abgeleitet von Konto
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class Girokonto extends Konto {
    double limit;

    Girokonto(String knr, double ks, double l) {
	super(knr, ks);
	limit = l;
    }

    double getLimit() {
	return limit;
    }

    void setLimit(double l) {
	limit = l;
    }

    void auszahlen(double betrag) {
	if ((getKontostand() - betrag) >= limit * (-1)) {
	    super.auszahlen(betrag);
	} else {
	    System.out.println("Fehler - Kreditlimit überschritten!");
	}
    }
}
