package ab08;

import javax.swing.JOptionPane;

public class AB12Aufgabe2 {
	 
	
	 static void linie(String ch, int anzahl){
		 
		 for (int i=0; i<=anzahl; i++ ){
			 
			 System.out.print(ch);
		 }
		 System.out.println(" ");
	 }
		 
		 
		 public static void quadrat(String dh, int anzahl){
			 
			 for (int i=0; i<anzahl; i++ ){
				 
				 System.out.println(dh);
			 }
			 System.out.println(" ");
			 
			 
		 }
		public static void leiter(int anzahl){
			 
			 for (int i=0; i<=anzahl; i++ ){
				 
				
				 System.out.println("## ##"); 
				System.out.println("#####");
				 }
			 System.out.println("## ##");
			 
			 
		 }
	 
	 
	
	
	
	public static void main(String[] args) {
		int anzahl= Integer.parseInt(JOptionPane.showInputDialog("Zahl eingeben: "));
		linie("-", anzahl);
		quadrat("0000", anzahl);
		leiter(anzahl);		 
		 
		 
		 
	}

}
