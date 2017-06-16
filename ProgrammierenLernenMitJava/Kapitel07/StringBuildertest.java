package uebung07;

/*
 * Programm StringBuildertest
 * Das Programm demonstriert die Verwendung von ver�nderlichen Strings mit StringBuilder.
 * Hans-Peter Habelitz
 * 2011-12-22
 */

public class StringBuildertest {
    public static void main(String[] args) {
        StringBuilder puffer=new StringBuilder();
        System.out.println("Puffergr��e: " + puffer.capacity());
        System.out.println("L�nge des Pufferinhalts: " + puffer.length());
        System.out.println(puffer);
        puffer.append("Drei Chinesen");
        System.out.println("Puffergr��e: " + puffer.capacity());
        System.out.println("L�nge des Pufferinhalts: " + puffer.length());
        System.out.println(puffer);
        puffer.setCharAt(2, 'i');
        puffer.setCharAt(9, 'i');
        puffer.setCharAt(11, 'i');
        System.out.println(puffer);
        puffer.delete(0, puffer.length());
        System.out.println(puffer);
        System.out.println("Puffergr��e: " + puffer.capacity());
        System.out.println("L�nge des Pufferinhalts: " + puffer.length());
        puffer.append("Drei Chinesen");
        puffer.append(" mit dem Kontrabass");
        System.out.println(puffer);
        System.out.println("Puffergr��e: " + puffer.capacity());
        System.out.println("L�nge des Pufferinhalts: " + puffer.length());
    }
}
