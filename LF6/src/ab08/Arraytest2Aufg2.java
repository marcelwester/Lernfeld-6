package ab08;

import javax.swing.JOptionPane;

public class Arraytest2Aufg2 {
	public static void main(String[] args) {	
		
		
		String binaerZahl;
		int dezimalZahl;
		String binaerZahl2;
		int dezimalZahl2;		
		 
		 
		 int uebertrag=0;
		 int summe=0;
		 int[] hilfe= {0,0,0,0};

	
		dezimalZahl= Integer.parseInt(JOptionPane.showInputDialog("Bitte erste Dezimalzahl eingeben: "));
		dezimalZahl2= Integer.parseInt(JOptionPane.showInputDialog("Bitte zweite Dezimalzahl eingeben: "));
		 System.out.println("Erste eingegebene Dezimalzahl: " + dezimalZahl);
		 System.out.println("Zweite eingegebene Dezimalzahl: " + dezimalZahl2);
		 
		 //Zahlen müssen noch ins Array gespeichert werden!
		//System.out.println(dezimalZahl.length);
		//Erste Dezimalzahl in Binaerzahl umwandeln
		if (dezimalZahl <=0){
			System.out.println("Bitte positive Zahl eingeben");
		}else{
			binaerZahl= "";
			
			 while (dezimalZahl != 0) {

                 // Leerzeichen hinzufügen, um 4 stellige Gruppe zu trennen.

                 if (binaerZahl.length() % 5 == 0)

                	 binaerZahl = " " + binaerZahl;

                 // Extrahiert die letzte Ziffer in Binärdarstellung

                 // und zu binaerZahl hinzufügen

                 binaerZahl = (dezimalZahl % 2) + binaerZahl;

                 // Letzte Ziffer in Binärdarstellung
                 dezimalZahl /= 2;

           }
			 System.out.println("Erste eingegebene Binärzahl: " + binaerZahl);
			 String[] parseZahl= binaerZahl.split(" ");
			 int[] numbers = new int[parseZahl.length];
			 for(int i=0; i<parseZahl.length; i++){
				 
				 numbers[i]= Integer.parseInt(parseZahl[i]);
				 
				 
			 }
			 

			 //Test Ausgabe

			 for(int i=0; i<parseZahl.length; i++){
				 
				 System.out.print("Test vom String Zahl1 to int Array: " + numbers[i]);
				 
				 
			 }
			 System.out.println(" ");
			 //Test Ausgabe
			 for(int i=0; i<numbers.length; i++){
				 
				System.out.println("Array Numbers: " + numbers[i]); 
				 
				 
			 }
			 //Test Ausgabe
			 System.out.println(" ");
			 System.out.println("Länge des Numbers Array " + numbers.length);
			 

			 System.out.println(" ");
			 System.out.println("###############################");

		//Zweite Dezimalzahl in Binaerzahl umwandeln
		if (dezimalZahl2 <=0){
			System.out.println("Bitte positive Zahl eingeben");
		}else{
			binaerZahl2= "";
			
			 while (dezimalZahl2 != 0) {
                 
                if (binaerZahl2.length() % 5 == 0)

                binaerZahl2 = " " + binaerZahl2;               
                binaerZahl2 = (dezimalZahl2 % 2) + binaerZahl2;              
                dezimalZahl2 /= 2;

           }
			 
			 String[] parseZahl2= binaerZahl2.split(" ");
			 int[] numbers2 = new int[parseZahl2.length];
			 for(int i=0; i<parseZahl2.length; i++){
				 
				 numbers2[i]= Integer.parseInt(parseZahl2[i]);
				 
				 
			 }

			  //Umgewandelte Binaerzahlen ausgeben
		   
           System.out.println("Zweite eingegebene Binärzahl: " + binaerZahl2);
			 System.out.print("Test Zahl 2 vom String to int Array: ");
			 for(int i=0; i<parseZahl2.length; i++){
				 
				 System.out.print(numbers2[i]);
				 
				 
			 }			 

			 System.out.println(" ");
			 System.out.println("###############################");

		 for (int i=3; i>-1; i--){			 
			 
			 summe = numbers[i] + numbers2[i] + uebertrag;
			 
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
			 

		
			 if(uebertrag == 1){
		            hilfe[i] = 1;
		      }
		 }
		 

		 
			 // Zahl 1 ausgeben
			 for (int i=0; i<4; i++){
				 
				 System.out.print(numbers[i]);
			 }
			 // Absatz ausgeben
			 System.out.println(" ");
			 
			// Zahl 2 ausgeben
			 for (int i=0; i<4; i++){
				 
				 System.out.print(numbers2[i]);
			 }
			// Absatz ausgeben
			System.out.println(" ");
			System.out.print("Ergebnis : ");
			     
			 for (int i=0; i<hilfe.length; i++){
			 			 
				 System.out.print(hilfe[i]);
			 			 
			 }		

     }				
		
		
	}
	
	
	}


}
