package uebung07;

/*
 * Programm Stringsort liest 3 Texteingaben ein und
 * gibt diese lexikalisch sortiert wieder aus.
 * Das Programm nutzt den Rückgabewert von String.compareTo.
 * Hans-Peter Habelitz
 * 2011-12-22
 */

import javax.swing.JOptionPane;

public class Stringsort {
    public static void main(String args[]) {
	String eingabe1 = JOptionPane
		.showInputDialog("Geben Sie einen Text ein: ");
	String eingabe2 = JOptionPane
		.showInputDialog("Geben Sie einen Text ein: ");
	String eingabe3 = JOptionPane
		.showInputDialog("Geben Sie einen Text ein: ");
	if ((eingabe1.compareTo(eingabe2) < 0)
		&& (eingabe2.compareTo(eingabe3) < 0)) {
	    System.out.println(eingabe1);
	    System.out.println(eingabe2);
	    System.out.println(eingabe3);
	} else {
	    if ((eingabe1.compareTo(eingabe3) < 0)
		    && (eingabe3.compareTo(eingabe2) < 0)) {
		System.out.println(eingabe1);
		System.out.println(eingabe3);
		System.out.println(eingabe2);
	    } else {
		if ((eingabe2.compareTo(eingabe1) < 0)
			&& (eingabe1.compareTo(eingabe3) < 0)) {
		    System.out.println(eingabe2);
		    System.out.println(eingabe1);
		    System.out.println(eingabe3);
		} else {
		    if ((eingabe2.compareTo(eingabe3) < 0)
			    && (eingabe3.compareTo(eingabe1) < 0)) {
			System.out.println(eingabe2);
			System.out.println(eingabe3);
			System.out.println(eingabe1);
		    } else {
			if ((eingabe3.compareTo(eingabe2) < 0)
				    && (eingabe2.compareTo(eingabe1) < 0)) {
				System.out.println(eingabe3);
				System.out.println(eingabe2);
				System.out.println(eingabe1);
			    } else {
				System.out.println(eingabe3);
				System.out.println(eingabe1);
				System.out.println(eingabe2);
			    }

		    }
		}
	    }

	}
    }
}
