package uebung07;

/*
 * Programm StringBuffertest
 * Das Programm demonstriert die Verwendung von veränderlichen Strings mit StringBuffer.
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class StringBuffertest {
    public static void main(String[] args) {
        StringBuffer puffer=new StringBuffer();
        System.out.println("Puffergröße: " + puffer.capacity());
        System.out.println("Länge des Pufferinhalts: " + puffer.length());
        System.out.println(puffer);
        puffer.append("Drei Chinesen");
        System.out.println("Puffergröße: " + puffer.capacity());
        System.out.println("Länge des Pufferinhalts: " + puffer.length());
        System.out.println(puffer);
        puffer.setCharAt(2, 'i');
        puffer.setCharAt(9, 'i');
        puffer.setCharAt(11, 'i');
        System.out.println(puffer);
        puffer.delete(0, puffer.length());
        System.out.println(puffer);
        System.out.println("Puffergröße: " + puffer.capacity());
        System.out.println("Länge des Pufferinhalts: " + puffer.length());
        puffer.append("Drei Chinesen");
        puffer.append(" mit dem Kontrabass");
        System.out.println(puffer);
        System.out.println("Puffergröße: " + puffer.capacity());
        System.out.println("Länge des Pufferinhalts: " + puffer.length());
    }
}
