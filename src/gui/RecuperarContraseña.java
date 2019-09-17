package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
public class RecuperarContraseña extends JDialog {
	private JLabel lblIngresaTuCodigo;
	private JTextField txtbuscar;
	private JButton btnConsultar;
	private JLabel lblEstaEsTu;
	private JLabel lblpregunta;
	private JLabel lblIngresaTuRespuesta;
	private JTextField txtingresarrespuesta;
	private JButton btnComprobarRespuesta;
	private JPanel panelrenovar;
	private JLabel lblNuevaContrasea;
	private JLabel lblRepiteContrasea;
	private JTextField txtcontraseña;
	private JTextField txtvalida;
	private JPanel panelpregunta;
	private JButton btnRenovarContrasea;
	private JButton btnReinicioBusqueda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperarContraseña dialog = new RecuperarContraseña();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					
					
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public RecuperarContraseña() {
		setBounds(100, 100, 790, 714);
		getContentPane().setLayout(null);
		
		lblIngresaTuCodigo = new JLabel("Ingresa tu codigo trabajador");
		lblIngresaTuCodigo.setBounds(12, 13, 175, 16);
		getContentPane().add(lblIngresaTuCodigo);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(206, 10, 161, 22);
		getContentPane().add(txtbuscar);
		txtbuscar.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnConsultar(arg0);
			}
		});
		btnConsultar.setBounds(417, 9, 97, 25);
		getContentPane().add(btnConsultar);
		
		panelrenovar = new JPanel();
		panelrenovar.setBounds(12, 371, 613, 283);
		getContentPane().add(panelrenovar);
		panelrenovar.setLayout(null);
		panelrenovar.setVisible(false);
		
		
		
		lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a");
		lblNuevaContrasea.setBounds(27, 37, 129, 16);
		panelrenovar.add(lblNuevaContrasea);
		
		lblRepiteContrasea = new JLabel("Repite Contrase\u00F1a");
		lblRepiteContrasea.setBounds(27, 84, 105, 16);
		panelrenovar.add(lblRepiteContrasea);
		
		txtcontraseña = new JTextField();
		txtcontraseña.setBounds(168, 34, 230, 22);
		panelrenovar.add(txtcontraseña);
		txtcontraseña.setColumns(10);
		
		txtvalida = new JTextField();
		txtvalida.setColumns(10);
		txtvalida.setBounds(168, 81, 230, 22);
		panelrenovar.add(txtvalida);
		
		btnRenovarContrasea = new JButton("Renovar Contrase\u00F1a");
		btnRenovarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnRenovarContrasea(arg0);
			}
		});
		btnRenovarContrasea.setBounds(415, 37, 162, 69);
		panelrenovar.add(btnRenovarContrasea);
		
		panelpregunta = new JPanel();
		panelpregunta.setBounds(12, 42, 741, 302);
		getContentPane().add(panelpregunta);
		panelpregunta.setLayout(null);
		panelpregunta.setVisible(false);
		btnComprobarRespuesta = new JButton("Comprobar Respuesta");
		btnComprobarRespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnComprobarRespuesta(arg0);
			}
		});
		btnComprobarRespuesta.setBounds(568, 38, 161, 25);
		panelpregunta.add(btnComprobarRespuesta);
		
		txtingresarrespuesta = new JTextField();
		txtingresarrespuesta.setBounds(342, 101, 148, 22);
		panelpregunta.add(txtingresarrespuesta);
		txtingresarrespuesta.setColumns(10);
		
		lblIngresaTuRespuesta = new JLabel("Ingresa tu respuesta");
		lblIngresaTuRespuesta.setBounds(94, 104, 131, 16);
		panelpregunta.add(lblIngresaTuRespuesta);
		
		lblEstaEsTu = new JLabel("Esta es tu pregunta de seguridad");
		lblEstaEsTu.setBounds(84, 75, 207, 16);
		panelpregunta.add(lblEstaEsTu);
		
		lblpregunta = new JLabel("");
		lblpregunta.setBounds(305, 76, 367, 16);
		panelpregunta.add(lblpregunta);
		
		btnReinicioBusqueda = new JButton("Reinicio Busqueda");
		btnReinicioBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnReinicioBusqueda(arg0);
			}
		});
		btnReinicioBusqueda.setBounds(528, 9, 166, 25);
		getContentPane().add(btnReinicioBusqueda);

	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int val =JOptionPane.showConfirmDialog(null,"Deseas Recuperar e Actualizar tu contraseña?");
		
		if(val==0){
			
		try {
			
			String pregunta="";
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conexionbuscar=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callbuscar=conexionbuscar.prepareCall("select preguntaseguridad from vendedor where codvendedor=?");
			callbuscar.setString(1,txtbuscar.getText());
			//lblpregunta.setText("hasjdk");
			
			
			ResultSet resulbuscar=callbuscar.executeQuery();
			
			if(resulbuscar.next()){
				panelpregunta.setVisible(true);	
				pregunta=resulbuscar.getString(1);
				
				lblpregunta.setText(pregunta);
			}
			
			
			
			
			else{
				JOptionPane.showMessageDialog(null,"No existe ese codigo de vendedor "+"\n"+"Ingresa de nuevo tu codigo");
				lblpregunta.setText("");
				txtbuscar.requestFocus();
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
			//,respuestaseguridad 
			
		}
		else{
			
			txtbuscar.requestFocus();
			return;
		}
		
	}
	protected void actionPerformedBtnComprobarRespuesta(ActionEvent arg0) {

		
		
	int val =JOptionPane.showConfirmDialog(null,"Deseas comprobar tu contraseña ?");
	
	if(val==0){
		
		try {
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement call=conexion.prepareCall("select *from vendedor where codvendedor=? and preguntaseguridad=? and respuestaseguridad=?");
			call.setString(1,txtbuscar.getText());
			call.setString(2,lblpregunta.getText());
			call.setString(3,txtingresarrespuesta.getText());
			ResultSet resultado=call.executeQuery();
			if(resultado.next()){
				
				panelrenovar.setVisible(true);
				txtbuscar.setEditable(false);
			}
			else{
				JOptionPane.showMessageDialog(null,"Validacion no exitosa");
				txtingresarrespuesta.requestFocus();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	else{
		
		txtingresarrespuesta.requestFocus();
			return;
	
			
	
			
			
	}
	}
	protected void actionPerformedBtnRenovarContrasea(ActionEvent arg0) {
	
	int val =JOptionPane.showConfirmDialog(null,"Deseas renovar contraseña ?");
	if(val==0)
	{
		String primertexto=txtvalida.getText();
		String segundotexto=txtcontraseña.getText();
	
		if(primertexto.equals("") && segundotexto.equals("")){
			JOptionPane.showMessageDialog(null,"Datos vacíos"+"\n"+"Ingresa datos en las cajas de texto porfavor");
			return;
			
		}
		
		if(primertexto.compareTo(segundotexto)==0){

			try {
				Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement call=conexion.prepareCall("update vendedor set contravendedor=? where codvendedor=?");
				call.setString(1,txtcontraseña.getText());
				call.setString(2,txtbuscar.getText());
				call.executeUpdate();
				dispose();
				
				JOptionPane.showMessageDialog(null,"Acabas de actualizar las contraseña"+"\n"+"Reenviando al login");
			
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		else{
			
			
			JOptionPane.showMessageDialog(null,"Contraseñas desiguales , Ingresalas correctamente");
			
		}
		
	}
	else
	{
		return;
	}
	
	}
	protected void actionPerformedBtnReinicioBusqueda(ActionEvent arg0) {
	txtbuscar.setEditable(true);
	panelpregunta.setVisible(false);
	panelrenovar.setVisible(false);
	txtbuscar.requestFocus();
	}
}

