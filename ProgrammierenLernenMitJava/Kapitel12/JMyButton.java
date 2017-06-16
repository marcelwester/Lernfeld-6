package gui12;


/*
 * Klasse JMyButton
 * Die Klasse ist von der Standardkomponente JButton abgeleitet.
 * Sie besitzt als Erweiterung eine grüne Linie als zusätzlichen
 * Rahmen.
 * 
 * Hans-Peter Habelitz
 * 2011-12-26
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class JMyButton extends JButton
{

	public JMyButton()
	{
		// TODO Auto-generated constructor stub
	}

	public JMyButton(Icon arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JMyButton(String arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JMyButton(Action arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JMyButton(String arg0, Icon arg1)
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.green);
		g.drawRect(3, 3, this.getWidth()-6, this.getHeight()-6);
	}

}
