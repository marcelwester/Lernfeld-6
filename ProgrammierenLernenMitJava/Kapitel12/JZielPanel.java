package gui12;

/*
 * Klasse JZielPanel
 * Die Klasse ist von der Standardkomponente JPanel abgeleitet.
 * Auf das Panel ist eine Zielscheibe eingezeichnet.
 * 
 * Hans-Peter Habelitz
 * 2011-12-26
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JZielPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(getWidth()/2, getHeight(), getWidth()/2, 0);
		g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
		int xmitte=getWidth()/2;
		int ymitte=getHeight()/2;
		int r1;
		if (getWidth()<getHeight())
		{
			
			r1=(getWidth()-10)/6;
		}
		else
		{
			r1=(getHeight()-10)/6;
		}
		g.drawOval(xmitte-r1, ymitte-r1, 2*r1, 2*r1);
		g.drawOval(xmitte-2*r1, ymitte-2*r1, 4*r1, 4*r1);
		g.drawOval(xmitte-3*r1, ymitte-3*r1, 6*r1, 6*r1);
	}
}
