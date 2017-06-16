package ab08;

import javax.swing.JOptionPane;

public class ArraysBlatt2Aufg1 {
	public static void main(String[] args) {
		
	
		 int[] zahl1; 
		 zahl1= new int [4];
		 int[] zahl2; 
		 zahl2= new int [4];
		 
		 int uebertrag=0;
		 int summe=0;
		 int[] hilfe= {0,0,0,0};

		 
		 //  Erste 4-stellige Binärzahl eingeben	 
		 for (int i=0; i<4; i++){
			 
			 zahl1[i]= Integer.parseInt(JOptionPane.showInputDialog( "Zahl1, Ziffer "+ (i+1) + " (von links) eingeben: " )); 
			 
		 }
		//  Zweite 4-stellige Binärzahl eingeben
		 for (int i=0; i<4; i++){
			 
			 zahl2[i]= Integer.parseInt(JOptionPane.showInputDialog( "Zahl2, Ziffer "+ (i+1) + " (von links) eingeben: " )); 
			 
		 }
		 
		 //Rechenoperation
		 for (int i=3; i>0; i--){			 
			 
			 summe = zahl1[i] + zahl2[i] + uebertrag;
			 
			 if (summe == 1){
				 hilfe[i]= 1;
				 uebertrag= 0;
			 }
			 else if(summe == 2){
				 
				 hilfe[i]= 0;
				 uebertrag= 1;
			 }
			 else if(summe== 3){
				 hilfe[i]= 1;
				 uebertrag= 1;
			 }
			 else if(summe==0){
				 hilfe[i]=0;
				 uebertrag=0;
				 
			 }
			 
			 else{
		          System.out.println("Nicht benötigt! Alle Fälle abgearbeitet!");
		        }
		 
		
			 if(uebertrag == 1){
		            hilfe[i] = 1;
		      }
		 }
		  
		 
		 // Zahl 1 ausgeben
		 for (int i=0; i<4; i++){
			 
			 System.out.print(zahl1[i]);
		 }
		 // Absatz ausgeben
		 System.out.println(" ");
		 
		// Zahl 2 ausgeben
		 for (int i=0; i<4; i++){
			 
			 System.out.print(zahl2[i]);
		 }
		// Absatz ausgeben
		System.out.println(" ");
		System.out.print("Ergebnis : ");
		     
		 for (int i=0; i<hilfe.length; i++){
		 			 
			 System.out.print(hilfe[i]);
		 			 
		 }
			
		
	}
	
	

}
