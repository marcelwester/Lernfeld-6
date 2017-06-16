package ab08;

import javax.swing.JOptionPane;

public class ArraysBlatt1Aufg4 {
	 public static void main(String[] args) {
		
		 
		 
		 int anzahl=Integer.parseInt(JOptionPane.showInputDialog("Anzahl der Artikel eingeben: " ));
		 
		 int[] kassensystem; 
		 kassensystem= new int [anzahl];
		 int[] stueckzahl; 
		 stueckzahl= new int [anzahl];
		 int summe = 0;
		 int zwischensumme=0;
		 int endsumme=0;
		 
		 for (int i=0; i<anzahl; i++){
			 
			 kassensystem[i]= Integer.parseInt(JOptionPane.showInputDialog( (i+1) + ". Artikel[Euro]: " ));
			 summe = summe + kassensystem[i];
			 stueckzahl[i]=Integer.parseInt(JOptionPane.showInputDialog("Stückzahl: " ));
			 
			 if(stueckzahl[i]==0){
				 
				 break;
				 
			 }
			 
		 }
		 
		 System.out.println("Kontrollausgabe: ");
		 
		 
	 for (int i=0; i<anzahl; i++){
		
		 System.out.println((i+1) + ". Artikel: " + kassensystem[i] + " Euro");
		 System.out.println("Stückzahl: " + stueckzahl[i]);
		 
		 if(stueckzahl[i]==0){
			 
			 break;
			 
		 }
		

		 }
	 //System.out.println("##################");
	 //System.out.println("Gesamtsumme: " + summe + " Euro");

	 for (int i=0; i<anzahl; i++){
		 
		 		 
		 System.out.println(stueckzahl[i] + " x " + kassensystem[i] + " : " + stueckzahl[i]*kassensystem[i] + " Euro");
		 zwischensumme= stueckzahl[i]*kassensystem[i];
		 endsumme +=  zwischensumme;
		 
		 if(stueckzahl[i]==0){
			 
			 break;
			 
		 }
		 
		 
	 }
	 System.out.println("------------------");
	 System.out.println("Endsumme: " + endsumme + " Euro");
	 

		 
		 
		 
		 
		 
	}

}
