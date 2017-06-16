package gui13;

/*
 * Programm Uhrzeit (Musterlösung zu Kapitel 13 Aufgabe 3)
 * Das Programm verwendet die selbsterstellte klasse JUhrLabel, um
 * eine laufende Uhr als Label in einem Frame darzustellen. 
 * 
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Uhrzeit extends JFrame {

    private JPanel contentPane;
    private Thread t;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Uhrzeit frame = new Uhrzeit();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Uhrzeit() {
    	setTitle("Frame mit Uhrzeit");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JUhrLabel lblUhrzeit = new JUhrLabel();
	lblUhrzeit.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblUhrzeit.setBounds(10, 11, 135, 14);
	contentPane.add(lblUhrzeit);
	t = new Thread(lblUhrzeit);
	t.start();
    }
}
