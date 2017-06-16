package uebung07;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

public class Zeit1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instant zeitpunkt;
		zeitpunkt = Instant.now();
		System.out.println(zeitpunkt.toString());
		System.out.println(zeitpunkt);
		System.out.println("Epoch: " + Instant.EPOCH);
		System.out.println("Min: " + Instant.MIN);
		System.out.println("Max: " + Instant.MAX);
		long ct = System.currentTimeMillis();
		System.out.println("Millisekunden seit 01.01.1970: " + ct);
		int test = 1000000000;
		Instant startEingabeAufforderung = Instant.now();
		System.out.println("Anfang: " + startEingabeAufforderung +" Nanos: " + startEingabeAufforderung.getNano());
		
		JOptionPane.showInputDialog("Geben Sie \"Hallo Welt!\" ein:");
		Instant endeDerEingabe = Instant.now();
		System.out.println("Anfang: " + endeDerEingabe);
		long nanoSecondsFuerEingabe = startEingabeAufforderung.until(endeDerEingabe, ChronoUnit.NANOS);
		System.out.println("Eingabedauer: " + nanoSecondsFuerEingabe);
		long milliSecondsFuerEingabe = startEingabeAufforderung.until(endeDerEingabe, ChronoUnit.MILLIS);
		System.out.println("Eingabedauer: " + milliSecondsFuerEingabe);
		long SecondsFuerEingabe = startEingabeAufforderung.until(endeDerEingabe, ChronoUnit.SECONDS);
		System.out.println("Eingabedauer: " + SecondsFuerEingabe);
		Instant meineZeit1 = Instant.parse("2013-11-08T16:35:07.37512345Z");
		System.out.println(meineZeit1);
		System.out.println("meineZeit1: " + meineZeit1.getNano());
		System.out.println("Nano: " + System.nanoTime());
		System.out.println("Nano: " + System.nanoTime());
		System.out.println("Millis: " + System.currentTimeMillis());
		
		Instant meineZeit2 = Instant.parse("2013-11-08T16:35:07.375123451Z");
		System.out.println("meineZeit2: " + meineZeit2);
		long nanoSecondsFuerMeineZeit = meineZeit1.until(meineZeit2, ChronoUnit.NANOS);
		System.out.println("Eingabedauer: " + nanoSecondsFuerMeineZeit);
		Instant epoch = Instant.EPOCH;
		Instant zeitpunkt3 = epoch.plus(10, ChronoUnit.SECONDS);
		Duration dauer1 = Duration.ofMinutes(10);
		Duration verlaengerung = dauer1.plus(3, ChronoUnit.HOURS);
		System.out.println(dauer1);
		System.out.println(dauer1.getSeconds());
		System.out.println(verlaengerung);
		Duration dauer2 = Duration.parse("P5DT23H5M16S");
		System.out.println(dauer2);
		Duration dauer3 = Duration.ofDays(100);
		System.out.println(dauer3.toString());
		LocalDate datum1 = LocalDate.of(2013, 11, 10);
		System.out.println(datum1);
		LocalDate datum2 = LocalDate.now();
		System.out.println(datum2);
		System.out.println(datum2.getMonth());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		System.out.println(datum2.format(formatter));
		System.out.println(datum2.lengthOfYear());
		LocalDateTime jetzt = LocalDateTime.now();
		LocalDateTime beliebig = LocalDateTime.parse("2013-11-17T12:00:00");
		System.out.println(jetzt.isBefore(beliebig));
		System.out.println("Jetzt: " + jetzt + " Beliebig: " + beliebig);
	}

}
