class SchweinAblauf
{
public static void main(String args[])
	{
		Schwein schwein1, schwein2, schwein3, schwein4; // Variable vom Typ Schwein
		schwein1 = new Schwein(); // Variable schwein1 zeigt nun auf das erzeugte Objekt
		schwein2 = new Schwein();
		schwein3 = new Schwein("Hugo", 12, 5, 14);
		schwein4 = new Schwein("Piggeldi", 10, 96, 19);
		
		
		schwein1.setName("Theobald");
		schwein2.setName("Luise");
		schwein4.fressen(3);
		schwein1.zeigeDich();
		schwein2.zeigeDich();
		schwein3.zeigeDich();
		schwein4.zeigeDich();
		
		
		schwein1.fressen(2);
		schwein3.fressen(2);
		schwein2.fressen(2);
		schwein1.zeigeDich();
		schwein2.zeigeDich();
		schwein1.bewegen(1);
		schwein2.bewegen(1);
		schwein1.zeigeDich();
		schwein2.zeigeDich();
		
	}
}