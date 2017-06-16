package gui12;

/*
 * Klasse JMyPanel
 * Die Klasse ist von der Standardkomponente JPanel abgeleitet.
 * Sie demonstriert das Verändern einer Standardkomponente
 * durch das Einzeichnen einer diagonalen Linie.
 * 
 * Hans-Peter Habelitz
 * 2014-10-20
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JMyPanel extends JPanel {
    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
	}

}
