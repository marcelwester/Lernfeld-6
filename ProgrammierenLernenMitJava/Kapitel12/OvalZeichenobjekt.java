package gui12;

/*
 * Klasse OvalZeichenobjekt
 * Die Klasse erweitert das Zeichenobjekt so, dass es ein Oval repräsentiert,
 * das sich selbst zeichnen kann, und dass es in einer ArrayList<Zeichenobjekt>
 * gespeichert werden kann.
 * 
 * Hans-Peter Habelitz
 * 2013-12-21
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class OvalZeichenobjekt extends Zeichenobjekt {
    private boolean istGefuellt;

    OvalZeichenobjekt(int x1, int y1, int x2, int y2, Color color,
	    float linienbreite, boolean istGefuellt) {
	super(x1, y1, x2, y2, color, linienbreite);
	this.istGefuellt = istGefuellt;
    }

    public boolean getGefuellt() {
	return istGefuellt;
    }

    public void setGefuellt(boolean istGefuellt) {
	this.istGefuellt = istGefuellt;
    }

    @Override
    void paint(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	Ellipse2D.Float oval = new Ellipse2D.Float(getX1(), getY1(), getX2(),
		getY2());
	if (getGefuellt()) {
	    g2d.fill(oval);
	} else {
	    g2d.draw(oval);
	}
    }

}
