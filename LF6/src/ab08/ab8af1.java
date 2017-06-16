package ab08;



public class ab8af1 {
	public static void main(String[]args){
		
		
		double anfangskapital;
		double zinssatz;
		double kapital;
		int jahre=0;
		char eingabe;
		
		
		do {
		anfangskapital=IO.readDouble("Bitte geben Sie Ihr Kapital ein: " );
		zinssatz=IO.readDouble("Bitte geben Sie Ihren Zinssatz ein: ");
		kapital=anfangskapital;
		do {
			kapital= (kapital * (zinssatz/100) + kapital);
			jahre++;
		}
		
		while (kapital<anfangskapital*2);
			System.out.println("Das Kapital hat sich nach " + jahre + " Jahren");
				eingabe=IO.readChar("Nochmal (j/n)?");
		}
		while (eingabe == 'j');
		{
			
			
		}

}
}