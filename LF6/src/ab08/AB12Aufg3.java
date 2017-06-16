package ab08;

import javax.swing.JOptionPane;

public class AB12Aufg3 {
	
	
	
		public static double addiere(double a , double b){
			double c= a+b;
			
			return c;
						
		}
		public static double multipliziere(double a , double b){
			double c= a*b;
			
			return c;
						
		}
		public static double subtrahiere(double a , double b){
			double c= a-b;
			
			return c;
						
		}
		
		
		public static double dividiere(double a , double b){
			double c= a/b;
			
			return c;
						
		}
		
		public static double verbrauch(double a, double b){
			
			double endverbrauch= b/a*100;
			
			
			return endverbrauch;
		}
			
	
	
	 	public static void main(String[] args) {
	 		double verbrauch= verbrauch(680, 50);
	 		char nochmal= 'j';
	 		while (nochmal== 'j'){
	 		double zahl1=Double.parseDouble(JOptionPane.showInputDialog("Zahl 1: "  ));
	 		double zahl2=Double.parseDouble(JOptionPane.showInputDialog("Zahl 2: "  ));
	 		char berechnung= JOptionPane.showInputDialog("Welche Rechnung soll durchgeführt werden (+ / - x) ?").charAt(0);
			
	 		if (berechnung == '+'){
	 			JOptionPane.showMessageDialog(null,"Ergebnis: " +  addiere(zahl1,zahl2));
	 		}
	 		if (berechnung == 'x' || berechnung == '*'){
	 			JOptionPane.showMessageDialog(null, "Ergebnis: " +  multipliziere(zahl1,zahl2));
	 		}
	 		if (berechnung == '-'){
	 			JOptionPane.showMessageDialog(null,"Ergebnis: " +  subtrahiere(zahl1,zahl2));
	 		}
	 		if (berechnung == '/'){
	 			JOptionPane.showMessageDialog(null,"Ergebnis: " +  dividiere(zahl1,zahl2));
	 		}
	 		nochmal= JOptionPane.showInputDialog("Nochmal (j/n)? ").charAt(0);
	 	
	 		}
	 		
	 		System.out.println("Verbrauch auf 100 Kilometer: /n"+ verbrauch);
	 		
	 		
		}

}
