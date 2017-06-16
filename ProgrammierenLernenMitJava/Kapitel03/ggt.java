import javax.swing.JOptionPane;

public class ggt {
	public static void main(String[] args) {
		
		int m,n,r;
		
		m=Integer.parseInt(JOptionPane.showInputDialog("m eingeben"));

		n=Integer.parseInt(JOptionPane.showInputDialog("n eingeben"));
		
		r=  m%n;
		
		while(r > 0){
			m=n;
			n=r;
			r = m % n;
		}
		System.out.println(n);
		
	}

}
