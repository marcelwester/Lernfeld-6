import javax.swing.JOptionPane;

public class Zahlentest2 {
public static void main(String[]args){
	
	double eingabe;
	
	
	eingabe= Double.parseDouble(JOptionPane.showInputDialog("bitte Zahl eingeben: " ));
	
	if ( eingabe < 0){
		
	JOptionPane.showMessageDialog(null, "Die zahl ist negativ!");
	
	}
	else{
		JOptionPane.showMessageDialog(null, "Die Zahl ist positiv!");
		
	}
	
	
	
	
}
}
