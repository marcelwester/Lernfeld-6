package gui13;

/*
 * Programm Ballanimation (verwendet die Komponente JBallPanel)
 * Das Programm demonstriert die Erstellung von
 * Bewegungsabläufen. Der Ball als JBallPanel eingebunden.
 * eingebunden.
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ballanimation extends JFrame {

    private JPanel contentPane;
    private Thread t;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Ballanimation frame = new Ballanimation();
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
    public Ballanimation() {
	setTitle("Ballanimation");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 519, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[207.00,grow][]"));

	JBallPanel panelSpielflaeche = new JBallPanel();
	contentPane.add(panelSpielflaeche, "cell 0 0,grow");

	JPanel panelSchalter = new JPanel();
	contentPane.add(panelSchalter, "cell 0 1,grow");
	panelSchalter.setLayout(new MigLayout("",
		"[][grow][][][][][][][][][][grow][]", "[]"));

	JButton btnStart = new JButton("Start");
	btnStart.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (t == null) {
		    t = new Thread(panelSpielflaeche);
		}
		if (!t.isAlive()) {
		    t.start();
		}
	    }
	});
	panelSchalter.add(btnStart, "cell 1 0,alignx center");

	JButton btnStopp = new JButton("Stopp");
	btnStopp.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		t.interrupt();
		t = new Thread(panelSpielflaeche);
	    }
	});
	panelSchalter.add(btnStopp, "cell 11 0,alignx center");
    }

}
