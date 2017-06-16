package ab08;

import javax.swing.JOptionPane;

public class Blatt15Aufg3 {
	
	public static void main(String[] args) {
		
		String output= "";
		int groesse= Integer.parseInt(JOptionPane.showInputDialog("Wie groﬂ soll das Dreieck sein? "));
		//System.out.println("");
		dreieck(groesse);
		//System.out.println("");
		//System.out.println("");
		dreieck2(groesse);
		
	}
	
	private static void dreieck(int groesse) {
		
		for (int i=1; i<groesse+1; i++){			
			String output=" ";
			for (int z=groesse; z>0; z--){
				output+=" ";
			}
			output+="*";
			for (int j= 1; j<i; j++){
				output=output+ " " +"*";
			}
			System.out.println(output);
		}
	}

		private static void dreieck2(int groesse){
			
			
			for (int i=groesse+1; i>1; i--){		
				String output=" ";
				for (int z=0; z<groesse; z++){ 
					output+=" ";
				}
				output+="*";
				for (int j= i; j>1; j--){
					output=output+ " " +"*";
				}
				System.out.println(output);
			}
		}
		}
			
				
				
		
		

	


	


	


