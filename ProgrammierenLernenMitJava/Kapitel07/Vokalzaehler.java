package uebung07;

/*
 * Programm Vokalzaehler zur Demonstration des Zugriffs
 * auf einzelne Zeichen innerhalb eines Strings
 * Hans-Peter Habelitz
 * 2011-12-22
 */

import javax.swing.JOptionPane;

public class Vokalzaehler {
    public static void main(String[] args) {
	String eingabe;
	int aZaehler = 0, eZaehler = 0, iZaehler = 0, oZaehler = 0, uZaehler = 0;
	eingabe = JOptionPane.showInputDialog("Geben Sie einen Text ein: ");
	for (int i = 0; i < eingabe.length(); i++) {
	    switch (eingabe.charAt(i)) {
	    case 'a':
		aZaehler++;
		break;
	    case 'e':
		eZaehler++;
		break;
	    case 'i':
		iZaehler++;
		break;
	    case 'o':
		oZaehler++;
		break;
	    case 'u':
		uZaehler++;
		break;
	    }
	}
	System.out.println("Die Eingabe \"" + eingabe + "\" enth�lt:");
	System.out.println(aZaehler + " mal a");
	System.out.println(eZaehler + " mal e");
	System.out.println(iZaehler + " mal i");
	System.out.println(oZaehler + " mal o");
	System.out.println(uZaehler + " mal u");
    }

}
