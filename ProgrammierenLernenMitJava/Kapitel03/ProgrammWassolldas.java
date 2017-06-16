import javax.swing.JOptionPane;

public class ProgrammWassolldas {
	public static void main(String[] args) {
		
		
		int m;
		int n;
		
		m=Integer.parseInt(JOptionPane.showInputDialog("Bitte m eingeben: "));
		n=Integer.parseInt(JOptionPane.showInputDialog("Bitte n eingeben: "));
		
		while(m!=n){
			

			if(m>n){
			m-=n;
			
		}else{
			n-=m;
		}
		System.out.println("m= " + m);
			
			
		}
				
	}

}
