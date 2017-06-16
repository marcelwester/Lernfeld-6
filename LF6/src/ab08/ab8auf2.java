package ab08;



public class ab8auf2 {
	public static void main(String[] args){
		
		
		double anfangskapital;
		double zinssatz;
		double kapital;
		int jahre=0;
		
		anfangskapital=IO.readDouble("Bitte geben Sie Ihr Kapital ein: " );
		zinssatz=IO.readDouble("Bitte geben Sie Ihren Zinssatz ein: ");
		kapital=anfangskapital;
		
		while (kapital<=anfangskapital*2)
		{
			kapital= (kapital * (zinssatz/100) + kapital);
			jahre++;
			
		}
		System.out.print("Ihr Anfangskapital verdopppelt sich nach " + jahre + " Jahren");
	}

}
