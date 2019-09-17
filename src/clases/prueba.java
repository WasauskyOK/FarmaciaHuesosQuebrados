package clases;

import javax.swing.JOptionPane;
import java.sql.*;
public class prueba {

	
	public  static void  main(String []args){
		String cae="24";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","123456789");

			String consulta="select sum(totalpagar) from venta where codvendedor='i201722624' and FECH_VENTA LIKE '%"+cae+"%'";
			PreparedStatement pre=conexion.prepareStatement(consulta);
			ResultSet re=pre.executeQuery();
			while(re.next()){
				System.out.println(re.getString(1));
			}
			
		
			JOptionPane.showMessageDialog(null, "Buena Conexion");
		}
		catch(Exception ex ){
			System.out.println("NO CONECTA");
			ex.printStackTrace();
		}
		}
	
}
