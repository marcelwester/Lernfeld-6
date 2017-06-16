package gui11;

/*
 * Klasse VerschluesseltWriter
 * Von der Klasse FilterWriter abgeleitete Klasse zum Verschlüsseln
 * von Text.
 * 
 * Hans-Peter Habelitz
 * 2011-12-25
 */

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class VerschluesseltWriter extends FilterWriter {
    public VerschluesseltWriter(Writer out) {
	super(out);
    }

    public void write(int c) throws IOException {
	super.write(c + 1);
	/* Schreibt an Stelle des Zeichens c das um eine Position
	 * im Unicode nach hinten verschobene Zeichen
	 */
    }

    public void write(char[] c, int offset, int count) throws IOException {
	for (int i = 0; i < count; i++)
	    write(c[offset + i]);
    }

    public void write(char[] c) throws IOException {
	write(c, 0, c.length);
    }

    public void write(String s, int offset, int count) throws IOException {
	for (int i = 0; i < count; i++)
	    write(s.charAt(offset + i));
    }

    public void write(String s) throws IOException {
	write(s, 0, s.length());
    }
}
