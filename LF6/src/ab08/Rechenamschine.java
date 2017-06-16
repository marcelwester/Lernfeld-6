package ab08;

import javax.swing.JOptionPane;

public class Rechenamschine {
	public static void main(String[] args) {
		
		
		char operation;
		char nochmal= 'j';
		int zahl1;
		int zahl2;
		
		
		
		while (nochmal =='j') {			
			
			operation= JOptionPane.showInputDialog("Welche Rechenoperation soll durchgeführt werden ( '+', '-', '*'.'/') ?").charAt(0);
			
			
			zahl1=Integer.parseInt(JOptionPane.showInputDialog("Bitte erste Zahl eingeben: "));
			zahl2=Integer.parseInt(JOptionPane.showInputDialog("Bitte zweite Zahl eingeben: "));
			
			switch(operation){
			case '+':
				int berechnung;
				berechnung = zahl1 + zahl2;
				JOptionPane.showMessageDialog(null, "Das Ergebnis Ihrer Berechnung ist:" + zahl1 + " + " + zahl2 + " ist " + berechnung);
				break;
			case '-':
				int berechnung1;
				berechnung1 = zahl1 - zahl2;
				JOptionPane.showMessageDialog(null, "Das Ergebnis Ihrer Berechnung: " + zahl1 + " - " + zahl2 + " ist " + berechnung1);
				break;
			case '/':
				double berechnung2;
				berechnung2 = zahl1 / zahl2;
				JOptionPane.showMessageDialog(null, "Das Ergebnis Ihrer Berechnung: " + zahl1 + " / " + zahl2 + " ist " + berechnung2);
				break;
			case '*':
				double berechnung3;
				berechnung3 = zahl1 * zahl2;
				JOptionPane.showMessageDialog(null, "Das Ergebnis Ihrer Berechnung: " + zahl1 + " * " + zahl2 + " ist " + berechnung3);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Bitte unterstützte Rechenoperation eingeben!");
				
			}		 
			
		
		nochmal= JOptionPane.showInputDialog("Nochmal (j/n)? ").charAt(0);
		if (nochmal != 'j' && nochmal != 'n'){
			JOptionPane.showMessageDialog(null, "Bitte richtiges Zeichen eingeben!");
			
			
		}
		}
		
		
		
		
		
	}

}
