package gui13;

/*
 * Klasse JAmpelPanel (von der Komponente JPanel abgeleitet)
 * Die Klasse dient der Darstellung einer Ampel mit den vier
 * Ampelphasen.
 * 
 * Hans-Peter Habelitz
 * 2011-12-27
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JAmpelPanel extends JPanel {
    int phase = 0;
    Color coben, cmitte, cunten;

    JAmpelPanel() {
	super();
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	setBackground(new Color(0, 80, 0));
	switch (phase) {
	case 0:
	    coben = Color.gray;
	    cmitte = Color.gray;
	    cunten = Color.gray;
	    break;
	case 1:
	    coben = Color.red;
	    cmitte = Color.gray;
	    cunten = Color.gray;
	    break;
	case 2:
	    coben = Color.red;
	    cmitte = Color.orange;
	    cunten = Color.gray;
	    break;
	case 3:
	    coben = Color.gray;
	    cmitte = Color.gray;
	    cunten = Color.green;
	    break;
	case 4:
	    coben = Color.gray;
	    cmitte = Color.orange;
	    cunten = Color.gray;
	    break;
	}
	int h = getHeight() / 3 - 12;
	int b = getWidth() - 6;
	g.setColor(coben);
	g.fillOval(3, 3, b, h);
	g.setColor(cmitte);
	g.fillOval(3, getHeight() / 3 + 6, b, h);
	g.setColor(cunten);
	g.fillOval(3, 2 * getHeight() / 3 + 9, b, h);
	g.setColor(Color.black);
	g.drawOval(3, 3, b, h);
	g.drawOval(3, getHeight() / 3 + 6, b, h);
	g.drawOval(3, 2 * getHeight() / 3 + 9, b, h);
    }

    public void setPhase(int i) {
	phase = i;
	repaint();
    }

}
