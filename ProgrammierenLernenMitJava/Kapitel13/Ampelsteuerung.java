package gui13;

/*
 * Programm Ampelsteuerung (ohne eigenen Thread und ohne paintImmediately)
 * Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell
 * in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * Die Automatik ist noch nicht implementiert. 
 * 
 * Hans-Peter Habelitz
 * 2014-10-21
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ampelsteuerung extends JFrame {

    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Ampelsteuerung frame = new Ampelsteuerung();
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
    public Ampelsteuerung() {
    	setTitle("Ampelsteuerung");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 268, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[73.00,grow][grow]", "[grow]"));
	
	JAmpelPanel panelAmpel = new JAmpelPanel();
	contentPane.add(panelAmpel, "cell 0 0,grow");
	
	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[125.00,grow]", "[grow][]"));
	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Handsteuerung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	panelBedienelemente.add(panel, "cell 0 0,grow");
	panel.setLayout(new MigLayout("", "[87.00]", "[][][][][]"));
	
	JRadioButton rdbtnRot = new JRadioButton("Rot");
	rdbtnRot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setPhase(1);
		}
	});
	buttonGroup.add(rdbtnRot);
	panel.add(rdbtnRot, "cell 0 0");
	
	JRadioButton rdbtnRotgelb = new JRadioButton("RotGelb");
	rdbtnRotgelb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setPhase(2);
		}
	});
	buttonGroup.add(rdbtnRotgelb);
	panel.add(rdbtnRotgelb, "cell 0 1");
	
	JRadioButton rdbtnGruen = new JRadioButton("Gr\u00FCn");
	rdbtnGruen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setPhase(3);
		}
	});
	buttonGroup.add(rdbtnGruen);
	panel.add(rdbtnGruen, "cell 0 2");
	
	JRadioButton rdbtnGelb = new JRadioButton("Gelb");
	rdbtnGelb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setPhase(4);
		}
	});
	buttonGroup.add(rdbtnGelb);
	panel.add(rdbtnGelb, "cell 0 3");
	
	JRadioButton rdbtnAus = new JRadioButton("Aus");
	rdbtnAus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    panelAmpel.setPhase(0);
		}
	});
	rdbtnAus.setSelected(true);
	buttonGroup.add(rdbtnAus);
	panel.add(rdbtnAus, "cell 0 4");
	
	JCheckBox chckbxAutomatik = new JCheckBox("Automatik");
	panelBedienelemente.add(chckbxAutomatik, "cell 0 1,alignx center");
    }
}
