package ab08;

import javax.swing.JOptionPane;

public class ArraysBlatt1Aufg5 {
	public static void main(String[] args) {
	
	
	 
	 int anzahl=Integer.parseInt(JOptionPane.showInputDialog("Anzahl der Artikel eingeben: " ));
	 
	 int[] kassensystem; 
	 kassensystem= new int [anzahl];
	 int summe = 0;
	 
	 
	 
	 for (int i=0; i<anzahl; i++){
		 
		 kassensystem[i]= Integer.parseInt(JOptionPane.showInputDialog( (i+1) + ". Artikel[Euro]: " ));
		 summe = summe + kassensystem[i];
		 
	 }
	 	System.out.print("Before sort: " );     
	 		for(int x = 0; x < kassensystem.length; x++) {
	 			System.out.print( " " + kassensystem[x]);     
	 		}
	 		System.out.println(" ");     

	 
	 
	  int i, j;       // Zählindizes
	  int tmp;        // Hilfsvariable zum Vertauschen von Werten
	 
	  // durch das ganze Feld gehen
	  for( i = 0; i < kassensystem.length; i++ )
	  {
	    // am Ende beginnen das kleinste Element zu suchen
	    for( j = kassensystem.length - 1; j > i; j-- )
	    {
	      // prüfen ob das Element kleiner als der Vorgänger ist
	      if( kassensystem[j] < kassensystem[j - 1] )
	      {
	        // Werte vertauschen
	        tmp = kassensystem[j];
	        kassensystem[j] = kassensystem[j - 1];
	        kassensystem[j - 1] = tmp;
	        
	        
	      }      	
	    }	    
	  }
	  
	  System.out.print("After sort: " );   
	    for(int l= 0; l < kassensystem.length; l++){
	    	
	    	System.out.print(" " + kassensystem[l]);    	
	    	
	    }
	    System.out.println(" ");  
	  
	  
	}
}


