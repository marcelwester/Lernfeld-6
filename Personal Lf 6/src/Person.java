import javax.swing.JOptionPane;

public class Person {
	
	String vorname;
	String nachname;
	String stra�e;
	String ort;
	String postleitzahl;
	String hausnummer;
	
	
	
	//Konstruktoren
	Person(){
		
		this.vorname=JOptionPane.showInputDialog("Vorname eingeben: ");		
		while (vorname.length() < 3 ){
			
			JOptionPane.showMessageDialog(null, "Bitte Vornamen eingeben!");
			this.vorname=JOptionPane.showInputDialog("Vorname eingeben: ");
			
			
		}
		this.nachname=JOptionPane.showInputDialog("Nachname eingeben: ");
		this.stra�e=JOptionPane.showInputDialog("Stra�e eingeben: ");
		this.hausnummer=JOptionPane.showInputDialog("Hausnummer eingeben: ");
		this.postleitzahl=JOptionPane.showInputDialog("Postleitzahl eingeben: ");
		this.ort=JOptionPane.showInputDialog("Wohnort eingeben: ");
				
	}
	
	Person(String vorname, String nachname, String stra�e, String hausnummer, String postleitzahl, String ort){
		
		this.vorname=vorname;
		this.nachname=nachname;
		this.stra�e=stra�e;
		this.hausnummer=hausnummer;
		this.postleitzahl=postleitzahl;
		this.ort=ort;
				
	}	
	
	//Methoden
	void ausgabe(){
		

		JOptionPane.showMessageDialog(null, "Vorname: " + this.vorname +
				"\nNachname: " + this.nachname + 
				"\nStra�e: " + this.stra�e + 
				"\nHausnummer: " + this.hausnummer + 
				"\nPostleitzahl: " + this.postleitzahl + 
				"\nOrt: " + this.ort );
	}
	
	

	
	
	
	
	

}
