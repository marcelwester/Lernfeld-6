package uebung07;
/* Programm zur Messung des Zeitbedarfs für die Eingabe des
 * eigenen Namens
 * Datum: 10.11.2013
 * Hans-Peter Habelitz
 */

import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;

public class Eingabedauer {

	public static void main(String[] args) {
		Instant startEingabeAufforderung = Instant.now();
		JOptionPane.showInputDialog("Geben Sie Ihren Namen ein");
		Instant endeDerEingabe = Instant.now();
		Duration dauer = Duration.between(startEingabeAufforderung, endeDerEingabe);
		System.out.println("Dauer nach ISO-8601: " + dauer);
		System.out.println("Dauer in Minuten: " + dauer.toMinutes());
		System.out.println("Dauer in Sekunden: " + dauer.getSeconds());
		System.out.println("Dauer in Millisekunden: " + dauer.toMillis());
	}

}
