package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Registrar extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JTextField txtapellidopaterno;
	private JTextField txtmaterno;
	private JComboBox cboaño;
	private JComboBox cbodia;
	private JTextField txtcorreo;
	private JTextField txttelefono;
	private JComboBox cbomes;
	private JLabel lblRepetirContrasea;
	private JButton btnRegistrarse;
	private JRadioButton rdbtnClickParaRegresar;
	private JLabel label_8;
	private JPasswordField txtcontraseña;
	private JPasswordField txtrepetir;
	private JLabel label_9;
	private JLabel lblPreguntaSeguridad;
	private JComboBox cbopregunta;
	private JLabel lblResponderPreguntas;
	private JTextField txtrespuesta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar frame = new Registrar();
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
	public Registrar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		
		setBounds(100, 100, 936, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		label = new JLabel("Codigo Trabajador");
		label.setBounds(426, 49, 133, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("Contrase\u00F1a vendedor");
		label_1.setBounds(426, 78, 133, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Nombre Trabajador");
		label_2.setBounds(426, 133, 121, 16);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Apellido Paterno");
		label_3.setBounds(426, 162, 106, 16);
		contentPane.add(label_3);
		
		label_4 = new JLabel("Apellido Materno");
		label_4.setBounds(426, 191, 106, 16);
		contentPane.add(label_4);
		
		label_5 = new JLabel("Fecha de Nacimiento");
		label_5.setBounds(426, 220, 121, 16);
		contentPane.add(label_5);
		
		label_6 = new JLabel("Correo Electronico");
		label_6.setBounds(426, 249, 121, 16);
		contentPane.add(label_6);
		
		label_7 = new JLabel("Telefono");
		label_7.setBounds(436, 278, 56, 16);
		contentPane.add(label_7);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(571, 46, 186, 22);
		contentPane.add(txtcodigo);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(571, 130, 186, 22);
		contentPane.add(txtnombre);
		
		txtapellidopaterno = new JTextField();
		txtapellidopaterno.setColumns(10);
		txtapellidopaterno.setBounds(571, 159, 186, 22);
		contentPane.add(txtapellidopaterno);
		
		txtmaterno = new JTextField();
		txtmaterno.setColumns(10);
		txtmaterno.setBounds(571, 188, 186, 22);
		contentPane.add(txtmaterno);
		
		cboaño = new JComboBox();
		cboaño.setBounds(769, 217, 106, 22);
		contentPane.add(cboaño);
		
		for (int i = 1940; i <2017; i++) {
			cboaño.addItem(i);
		}
		cbodia = new JComboBox();
		cbodia.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbodia.setBounds(559, 217, 48, 22);
		contentPane.add(cbodia);
		
		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);
		txtcorreo.setBounds(569, 246, 188, 22);
		contentPane.add(txtcorreo);
		
		txttelefono = new JTextField();
		txttelefono.setColumns(10);
		txttelefono.setBounds(571, 275, 186, 22);
		contentPane.add(txttelefono);
		
		cbomes = new JComboBox();
		cbomes.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
		cbomes.setBounds(619, 217, 138, 22);
		contentPane.add(cbomes);
		
		lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a");
		lblRepetirContrasea.setBounds(426, 104, 133, 16);
		contentPane.add(lblRepetirContrasea);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setForeground(new Color(64, 224, 208));
		btnRegistrarse.setBackground(new Color(240, 248, 255));
		btnRegistrarse.setIcon(new ImageIcon(Registrar.class.getResource("/gui/guardar (3).png")));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnRegistrarse(arg0);
			}
		});
		btnRegistrarse.setBounds(571, 458, 227, 92);
		contentPane.add(btnRegistrarse);
		
		rdbtnClickParaRegresar = new JRadioButton("Click para regresar al login");
		rdbtnClickParaRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedRdbtnClickParaRegresar(arg0);
			}
		});
		rdbtnClickParaRegresar.setBounds(542, 15, 198, 25);
		contentPane.add(rdbtnClickParaRegresar);
		
		txtcontraseña = new JPasswordField();
		txtcontraseña.setBounds(571, 74, 189, 25);
		contentPane.add(txtcontraseña);
		
		txtrepetir = new JPasswordField();
		txtrepetir.setBounds(568, 104, 189, 20);
		contentPane.add(txtrepetir);
		
		label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLabel_9(e);
			}
		});
		
		lblPreguntaSeguridad = new JLabel("Pregunta Seguridad");
		lblPreguntaSeguridad.setBounds(436, 321, 123, 16);
		contentPane.add(lblPreguntaSeguridad);
		
		cbopregunta = new JComboBox();
		cbopregunta.setModel(new DefaultComboBoxModel(new String[] {"\u00BFCual es nombre de tu mascota?", "\u00BFCual es tu pelicula favorita?", "\u00BFCual es tu hobby o pasatiempo?", "\u00BFCual es tu sitio favorito?", "\u00BFComo se llama la institucion en donde estudias?", "\u00BFComo se llama la institucion en donde laboras?", "\u00BFCual es tu actor favorito?", "\u00BFCual es el nombre de tu mejor amigo(a)?", "\u00BFCual es tu apodo?", "\u00BFCuanto dinero ganas?", "\u00BFQue lugar te gustaria visitar?"}));
		cbopregunta.setBounds(571, 328, 353, 22);
		contentPane.add(cbopregunta);
		
		lblResponderPreguntas = new JLabel("Responder Pregunta");
		lblResponderPreguntas.setBounds(426, 367, 123, 16);
		contentPane.add(lblResponderPreguntas);
		
		txtrespuesta = new JTextField();
		txtrespuesta.setBounds(571, 363, 314, 22);
		contentPane.add(txtrespuesta);
		txtrespuesta.setColumns(10);
		label_9.setIcon(new ImageIcon(Registrar.class.getResource("/gui/cancelar.png")));
		label_9.setBounds(832, 4, 79, 90);
		contentPane.add(label_9);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Registrar.class.getResource("/gui/bearded-wise-man.gif")));
		label_8.setBounds(0, 0, 918, 568);
		contentPane.add(label_8);
	}
	protected void actionPerformedBtnRegistrarse(ActionEvent arg0) {
	
		
		
		String igual=txtrepetir.getText();
	boolean val=igual.equals(txtcontraseña.getText());
	try{
	if(val==false){
		throw new ExcepionContraseñaDistintas();
		
	}
	}catch(ExcepionContraseñaDistintas ex){
		ex.exceptioncapturado();
		return;
	}
	
		String dia=(String)cbodia.getSelectedItem().toString();
		int mes=cbomes.getSelectedIndex();
		String año=(String)cboaño.getSelectedItem().toString();
		String fecha=año+"-"+mes+"-"+dia;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection  conexionregistro=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callregistro=conexionregistro.prepareCall("call agregarvendedor(?,?,?,?,?,?,?,?,?,?)");
			
			callregistro.setString(1, txtcodigo.getText());
			callregistro.setString(2,txtcontraseña.getText());
			callregistro.setString(3,txtnombre.getText());
			callregistro.setString(4,txtapellidopaterno.getText());
			callregistro.setString(5,txtmaterno.getText());
			callregistro.setString(6,fecha);
			callregistro.setString(7,txtcorreo.getText());
			callregistro.setString(8,txttelefono.getText());
			callregistro.setString(9,(String)cbopregunta.getSelectedItem().toString());
			callregistro.setString(10,txtrespuesta.getText());
			callregistro.executeUpdate();
			JOptionPane.showMessageDialog(null,"FELICIDADES "+txtcodigo.getText()+" ACABAS DE CREARTE UNA CUENTA EN NUESTRO SISTEMA ");
			
			txtcodigo.setText("");
			txtcontraseña.setText("");
			txtnombre.setText("");
			txtapellidopaterno.setText("");
			txtmaterno.setText("");
			cbodia.setSelectedIndex(0);
			cbomes.setSelectedIndex(0);
			cboaño.setSelectedIndex(0);
			txtcorreo.setText("");
			txttelefono.setText("");
			txtrepetir.setText("");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void actionPerformedRdbtnClickParaRegresar(ActionEvent arg0) {
	
		Login log=new Login();
		log.setVisible(true);
		dispose();
	}
	protected void mouseClickedLabel_9(MouseEvent e) {
	dispose();
	}
}
