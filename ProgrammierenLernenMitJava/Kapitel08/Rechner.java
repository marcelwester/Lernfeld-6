package gui;

/*
 * Programm Rechner als Mini-Taschenrechner
 * für die vier Grundrechenarten.
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

public class Rechner extends JFrame {

    private JPanel contentPane;
    private JTextField tfOperand1;
    private JTextField tfOperand2;
    private JTextField tfErgebnis;
    private double x, y, ergebnis;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Rechner frame = new Rechner();
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
    public Rechner() {
	setTitle("Rechner");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 338, 178);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblOperand1 = new JLabel("Operand1");
	lblOperand1.setBounds(10, 11, 90, 14);
	contentPane.add(lblOperand1);

	JLabel lblOperand2 = new JLabel("Operand2");
	lblOperand2.setBounds(223, 11, 86, 14);
	contentPane.add(lblOperand2);

	tfOperand1 = new JTextField();
	tfOperand1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfOperand2.requestFocus();
		    }
		}
	});
	tfOperand1.setBounds(10, 25, 86, 20);
	contentPane.add(tfOperand1);
	tfOperand1.setColumns(10);

	tfOperand2 = new JTextField();
	tfOperand2.setBounds(223, 25, 86, 20);
	contentPane.add(tfOperand2);
	tfOperand2.setColumns(10);

	JButton btnPlus = new JButton("+");
	btnPlus.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		x = Double.parseDouble(tfOperand1.getText());
		y = Double.parseDouble(tfOperand2.getText());
		ergebnis = x + y;
		tfErgebnis.setText(x + " + " + y + " = " + ergebnis);
	    }
	});
	btnPlus.setBounds(106, 24, 52, 23);
	contentPane.add(btnPlus);

	JButton btnMinus = new JButton("-");
	btnMinus.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		x = Double.parseDouble(tfOperand1.getText());
		y = Double.parseDouble(tfOperand2.getText());
		ergebnis = x - y;
		tfErgebnis.setText(x + " - " + y + " = " + ergebnis);
	    }
	});
	btnMinus.setBounds(161, 24, 52, 23);
	contentPane.add(btnMinus);

	JButton btnGeteilt = new JButton("/");
	btnGeteilt.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		x = Double.parseDouble(tfOperand1.getText());
		y = Double.parseDouble(tfOperand2.getText());
		ergebnis = x / y;
		tfErgebnis.setText(x + " / " + y + " = " + ergebnis);
	    }
	});
	btnGeteilt.setBounds(161, 56, 52, 23);
	contentPane.add(btnGeteilt);

	JButton btnMal = new JButton("*");
	btnMal.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		x = Double.parseDouble(tfOperand1.getText());
		y = Double.parseDouble(tfOperand2.getText());
		ergebnis = x * y;
		tfErgebnis.setText(x + " * " + y + " = " + ergebnis);
	    }
	});
	btnMal.setBounds(106, 56, 52, 23);
	contentPane.add(btnMal);

	JLabel lblErgebnis = new JLabel("Ergebnis");
	lblErgebnis.setBounds(10, 91, 86, 14);
	contentPane.add(lblErgebnis);

	tfErgebnis = new JTextField();
	tfErgebnis.setEditable(false);
	tfErgebnis.setBounds(10, 105, 299, 20);
	contentPane.add(tfErgebnis);
	tfErgebnis.setColumns(10);
    }

}
