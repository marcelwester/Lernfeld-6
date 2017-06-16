package gui11;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * Klasse OhneUmlautWriter
 * Die von der Klasse FilterWriter abgeleitete Klasse
 * soll beim Schreiben die Umlaute �, �, � durch ae, oe
 * und ue ersetzen.
 * 
 * Hans-Peter Habelitz
 * 2011-12-25
 */

public class OhneUmlautWriter extends FilterWriter {
    public OhneUmlautWriter(Writer out) {
	super(out);
    }

    public void write(int c) throws IOException {
	switch ((char) c) {
	case '�':
	    super.write('a');
	    super.write('e');
	    break;
	case '�':
	    super.write('o');
	    super.write('e');
	    break;
	case '�':
	    super.write('u');
	    super.write('e');
	    break;
	case '�':
	    super.write('s');
	    super.write('s');
	    break;
	case '�':
	    super.write('A');
	    super.write('E');
	    break;
	case '�':
	    super.write('O');
	    super.write('E');
	    break;
	case '�':
	    super.write('U');
	    super.write('E');
	    break;
	default:
	    super.write(c);
	}
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