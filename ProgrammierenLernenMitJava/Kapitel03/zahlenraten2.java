import javax.swing.JOptionPane;

public class zahlenraten2 {
	public static void main(String[] args) {
		
		int zahl=6;
		int zahlEingabe;
		
		zahlEingabe=Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Zahl erraten"));
		
		switch(zahlEingabe){
		case 6:
			JOptionPane.showMessageDialog(null, "Treffer!");
			break;
		case 4:
		case 5:
		case 7:
		case 8:
			JOptionPane.showMessageDialog(null, "Knapp Daneben!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Daneben!");
			
		}
		
		
	}

}
