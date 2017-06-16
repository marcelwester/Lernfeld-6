import javax.swing.JOptionPane;

public class schaltjahr2 {

	public static void main(String[] args) {
	
		//Prüfen ob eingegebenes Jahr ein Schaltjahr ist
		
		int jahr;
		
		jahr= Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Jahr eingeben: "));
		
		
		if ((jahr%400 ==0 )){
			JOptionPane.showMessageDialog(null, "Das Jahr " + jahr + " ist ein Schaltjahr!");
		}else{
			}if (jahr%100==0) {
			JOptionPane.showMessageDialog(null, "Das Jahr " + jahr + " ist kein Schaltjahr!");
		
				}else
					if (jahr%4==0) {
						JOptionPane.showMessageDialog(null, "Das Jahr " + jahr + " ist ein Schaltjahr!");
	}
		
		
}
}
