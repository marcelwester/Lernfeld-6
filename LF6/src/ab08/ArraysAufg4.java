package ab08;

import javax.swing.JOptionPane;

public class ArraysAufg4 {
	public static void main(String[] args) {
	
	
		
	int anzahl=Integer.parseInt(JOptionPane.showInputDialog("Wie viele Zahlen möchten Sie eingeben: " ));
	 

	 int[] ganzzahlenspeicher; 
	 ganzzahlenspeicher= new int [anzahl];

	 
	 	 
	 for (int i=0; i<anzahl; i++){
		 
		 ganzzahlenspeicher[i]= Integer.parseInt(JOptionPane.showInputDialog( (i+1) + ". Zahl eingeben: " )); 
		 
	 }
	 
	 int minimum=ganzzahlenspeicher[0];
	 int maximum=ganzzahlenspeicher[0];
	 int summe=0;
	 int summeGeradenIndex=0;
	 int summeUngeradenIndex=0;
	 double mittelwert=0;
	 double zwischenwert=0;
	 
	 //Kleinste eingegebene Zahl
	 for(int i=0; i < ganzzahlenspeicher.length; i++) {
		    if (ganzzahlenspeicher[i] < minimum){
		    	minimum = ganzzahlenspeicher[i];
		    	 		    	
		    }
		}
	 //Groesste eingegebene Zahl
	 for(int i=0; i < ganzzahlenspeicher.length; i++) {
		    if (ganzzahlenspeicher[i] > maximum){
		    	maximum = ganzzahlenspeicher[i];
		    	 		    	
		    }
		}
	 //Summe des Arrays
	 for(int i=0; i < ganzzahlenspeicher.length; i++) {
		 summe += ganzzahlenspeicher[i];
	 }
	 
	 //Summe des Arrays auf geradem Index
	 for(int i=0; i < ganzzahlenspeicher.length; i++) {
		 if(ganzzahlenspeicher[i] % 2 == 0){
			 summeGeradenIndex += ganzzahlenspeicher[i];
			 
		 }
	 }
	 
	 //Summe des Arrays auf Ungeradem Index
	 for(int i=0; i < ganzzahlenspeicher.length; i++) {
		 if(ganzzahlenspeicher[i] % 2 == 1){
			 summeUngeradenIndex += ganzzahlenspeicher[i];
		 }
	 }
	 
	//Mittelwert des Arrays berechnen
	 for(int i=0; i < ganzzahlenspeicher.length; i++) {
		 
		 zwischenwert+= ganzzahlenspeicher[i];
		 mittelwert= zwischenwert / ganzzahlenspeicher.length;	 
		 
	}

	 
	 System.out.println("Die kleinste eingegebene Zahl ist die " + minimum);
	 System.out.println("Die größte eingegebene Zahl ist die " + maximum);
	 System.out.println("Die Summe aller Zahlen: " + summe);
	 System.out.println("Der Mittelwert aller Zahlen beträgt: " + mittelwert);
	 System.out.println("Die Summe aller Array6 Elemente mit geradem Index: " + summeGeradenIndex);
	 System.out.println("Die Summe aller Array Elemente mit ungeradem Index: " + summeUngeradenIndex);
	 
	 
	 
	
	 

	 
	 
	 
	 
	 
	 
	 
	 
}
}