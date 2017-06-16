package gui12;

/*
 * Klasse JMyPaintPanel
 * Die Klasse ist von der Standardkomponente JPanel abgeleitet.
 * Sie dient der Demonstration des Zeichnens in eine Komponente.
 * 
 * Hans-Peter Habelitz
 * 2013-12-21
 */

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;

public class JMyPaintPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private ArrayList<Zeichenobjekt> figuren;

    public JMyPaintPanel() {
	super();
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public JMyPaintPanel(LayoutManager arg0) {
	super(arg0);
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public JMyPaintPanel(boolean arg0) {
	super(arg0);
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public JMyPaintPanel(LayoutManager arg0, boolean arg1) {
	super(arg0, arg1);
	figuren = new ArrayList<Zeichenobjekt>();
    }

    public void addZeichenobjekt(Zeichenobjekt obj) {
	figuren.add(obj);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	for (Zeichenobjekt zo : figuren) {
	    g2d.setColor(zo.getColor());
	    BasicStroke stil = new BasicStroke(zo.getLinienbreite(),
		    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
	    g2d.setStroke(stil);
	    zo.paint(g2d);
	}
    }

}
