package ab08;

import javax.swing.JOptionPane;

public class switchcase {
	public static void main(String[] args) {
		int kinder;
		int einkommen;
		char nochmal = 'j';
		
		while (nochmal == 'j'){
		
		kinder=Integer.parseInt(JOptionPane.showInputDialog("Wie viele Kinder haben Sie: "));
		

		einkommen=Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie Ihr Jahreseinkommen ein: "));
		if(einkommen < 45000){ 
			switch(kinder){
			case 0:
				System.out.println("Sie bekommen kein Kindergeld!");
				break;
			case 1:
				System.out.println("Sie bekommen 70€ Kindergeld");
				break;
			case 2:
				System.out.println("Sie bekommen insgesamt 200€ Kindergeld");
				break;
			case 3:
				System.out.println("Sie bekommen insgesamt 420€ Kindergeld");
				break;
			default:
				int berechnung= 420+(kinder-3)*240;
				System.out.println("Sie bekommen insgesamt für " + kinder + " Kinder " + berechnung + "€ Kindergeld!");
			}
		}else{
			switch(kinder){
			case 0:
				System.out.println("Sie bekommen keind Kindergeld!");
				break;
			case 1:
				System.out.println("Sie bekommen 70€ Kindergeld");
				break;
			case 2:
				System.out.println("Sie bekommen insgesamt 140€ Kindergeld");
				break;
			case 3:
				System.out.println("Sie bekommen insgesamt 280€ Kindergeld");
				break;
			default:
				int berechnung= 280+(kinder-3)*140;
				System.out.println("Sie bekommen insgesamt für " + kinder + " Kinder " + berechnung + "€ Kindergeld!");			
			}
			
		}
		nochmal= JOptionPane.showInputDialog("Nochmal (j/n)? ").charAt(0);
		if (nochmal != 'j' && nochmal != 'n'){
			JOptionPane.showMessageDialog(null, "Bitte richtiges Zeichen eingeben!");
		}
		}
		
		
		
		
	
	}
	}
