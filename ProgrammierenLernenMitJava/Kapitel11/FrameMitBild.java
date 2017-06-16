package gui11;

/*
 * Programm FrameMitBild
 * Das Programm demonstriert das Einbinden von Bilddateien in
 * ein JLabel, einen JButton und als Icon des Programmframes.
 * 
 * Hans-Peter Habelitz
 * 2014-09-24
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrameMitBild extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    FrameMitBild frame = new FrameMitBild();
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
    public FrameMitBild() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMitBild.class.getResource("/gui11/HPH.JPG")));
    	setTitle("Frame mit Bild");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 488, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JLabel label = new JLabel("New label");
	label.setIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/gardaseeoel.jpg")));
	contentPane.add(label, BorderLayout.CENTER);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setPressedIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/HPH2.gif")));
	btnEnde.setRolloverIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/HPH.JPG")));
	btnEnde.setIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/HPH3.GIF")));
	contentPane.add(btnEnde, BorderLayout.NORTH);
    }

}
