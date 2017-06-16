class Schwein
{
	// Attribute
	String name;
	int groesse; // in cm
	int gewicht; // in kg
	int saettigungsgrad; // in %
	
	// Methoden
	Schwein() // Konstruktor ohne Parameter
	{
	// Initialisierung der Attribute
		this.name = "Ferkel";
		this.groesse = 10;
		this.gewicht = 4;
		this.saettigungsgrad = 10;
		
	}
	
	Schwein(String name, int gr, int gw, int sgrad) // Konstruktor mit Parametern
	{
	// Initialisierung der Attribute
		this.name = name;
		this.groesse = gr;
		this.gewicht = gw;
		this.saettigungsgrad = sgrad;
	}
	
	void fressen(int kilo)
	{
		this.groesse = this.groesse + kilo;
		this.gewicht = this.gewicht + kilo;
		this.saettigungsgrad = this.saettigungsgrad + 10;
	}
	void bewegen(int dauer)
	{
		this.gewicht = this.gewicht - dauer;
		this.saettigungsgrad = this.saettigungsgrad - dauer*20;
	}
	void zeigeDich()
	{
		System.out.println("Hallo! Mein Name ist " + this.name);
		System.out.println("Groesse: " + this.groesse);
		System.out.println("Gewicht: " + this.gewicht);
		System.out.println("S.-grad: " + this.saettigungsgrad);
	}
	void setName(String name)
	{
		this.name = name;
	}
	
}