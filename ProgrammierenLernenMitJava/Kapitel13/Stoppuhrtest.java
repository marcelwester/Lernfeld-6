package gui13;

/*
 * Programm Stoppuhrtest
 * zum Testen der von Thread abgeleiteten Klasse Stoppuhr.
 * 
 * Hans-Peter Habelitz
 * 2011-12-27
 */

public class Stoppuhrtest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Stoppuhr stoppuhr = new Stoppuhr();
	stoppuhr.start();
    }

}
