package gui13;

/*
 * Klasse JAmpelPanel (Musterlösung zu Kapitel 13 Aufgabe 1)
 * Die Klasse dient der Darstellung einer Ampel mit den vier
 * Ampelphasen.
 * 
 * Hans-Peter Habelitz
 * 2011-12-27
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JAmpelPanel2 extends JPanel implements Runnable {
    private int[] phasendauer = { 3000, 500, 3000, 500 };
    int phase = 0;
    Color coben, cmitte, cunten;
    boolean automatik = false;

    JAmpelPanel2() {
	super();
    }

    JAmpelPanel2(int r, int rg, int gr, int ge) {
	super();
	phasendauer[0] = r;
	phasendauer[1] = rg;
	phasendauer[2] = gr;
	phasendauer[3] = ge;
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

    @Override
    public void run() {
	int i = 1;
	while (automatik) {
	    try {
		setPhase(i);
		Thread.sleep(phasendauer[i - 1]);
		i++;
		if (i > 4) {
		    i = 1;
		}
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

}