package uebung06;

/*
 * Klasse Bruch_mit_Seriennummer
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class BruchMitSeriennummer extends Bruch {
    static int anzahl = 0;
    private final int seriennummer;

    BruchMitSeriennummer(int x, int y) {
	super(x, y);
	anzahl++;
	seriennummer = anzahl;
    }

    BruchMitSeriennummer() {
	this(0, 1);
    }

    BruchMitSeriennummer(int x) {
	this(x, 1);
    }

    int getSeriennummer() {
	return seriennummer;
    }
}
