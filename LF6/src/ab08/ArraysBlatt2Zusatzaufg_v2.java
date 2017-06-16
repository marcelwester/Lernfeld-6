package ab08;

import javax.swing.JOptionPane;

public class ArraysBlatt2Zusatzaufg_v2 {
	public static void main(String[] args) {
		

		 int uebertrag=0;
		 int summe=0;
		 int[] hilfe;

		 

		 
		 int dezimalZahl= Integer.parseInt(JOptionPane.showInputDialog("Bitte erste Dezimalzahl eingeben: "));
		 int dezimalZahl2= Integer.parseInt(JOptionPane.showInputDialog("Bitte zweite Dezimalzahl eingeben: "));
		 System.out.println("Dezimal Zahl 1: " + dezimalZahl);
		 System.out.println("Dezimal Zahl 2: " + dezimalZahl2);
		
		 
		 //DezimalZahl in Binärdarstellung
		 	String binaer= "";
			while (dezimalZahl >= 1){				
				binaer = dezimalZahl % 2 + binaer;
				dezimalZahl /=2;				
			}
			String[] strArray= binaer.split(""); //String Binär in String Array einlesen

			int[]zahl1= new int[strArray.length]; //Neues Int Array mit der Größe des String Array anlegen
			for (int i=0; i< strArray.length; i++){
				
				zahl1[i]=Integer.parseInt(strArray[i]); // String Array Inhalt dem Int Array zuweisen
				
			}

						 
			 String binaer2= "";
				while (dezimalZahl2 >= 1){				
					binaer2 = dezimalZahl2 % 2 + binaer2;
					dezimalZahl2 /=2;				
				}
				String[] strArray2= binaer2.split("");

				int[]zahl2= new int[strArray2.length];
				for (int i=0; i< strArray2.length; i++){
					
					zahl2[i]=Integer.parseInt(strArray2[i]);
					
				}
				//Array Größe Vergleichen:
		 	
				 System.out.println("Größe Array Zahl1 " + zahl1.length);
				 System.out.println("Größe Array Zahl2 " + zahl2.length);
				 if (zahl1.length > zahl2.length){
					 hilfe=new int[zahl1.length];
				 }else{
					 hilfe=new int[zahl2.length];					 
					 					 
				 }
				 System.out.println("Dezimalzahl 1 in Binär Zahl: " + binaer);
				 System.out.println("Dezimalzahl 2 in Binär Zahl: " + binaer2);
				 System.out.println("Größe Array Hilfe: " + hilfe.length);
		 
		 //Rechenoperation
		 for (int i=hilfe.length-1; i>=0; i--){			 
			 
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
		  
		 System.out.println("Addition: ");
		 System.out.print("Binär Zahl 1    ");
		 // Zahl 1 ausgeben
		 for (int i=0; i<zahl1.length; i++){
			 
			 System.out.print(zahl1[i]);
		 }
		 System.out.print(" +");
		 // Absatz ausgeben
		 System.out.println(" ");
		 System.out.print("Binär Zahl 2    ");
		// Zahl 2 ausgeben
		 for (int i=0; i<zahl2.length; i++){
			 
			 System.out.print(zahl2[i]);
		 }
		// Absatz ausgeben
		System.out.println(" ");
		System.out.print("     Ergebnis : ");
		     
		 for (int i=0; i<hilfe.length; i++){
		 			 
			 System.out.print(hilfe[i]);
		 			 
		 }
			
		
	}
	
	

}
