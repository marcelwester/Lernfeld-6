package gui13;

/*
 * Programm Ballonfangen (Musterlösung zu Kapitel 13 Aufgabe 6)
 * Das Programm verwendet die Komponente JBallonPanel.
 * Das Programm demonstriert in Form eines kleinen Spiels. 
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
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ballonfangen extends JFrame {

    private JPanel contentPane;
    private Thread t;
    private int treffer = 0;
    private JLabel lblSpielstand;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Ballonfangen frame = new Ballonfangen();
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
    public Ballonfangen() {
	setTitle("Ballonfangen");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 509, 362);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[grow][][]"));

	JBallonPanel panelSpielflaeche = new JBallonPanel();
	panelSpielflaeche.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		if ((e.getX() >= panelSpielflaeche.getBallonX())
			&& (e.getX() <= panelSpielflaeche.getBallonX()
				+ panelSpielflaeche.getBallonSizeX())
			&& ((e.getY() >= panelSpielflaeche.getBallonY()) && (e
				.getY() <= panelSpielflaeche.getBallonY()
				+ panelSpielflaeche.getBallonSizeY()))) {
		    treffer++;
		    lblSpielstand.setText("Treffer: " + treffer + " von "
			    + panelSpielflaeche.getBallonzaehler() + " Ballons");
		    panelSpielflaeche.setBildNr(1);
		    panelSpielflaeche.repaint();
		}
	    }
	});
	contentPane.add(panelSpielflaeche, "cell 0 0,grow");

	lblSpielstand = new JLabel("Treffer: 0");
	contentPane.add(lblSpielstand, "cell 0 1");

	JButton btnStopp = new JButton("Stopp");
	btnStopp.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		t.interrupt();
		t = new Thread(panelSpielflaeche);
	    }
	});
	contentPane.add(btnStopp, "flowx,cell 0 2,alignx center");

	JButton btnNeuesSpiel = new JButton("Neues Spiel");
	btnNeuesSpiel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		treffer = 0;
		panelSpielflaeche.resetBallonzaehler();
		lblSpielstand.setText("Treffer: 0");
		if (t == null) {
		    t = new Thread(panelSpielflaeche);
		}
		if (!t.isAlive()) {
		    t.start();
		}
	    }
	});
	contentPane.add(btnNeuesSpiel, "cell 0 2,alignx center");
	t = new Thread(panelSpielflaeche);
	t.start();
    }

}
