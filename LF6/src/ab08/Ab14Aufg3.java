package ab08;

import javax.swing.JOptionPane;

public class Ab14Aufg3 {
	
	
	
	public static int addiere (int zahl1, int zahl2){
		int erg= zahl1 + zahl2;
		System.out.println(zahl1 + " + " + zahl2 + " = " + erg);
		return erg;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		int zahl1=Integer.parseInt(JOptionPane.showInputDialog("Zahl 1: "  ));
		int zahl2=Integer.parseInt(JOptionPane.showInputDialog("Zahl 2: "  ));
		addiere(zahl1,zahl2);
		
	}

}
