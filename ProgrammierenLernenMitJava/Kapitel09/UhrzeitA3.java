package gui09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UhrzeitA3 extends JFrame {

    private JPanel contentPane;
    private JTextField tfStunden;
    private JTextField tfMinuten;
    private JLabel lblAusgabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UhrzeitA3 frame = new UhrzeitA3();
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
    public UhrzeitA3() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 350, 182);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblStunden = new JLabel("Stunden");
	lblStunden.setBounds(10, 10, 72, 14);
	contentPane.add(lblStunden);

	JLabel lblMinuten = new JLabel("Minuten");
	lblMinuten.setBounds(101, 10, 72, 14);
	contentPane.add(lblMinuten);

	tfStunden = new JTextField();
	tfStunden.setBounds(10, 30, 59, 20);
	contentPane.add(tfStunden);
	tfStunden.setColumns(10);

	tfMinuten = new JTextField();
	tfMinuten.setBounds(101, 30, 59, 20);
	contentPane.add(tfMinuten);
	tfMinuten.setColumns(10);

	JButton btnUebernehmen = new JButton("\u00DCbernehmen");
	btnUebernehmen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		int std, min;
		try {
		    std = Integer.parseInt(tfStunden.getText());
		    if ((std > 23) || (std < 0)) {
			throw new NumberFormatException(
				"Bitte nur Stundenwerte von 0 bis 23 angeben.");
		    }
		    min = Integer.parseInt(tfMinuten.getText());
		    if ((min > 59) || (min < 0)) {
			throw new NumberFormatException(
				"Bitte nur Minutenwerte von 0 bis 59 abgeben.");
		    }
		    lblAusgabe.setText("Ihre Uhrzeit ist "
			    + tfStunden.getText() + ":" + tfMinuten.getText()
			    + " Uhr.");
		} catch (NumberFormatException nfe) {
		    lblAusgabe
			    .setText("Ungültige Uhrzeit.");
		}
		tfStunden.requestFocus();
		tfStunden.selectAll();
	    }
	});
	btnUebernehmen.setBounds(190, 29, 134, 23);
	contentPane.add(btnUebernehmen);

	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	btnEnde.setBounds(217, 96, 89, 23);
	contentPane.add(btnEnde);

	lblAusgabe = new JLabel("");
	lblAusgabe.setBounds(10, 69, 294, 16);
	contentPane.add(lblAusgabe);
    }
}
