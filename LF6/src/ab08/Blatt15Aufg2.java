package ab08;

import javax.swing.JOptionPane;

public class Blatt15Aufg2 {
	
	public static void main(String[] args) {
		
		
		int groesse= Integer.parseInt(JOptionPane.showInputDialog("Wie groﬂ soll das Quadrat sein? "));
		
		for (int i=0; i<groesse; i++){
			sternchen();
		}
		System.out.println("");

		reihe(groesse);
		for (int i=0; i<groesse; i++){
			sternchen();
		}
	}
	
	public static void sternchen(){
		
		System.out.print("*");
	}
	
	public static void reihe(int groesse){
		
		for (int i=0; i<groesse-2; i++){
			System.out.print("*");
			
			for( int j=0; j<groesse-2; j++){
			
				System.out.print(" ");

			
			}
			System.out.println("*");
		}
	}
	}


