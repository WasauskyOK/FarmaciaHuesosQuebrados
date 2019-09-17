package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dialog;

import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class infocli1 extends JDialog {
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelofarmacia;
	private JLabel lblCodigoMedicamento;
	private JLabel lblTipoMedicamento;
	private JLabel lblDescripcionMedicamento;
	private JLabel lblPresentacionMedicamento;
	private JLabel lblPrecioDelMedicamento;
	private JTextField txtcodigo;
	private JTextField txttipo;
	private JTextField txtdescripcion;
	private JTextField txtpresentacion;
	private JTextField txtprecio;
	private JLabel lblConexion;
	private JButton btnNewButton;
	private JButton btnAgregar;
	private JButton btnActualizarDatos;
	private JButton btnEliminarDatos;
	private JButton btnListarInformacion;
	private JButton btnDesconexionDeBd;
	private JButton btnImprimirInventarioProductos;
	private JButton btnImprimirMedicamento;
	private JButton btnAbrirMedicamentoArchivo;
	private JLabel lblMonedaSoles;
	private JLabel lblStock;
	private JTextField txtStock;
	private JButton btnNuevoCodigoMedicamento;
	private JComboBox cbotipo;
	private JLabel lblClickDerechoSi;
	private JLabel lblclickAqui;
	private JButton btnTraerLista;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					infocli1 dialog = new infocli1();
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
	public infocli1() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("PRODUCTOS");
		setBounds(100, 100, 1394, 749);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 269, 1352, 420);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTable(arg0);
			}
		});
		modelofarmacia=new DefaultTableModel();
		modelofarmacia.addColumn("Codigo de Medicamento");
		modelofarmacia.addColumn("Tipo de Medicamento");
		modelofarmacia.addColumn("Descripcion de Medicamento");
		modelofarmacia.addColumn("Presentacion del Medicamento");
		modelofarmacia.addColumn("Precio del Medicamento");
		modelofarmacia.addColumn("Stock");
		
		table.setModel(modelofarmacia);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		lblCodigoMedicamento = new JLabel("Codigo Medicamento");
		lblCodigoMedicamento.setBounds(48, 27, 133, 16);
		getContentPane().add(lblCodigoMedicamento);
		
		lblTipoMedicamento = new JLabel("Tipo Medicamento");
		lblTipoMedicamento.setBounds(68, 51, 119, 16);
		getContentPane().add(lblTipoMedicamento);
		
		lblDescripcionMedicamento = new JLabel("Descripcion Medicamento");
		lblDescripcionMedicamento.setBounds(32, 80, 166, 16);
		getContentPane().add(lblDescripcionMedicamento);
		
		lblPresentacionMedicamento = new JLabel("Presentacion Medicamento");
		lblPresentacionMedicamento.setBounds(32, 107, 155, 16);
		getContentPane().add(lblPresentacionMedicamento);
		
		lblPrecioDelMedicamento = new JLabel("Precio del Medicamento");
		lblPrecioDelMedicamento.setBounds(48, 136, 150, 16);
		getContentPane().add(lblPrecioDelMedicamento);
		
		txtcodigo = new JTextField();
		txtcodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				keyPressedTxtcodigo(e);
			}
		});
		txtcodigo.setBounds(199, 24, 116, 22);
		getContentPane().add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txttipo = new JTextField();
		txttipo.setColumns(10);
		txttipo.setBounds(209, 48, 328, 22);
		getContentPane().add(txttipo);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setColumns(10);
		txtdescripcion.setBounds(199, 75, 389, 22);
		getContentPane().add(txtdescripcion);
		
		txtpresentacion = new JTextField();
		txtpresentacion.setColumns(10);
		txtpresentacion.setBounds(199, 104, 389, 22);
		getContentPane().add(txtpresentacion);
		
		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		txtprecio.setBounds(199, 133, 116, 22);
		getContentPane().add(txtprecio);
		
		lblConexion = new JLabel("Desconectado");
		lblConexion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConexion.setForeground(Color.RED);
		lblConexion.setBounds(1203, 0, 173, 16);
		getContentPane().add(lblConexion);
			
			btnNewButton = new JButton("BUSCAR");
			btnNewButton.setBackground(new Color(0, 0, 0));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
			btnNewButton.setIcon(new ImageIcon(infocli1.class.getResource("/gui/busqueda.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnNewButton(arg0);
				}
			});
			btnNewButton.setBounds(1056, 63, 197, 60);
			getContentPane().add(btnNewButton);
			
			btnAgregar = new JButton("AGREGAR");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnAgregar(e);
				}
			});
			btnAgregar.setBounds(828, 13, 155, 25);
			getContentPane().add(btnAgregar);
			
			btnActualizarDatos = new JButton("ACTUALIZAR DATOS");
			btnActualizarDatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnActualizarDatos(e);
				}
			});
			btnActualizarDatos.setBounds(940, 161, 155, 25);
			getContentPane().add(btnActualizarDatos);
			
			btnEliminarDatos = new JButton("ELIMINAR DATOS");
			btnEliminarDatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnEliminarDatos(e);
				}
			});
			btnEliminarDatos.setBounds(1185, 161, 155, 25);
			getContentPane().add(btnEliminarDatos);
			
			btnListarInformacion = new JButton("LISTAR INFORMACION");
			btnListarInformacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnListarInformacion(e);
				}
			});
			btnListarInformacion.setBounds(941, 198, 173, 25);
			getContentPane().add(btnListarInformacion);
			
			btnDesconexionDeBd = new JButton("Desconexion de BD");
			btnDesconexionDeBd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnDesconexionDeBd(arg0);
				}
			});
			btnDesconexionDeBd.setBounds(1178, 23, 162, 25);
			getContentPane().add(btnDesconexionDeBd);
			
			btnImprimirInventarioProductos = new JButton("IMPRIMIR INVENTARIO PRODUCTOS EN UN ARCHIVO");
			btnImprimirInventarioProductos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					mouseClickedBtnImprimirInventarioProductos(arg0);
				}
			});
		
		
			btnImprimirInventarioProductos.setBounds(692, 132, 372, 25);
			getContentPane().add(btnImprimirInventarioProductos);
			
			btnImprimirMedicamento = new JButton("IMPRIMIR MEDICAMENTO");
			btnImprimirMedicamento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnImprimirMedicamento(e);
				}
			});
			btnImprimirMedicamento.setBounds(1115, 198, 235, 25);
			getContentPane().add(btnImprimirMedicamento);
			
			btnAbrirMedicamentoArchivo = new JButton("ABRIR MEDICAMENTO ARCHIVO");
			btnAbrirMedicamentoArchivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnAbrirMedicamentoArchivo(e);
				}
			});
			btnAbrirMedicamentoArchivo.setBounds(980, 236, 235, 25);
			getContentPane().add(btnAbrirMedicamentoArchivo);
			
			lblMonedaSoles = new JLabel("Moneda : Soles (S/.)");
			lblMonedaSoles.setBounds(1227, 240, 137, 16);
			getContentPane().add(lblMonedaSoles);
			
			lblStock = new JLabel("Stock");
			lblStock.setBounds(48, 165, 56, 16);
			getContentPane().add(lblStock);
			
			txtStock = new JTextField();
			txtStock.setBounds(199, 168, 116, 22);
			getContentPane().add(txtStock);
			txtStock.setColumns(10);
			
			btnNuevoCodigoMedicamento = new JButton("Nuevo codigo medicamento");
			btnNuevoCodigoMedicamento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNuevoCodigoMedicamento(e);
				}
			});
			btnNuevoCodigoMedicamento.setBounds(587, 13, 210, 25);
			getContentPane().add(btnNuevoCodigoMedicamento);
			
			cbotipo = new JComboBox();
			cbotipo.setEnabled(false);
			cbotipo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					itemStateChangedCbotipo(arg0);
				}
			});
			
			lblClickDerechoSi = new JLabel("Opciones");
			lblClickDerechoSi.setBounds(566, 51, 62, 16);
			getContentPane().add(lblClickDerechoSi);
			
			lblclickAqui = new JLabel("(Click aqui)");
			lblclickAqui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					mouseClickedLblclickAqui(arg0);
				}
			});
			lblclickAqui.setBounds(626, 39, 85, 37);
			getContentPane().add(lblclickAqui);
			cbotipo.setBounds(736, 48, 308, 22);
			getContentPane().add(cbotipo);
			
			btnTraerLista = new JButton("Traer Lista");
			btnTraerLista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnTraerLista(arg0);
				}
			});
			btnTraerLista.setBounds(1115, 132, 97, 25);
			getContentPane().add(btnTraerLista);
		try {
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callpro=conexion.prepareCall("select distinct(tipopro) from productos");
			ResultSet resultado=callpro.executeQuery();
			while(resultado.next()){
				cbotipo.addItem(resultado.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			listado();
			
		
			 

	}
	
	public void listado(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			lblConexion.setText("Usuario Conectado");
			
		CallableStatement cal=conexion.prepareCall("call listarproducto()");
		ResultSet res=cal.executeQuery();
		modelofarmacia.setRowCount(0);
		while(res.next()){
			Object []listar={res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6)};
			
			modelofarmacia.addRow(listar);
		}
		
	}
	
	catch(Exception ex ){
		
		lblConexion.setText("No hay conexion");
		ex.printStackTrace();
	}
		
	}
	
	
	protected void mouseClickedTable(MouseEvent arg0) {
		
		int indice=table.getSelectedRow();
		/*int columna=table.getSelectedColumn();*/
		txtcodigo.setText(""+table.getValueAt(indice,0));
		txttipo.setText(""+table.getValueAt(indice, 1));
		txtdescripcion.setText(""+table.getValueAt(indice,2));
		txtpresentacion.setText(""+table.getValueAt(indice,3));
		
		txtprecio.setText(""+table.getValueAt(indice, 4));
		txtStock.setText(""+table.getValueAt(indice, 5));
		
		
		
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
	
	//buscar
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			
			
		CallableStatement cal=conexion.prepareCall("call buscarproducto(?)");
		cal.setString(1,txtcodigo.getText());
		ResultSet res=cal.executeQuery();
		modelofarmacia.setRowCount(0);
		while(res.next()){
			Object []listar={res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6)};
			
			modelofarmacia.addRow(listar);
		}
		
	}
	
	catch(Exception ex ){
		
		lblConexion.setText("No hay conexion");
		ex.printStackTrace();
	}
	}
	protected void keyPressedTxtcodigo(KeyEvent e) {
	
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				
				
			CallableStatement cal=conexion.prepareCall("call buscarproducto(?)");
			cal.setString(1,txtcodigo.getText());
			ResultSet res=cal.executeQuery();
			modelofarmacia.setRowCount(0);
			while(res.next()){
				Object []listar={res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6)};
				
				modelofarmacia.addRow(listar);
			}
			
		}
		
		catch(Exception ex ){
			
			lblConexion.setText("No hay conexion");
			ex.printStackTrace();
		
		}
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
	//agregar
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			
			
		CallableStatement cal=conexion.prepareCall("call agregarproducto(?,?,?,?,?,?)");
		cal.setString(1,txtcodigo.getText());
		cal.setString(2,txttipo.getText());
		cal.setString(3,txtdescripcion.getText());
		cal.setString(4,txtpresentacion.getText());
		cal.setDouble(5,Double.parseDouble(txtprecio.getText()));
		cal.setInt(6,Integer.parseInt(txtStock.getText()));
		
		cal.executeUpdate();
		
		listado();
		
	}
	
	catch(Exception ex ){
		
		lblConexion.setText("No hay conexion");
		ex.printStackTrace();
	}	
		
	}
	protected void actionPerformedBtnActualizarDatos(ActionEvent e) {
	
		//ACTUALIZAR
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					
					
				CallableStatement cal=conexion.prepareCall("call actualizarproducto(?,?,?,?,?,?)");
				cal.setString(1,txtcodigo.getText());
				cal.setString(2,txttipo.getText());
				cal.setString(3, txtdescripcion.getText());
				cal.setString(4, txtpresentacion.getText());
				cal.setDouble(5,Double.parseDouble(txtprecio.getText()));
				cal.setInt(6,Integer.parseInt(txtStock.getText()));
				cal.executeUpdate();
				listado();
				
				
			}
			
			catch(Exception ex ){
				
				lblConexion.setText("No hay conexion");
				ex.printStackTrace();
			}	
	}
	protected void actionPerformedBtnListarInformacion(ActionEvent e) {
		listado();
	}
	protected void actionPerformedBtnEliminarDatos(ActionEvent e) {
		//ELIMINAR
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			
			
		CallableStatement cal=conexion.prepareCall("call borrarproducto(?)");
		cal.setString(1,txtcodigo.getText());
		
		cal.executeUpdate();
		listado();
		
		
	}
	
	catch(Exception ex ){
		
		lblConexion.setText("No hay conexion");
		ex.printStackTrace();
	}	
	}
	protected void actionPerformedBtnImprimirMedicamento(ActionEvent e) {
	
	
	
	
		JFileChooser file=new JFileChooser();
	FileNameExtensionFilter filtro=new FileNameExtensionFilter("Solo txt","txt");
	
	file.setFileFilter(filtro);
	
	if(file.showSaveDialog(file.getParent())==file.APPROVE_OPTION){
		String ruta=file.getSelectedFile().getPath();
		try {
			PrintWriter imprimir=new PrintWriter(new FileWriter(ruta));
			
			String cod=txtcodigo.getText();
			String tipo=txttipo.getText();
			String desc=txtdescripcion.getText();
			String pres=txtpresentacion.getText();
			String pre=txtprecio.getText();
			String sto=txtStock.getText();
			
			imprimir.println(cod);
			imprimir.println(tipo);
			imprimir.println(desc);
			imprimir.println(pres);
			imprimir.println(pre);
			imprimir.print(sto);
			imprimir.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	}
	protected void actionPerformedBtnAbrirMedicamentoArchivo(ActionEvent e) {
	
	JFileChooser file=new JFileChooser();
	FileNameExtensionFilter ext=new FileNameExtensionFilter("Solo Texto","txt");
	file.setFileFilter(ext);
	if(file.showOpenDialog(file.getParent())==file.APPROVE_OPTION){
		
		try {
			BufferedReader bf=new BufferedReader(new FileReader(file.getSelectedFile().getPath()));
			txtcodigo.setText(bf.readLine());
			txttipo.setText(bf.readLine());
			txtdescripcion.setText(bf.readLine());
			txtpresentacion.setText(bf.readLine());
			txtprecio.setText(bf.readLine());
			txtStock.setText(bf.readLine());
			
			bf.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	}
	
	

	protected void mouseClickedBtnImprimirInventarioProductos(MouseEvent arg0) {
		
		try {
			JFileChooser file=new JFileChooser();
			FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo texto","txt");
			file.setFileFilter(extension);
			Connection conexioninventario=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			
			CallableStatement callinventario=conexioninventario.prepareCall("select *from productos");
			ResultSet resulinventario=callinventario.executeQuery();
			
			
			if(file.showSaveDialog(file.getParent())==file.APPROVE_OPTION){
				String ruta=file.getSelectedFile().getPath();
				PrintWriter imprimir=new PrintWriter(ruta);
				while(resulinventario.next()){
					imprimir.println(resulinventario.getString(1)+";"+resulinventario.getString(2)+";"+resulinventario.getString(3)+";"+
							resulinventario.getString(4)+";"+resulinventario.getDouble(5)+";"+resulinventario.getInt(6));
					
				}
				imprimir.close();
				JOptionPane.showMessageDialog(null,"TODA LA LISTA AH SIDO GUARDADA");
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		
	}

	protected void actionPerformedBtnDesconexionDeBd(ActionEvent arg0) {
	int val=JOptionPane.showConfirmDialog(null,"Deseas Desconectarte ?");
	
	if(val==0){
		Login log=new Login();
		log.setVisible(true);
		dispose();
	}
	else{
		return;
	}
	
	}
	protected void actionPerformedBtnNuevoCodigoMedicamento(ActionEvent e) {
		try {
			Connection conexionpuntos2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callpuntos2=conexionpuntos2.prepareCall("select max(codpro)from productos");
			ResultSet respun2=callpuntos2.executeQuery();
			
			if(respun2.next()){
				
			String sentencia=respun2.getString(1);
		
			
			String ven=sentencia.substring(0,1);
			String num=sentencia.substring(1);
			int num2=Integer.parseInt(num);
			num2++;
			String cadena=ven+num2;
			txtcodigo.setText(cadena);	
			}
			
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
		txtcodigo.setEditable(false);
		txtdescripcion.setText("");
		txtprecio.setText("");
		txtpresentacion.setText("");
		txtStock.setText("");
		txttipo.setText("");
	}
	protected void itemStateChangedCbotipo(ItemEvent arg0) {
	txttipo.setText((String)cbotipo.getSelectedItem().toString());
	}

	protected void mouseClickedLblclickAqui(MouseEvent arg0) {
	cbotipo.setEnabled(true);
	}
	protected void actionPerformedBtnTraerLista(ActionEvent arg0) {
	
		
		JFileChooser file=new JFileChooser();
		FileNameExtensionFilter ext=new  FileNameExtensionFilter("Solo texto","txt");
		
		file.setFileFilter(ext);
		if(file.showOpenDialog(file.getParent())==JFileChooser.APPROVE_OPTION){
			try {
				BufferedReader leer=new BufferedReader(new FileReader(file.getSelectedFile().getPath()));
				String []vector;
				String cadena;
				while((cadena=leer.readLine())!=null){
					vector=cadena.split(";");
					Object []fila={vector[0],vector[1],vector[2],vector[3],vector[4],vector[5]};
					modelofarmacia.addRow(fila);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
}
