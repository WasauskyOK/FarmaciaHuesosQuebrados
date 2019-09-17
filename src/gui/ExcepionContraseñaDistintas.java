package gui;

import javax.swing.JOptionPane;

public class ExcepionContraseñaDistintas extends Exception {

	public void exceptioncapturado(){
		JOptionPane.showMessageDialog(null,"LAS CONTRASEÑAS NO SON VALIDAS");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
