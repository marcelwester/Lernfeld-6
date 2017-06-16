package uebung07;

/*
 * Programm Stringrueckwaerts gibt eine eingegebene Textzeile
 * Zeichen für Zeichen rückwärts in der Console aus
 * Hans-Peter Habelitz
 * 2011-12-22
 */

import javax.swing.JOptionPane;

public class Stringrueckwaerts {
    public static void main(String[] args) {
	String eingabe = JOptionPane
		.showInputDialog("Geben Sie einen Text ein: ");
	for (int i = eingabe.length() - 1; i >= 0; i--) {
	    System.out.print(eingabe.charAt(i));
	}
    }
}
