package gui;
import gui.Principal;
import java.awt.EventQueue;



import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.DropMode;
public class Login extends JDialog {
	private JLabel lblUsuarioTrabajador;
	private JTextField txtusuario;
	private JLabel lblContraseaTrabajador;
	private JPasswordField txtcontra;
	private JButton btnRegistrar;
	private JButton btnAcceder;
	public static String Usuario;
	public  String contraseña;
	private JLabel lblimagen;
	private JLabel lblNewLabel;
	private JLabel label;
	private JRadioButton rdbtnVer;
	private JLabel lblOlvidasteTuContrasea;
	private JLabel label_1;
	private JLabel lblclickAqui;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login dialog = new Login();
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
	public Login() {
		//this.setIconImage(new ImageIcon(getClass().getResource("/gui/20f795ab-011b-4e40-b5ee-876e713dc5cf.png")).getImage());
		//
		setUndecorated(true);
		setResizable(false);
		getContentPane().setBackground(new Color(0, 0, 0));
		
		/*
		setResizable(true);
		*/
		setBounds(100, 100, 1038, 534);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		lblUsuarioTrabajador = new JLabel("Codigo Trabajador");
		lblUsuarioTrabajador.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblUsuarioTrabajador.setForeground(new Color(245, 255, 250));
		lblUsuarioTrabajador.setBounds(651, 138, 148, 23);
		getContentPane().add(lblUsuarioTrabajador);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(811, 133, 156, 36);
		getContentPane().add(txtusuario);
		txtusuario.setColumns(10);
		
		lblContraseaTrabajador = new JLabel("Contrase\u00F1a trabajador");
		lblContraseaTrabajador.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblContraseaTrabajador.setForeground(new Color(245, 255, 250));
		lblContraseaTrabajador.setBounds(630, 194, 169, 29);
		getContentPane().add(lblContraseaTrabajador);
		
		txtcontra = new JPasswordField();
		txtcontra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				keyPressedTxtcontra(e);
			}
		});
		txtcontra.setBounds(811, 191, 156, 36);
		getContentPane().add(txtcontra);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		btnRegistrar.setBackground(new Color(124, 252, 0));
		btnRegistrar.setIcon(new ImageIcon(Login.class.getResource("/gui/prueba.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setBounds(759, 340, 157, 81);
		getContentPane().add(btnRegistrar);
		
		btnAcceder = new JButton("Acceder");
		btnAcceder.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		btnAcceder.setBackground(new Color(173, 255, 47));
		btnAcceder.setIcon(new ImageIcon(Login.class.getResource("/gui/contrasena.png")));
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnAcceder(arg0);
			}
		});
		btnAcceder.setBounds(579, 340, 156, 81);
		getContentPane().add(btnAcceder);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLblNewLabel(arg0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/gui/cancelar.png")));
		lblNewLabel.setBounds(945, 13, 79, 90);
		getContentPane().add(lblNewLabel);
		
		lblimagen = new JLabel("");
		lblimagen.setBackground(Color.LIGHT_GRAY);
		lblimagen.setIcon(new ImageIcon(Login.class.getResource("/gui/tna-dribbble-03.gif")));
		lblimagen.setBounds(-101, 0, 681, 534);
		getContentPane().add(lblimagen);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/gui/f7827ba1-f9c4-4598-93f9-bd3b8ccf2693.png")));
		label.setBounds(649, 377, 258, 144);
		getContentPane().add(label);
		
		rdbtnVer = new JRadioButton("Ver");
		rdbtnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedRdbtnVer(arg0);
			}
		});
		rdbtnVer.setForeground(Color.RED);
		rdbtnVer.setBackground(Color.BLACK);
		rdbtnVer.setBounds(975, 197, 49, 25);
		getContentPane().add(rdbtnVer);
		
		lblOlvidasteTuContrasea = new JLabel("Olvidaste tu contraseña ?");
		lblOlvidasteTuContrasea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblOlvidasteTuContrasea.setForeground(Color.BLUE);
		lblOlvidasteTuContrasea.setBounds(619, 286, 184, 16);

		getContentPane().add(lblOlvidasteTuContrasea);
		
		label_1 = new JLabel("_____________________________________");
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(592, 299, 290, 16);
		getContentPane().add(label_1);
		
		lblclickAqui = new JLabel("(CLICK AQUI)");
		lblclickAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLblclickAqui(arg0);
			}
		});
		lblclickAqui.setForeground(Color.BLUE);
		lblclickAqui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblclickAqui.setBounds(796, 286, 86, 16);
		getContentPane().add(lblclickAqui);
		

		
	}	protected void keyPressedTxtcontra(KeyEvent e) {
	
		
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER){ 
			
			
			try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			PreparedStatement calla=conexion.prepareStatement("call validarusuario(?,?)");
			calla.setString(1, txtusuario.getText());
			calla.setString(2, txtcontra.getText());
			ResultSet resu=calla.executeQuery();
			
			if(resu.next()){
				Usuario=txtusuario.getText();
				Cargando car=new Cargando();
				car.setVisible(true);
				dispose();
				
				
			}
			else{
				JOptionPane.showMessageDialog(null,"Verifica tu logeo , porque es incorrecto");
			}
			
			
			
	}
		catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Verifica tu logeo , porque es incorrecto");
		}
		}
	}
	protected void actionPerformedBtnAcceder(ActionEvent arg0) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			PreparedStatement calla=conexion.prepareStatement("call validarusuario(?,?)");
			calla.setString(1, txtusuario.getText());
			calla.setString(2, txtcontra.getText());
			ResultSet resu=calla.executeQuery();
			
			if(resu.next()){
				Usuario=txtusuario.getText();
				Cargando car=new Cargando();
				car.setVisible(true);
				dispose();
				
				
			}
			else{
				JOptionPane.showMessageDialog(null,"Verifica tu logeo , porque es incorrecto");
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Verifica tu logeo , porque es incorrecto");
		}
		
	
	
	
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
	
		Registrar re=new Registrar();
		re.setVisible(true);
		dispose();
	}
	protected void mouseClickedLblNewLabel(MouseEvent arg0) {
	
		dispose();
	}
	protected void mouseClickedRdbtnVer(MouseEvent arg0) {
	
		
		Boolean radio=rdbtnVer.isSelected();
		
		if(rdbtnVer.isSelected()){
			
			//txtcontra.setSelectedText();
			txtcontra.setEchoChar((char)0);
			
		}
		
		else{
			txtcontra.setEchoChar('●');
		}
	
	}
	protected void mouseClickedLblclickAqui(MouseEvent arg0) {
	int val =JOptionPane.showConfirmDialog(null,"Deseas Recuperar e Actualizar tu contraseña?");
	
	if(val==0){
		
		RecuperarContraseña recu=new RecuperarContraseña();
		recu.setVisible(true);
	}
	else{
		return;
	}
	
	}
}
