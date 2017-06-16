package uebung06;

/*
 * Klasse Anteil abgeleitet von Bruch
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class Anteil extends Bruch {
    static Bruch verteilt = new Bruch(0);

    Anteil() {
	super();
    }

    Anteil(int z, int n) {
	super(z, n);
	verteilt = verteilt.addiere(this);
	if (this.getVerteilt() > 1)
	    System.out.println("Fehler!! Es wurde zu viel verteilt!");
    }

    double getVerteilt() {
	return (double) verteilt.getZaehler() / verteilt.getNenner();
    }

    Bruch getRest() {
	Bruch gesamt = new Bruch(1);
	return gesamt.subtrahiere(verteilt);
    }
}
