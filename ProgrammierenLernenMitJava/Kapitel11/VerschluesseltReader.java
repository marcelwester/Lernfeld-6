package gui11;

/*
 * Klasse VerschluesseltReader
 * Von der Klasse FilterReader abgeleitete Klasse zum Entschlüsseln
 * von Text. Die Klasse macht beim Lesen aus der Datei die vom 
 * VerschluesseltWriter vorgenommenen Manipulationen wieder rückgängig
 * und entschluesselt dadurch wieder den Text.
 * 
 * Hans-Peter Habelitz
 * 2011-12-25
 */

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class VerschluesseltReader extends FilterReader {
    public VerschluesseltReader(Reader in) {
	super(in);
    }

    public int read() throws IOException {
	return super.read() - 1;
	/*
	 * verschiebt das gelesene Zeichen wieder um eine Position zurück
	 */
    }

    public int read(char[] c, int offset, int length) throws IOException {
	// 1. Orginaldaten einlesen
	int result = super.read(c, offset, length);
	/*
	 * Zeichen werden in das char-Array c eingelesen, und in result wird die
	 * Anzahl der gelesenen Zeichen gespeichert
	 */
	// 2. dekodieren
	for (int i = 0; i < result; i++) {
	    c[i + offset] = (char) ((c[i + offset]) - 1);
	    /*
	     * Der Code jedes Zeichens des char-Arrays wird um 1 reduziert und anschließend
	     * wieder in den Datentyp char umgewandelt
	     */
	}
	return result;
    }

}
