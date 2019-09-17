package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
public class Cliente extends JDialog {
	private JLabel lblCodigoCliente;
	private JLabel lblDni;
	private JLabel lblNombreCliente;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnImprimirCliente;
	private JButton btnAbrirClienteArchivo;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtcodigo;
	private JTextField txtdni;
	private JTextField txtnombre;
	private JTextField txtpaterno;
	private JTextField txtmaterno;
	private DefaultTableModel modelocliente;
	
	private Connection concliente;
	private CallableStatement calcliente;
	private ResultSet rescliente;
	private String url="jdbc:mysql://localhost:3306/farmacia";
	private String usuario="root";
	private String contraseña="123456789";
	private JButton btnBuscar;
	private JButton btnMandarDatosPara;
	
	
	public static String codigocliente1;
	public static String dnicliente1;
	public static String nombrecliente1;
	public static String apepaterno1;
	public static String apematerno1;
	public static int puntos1;
	private JTextField txtpuntos;
	private JLabel lblPuntos;
	private JButton btnHabilitarParaCambiar;
	private JLabel label;
	private JButton btnImprimirLista;
	private JButton btnTraerLista;
	public static Boolean validar2=false;
	private JButton btnNuevoCodigoCliente;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente dialog = new Cliente();
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
	public Cliente() {
		getContentPane().setForeground(new Color(175, 238, 238));
		getContentPane().setBackground(new Color(175, 238, 238));
		setTitle("CLIENTE |");
		setBounds(100, 100, 1369, 612);
		getContentPane().setLayout(null);
		
		lblCodigoCliente = new JLabel("Codigo Cliente");
		lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblCodigoCliente.setBounds(28, 24, 107, 16);
		getContentPane().add(lblCodigoCliente);
		
		lblDni = new JLabel("Dni Cliente");
		lblDni.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDni.setBounds(28, 53, 95, 16);
		getContentPane().add(lblDni);
		
		lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNombreCliente.setBounds(28, 92, 107, 16);
		getContentPane().add(lblNombreCliente);
		
		lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblApellidoPaterno.setBounds(28, 122, 107, 16);
		getContentPane().add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblApellidoMaterno.setBounds(12, 162, 123, 16);
		getContentPane().add(lblApellidoMaterno);
		
		button = new JButton("AGREGAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedButton(arg0);
			}
		});
		button.setBounds(616, 20, 155, 25);
		getContentPane().add(button);
		
		button_1 = new JButton("ACTUALIZAR DATOS");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedButton_1(arg0);
			}
		});
		button_1.setBounds(616, 49, 155, 25);
		getContentPane().add(button_1);
		
		button_2 = new JButton("ELIMINAR DATOS");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_2(e);
			}
		});
		button_2.setBounds(616, 88, 155, 25);
		getContentPane().add(button_2);
		
		button_3 = new JButton("LISTAR INFORMACION");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_3(e);
			}
		});
		button_3.setBounds(600, 118, 173, 25);
		getContentPane().add(button_3);
		
		btnImprimirCliente = new JButton("IMPRIMIR CLIENTE");
		btnImprimirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnImprimirCliente(e);
			}
		});
		btnImprimirCliente.setBounds(536, 162, 235, 25);
		getContentPane().add(btnImprimirCliente);
		
		btnAbrirClienteArchivo = new JButton("ABRIR CLIENTE ARCHIVO");
		btnAbrirClienteArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnAbrirClienteArchivo(arg0);
			}
		});
		btnAbrirClienteArchivo.setBounds(536, 193, 235, 25);
		getContentPane().add(btnAbrirClienteArchivo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 238, 746, 319);
		getContentPane().add(scrollPane);
		
		modelocliente =new DefaultTableModel();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTable(arg0);
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		modelocliente.addColumn("Codigo Cliente");
		modelocliente.addColumn("Dni Cliente");
		modelocliente.addColumn("Nombre Cliente");
		modelocliente.addColumn("Apellido Paterno");
		modelocliente.addColumn("Apellido Materno");
		modelocliente.addColumn("Puntos");
		table.setModel(modelocliente);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(144, 21, 116, 22);
		getContentPane().add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(144, 50, 116, 22);
		getContentPane().add(txtdni);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(144, 89, 116, 22);
		getContentPane().add(txtnombre);
		
		txtpaterno = new JTextField();
		txtpaterno.setColumns(10);
		txtpaterno.setBounds(144, 122, 116, 22);
		getContentPane().add(txtpaterno);
		
		txtmaterno = new JTextField();
		txtmaterno.setColumns(10);
		txtmaterno.setBounds(144, 159, 116, 22);
		getContentPane().add(txtmaterno);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setBounds(507, 20, 97, 25);
		getContentPane().add(btnBuscar);
		
		btnMandarDatosPara = new JButton("MANDAR DATOS PARA VENTA");
		btnMandarDatosPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnMandarDatosPara(e);
			}
		});
		btnMandarDatosPara.setBounds(288, 58, 205, 80);
		getContentPane().add(btnMandarDatosPara);
		
		txtpuntos = new JTextField();
		txtpuntos.setEditable(false);
		txtpuntos.setText("0");
		txtpuntos.setBounds(144, 194, 116, 22);
		getContentPane().add(txtpuntos);
		txtpuntos.setColumns(10);
		
		lblPuntos = new JLabel("Puntos");
		lblPuntos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPuntos.setBounds(38, 197, 56, 16);
		getContentPane().add(lblPuntos);
		
		btnHabilitarParaCambiar = new JButton("Click para Habilitar esta caja");
		btnHabilitarParaCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnHabilitarParaCambiar(arg0);
			}
		});
		btnHabilitarParaCambiar.setBounds(272, 193, 201, 25);
		getContentPane().add(btnHabilitarParaCambiar);
		
		btnTraerLista = new JButton("Traer Lista");
		btnTraerLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnTraerLista(e);
			}
		});
		btnTraerLista.setBounds(792, 204, 124, 25);
		getContentPane().add(btnTraerLista);
		
		btnImprimirLista = new JButton("Imprimir lista");
		btnImprimirLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnImprimirLista(arg0);
			}
		});
		btnImprimirLista.setBounds(793, 158, 123, 25);
		getContentPane().add(btnImprimirLista);
		
		label = new JLabel("");
		label.setForeground(new Color(240, 255, 255));
		label.setBackground(new Color(0, 0, 0));
		label.setIcon(new ImageIcon(Cliente.class.getResource("/gui/05.gif-art-big.gif")));
		label.setBounds(823, 0, 540, 565);
		getContentPane().add(label);
		
		btnNuevoCodigoCliente = new JButton("Nuevo codigo cliente");
		btnNuevoCodigoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNuevoCodigoCliente(e);
			}
		});
		btnNuevoCodigoCliente.setBounds(263, 20, 210, 25);
		getContentPane().add(btnNuevoCodigoCliente);

		
		
		listar();
	}
	
	
	public void listar(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			concliente =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			calcliente=concliente.prepareCall("select * from cliente");
			rescliente=calcliente.executeQuery();
			modelocliente.setRowCount(0);
			while(rescliente.next()){
				Object []filacliente={rescliente.getString(1),rescliente.getString(2),rescliente.getString(3),rescliente.getString(4),rescliente.getString(5),rescliente.getInt(6)};
			modelocliente.addRow(filacliente);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Existe un problema te dare una pista");
			e.printStackTrace();
		}
		}
	
	
	protected void actionPerformedButton(ActionEvent arg0) {
	//agregar
		
		try {
		
			concliente =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			calcliente=concliente.prepareCall("call agregarcliente(?,?,?,?,?,?)");
			
			calcliente.setString(1, txtcodigo.getText());
			calcliente.setString(2, txtdni.getText());
			calcliente.setString(3,txtnombre.getText());
			calcliente.setString(4, txtpaterno.getText());
			calcliente.setString(5,txtmaterno.getText());
			calcliente.setInt(6,Integer.parseInt(txtpuntos.getText()));
			calcliente.executeUpdate();
			
			
			listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
	//actualizar
		try {
		
			concliente =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			calcliente=concliente.prepareCall("call actualizarcliente(?,?,?,?,?,?)");
			
			calcliente.setString(1,txtcodigo.getText());
			calcliente.setString(2,txtdni.getText());
			calcliente.setString(3,txtnombre.getText());
			calcliente.setString(4,txtpaterno.getText());
			calcliente.setString(5,txtmaterno.getText());
			calcliente.setInt(6,Integer.parseInt(txtpuntos.getText()));
			calcliente.executeUpdate();
			
			
			listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void actionPerformedButton_2(ActionEvent e) {
	
		//eliminar
				try {
					concliente =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					calcliente=concliente.prepareCall("call borrarcliente(?)");
					calcliente.setString(1,txtcodigo.getText());
					calcliente.executeUpdate();

					listar();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
		
	}
	protected void actionPerformedButton_3(ActionEvent e) {
	listar();
	
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		//Buscar
				try {
					concliente =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					calcliente=concliente.prepareCall("call buscarcliente(?)");
					calcliente.setString(1,txtcodigo.getText());
					rescliente=calcliente.executeQuery();
					modelocliente.setRowCount(0);
					while(rescliente.next()){
						Object []filacliente={rescliente.getString(1),rescliente.getString(2),rescliente.getString(3),rescliente.getString(4),rescliente.getString(5),rescliente.getString(6)};
					modelocliente.addRow(filacliente);
					}
					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
	}
	protected void actionPerformedBtnMandarDatosPara(ActionEvent e) {
	
		codigocliente1=txtcodigo.getText();
		dnicliente1=txtdni.getText();
		nombrecliente1=txtnombre.getText();
		apepaterno1=txtpaterno.getText();
		apematerno1=txtmaterno.getText();
		puntos1=Integer.parseInt(txtpuntos.getText());
	
		validar2=true;
		
		Venta obj=new Venta();
		
		
		obj.setVisible(true);
		dispose();
		
		
		
		
	}
	protected void mouseClickedTable(MouseEvent arg0) {
	
		int fila=table.getSelectedRow();
		txtcodigo.setText(table.getValueAt(fila,0).toString());
		txtdni.setText(table.getValueAt(fila,1).toString());
		txtnombre.setText(table.getValueAt(fila,2).toString());
		txtpaterno.setText(table.getValueAt(fila,3).toString());
		txtmaterno.setText(table.getValueAt(fila,4).toString());
		txtpuntos.setText(table.getValueAt(fila,5).toString());
		
	}
	protected void actionPerformedBtnImprimirCliente(ActionEvent e) {
	
		JFileChooser file=new JFileChooser();
		
		FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo texto","txt");
		file.setFileFilter(extension);
		
		if(file.showSaveDialog(file.getParent())==file.APPROVE_OPTION){
			try{
			
				PrintWriter imprimir=new PrintWriter(file.getSelectedFile().getPath());
					imprimir.println(txtcodigo.getText());
					imprimir.println(txtdni.getText());
					imprimir.println(txtnombre.getText());
					imprimir.println(txtpaterno.getText());
					imprimir.println(txtmaterno.getText());
					imprimir.println(txtpuntos.getText());
					
			imprimir.close();
			}
			catch(IOException ex){
				
			}
		}
		
		
		
		
		
	}
	protected void actionPerformedBtnHabilitarParaCambiar(ActionEvent arg0) {
	txtpuntos.setEditable(true);
	}
	protected void actionPerformedBtnAbrirClienteArchivo(ActionEvent arg0) {
	//abrir
		
		JFileChooser abrir =new JFileChooser();
		FileNameExtensionFilter extension=new FileNameExtensionFilter("Texto","txt");
		abrir.setFileFilter(extension);
		
		if(abrir.showOpenDialog(abrir.getParent())==abrir.APPROVE_OPTION){
			
			try {
				BufferedReader leer=new BufferedReader(new FileReader(abrir.getSelectedFile().getPath()));
						
				try {
					txtcodigo.setText(""+leer.readLine());
					txtdni.setText(""+leer.readLine());
					txtnombre.setText(""+leer.readLine());
					txtpaterno.setText(""+leer.readLine());
					txtmaterno.setText(""+leer.readLine());
					txtpuntos.setText(""+leer.readLine());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
	
	}
	protected void actionPerformedBtnImprimirLista(ActionEvent arg0) {
	
		
		
		JFileChooser file=new JFileChooser();
		FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo texto","txt");
		file.setFileFilter(extension);
		if(file.showSaveDialog(file.getParent())==JFileChooser.APPROVE_OPTION){
			
			try {
				PrintWriter impresion=new PrintWriter(file.getSelectedFile().getPath());
				
				Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement callpro=conexion.prepareCall("select *from cliente");
				ResultSet resultado=callpro.executeQuery();
				while(resultado.next()){
					impresion.println(resultado.getString(1)+";"+resultado.getString(2)+";"+resultado.getString(3)+";"+resultado.getString(4)+";"+resultado.getString(5)+";"+resultado.getString(6));
				}
				impresion.close();
			} catch (Exception e) {
				// TODO: handle exception
			} 
			
		}
		
		
		/*
		JFileChooser file=new JFileChooser();
		FileNameExtensionFilter ext=new  
				FileNameExtensionFilter("Solo texto","txt");
		file.setFileFilter(ext);
		int fila=0;
		int columna=0;
		if(file.showSaveDialog(file.getParent())==JFileChooser.APPROVE_OPTION){
					
			for (int i = 0; i < modelocliente.getRowCount(); i++) {
					for (fila = 0; fila < modelocliente.getColumnCount(); fila++) {
						try {
							PrintWriter imprimir=new PrintWriter(new FileWriter(file.getSelectedFile().getPath()),true);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

			}
		}
		*/
		
	}
	protected void actionPerformedBtnNuevoCodigoCliente(ActionEvent e) {
		try {
			Connection conexionpuntos2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callpuntos2=conexionpuntos2.prepareCall("select max(codcli)from cliente");
			ResultSet respun2=callpuntos2.executeQuery();
			
			if(respun2.next()){
				
			String sentencia=respun2.getString(1);
		
			
			String ven=sentencia.substring(0,3);
			String num=sentencia.substring(3);
			int num2=Integer.parseInt(num);
			num2++;
			String cadena=ven+num2;
			txtcodigo.setText(cadena);	
			}
			
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
		txtcodigo.setEditable(false);
		txtdni.setText("");
		txtmaterno.setText("");
		txtnombre.setText("");
		txtpaterno.setText("");
		txtpuntos.setText("0");
		
	}
	protected void actionPerformedBtnTraerLista(ActionEvent e) {
	
		
		JFileChooser file=new JFileChooser();
		FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo texto","txt");
		file.setFileFilter(extension);
		if(file.showOpenDialog(file.getParent())==JFileChooser.APPROVE_OPTION){
			
			try {
			
				BufferedReader leer=new  BufferedReader(new FileReader(file.getSelectedFile().getPath()));
				String linea;
				String []vector;
				while((linea=leer.readLine())!=null){
					vector=linea.split(";");
					Object [] fila={vector[0],vector[1],vector[2],vector[3],vector[4],vector[5]};
					modelocliente.addRow(fila);
				}
				
				leer.close();
				
			} catch (Exception ex) {
				// TODO: handle exception
			} 
			
		}
		
	}
}
