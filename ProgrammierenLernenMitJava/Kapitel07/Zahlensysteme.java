package uebung07;

/*
 * Programm Zahlensysteme zur Umwandlung einer Dezimalzahl
 * in das Dual- und in das Hexadezimalsystem.
 * Hans-Peter Habelitz
 * 2011-12-22
 */

import javax.swing.JOptionPane;

public class Zahlensysteme {
    public static void main(String args[]) {
	String eingabe = JOptionPane
		.showInputDialog("Geben Sie eine ganze Zahl ein: ");
	Integer z = Integer.parseInt(eingabe);
	JOptionPane.showMessageDialog(null, "Dezimal: " + z + "\n" + "Dual: "
		+ Integer.toBinaryString(z) + "\n" + "Hexadezimal: "
		+ Integer.toHexString(z).toUpperCase());
    }
}
