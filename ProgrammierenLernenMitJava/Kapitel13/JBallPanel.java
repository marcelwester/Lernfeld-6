package gui13;

/*
 * Klasse JBallPanel (von der Klasse JPanel abgeleitet)
 * Die Klasse stellt einen Ball zur Demonstartion von
 * Bewegungsabläufen dar. Der Ball wird aus einer Bilddatei
 * eingebunden.
 *  
 * Hans-Peter Habelitz
 * 2011-12-27
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JBallPanel extends JPanel implements Runnable {
    private int x = 0;
    private Image img;
    private boolean vor = true;

    JBallPanel() {
	setBackground(Color.white);
	img = Toolkit.getDefaultToolkit().getImage(
		"." + File.separator + "Ball.jpg");
/* Alternative ohne Toolkit, die das Bild aus dem bin-Verzeichnis des Package lädt. Dadurch kann
 * das Bild auch in ein jar-File eingebunden werden und muss nicht als separate Datei
 * mit dem jar-File mitgeliefert werden.	
	try {
	    img = ImageIO.read(this.getClass().getResource("Ball.jpg"));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}*/
    }

    public void run() {
	while (true) {
	    synchronized (this) {
		if (x > getWidth() - img.getWidth(this)) {
		    vor = false;
		} else if (x <= 0)
		    vor = true;
		if (vor) {
		    x += 2;
		} else {
		    x -= 2;
		}
	    }
	    repaint();
	    try {
		Thread.sleep(20);
	    } catch (InterruptedException e) {
		break;
	    }
	}
    }

    public synchronized void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(img, x, getHeight() / 2 - img.getHeight(this) / 2,
		img.getWidth(this), img.getHeight(this), this);
    }

}
