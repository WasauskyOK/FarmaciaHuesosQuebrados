package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class Vendedor extends JDialog {
	private JLabel lblCodigoTrabajador;
	private JLabel lblNewLabel;
	private JLabel lblNombreTrabajador;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblCorreoElectronico;
	private JLabel lblTelefono;
	private JTextField txtcodigo;
	private JTextField txtcontraseña;
	private JTextField txtnombre;
	private JTextField txtpaterno;
	private JTextField txtmaterno;
	private JComboBox cboaño;
	private JComboBox cbodia;
	private JTextField txtcorreo;
	private JTextField txttelefono;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JComboBox cbomes;
	public String dia;
	public String mes;
	public String año;
	public String fecha;
	private JTextArea txtS;
	private JButton btnMostrar;
	
	
	private DefaultTableModel modelovendedor;
	
	private Connection concliente;
	private CallableStatement calcliente;
	private ResultSet rescliente;
	private String url="jdbc:mysql://localhost:3306/farmacia";
	private String usuario="root";
	private String contraseña="123456789";
	private JComboBox cbopregunta;
	private JLabel label;
	private JLabel label_1;
	private JTextField txtrepuesta;
	private JButton btnNuevoTrabajador;
	private JButton btnImprimirEnArchivo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendedor dialog = new Vendedor();
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
	public Vendedor() {
		setTitle("Vendedor");
		setBounds(100, 100, 1495, 754);
		getContentPane().setLayout(null);
		
		lblCodigoTrabajador = new JLabel("Codigo Trabajador");
		lblCodigoTrabajador.setBounds(12, 30, 133, 16);
		getContentPane().add(lblCodigoTrabajador);
		
		lblNewLabel = new JLabel("Contrase\u00F1a vendedor");
		lblNewLabel.setBounds(12, 59, 133, 16);
		getContentPane().add(lblNewLabel);
		
		lblNombreTrabajador = new JLabel("Nombre Trabajador");
		lblNombreTrabajador.setBounds(12, 88, 121, 16);
		getContentPane().add(lblNombreTrabajador);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(12, 117, 106, 16);
		getContentPane().add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(12, 146, 106, 16);
		getContentPane().add(lblApellidoMaterno);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(12, 175, 121, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setBounds(12, 204, 121, 16);
		getContentPane().add(lblCorreoElectronico);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(22, 233, 56, 16);
		getContentPane().add(lblTelefono);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(157, 27, 217, 22);
		getContentPane().add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtcontraseña = new JTextField();
		txtcontraseña.setBounds(157, 56, 217, 22);
		getContentPane().add(txtcontraseña);
		txtcontraseña.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(157, 85, 217, 22);
		getContentPane().add(txtnombre);
		
		txtpaterno = new JTextField();
		txtpaterno.setColumns(10);
		txtpaterno.setBounds(157, 114, 217, 22);
		getContentPane().add(txtpaterno);
		
		txtmaterno = new JTextField();
		txtmaterno.setColumns(10);
		txtmaterno.setBounds(157, 143, 217, 22);
		getContentPane().add(txtmaterno);
		
		
		
		
		cboaño = new JComboBox();
		cboaño.setBounds(355, 172, 106, 22);
		getContentPane().add(cboaño);
		
		for (int i = 2018; i>= 1919; i--) {
			cboaño.addItem(i);
		}
		
		cbodia = new JComboBox();
	
	
		
		cbodia.setBounds(145, 172, 48, 22);
		getContentPane().add(cbodia);
	for (int i = 1; i < 32; i++) {
		cbodia.addItem(i);
	}
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(162, 201, 223, 22);
		getContentPane().add(txtcorreo);
		txtcorreo.setColumns(10);
		
		txttelefono = new JTextField();
		txttelefono.setColumns(10);
		txttelefono.setBounds(162, 230, 212, 22);
		getContentPane().add(txttelefono);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 324, 1419, 370);
		getContentPane().add(scrollPane);
		
		modelovendedor =new DefaultTableModel();
		modelovendedor.addColumn("Codigo Trabajador");
		modelovendedor.addColumn("Contraseña Trabajador");
		modelovendedor.addColumn("Nombre Trabajdor");
		modelovendedor.addColumn("Ape_Paterno");
		modelovendedor.addColumn("Ape_Materno");
		modelovendedor.addColumn("Fech_Nacimiento");
		modelovendedor.addColumn("Correo Coorporativo");
		modelovendedor.addColumn("Telefono");
		modelovendedor.addColumn("Pregunta a reponder");
		modelovendedor.addColumn("Responder Pregunta");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTable(arg0);
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setModel(modelovendedor);
		table.setRowHeight(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		
		button = new JButton("AGREGAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton(e);
			}
		});
		button.setBounds(695, 30, 155, 25);
		getContentPane().add(button);
		
		button_1 = new JButton("ACTUALIZAR DATOS");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_1(e);
			}
		});
		button_1.setBounds(695, 68, 155, 25);
		getContentPane().add(button_1);
		
		button_2 = new JButton("ELIMINAR DATOS");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_2(e);
			}
		});
		button_2.setBounds(695, 110, 155, 25);
		getContentPane().add(button_2);
		
		button_3 = new JButton("LISTAR INFORMACION");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_3(e);
			}
		});
		button_3.setBounds(695, 148, 173, 25);
		getContentPane().add(button_3);
		
		cbomes = new JComboBox();
		cbomes.setBounds(205, 172, 138, 22);
		getContentPane().add(cbomes);
		
		
		txtS = new JTextArea();
		txtS.setBounds(921, 56, 173, 106);
		getContentPane().add(txtS);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnMostrar(e);
			}
		});
	
		btnMostrar.setBounds(502, 26, 97, 25);
		getContentPane().add(btnMostrar);
		
		cbopregunta = new JComboBox();
		cbopregunta.setModel(new DefaultComboBoxModel(new String[] {"\u00BFCual es nombre de tu mascota?", "\u00BFCual es tu pelicula favorita?", "\u00BFCual es tu hobby o pasatiempo?", "\u00BFCual es tu sitio favorito?", "\u00BFComo se llama la institucion en donde estudias?", "\u00BFComo se llama la institucion en donde laboras?", "\u00BFCual es tu actor favorito?", "\u00BFCual es el nombre de tu mejor amigo(a)?", "\u00BFCual es tu apodo?", "\u00BFCuanto dinero ganas?", "\u00BFQue lugar te gustaria visitar?"}));
		cbopregunta.setBounds(160, 256, 353, 22);
		getContentPane().add(cbopregunta);
		
		label = new JLabel("Pregunta Seguridad");
		label.setBounds(32, 259, 123, 16);
		getContentPane().add(label);
		
		label_1 = new JLabel("Responder Pregunta");
		label_1.setBounds(22, 295, 123, 16);
		getContentPane().add(label_1);
		
		txtrepuesta = new JTextField();
		txtrepuesta.setColumns(10);
		txtrepuesta.setBounds(167, 291, 314, 22);
		getContentPane().add(txtrepuesta);
		
		btnNuevoTrabajador = new JButton("Nuevo Trabajador ?");
	
		btnNuevoTrabajador.setBounds(444, 59, 155, 25);
		getContentPane().add(btnNuevoTrabajador);
		
		btnImprimirEnArchivo = new JButton("Imprimir en archivo total de trabajadores");
		btnImprimirEnArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnImprimirEnArchivo(arg0);
			}
		});
		btnImprimirEnArchivo.setBounds(695, 204, 344, 25);
		getContentPane().add(btnImprimirEnArchivo);
		
		String[] mes={"Selecciona","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		for (int i = 0; i < mes.length; i++) {
			cbomes.addItem(mes[i]);	
		}
		
		
		listar();
	}


