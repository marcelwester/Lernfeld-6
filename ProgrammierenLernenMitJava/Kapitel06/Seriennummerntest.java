package uebung06;

/*
 * Programm Seriennummerntest zum Testen der Klasse
 * Bruch_mit_Seriennummer
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class Seriennummerntest {
    public static void main(String[] args) {
	BruchMitSeriennummer a = new BruchMitSeriennummer(1, 2);
	BruchMitSeriennummer b = new BruchMitSeriennummer(1, 3);
	BruchMitSeriennummer c = new BruchMitSeriennummer(1, 4);
	BruchMitSeriennummer d = new BruchMitSeriennummer(1, 6);
	BruchMitSeriennummer e = new BruchMitSeriennummer(1, 8);
	System.out.println(a.bruchtoString() + " Seriennummer: "
		+ a.getSeriennummer());
	System.out.println(b.bruchtoString() + " Seriennummer: "
		+ b.getSeriennummer());
	System.out.println(c.bruchtoString() + " Seriennummer: "
		+ c.getSeriennummer());
	System.out.println(d.bruchtoString() + " Seriennummer: "
		+ d.getSeriennummer());
	System.out.println(e.bruchtoString() + " Seriennummer: "
		+ e.getSeriennummer());
    }

}
