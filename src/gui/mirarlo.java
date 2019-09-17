package gui;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
public class mirarlo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		try {
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","123456789");
			CallableStatement cal=conexion.prepareCall("call imprimirboleta2");
			ResultSet res=cal.executeQuery();
			while(res.next()){
				System.out.println(res.getString(1));
				/*
				/*+"   "+resboleta.getString(2)+"   "+resboleta.getString(3)+"  "+resboleta.getString(4)+"   "+resboleta.getString(5)*/
		String sd="p";
		String cadena="gel hidroalcohólico desinfección manos Sterilium® gel, 100 ml, con dosificador #DGM"+sd; //84
		String cadena2="peróxido de hidrógeno (agua oxigenada) 3%, 10 vol. 250 ml";//54
		System.out.println(cadena2.length());
		int guardar;
		String espacio=" ";
		String espacio2=" ";
		if(cadena2.length()<85){
			guardar=85-cadena2.length();
			for (int i = 1; i <=guardar; i++) {
				espacio+=espacio2;
			}
			cadena2=cadena2+espacio+"s";
			
		
		}
		System.out.println(cadena);
		System.out.println(cadena2);
		System.out.println(cadena2.length());
		/*
		String cadena3=JOptionPane.showInputDialog("Ingresa una palabra");
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero"));
		System.out.println(""+cadena2.length());
	
			for (int i = 1; i <=numero ; i++) {
				System.out.println(cadena3);
			}
*/
	}
		


}
