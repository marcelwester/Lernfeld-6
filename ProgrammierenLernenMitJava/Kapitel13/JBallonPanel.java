package gui13;

/*
 * Klasse JBallonPanel (Musterlösung zu Kapitel 13 Aufgabe 5)
 * Die Klasse ist von der Klasse JPanel abgeleitet.
 * Die Klasse stellt einen Ball zur Demonstartion von
 * Bewegungsabläufen dar. Der Ballon wird aus zwei Bilddateien
 * eingebunden. Ein Bild stellt den intakten Ballon dar. Das zweite
 * Bild wird verwendet, um den Ballon beim Zerplatzen darzustellen. 
 *  
 * Hans-Peter Habelitz
 * 2011-12-27
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Random;

import javax.swing.JPanel;

public class JBallonPanel extends JPanel implements Runnable {
    private int n = 0;
    private int anzeigedauer = 1000;
    private Image[] img;
    private int x, y;
    private int ballonzaehler = 0;

    JBallonPanel() {

	img = new Image[2];
	setBackground(Color.white);
	img[0] = Toolkit.getDefaultToolkit().getImage(
		"." + File.separator + "Ball.jpg");
	img[1] = Toolkit.getDefaultToolkit().getImage(
		"." + File.separator + "Ball2.jpg");
	Random rand = new Random();
	x = -100;
	y = -100;
    }

    public int getBallonzaehler() {
	return ballonzaehler;
    }

    public void resetBallonzaehler() {
	ballonzaehler = 0;
    }

    public int getBallonSizeX() {
	return img[0].getWidth(this);
    }

    public int getBallonSizeY() {
	return img[0].getHeight(this);
    }

    public int getBallonX() {
	return x;
    }

    public int getBallonY() {
	return y;
    }

    public void setAnzeigedauer(int d) {
	if (d < 0) {
	    anzeigedauer = 2000;
	} else
	    anzeigedauer = d;
    }

    public void setBildNr(int nr) {
	if ((nr < 0) || (nr > 1)) {
	    n = 0;
	} else
	    n = nr;
    }

    public void run() {
	while (true) {
	    synchronized (this) {
		Random rand = new Random();
		x = rand.nextInt(getWidth() - img[0].getWidth(this));
		y = rand.nextInt(getHeight() - img[0].getHeight(this));
		ballonzaehler++;
	    }
	    repaint();
	    try {
		Thread.sleep(anzeigedauer);
	    } catch (InterruptedException e) {
		break;
	    }
	}
    }

    public synchronized void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(img[n], x, y, img[n].getWidth(this),
		img[n].getHeight(this), this);
	n = 0;
    }

}