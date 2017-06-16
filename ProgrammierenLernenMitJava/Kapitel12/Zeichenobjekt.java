package gui12;

/*
 * Klasse Zeichenobjekt
 * Die Klasse beschreibt zu zeichnende Objekte so, dass sie in einer ArrayList
 * gespeichert werden können.
 * 
 * Hans-Peter Habelitz
 * 2013-12-21
 */

import java.awt.Color;
import java.awt.Graphics;

public abstract class Zeichenobjekt
{
	protected int x1, y1, x2, y2;
	protected Color color;
	protected float linienbreite;
	
	Zeichenobjekt()
	{
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.white;
		linienbreite = 1.0f;
	}
	Zeichenobjekt(int x1, int y1, int x2, int y2, Color color, float linienbreite)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.linienbreite = linienbreite;
	}
	abstract void paint(Graphics g);
	
	public int getX1()
	{
		return x1;
	}
	public void setX1(int x1)
	{
		this.x1 = x1;
	}
	public int getY1()
	{
		return y1;
	}
	public void setY1(int y1)
	{
		this.y1 = y1;
	}
	public int getX2()
	{
		return x2;
	}
	public void setX2(int x2)
	{
		this.x2 = x2;
	}
	public int getY2()
	{
		return y2;
	}
	public void setY2(int y2)
	{
		this.y2 = y2;
	}
	public Color getColor()
	{
		return color;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
	public float getLinienbreite()
	{
		return linienbreite;
	}
	public void setLinienbreite(float linienbreite)
	{
		this.linienbreite = linienbreite;
	}
}