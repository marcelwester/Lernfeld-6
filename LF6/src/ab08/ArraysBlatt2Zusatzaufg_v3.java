package ab08;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class ArraysBlatt2Zusatzaufg_v3 {
	public static void main(String[] args) {

		int uebertrag = 0;
		int summe = 0;
		int groesse;

		int dezimalZahl = Integer.parseInt(JOptionPane.showInputDialog("Bitte erste Dezimalzahl eingeben: "));
		int dezimalZahl2 = Integer.parseInt(JOptionPane.showInputDialog("Bitte zweite Dezimalzahl eingeben: "));
		System.out.println("Dezimal Zahl 1: " + dezimalZahl);
		System.out.println("Dezimal Zahl 2: " + dezimalZahl2);

		// DezimalZahl in Binärdarstellung
		String binaer = "";
		while (dezimalZahl >= 1) {
			binaer = dezimalZahl % 2 + binaer;
			dezimalZahl /= 2;
		}
		String[] strArray = binaer.split(""); // String Binär in String Array
												// einlesen

		int[] zahl1 = new int[strArray.length]; // Neues Int Array mit der Größe
												// des String Array anlegen
		for (int i = 0; i < strArray.length; i++) {

			zahl1[i] = Integer.parseInt(strArray[i]); // String Array Inhalt dem
														// Int Array zuweisen

		}

		String binaer2 = "";
		while (dezimalZahl2 >= 1) {
			binaer2 = dezimalZahl2 % 2 + binaer2;
			dezimalZahl2 /= 2;
		}
		String[] strArray2 = binaer2.split("");

		int[] zahl2 = new int[strArray2.length];
		for (int i = 0; i < strArray2.length; i++) {

			zahl2[i] = Integer.parseInt(strArray2[i]);

		}
		// Array Größe Vergleichen:

		System.out.println("Größe Array Zahl1 " + zahl1.length);
		System.out.println("Größe Array Zahl2 " + zahl2.length);
		if (zahl1.length > zahl2.length) {
			groesse = zahl1.length;
		} else {
			groesse = zahl2.length;

		}
		System.out.println("Dezimalzahl 1 in Binär Zahl: " + binaer);
		System.out.println("Dezimalzahl 2 in Binär Zahl: " + binaer2);
		int[] ergebnis = new int[groesse + 1];
		System.out.println("Größe Array Ergebnis: " + ergebnis.length);
		Arrays.fill(ergebnis, 0);

		for (int i = 0; i < groesse+1; i++) {

			int stelle1 = zahl1.length - 1 - i;
			int stelle2 = zahl2.length - 1 - i;
			int ergebnisssize = ergebnis.length - 1 - i;

			int wert1;
			if (stelle1 < 0) {
				wert1 = 0;
			} else {
				wert1 = zahl1[stelle1];
			}

			int wert2;
			if (stelle2 < 0) {
				wert2 = 0;
			} else {
				wert2 = zahl2[stelle2];
			}
			
			summe = wert1 + wert2 + uebertrag;

			if (summe == 1) {
				ergebnis[ergebnisssize] = summe;
				uebertrag = 0;
			} else if (summe == 2) {
				ergebnis[ergebnisssize] = 0;
				uebertrag = 1;
			} else if (summe == 3) {
				ergebnis[ergebnisssize] = 1;
				uebertrag = 1;
			} else {
				ergebnis[ergebnisssize] = uebertrag + zahl1[i] + zahl2[i];
			}
		}

		System.out.println("Addition: ");
		System.out.print("Binär Zahl 1    ");
		// Zahl 1 ausgeben
		for (int i = 0; i < zahl1.length; i++) {

			System.out.print(zahl1[i]);
		}
		System.out.print(" +");
		// Absatz ausgeben
		System.out.println(" ");
		System.out.print("Binär Zahl 2    ");
		// Zahl 2 ausgeben
		for (int i = 0; i < zahl2.length; i++) {

			System.out.print(zahl2[i]);
		}
		// Absatz ausgeben
		System.out.println(" ");
		System.out.print("     Ergebnis:  ");

		for (int i = 0; i < ergebnis.length; i++) {

			System.out.print(ergebnis[i]);

		}

	}

}
