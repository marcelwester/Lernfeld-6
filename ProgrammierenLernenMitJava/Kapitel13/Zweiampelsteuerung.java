package gui13;

/*
 * Programm Zweiampelsteuerung (Musterlösung zu Kapitel 13 Aufgabe 2)
 * Das Programm nutzt die Klasse JAmpelPanel. Zwei Ampeln wechseln ihre
 * Phasen mit unterschiedlicher Phasendauer.
 * 
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zweiampelsteuerung extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Zweiampelsteuerung frame = new Zweiampelsteuerung();
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
    public Zweiampelsteuerung() {
	setTitle("Zweiampelsteuerung");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 357, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[7.00,grow][grow][grow]",
		"[grow]"));

	JAmpelPanel2 panelAmpel1 = new JAmpelPanel2(5000, 800, 4000, 700);
	contentPane.add(panelAmpel1, "cell 0 0,grow");

	JAmpelPanel2 panelAmpel2 = new JAmpelPanel2(3000, 500, 3000, 500);
	contentPane.add(panelAmpel2, "cell 1 0,grow");

	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 2 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[grow]",
		"[][grow][][grow][grow][grow][]"));

	JButton btnStart = new JButton("Start");
	btnStart.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Thread t1 = new Thread(panelAmpel1);
		panelAmpel1.automatik = true;
		t1.start();
		Thread t2 = new Thread(panelAmpel2);
		panelAmpel2.automatik = true;
		t2.start();
	    }
	});
	panelBedienelemente.add(btnStart, "cell 0 0,alignx center");

	JButton btnStopp = new JButton("Stopp");
	btnStopp.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelAmpel1.automatik = false;
		panelAmpel2.automatik = false;
	    }
	});
	panelBedienelemente.add(btnStopp, "cell 0 2,alignx center");

	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	panelBedienelemente.add(btnEnde, "cell 0 6,alignx center");
    }

}
