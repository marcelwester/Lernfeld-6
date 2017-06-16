package ab08;

import javax.swing.JOptionPane;

public class Umrechner {
	public static void main(String[] args) {
		
		
		double euro;
		double dollar;
		char waehrung='E';
		char nochmal='j';
		
		
		waehrung=JOptionPane.showInputDialog("Welche Umwandlung soll durchgeführt werden (Euro=E/Dollar=D) ?").charAt(0);
		if (waehrung != 'E' && waehrung != 'D'){
			JOptionPane.showMessageDialog(null,"Bitte richtige Ziffer eingeben!");
		}
		//if (waehrung == 'e' )
			//waehrung=waehrung.replace(/e/ g, )
		
		
	
		
		while(nochmal=='j'){
		if (waehrung == 'E'){
			double berechnung;
			
			euro=Double.parseDouble(JOptionPane.showInputDialog("Euro eingeben: "));
			berechnung= euro * 1.057545;
			JOptionPane.showMessageDialog(null, "Für " + euro + "€ erhalten Sie " + berechnung + "$");		
		}
		
		if (waehrung == 'D'){
			double berechnung;
			
			dollar=Double.parseDouble(JOptionPane.showInputDialog("Dollar eingeben: "));
			berechnung= dollar * 0.9455;
			JOptionPane.showMessageDialog(null, "Für " + dollar + "€ erhalten Sie " + berechnung + "$");
			
		}
		
		nochmal= JOptionPane.showInputDialog("Nochmal (j/n)? ").charAt(0);
		if (nochmal!= 'E' && waehrung != 'D'){
			JOptionPane.showMessageDialog(null,"Bitte richtige Ziffer eingeben!");
		}
		
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
	}
}
