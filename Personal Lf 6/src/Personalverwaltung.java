import javax.swing.JOptionPane;

public class Personalverwaltung {
	
	public static void main(String[] args) {
		
		char changeValue= 'j';
		int setNewValue= 0;
		
		
		
		
		int personenzahl=Integer.parseInt(JOptionPane.showInputDialog("Wie viele Personen sollen eingegeben werden?" ));
		Person[] pers= new Person[personenzahl];
		
		
		// Beliebig viele Personen durch dynamische Abfrage erzeugen
		for (int i=0; i < personenzahl; i++){
			
			pers[i]=  new Person();			
			
		}
		
		// Wurde ein Wert falsch eingegeben?
		if ( personenzahl != 0){
			
			changeValue= JOptionPane.showInputDialog("M�chten Sie einen Wert �ndern j/n? ").charAt(0);
		}
		while (changeValue = 'j' ){
			
			JOptionPane.showMessageDialog(null, "Bitte Vornamen eingeben!");
			this.vorname=JOptionPane.showInputDialog("Vorname eingeben: ");
			
			
		}
		
		
				
		while( changeValue == 'j'){
		
			for ( int i=0; i < personenzahl; i++){
				
		
				
				
				
			
					Object[] options = {"Vorname", "Nachname", "Stra�e", "Hausnummer", "Postleitzahl", "Ort"};

					int selected = JOptionPane.showOptionDialog(null,
														"Treffen Sie eine Auswahl",
	                                                    "Alternativen",
	                                                    JOptionPane.DEFAULT_OPTION, 
	                                                    	JOptionPane.INFORMATION_MESSAGE, 
	                                                    		null, options, options[0]);
					

					
							
				
						if (selected == 0){
							pers[i].vorname = JOptionPane.showInputDialog("�ndern Sie Ihren Vornamen: ");
							changeValue='n';
							
								
						}
						
						if (setNewValue == 1){
							pers[i].nachname = JOptionPane.showInputDialog("�ndern Sie Ihren Nachnamen: ");
							changeValue='n';
							
						}
						if (setNewValue == 2){
							pers[i].stra�e = JOptionPane.showInputDialog("�ndern Sie Ihre Stra�e: ");
							changeValue='n';
							
						}
						if (setNewValue == 3){
							pers[i].hausnummer = JOptionPane.showInputDialog("�ndern Sie Ihre Hausnummer: ");
							changeValue='n';
							
						}
						if (setNewValue == 4){
							pers[i].postleitzahl = JOptionPane.showInputDialog("�ndern Sie Ihre Postleitzahl: ");
							changeValue='n';
							
						}
						if (setNewValue == 5){
							pers[i].ort = JOptionPane.showInputDialog("�ndern Sie Ihren Wohnort: ");
							changeValue='n';
							
						}			
				}

			} // Ende While-Block

		
		for (int i=0; i<=pers.length-1; i++ ){
			
			System.out.println("Person: " + (i+1) );
			pers[i].ausgabe();
			
					
		}
		
		
		
		
		
		
	}
}
	
	


