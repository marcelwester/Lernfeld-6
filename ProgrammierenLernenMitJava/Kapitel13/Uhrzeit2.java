package gui13;

/*
 * Programm Uhrzeit2 (Musterlösung zu Kapitel 13 Aufgabe 4)
 * Das Programm verwendet die selbsterstellte klasse JUhrzeitPanel, um
 * eine laufende Uhr als Panel in einem Frame darzustellen. 
 * 
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Uhrzeit2 extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Uhrzeit2 frame = new Uhrzeit2();
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
    public Uhrzeit2() {
    	setTitle("Uhrzeit2");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JUhrzeitPanel panel = new JUhrzeitPanel();
	panel.setBounds(10, 11, 143, 26);
	contentPane.add(panel);
    }
}
