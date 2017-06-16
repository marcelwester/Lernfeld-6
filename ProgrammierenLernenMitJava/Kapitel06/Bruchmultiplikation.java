package uebung06;

/*
 * Programm Bruchmultiplikation
 * Hans-Peter Habelitz
 * 2011-12-21
 */

import javax.swing.JOptionPane;

public class Bruchmultiplikation {
    public static void main(String args[]) {
        String eingabe;
        int z, n;
        eingabe = JOptionPane.showInputDialog(
                      "Geben Sie den Zähler von Bruch a ein: ");
        z = Integer.parseInt(eingabe);
        eingabe = JOptionPane.showInputDialog(
                      "Geben Sie den Nenner von Bruch a ein: ");
        n = Integer.parseInt(eingabe);
        Bruch a = new Bruch(z, n);
        eingabe = JOptionPane.showInputDialog(
                      "Geben Sie den Zähler von Bruch b ein: ");
        z = Integer.parseInt(eingabe);
        eingabe = JOptionPane.showInputDialog(
                      "Geben Sie den Nenner von Bruch b ein: ");
        n = Integer.parseInt(eingabe);
        Bruch b = new Bruch(z, n);
        Bruch c = a.multipliziere(b);
        System.out.println("Bruch a: " + a.bruchtoString());
        System.out.println("Bruch b: " + b.bruchtoString());
        System.out.println("Bruch c: " + c.bruchtoString());
    }
}
