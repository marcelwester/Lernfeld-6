package gui13;

/*
 * Programm Ampelsteuerung3 (mit eigenem Thread)
 * Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell
 * in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * Der Automatikmodus funktioniert, aber das Beenden der Automatik
 * erfolgt offensichtlich nicht ganz korrekt. Es werden noch die Ampelphasen
 * bis zur Gelbphase weiter durchlaufen. Erst danach endet der Schleifendurchlauf. 
 * 
 * Hans-Peter Habelitz
 * 2014-10-21
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ampelsteuerung3 extends javax.swing.JFrame implements Runnable {

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private int rotPhase = 3000;
    private int rotgelbPhase = 500;
    private int gruenPhase = 3000;
    private int gelbPhase = 500;
    private JAmpelPanel panelAmpel;
    private JCheckBox chckbxAutomatik;
    Thread t;
    private JRadioButton rdbtnRot;
    private JRadioButton rdbtnRotgelb;
    private JRadioButton rdbtnGruen;
    private JRadioButton rdbtnGelb;
    private JRadioButton rdbtnAus;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Ampelsteuerung3 frame = new Ampelsteuerung3();
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
    public Ampelsteuerung3() {
	setTitle("Ampelsteuerung3");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 268, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane
		.setLayout(new MigLayout("", "[73.00,grow][grow]", "[grow]"));

	panelAmpel = new JAmpelPanel();
	contentPane.add(panelAmpel, "cell 0 0,grow");

	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[125.00,grow]",
		"[grow][]"));

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(UIManager
		.getBorder("TitledBorder.border"), "Handsteuerung",
		TitledBorder.LEADING, TitledBorder.TOP, null,
		new Color(0, 0, 0)));
	panelBedienelemente.add(panel, "cell 0 0,grow");
	panel.setLayout(new MigLayout("", "[87.00]", "[][][][][]"));

	rdbtnRot = new JRadioButton("Rot");
	rdbtnRot.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelAmpel.setPhase(1);
	    }
	});
	buttonGroup.add(rdbtnRot);
	panel.add(rdbtnRot, "cell 0 0");

	rdbtnRotgelb = new JRadioButton("RotGelb");
	rdbtnRotgelb.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelAmpel.setPhase(2);
	    }
	});
	buttonGroup.add(rdbtnRotgelb);
	panel.add(rdbtnRotgelb, "cell 0 1");

	rdbtnGruen = new JRadioButton("Gr\u00FCn");
	rdbtnGruen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelAmpel.setPhase(3);
	    }
	});
	buttonGroup.add(rdbtnGruen);
	panel.add(rdbtnGruen, "cell 0 2");

	rdbtnGelb = new JRadioButton("Gelb");
	rdbtnGelb.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelAmpel.setPhase(4);
	    }
	});
	buttonGroup.add(rdbtnGelb);
	panel.add(rdbtnGelb, "cell 0 3");

	rdbtnAus = new JRadioButton("Aus");
	rdbtnAus.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelAmpel.setPhase(0);
	    }
	});
	rdbtnAus.setSelected(true);
	buttonGroup.add(rdbtnAus);
	panel.add(rdbtnAus, "cell 0 4");

	chckbxAutomatik = new JCheckBox("Automatik");
	chckbxAutomatik.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		umschaltenAutomatik(e);
	    }
	});
	panelBedienelemente.add(chckbxAutomatik, "cell 0 1,alignx center");
    }
    
    private void umschaltenAutomatik(ActionEvent e) {
	Boolean automatikSelected = chckbxAutomatik.isSelected();
	rdbtnRot.setEnabled(!automatikSelected);
	rdbtnRotgelb.setEnabled(!automatikSelected);
	rdbtnGruen.setEnabled(!automatikSelected);
	rdbtnGelb.setEnabled(!automatikSelected);
	rdbtnAus.setEnabled(!automatikSelected);
	if (chckbxAutomatik.isSelected()) {
	    t = new Thread(this, "Automatik");
	    t.start();
	} else {
	    rdbtnAus.setSelected(true);
	    panelAmpel.setPhase(0);
	}
    }

    @Override
    public void run() {
	while (chckbxAutomatik.isSelected()) {
	    try {
		panelAmpel.setPhase(1);
		Thread.sleep(rotPhase);
		panelAmpel.setPhase(2);
		Thread.sleep(rotgelbPhase);
		panelAmpel.setPhase(3);
		Thread.sleep(gruenPhase);
		panelAmpel.setPhase(4);
		Thread.sleep(gelbPhase);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

}
