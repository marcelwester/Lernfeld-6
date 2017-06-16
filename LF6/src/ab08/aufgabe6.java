package ab08;

import javax.swing.JOptionPane;

public class aufgabe6 {
	public static void main(String[] args) {
		
		String wort1;
		String wort2;
		
		
		wort1=JOptionPane.showInputDialog("Bitte erstes Wort eingeben: " );
		wort2=JOptionPane.showInputDialog("Bitte zweites Wort eingeben: " );
		int erweiterung=30-wort1.length()-wort2.length();
		
		System.out.print(wort1);
		int i=0;
		while (erweiterung > i){
			System.out.print(".");
			erweiterung--;

			
		}
		System.out.print(wort2);
		
	}

}
