package gui12;

/*
 * Programm TestFrame
 * Verwendet die Komponenten JZielPanel und JMyButton.
 * 
 * Hans-Peter Habelitz
 * 2014-10-21
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Testframe extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Testframe frame = new Testframe();
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
    public Testframe() {
    	setTitle("Testframe");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow][]", "[grow]"));
	
	JZielPanel panel = new JZielPanel();
	contentPane.add(panel, "cell 0 0,grow");
	
	JMyButton btnEnde = new JMyButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	contentPane.add(btnEnde, "cell 1 0,aligny bottom");
    }

}
