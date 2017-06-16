package gui13;

/*
 * Klasse JUhrzeitPanel (Musterlösung zu Kapitel 13 Aufgabe 4)
 * Die Klasse ist von der Klasse JPanel abgeleitet.
 * Die Klasse stellt die aktuelle Uhrzeit in einem Panel dar.
 * Die Uhrzeit wird ohne Thread ständig aktualisiert. 
 * 
 * Hans-Peter Habelitz
 * 2011-12-27
 */

import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

public class JUhrzeitPanel extends JPanel {

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String uhrzeit = sdf.format(System.currentTimeMillis());
	// Holt die aktuelle Uhrzeit in die Variable uhrzeit
	Font oldFont = g.getFont();
	Font font = new Font(oldFont.getFontName(), Font.PLAIN, (int) getSize()
		.getHeight());
	setFont(font);
	// setzt die Schriftgröße auf die Höhe des Panels
	g.drawString(uhrzeit, 0, (int) getSize().getHeight());
    }

}
