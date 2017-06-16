package gui09;

/*
 * Klasse LeereEingabeException
 * 
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class LeereEingabeException extends NumberFormatException {
    public LeereEingabeException() {
	super();
    }

    public LeereEingabeException(String s) {
	super(s);
    }
}
