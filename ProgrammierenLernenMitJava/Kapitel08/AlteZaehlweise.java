package gui;

/*
 * Programm AlteZaehlweise zur Umrechnung einer Mengenangabe
 * in die alten Mengenangaben Dutzend, Schock und Gros.
 * Hans-Peter Habelitz
 * 2014-08-24
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlteZaehlweise extends JFrame {

    private JPanel contentPane;
    private JTextField tfStueckzahl;
    private JLabel lblGros;
    private JLabel lblSchock;
    private JLabel lblDutzend;
    private JLabel lblStueck;
    private JButton btnEnde;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AlteZaehlweise frame = new AlteZaehlweise();
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
    public AlteZaehlweise() {
    	setTitle("Alte Z\u00E4hlweise");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 244);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblStueckzahl = new JLabel("Geben Sie eine St\u00FCckzahl an:");
	lblStueckzahl.setBounds(10, 11, 221, 14);
	contentPane.add(lblStueckzahl);
	
	tfStueckzahl = new JTextField();
	tfStueckzahl.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			    umrechnen();
			}
		}
	});
	tfStueckzahl.setBounds(10, 27, 99, 20);
	contentPane.add(tfStueckzahl);
	tfStueckzahl.setColumns(10);
	
	JButton btnInAlteZhlmae = new JButton("In alte Z\u00E4hlma\u00DFe umrechnen");
	btnInAlteZhlmae.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    umrechnen();
		}
	});
	btnInAlteZhlmae.setBounds(160, 26, 221, 23);
	contentPane.add(btnInAlteZhlmae);
	
	lblGros = new JLabel("Gros");
	lblGros.setBounds(10, 84, 154, 14);
	contentPane.add(lblGros);
	
	lblSchock = new JLabel("Schock");
	lblSchock.setBounds(10, 113, 99, 14);
	contentPane.add(lblSchock);
	
	lblDutzend = new JLabel("Dutzend");
	lblDutzend.setBounds(10, 140, 99, 14);
	contentPane.add(lblDutzend);
	
	lblStueck = new JLabel("St\u00FCck");
	lblStueck.setBounds(10, 168, 99, 14);
	contentPane.add(lblStueck);
	
	btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(231, 148, 89, 23);
	contentPane.add(btnEnde);
    }
    
    private void umrechnen() {
	int stueck, gros, schock, dutzend;
	stueck = Integer.parseInt(tfStueckzahl.getText());
	gros = stueck / 144;
	stueck = stueck % 144;
	schock = stueck / 60;
	stueck = stueck % 60;
	dutzend = stueck / 12;
	stueck = stueck % 12;
	lblGros.setText(gros + " Gros");
	lblSchock.setText(schock + " Schock");
	lblDutzend.setText(dutzend + " Dutzend");
	lblStueck.setText(stueck + " Stück");
	tfStueckzahl.requestFocus();
	tfStueckzahl.selectAll();
    }

}
