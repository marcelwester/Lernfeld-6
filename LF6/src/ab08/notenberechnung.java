package ab08;

import javax.swing.JOptionPane;

public class notenberechnung {
	public static void main(String[] args) {	
		
		
		int anzahl=Integer.parseInt(JOptionPane.showInputDialog("Anzahl: "  ));
		int[] notenSpeicher= new int[anzahl];
		notenEinlesen(anzahl, notenSpeicher);
		notenDurchschnitt(anzahl, notenSpeicher);
		notenSpeicherAusgabe(notenSpeicher);

		System.out.println("Feldlänge: " + notenSpeicher.length);
	
	

		
		
		
		
	}
	

	
	
	
	private static void notenSpeicherAusgabe(int[] notenSpeicher) {
		
		for (int i=0; i<notenSpeicher.length; i++)
		System.out.println((i+1)+ ".Feldplatz:" + notenSpeicher[i]);
		
	}





	private static void notenDurchschnitt(int anzahl, int[] notenSpeicher) {
		double durchschnitt=0;
		for (int i=0; i< notenSpeicher.length; i++){
			
			durchschnitt= durchschnitt +  notenSpeicher[i];	
			
		}
		durchschnitt/= anzahl;
		System.out.println("Durchschnitt: " + durchschnitt);		
	}
	






	public static int[] notenEinlesen(int anzahl2, int[] notenSpeicher){		
			
		for (int i=0; i < anzahl2; i++){
		
			notenSpeicher[i]= Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die Noten nacheinander ein: "));
		
		}	
		return notenSpeicher;
	}
	
	
	
	
	


}
