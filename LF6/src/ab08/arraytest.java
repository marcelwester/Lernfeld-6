package ab08;

import javax.swing.JOptionPane;

public class arraytest {
	public static void main(String[] args) {
		
	
		String binaerZahl;
		int dezimalZahl;
		String binaerZahl2;
		int dezimalZahl2;
	
		dezimalZahl= Integer.parseInt(JOptionPane.showInputDialog("Bitte erste Dezimalzahl eingeben: "));
		if (dezimalZahl <=0){
			System.out.println("Bitte positive Zahl eingeben");
		}else{
			binaerZahl= "";
			
			 while (dezimalZahl != 0) {

                 // add spaces to separate 4-digit groups

                 if (binaerZahl.length() % 5 == 0)

                	 binaerZahl = " " + binaerZahl;

                 // extract last digit in binary representation

                 // and add it to binaryNumber

                 binaerZahl = (dezimalZahl % 2) + binaerZahl;

                 // cut last digit in binary representation

                 dezimalZahl /= 2;

           }
			 
				dezimalZahl2= Integer.parseInt(JOptionPane.showInputDialog("Bitte zweite Dezimalzahl eingeben: "));
				if (dezimalZahl2 <=0){
					System.out.println("Bitte positive Zahl eingeben");
				}else{
					binaerZahl2= "";
					
					 while (dezimalZahl2 != 0) {

		                 // add spaces to separate 4-digit groups

		                 if (binaerZahl2.length() % 5 == 0)

		                	 binaerZahl2 = " " + binaerZahl2;

		                 // extract last digit in binary representation

		                 // and add it to binaryNumber

		                 binaerZahl2 = (dezimalZahl2 % 2) + binaerZahl2;

		                 // cut last digit in binary representation

		                 dezimalZahl2 /= 2;

		           }
			 
			 
			 
			 
			 
			 

           System.out.println("Erste Binaer Zahl: " + binaerZahl);
           System.out.println("Zweite Binaer Zahl: " + binaerZahl2);


     }

}


			
			
			
			
			
			
			
			
			
		}}
