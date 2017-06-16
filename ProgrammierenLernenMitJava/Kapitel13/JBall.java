package gui13;

/*
 * Klasse JBall (von der Klasse JPanel abgeleitet)
 * Die Klasse stellt einen Ball zur Demonstartion von
 * Bewegungsabläufen dar.
 *  
 * Hans-Peter Habelitz
 * 2011-12-27
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JBall extends JPanel {
    int groesse;
    Color farbe;
    Color hintergrund;
    int xpos, ypos;

    JBall() {
	super();
	setPreferredSize(new Dimension(20, 20));
	farbe = Color.red;
	setBackground(Color.white);
	xpos = 0;
	ypos = 0;
    }

    JBall(int g, Color c, Color bc, int x, int y) {
	super();
	setPreferredSize(new Dimension(g, g));
	farbe = c;
	hintergrund = bc;
	xpos = x;
	ypos = y;
    }

    public void bewege(int dx, int dy) {
	xpos += dx;
	ypos += dy;
    }

    public int getPosX() {
	return xpos;
    }

    public int getPosY() {
	return ypos;
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	setBackground(hintergrund);
	g.fillOval(0, 0, groesse, groesse);
    }

}
