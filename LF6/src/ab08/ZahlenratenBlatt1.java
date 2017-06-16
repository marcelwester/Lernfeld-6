package ab08;

import javax.swing.JOptionPane;

public class ZahlenratenBlatt1 {
	public static void main(String[] args) {
		
		
		int ug= 0;
		int og=10;
		int eingabe;
		int zufallszahl;
		int zahl=0;
		char nochmal='j';
		
		
		
		zufallszahl = ug + (int) Math.floor(Math.random() * (og-ug+1));
		while (nochmal == 'j'){
			eingabe= Integer.parseInt(JOptionPane.showInputDialog("Raten Sie eine Zahl " + "[" + ug + "-" + og + "]:"));
		
			//Groessere Zufallszahl
			if(zufallszahl > eingabe){
			System.out.println("Bitte größere Zahl eingeben!");
			}
			if (zufallszahl < eingabe){
				System.out.println("Bitte kleinere Zahl eingeben!");
			}
			//Versuche mitzählen!
			zahl++;
			//Zahl erraten!
			if (zufallszahl == eingabe){
					System.out.println("Sie haben die " + zufallszahl + " erraten!");						
					System.out.println("Das ist ihr  " + zahl + "er versuch!");
			}
		nochmal= JOptionPane.showInputDialog("Möchten Sie einen Wert ändern? ").charAt(0);
			
			
		
	
		}		
	}
}
	
	


