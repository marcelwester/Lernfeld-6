import javax.swing.JOptionPane;

public class LoesungQuadratischeGleicung2 {
	public static void main(String[] args) {
		
		double a,b,c,d;
		
			a=Double.parseDouble(JOptionPane.showInputDialog(null, "A eingeben:"));
			b=Double.parseDouble(JOptionPane.showInputDialog(null, "B eingeben:"));
			c=Double.parseDouble(JOptionPane.showInputDialog(null, "C eingeben:"));
		
			
			d= 	b*b-4*a*c;
			
			if (d==0){
				JOptionPane.showMessageDialog(null, "Die L�sung lautet: " + d);
			
			}else {
				if (d>0){
					JOptionPane.showMessageDialog(null, "Die zwei L�sungen lauten: " +d);
				}
				else{  
					if (d<0){	
						JOptionPane.showMessageDialog(null, "Es gibt keien L�sung");
					}
					
				}
				
				
			}
	}

}
