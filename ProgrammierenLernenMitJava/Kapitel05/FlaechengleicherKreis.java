package uebung05;

/*
 * Programm FlaechengleicherKreis
 * Es wird zu einem vorgegebenen Rechteck der Radius eines
 * Kreises mit gleichem Fl�cheninhalt berechnet.
 * Hans-Peter Habelitz
 * 2011-12-21
 */

import javax.swing.JOptionPane;

public class FlaechengleicherKreis {
    public static void main(String[] args) {
	String eingabe;
	double l, b;
	eingabe = JOptionPane
		.showInputDialog("Geben Sie die Rechteckl�nge ein:");
	l = Double.parseDouble(eingabe);
	eingabe = JOptionPane
		.showInputDialog("Geben Sie die Rechteckbreite ein:");
	b = Double.parseDouble(eingabe);
	Rechteck r = new Rechteck(l, b);
	Kreis k = new Kreis();
	k.setFlaeche(r.getFlaeche());
	System.out.println("Rechteckl�nge: " + r.getLaenge());
	System.out.println("Rechteckbreite: " + r.getBreite());
	System.out.println("Rechteckfl�che: " + r.getFlaeche());
	System.out.println("");
	System.out.println("Kreisradius: " + k.getRadius());
	System.out.println("Kreisfl�che: " + k.getFlaeche());
    }

}
