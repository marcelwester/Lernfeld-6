package ab08;

import javax.swing.JOptionPane;

public class ArraysBlatt1Aufg1 {
	 public static void main(String[] args) {
		
		 
		 
		 int anzahl=Integer.parseInt(JOptionPane.showInputDialog("Anzahl der Artikel eingeben: " ));
		 
		 int[] kassensystem; 
		 kassensystem= new int [anzahl];
		 int summe = 0;
		 
		 
		 
		 for (int i=0; i<anzahl; i++){
			 
			 kassensystem[i]= Integer.parseInt(JOptionPane.showInputDialog( (i+1) + ". Artikel[Euro]: " ));
			 summe = summe + kassensystem[i];
			 
		 }
		 
		 System.out.println("Kontrollausgabe: ");
		 
		 
	 for (int i=0; i<anzahl; i++){
		
		 System.out.println((i+1) + ". Artikel: " + kassensystem[i] + " Euro");
		 
		 }
	 System.out.println("##################");
	 System.out.println("Gesamtsumme: " + summe + " Euro");

		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
