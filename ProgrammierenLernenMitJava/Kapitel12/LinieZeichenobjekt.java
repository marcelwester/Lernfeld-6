package gui12;

/*
 * Klasse LinieZeichenobjekt
 * Die Klasse erweitert das Zeichenobjekt so, dass es eine Linie repräsentiert,
 * die sich selbst zeichnen kann, und dass sie in einer ArrayList<Zeichenobjekt>
 * gespeichert werden kann.
 * 
 * Hans-Peter Habelitz
 * 2013-12-21
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LinieZeichenobjekt extends Zeichenobjekt {

    LinieZeichenobjekt(int x1, int y1, int x2, int y2, Color color,
	    float linienbreite) {
	super(x1, y1, x2, y2, color, linienbreite);
    }

    @Override
    public void paint(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	Line2D.Float linie = new Line2D.Float(getX1(), getY1(), getX2(),
		getY2());
	g2d.draw(linie);
    }

}