public void listar(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		concliente =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		calcliente=concliente.prepareCall("select * from vendedor");
		rescliente=calcliente.executeQuery();
		modelovendedor.setRowCount(0);
		while(rescliente.next()){
			Object []filavendedor={rescliente.getString(1),rescliente.getString(2),rescliente.getString(3),rescliente.getString(4),rescliente.getString(5)
					,rescliente.getString(6),rescliente.getString(7),rescliente.getString(8),rescliente.getString(9),rescliente.getString(10)};
			modelovendedor.addRow(filavendedor);
		
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Existe un problema te dare una pista");
		e.printStackTrace();
	}
}

	protected void actionPerformedButton(ActionEvent e) {
//agregar
	
		String dia=(String)cbodia.getSelectedItem().toString();
		int mes=cbomes.getSelectedIndex();
		String año=(String)cboaño.getSelectedItem().toString();
		
		String fecha=año+"-"+mes+"-"+dia;
		
		try {
			concliente=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			calcliente=concliente.prepareCall("call agregarvendedor(?,?,?,?,?,?,?,?,?,?)");
			
			calcliente.setString(1, txtcodigo.getText());
			calcliente.setString(2,txtcontraseña.getText());
			calcliente.setString(3,txtnombre.getText());
			calcliente.setString(4,txtpaterno.getText());
			calcliente.setString(5,txtmaterno.getText());
			calcliente.setString(6,fecha);
			calcliente.setString(7,txtcorreo.getText());
			calcliente.setString(8,txttelefono.getText());
			calcliente.setString(9,(String)cbopregunta.getSelectedItem().toString());
			calcliente.setString(10,txtrepuesta.getText());
			
			calcliente.executeUpdate();
			
		listar();	
			
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	protected void actionPerformedButton_1(ActionEvent e) {
	//actualizar
		String dia=(String)cbodia.getSelectedItem().toString();
		int mes=cbomes.getSelectedIndex();
		String año=(String)cboaño.getSelectedItem().toString();
		
		String fecha=año+"-"+mes+"-"+dia;
		
		try {
			concliente=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			calcliente=concliente.prepareCall("call actualizarvendedor(?,?,?,?,?,?,?,?,?,?)");
			
			calcliente.setString(1, txtcodigo.getText());
			calcliente.setString(2,txtcontraseña.getText());
			calcliente.setString(3,txtnombre.getText());
			calcliente.setString(4,txtpaterno.getText());
			calcliente.setString(5,txtmaterno.getText());
			calcliente.setString(6,fecha);
			calcliente.setString(7,txtcorreo.getText());
			calcliente.setString(8,txttelefono.getText());
			calcliente.setString(9,(String)cbopregunta.getSelectedItem().toString());
			calcliente.setString(10,txtrepuesta.getText());
			
			calcliente.executeUpdate();
			
		listar();	
			
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	protected void actionPerformedButton_2(ActionEvent e) {
	//borrar
		
		
		int val=JOptionPane.showConfirmDialog(null,"Deseas eliminar Si o No ?");
		
		 
		if(val==0){
			try {
				concliente=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				calcliente=concliente.prepareCall("call borrarvendedor(?)");
				
				calcliente.setString(1, txtcodigo.getText());
			
				calcliente.executeUpdate();
				
			listar();	
				
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else{
			return;
		}
		
		
		
	}
	protected void actionPerformedButton_3(ActionEvent e) {
	listar();
	}
	protected void actionPerformedBtnMostrar(ActionEvent e) {
	
		//Buscar
		try {
			concliente =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			calcliente=concliente.prepareCall("call buscarvendedor(?)");
			calcliente.setString(1,txtcodigo.getText());
			rescliente=calcliente.executeQuery();
			modelovendedor.setRowCount(0);
			while(rescliente.next()){
				Object []filavendedor={rescliente.getString(1),rescliente.getString(2),rescliente.getString(3),rescliente.getString(4),rescliente.getString(5),rescliente.getString(6),rescliente.getString(7),rescliente.getString(8),rescliente.getString(9),rescliente.getString(10)};
				modelovendedor.addRow(filavendedor);
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	protected void mouseClickedTable(MouseEvent arg0) {
	
	
	txtcodigo.setText(table.getValueAt(table.getSelectedRow(),0).toString());
	txtcontraseña.setText(table.getValueAt(table.getSelectedRow(),1).toString());
	txtnombre.setText(table.getValueAt(table.getSelectedRow(),2).toString());
	txtpaterno.setText(table.getValueAt(table.getSelectedRow(),3).toString());
	txtmaterno.setText(table.getValueAt(table.getSelectedRow(),4).toString());

	String fecha=table.getValueAt(table.getSelectedRow(),5).toString();
	String mes=fecha.substring(5,7);
	String año=fecha.substring(0,4);
	int converaño=Integer.parseInt(año);
	cboaño.setSelectedItem(converaño);
	int convertmes=Integer.parseInt(mes);
	cbomes.setSelectedIndex(convertmes);
	String dia=fecha.substring(8);
	int converdia=Integer.parseInt(dia);
	cbodia.setSelectedItem(converdia);
	txtcorreo.setText(table.getValueAt(table.getSelectedRow(),6).toString());
	txttelefono.setText(table.getValueAt(table.getSelectedRow(),7).toString());
	cbopregunta.setSelectedItem(table.getValueAt(table.getSelectedRow(), 8).toString());
	txtrepuesta.setText(table.getValueAt(table.getSelectedRow(),9).toString());
	
	}
	protected void actionPerformedBtnImprimirEnArchivo(ActionEvent arg0) {
		try {
			JFileChooser file=new JFileChooser();
			FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo texto","txt");
			file.setFileFilter(extension);
			Connection conexioninventario=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			
			CallableStatement callinventario=conexioninventario.prepareCall("select *from vendedor");
			ResultSet resulinventario=callinventario.executeQuery();
			
			
			if(file.showSaveDialog(file.getParent())==file.APPROVE_OPTION){
				String ruta=file.getSelectedFile().getPath();
				PrintWriter imprimir=new PrintWriter(ruta);
				while(resulinventario.next()){
					imprimir.println(resulinventario.getString(1)+";"+resulinventario.getString(2)+";"+resulinventario.getString(3)+";"+
							resulinventario.getString(4)+";"+resulinventario.getString(5)+";"+resulinventario.getString(6)+";"+resulinventario.getString(7)+";"+
							resulinventario.getString(8)+";"+resulinventario.getString(9)+";"+resulinventario.getString(10));
					
				}
				imprimir.close();
				JOptionPane.showMessageDialog(null,"TODA LA LISTA AH SIDO GUARDADA");
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		
		
	}
}
