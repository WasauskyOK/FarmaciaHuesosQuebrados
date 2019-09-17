package gui;

import java.awt.EventQueue;


import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

public class Venta extends JDialog {
	private JTextField txtvendedor;
	
	public static String usuuarioventa=Login.Usuario;
	private JLabel lblCodigoVendedor;
	private JLabel lblCodigoCliene;
	private JLabel lblCodigoDeVenta;
	private JLabel lblCodigoProducto;
	private JLabel lblFechaDeVenta;
	private JLabel lblCantidad;
	private JTextField txtcodigocliente;
	private JTextField txtcodmedicamento2;
	private JTextField txtcodigoventa;
	private JTextField txtfecha;
	private JScrollPane scrollPane;
	private JTable tblmedicamento;
	private JButton btnEliminarVenta;
	private JScrollPane scrollPane_1;
	private JTable tblventa;
	private JLabel lblDatosDetalladosDel;
	private JSpinner scantidad;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField txtcodmedicamento;
	private JTextField txttipo;
	private JTextField txtdescripcion;
	private JTextField txtpresentacion;
	private JTextField txtpreciomedicamento;
	private JLabel lblCotizacion;
	private JScrollPane scrollPane_2;
	private JLabel lblVentas;
	private JTable tblcliente;
	
	
	private DefaultTableModel modelofarmacia;
	private DefaultTableModel modelocliente;
	private JLabel lblmontopagar;
	private JButton btnCotizarEnOtra;
	
	public  String codigocliente2=Cliente.codigocliente1;
	public  String dnicliente2=Cliente.dnicliente1;
	public  String nombrecliente2=Cliente.nombrecliente1;
	public  String apepaterno2=Cliente.apepaterno1;
	public  String apematerno2=Cliente.apematerno1;
	public int puntos2=Cliente.puntos1;
	

	private JLabel lblmoneda;
	private JButton btnAsdad;
	public  static double descuentomonto;
	
	
	
	public static String codigoclienteventaboleta;
	
	
	
	
	public static String EstadoNo="FALTA PAGAR";
	public static String EstadoSi="PAGADO";
	
	public static String codigoañadidoalcarro;
	
	public static double monedaconquepaga;
	public  static double totalapagardinero;
	public static double vuelto;
	public static int puntosganados;
	
	
	public static Boolean validar=false;
	
	
	public static int cantidadarestablecer;
	
	private Connection conexionventa;
	private CallableStatement callventa;
	private ResultSet resventa;
	private String url="jdbc:mysql://localhost:3306/farmacia";
	private String usuario="root";
	private String contraseña="123456789";
	private DefaultTableModel modeloventa;
	private JButton btnEntregarBoleta;
	private JButton btnAgregarAlCarrito;
	private JScrollPane scrollPane_3;
	private JTable tblcarrito;
	private JLabel lblAadidosAlCarrito;
	
	
	private DefaultTableModel modelocarrito;
	private JButton btnHabilitarClienteCasual;
	private JLabel lblPagarConPuntos;
	private JTextField txtpuntos;
	private JButton btnPagarConPunto;
	private JButton btnaceptarpunto;
	private JLabel lblTotalAPagar;
	private JLabel lblcotizaciontotalapagar;
	private JLabel label_5;
	private JButton btnRetirarDelCarrito;
	private JLabel lblPuntosGanados;
	private JLabel lblpuntosaganar;
	private JLabel lblConCuantoPagara;
	private JTextField txtefectivosoles;
	private JButton btnYaDeseaVer;
	private JTextField txtbusquedamedicamento;
	private JLabel lblMedicamentoABuscar;
	private JLabel label_6;
	
	public static int puntosactual;
	private JLabel lblStockMedicamento;
	private JTextField txtStock;
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta dialog = new Venta();
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

	public class horacio extends Thread{
			
		public void run(){
		
			while(true){
			Date dat=new Date();
		SimpleDateFormat simpl=new SimpleDateFormat("hh:mm:s");
		setTitle("VENTA: "+simpl.format(dat)+"                                   "+"| Usuario actual :  "+usuuarioventa);
		
	try {
		sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			}
		}
		}
	public Venta() {
		this.setIconImage(new ImageIcon(getClass().getResource("/gui/20f795ab-011b-4e40-b5ee-876e713dc5cf.png")).getImage());
		getContentPane().setBackground(new Color(240, 230, 140));
		setBackground(new Color(255, 228, 181));
		
		
	
		setTitle("Venta");
		setBounds(100, 100, 1898, 950);
		getContentPane().setLayout(null);
		
	
		setLocationRelativeTo(null);
		horacio h=new horacio();
		h.start();
		txtvendedor = new JTextField();
		txtvendedor.setEditable(false);
		txtvendedor.setBounds(122, 100, 155, 22);
		getContentPane().add(txtvendedor);
		txtvendedor.setColumns(10);
		
	
	txtvendedor.setText(usuuarioventa);
	
	lblCodigoVendedor = new JLabel("Codigo Vendedor");
	lblCodigoVendedor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblCodigoVendedor.setBounds(13, 103, 107, 16);
	getContentPane().add(lblCodigoVendedor);
	
	lblCodigoCliene = new JLabel("Codigo Cliente");
	lblCodigoCliene.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblCodigoCliene.setBounds(13, 45, 92, 16);
	getContentPane().add(lblCodigoCliene);
	
	lblCodigoDeVenta = new JLabel("Codigo de venta");
	lblCodigoDeVenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblCodigoDeVenta.setBounds(12, 16, 98, 16);
	getContentPane().add(lblCodigoDeVenta);
	
	lblCodigoProducto = new JLabel("Codigo Medicamento");
	lblCodigoProducto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblCodigoProducto.setBounds(0, 74, 125, 16);
	getContentPane().add(lblCodigoProducto);
	
	lblFechaDeVenta = new JLabel("Fecha de Venta");
	lblFechaDeVenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblFechaDeVenta.setBounds(23, 132, 98, 16);
	getContentPane().add(lblFechaDeVenta);
	
	lblCantidad = new JLabel("Cantidad");
	lblCantidad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblCantidad.setBounds(45, 182, 59, 16);
	getContentPane().add(lblCantidad);
	
	txtcodigocliente = new JTextField();
	txtcodigocliente.setEditable(false);
	txtcodigocliente.setText((String) null);
	txtcodigocliente.setColumns(10);
	txtcodigocliente.setBounds(122, 42, 155, 22);
	getContentPane().add(txtcodigocliente);
	
	ClienteCasual cl=new ClienteCasual();
	if(cl.filtro()==true){
		txtcodigocliente.setText(cl.clientecasual);	
	}
	
	
	
	txtcodigocliente.setText(Cliente.codigocliente1);
	
	txtcodmedicamento2 = new JTextField();
	txtcodmedicamento2.setEditable(false);
	txtcodmedicamento2.setText((String) null);
	txtcodmedicamento2.setColumns(10);
	txtcodmedicamento2.setBounds(122, 71, 155, 22);
	getContentPane().add(txtcodmedicamento2);
	
	txtcodigoventa = new JTextField();
	txtcodigoventa.setEditable(false);
	txtcodigoventa.setColumns(10);
	txtcodigoventa.setBounds(122, 13, 155, 22);
	getContentPane().add(txtcodigoventa);
	

	
	
	txtfecha = new JTextField();
	txtfecha.setForeground(new Color(255, 0, 102));
	txtfecha.setEditable(false);
	txtfecha.setText((String) null);
	txtfecha.setColumns(10);
	txtfecha.setBounds(122, 129, 155, 22);
	getContentPane().add(txtfecha);
	class fecha extends Thread{
		
		public void run(){
			while(true){
				Date dat=new Date();
				
				SimpleDateFormat sf=new SimpleDateFormat("yyyy/MM/dd  HH:mm:s");
				txtfecha.setText(sf.format(dat));
				
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	fecha fech=new fecha();
	fech.start();
	scrollPane = new JScrollPane();
	scrollPane.setBounds(781, 543, 1087, 347);
	getContentPane().add(scrollPane);
	
	modelofarmacia=new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	modelofarmacia.addColumn("Codigo de Medicamento");
	modelofarmacia.addColumn("Tipo de Medicamento");
	modelofarmacia.addColumn("Descripcion de Medicamento");
	modelofarmacia.addColumn("Presentacion del Medicamento");
	modelofarmacia.addColumn("Precio del Medicamento");
	modelofarmacia.addColumn("Stock");
	
	
	tblmedicamento = new JTable();
	tblmedicamento.setFillsViewportHeight(true);
	tblmedicamento.setBackground(new Color(255, 255, 255));
	tblmedicamento.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mouseClickedTblmedicamento(arg0);
		}
	});
	scrollPane.setViewportView(tblmedicamento);
	tblmedicamento.setModel(modelofarmacia);
	
	btnEliminarVenta = new JButton("Eliminar Venta");
	btnEliminarVenta.setBackground(new Color(245, 255, 250));
	btnEliminarVenta.setIcon(new ImageIcon(Venta.class.getResource("/gui/goma-de-borrar.png")));
	btnEliminarVenta.setBounds(289, 12, 218, 66);
	getContentPane().add(btnEliminarVenta);
	
	scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(793, 16, 1075, 207);
	getContentPane().add(scrollPane_1);
	
	
	///////tblventa y columnas
	modeloventa=new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	modeloventa.addColumn("Codigo Venta");
	modeloventa.addColumn("Codigo Cliente");
	modeloventa.addColumn("Codigo Producto");
	modeloventa.addColumn("CodigoVendedor");
	modeloventa.addColumn("Fecha de Venta");
	modeloventa.addColumn("Cantidad");
	modeloventa.addColumn("Total Pagar");
	modeloventa.addColumn("ESTADO");
	
	tblventa = new JTable();
	tblventa.setBackground(new Color(255, 255, 255));
	tblventa.setFillsViewportHeight(true);
	scrollPane_1.setViewportView(tblventa);
	tblventa.setModel(modeloventa);
	
	lblDatosDetalladosDel = new JLabel("Datos detallados del cliente");
	lblDatosDetalladosDel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblDatosDetalladosDel.setBounds(603, 464, 166, 16);
	getContentPane().add(lblDatosDetalladosDel);
	
	scantidad = new JSpinner();
	scantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
	scantidad.setFont(new Font("Tahoma", Font.PLAIN, 29));
	scantidad.setBounds(122, 161, 155, 59);
	getContentPane().add(scantidad);
	
	label = new JLabel("Codigo Medicamento");
	label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label.setBounds(28, 645, 133, 16);
	getContentPane().add(label);
	
	label_1 = new JLabel("Tipo Medicamento");
	label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label_1.setBounds(48, 669, 119, 16);
	getContentPane().add(label_1);
	
	label_2 = new JLabel("Descripcion Medicamento");
	label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label_2.setBounds(12, 698, 166, 16);
	getContentPane().add(label_2);
	
	label_3 = new JLabel("Presentacion Medicamento");
	label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label_3.setBounds(12, 725, 155, 16);
	getContentPane().add(label_3);
	
	label_4 = new JLabel("Precio del Medicamento");
	label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label_4.setBounds(28, 754, 150, 16);
	getContentPane().add(label_4);
	
	txtcodmedicamento = new JTextField();
	txtcodmedicamento.setEditable(false);
	txtcodmedicamento.setColumns(10);
	txtcodmedicamento.setBounds(179, 642, 116, 22);
	getContentPane().add(txtcodmedicamento);
	
	txttipo = new JTextField();
	txttipo.setEditable(false);
	txttipo.setColumns(10);
	txttipo.setBounds(179, 666, 328, 22);
	getContentPane().add(txttipo);
	
	txtdescripcion = new JTextField();
	txtdescripcion.setEditable(false);
	txtdescripcion.setColumns(10);
	txtdescripcion.setBounds(179, 693, 389, 22);
	getContentPane().add(txtdescripcion);
	
	txtpresentacion = new JTextField();
	txtpresentacion.setEditable(false);
	txtpresentacion.setColumns(10);
	txtpresentacion.setBounds(179, 722, 389, 22);
	getContentPane().add(txtpresentacion);
	
	txtpreciomedicamento = new JTextField();
	txtpreciomedicamento.setEditable(false);
	txtpreciomedicamento.setColumns(10);
	txtpreciomedicamento.setBounds(179, 751, 116, 22);
	getContentPane().add(txtpreciomedicamento);
	
	lblCotizacion = new JLabel("COTIZACION");
	lblCotizacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblCotizacion.setBounds(23, 281, 85, 22);
	getContentPane().add(lblCotizacion);
	
	scrollPane_2 = new JScrollPane();
	scrollPane_2.setBounds(781, 449, 1087, 45);
	getContentPane().add(scrollPane_2);
	
	
	modelocliente=new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
		return false;
		}
	};
	modelocliente.addColumn("Codigo Cliente");
	modelocliente.addColumn("Dni Cliente");
	modelocliente.addColumn("Nombre Cliente");
	modelocliente.addColumn("Apellido Paterno");
	modelocliente.addColumn("Apellido Materno");
	modelocliente.addColumn("Puntos");
	tblcliente = new JTable();
	tblcliente.setBackground(new Color(255, 255, 255));
	tblcliente.setFillsViewportHeight(true);
	scrollPane_2.setViewportView(tblcliente);

	tblcliente.setModel(modelocliente);
	
	lblVentas = new JLabel("VENTAS");
	lblVentas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblVentas.setBounds(696, 58, 85, 32);
	getContentPane().add(lblVentas);
	
	
	
	lblmontopagar = new JLabel("0.0");
	lblmontopagar.setBounds(131, 284, 38, 16);
	getContentPane().add(lblmontopagar);
	
	btnCotizarEnOtra = new JButton("Cotizar en otra moneda");
	btnCotizarEnOtra.setBackground(new Color(245, 255, 250));
	btnCotizarEnOtra.setBounds(286, 233, 191, 25);
	getContentPane().add(btnCotizarEnOtra);
	
	lblmoneda = new JLabel("S/.");
	lblmoneda.setBounds(195, 284, 38, 16);
	getContentPane().add(lblmoneda);
	
	btnAsdad = new JButton("Ver Cotizacion");
	btnAsdad.setBackground(new Color(245, 255, 250));

	btnAsdad.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			actionPerformedBtnAsdad(arg0);
		}
	});
	btnAsdad.setBounds(132, 233, 145, 25);
	getContentPane().add(btnAsdad);
	
	btnEntregarBoleta = new JButton("ENTREGAR BOLETA");
	btnEntregarBoleta.setBackground(new Color(245, 255, 250));
	btnEntregarBoleta.setEnabled(false);

	btnEntregarBoleta.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mouseClickedBtnEntregarBoleta(arg0);
		}
	});
	btnEntregarBoleta.setBounds(432, 408, 143, 32);
	getContentPane().add(btnEntregarBoleta);
	
	btnAgregarAlCarrito = new JButton("AGREGAR AL CARRITO");
	btnAgregarAlCarrito.setBackground(new Color(245, 255, 250));
	btnAgregarAlCarrito.setIcon(new ImageIcon(Venta.class.getResource("/gui/icons8-carrito-de-compras-50.png")));
	btnAgregarAlCarrito.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			actionPerformedBtnAgregarAlCarrito(arg0);
		}
	});
	btnAgregarAlCarrito.setBounds(243, 318, 234, 45);
	getContentPane().add(btnAgregarAlCarrito);
	
	scrollPane_3 = new JScrollPane();
	scrollPane_3.setBounds(793, 236, 1075, 175);
	getContentPane().add(scrollPane_3);
	
	
	modelocarrito=new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	modelocarrito.addColumn("Codigo Venta");
	modelocarrito.addColumn("Codigo Cliente");
	modelocarrito.addColumn("Codigo Producto");
	modelocarrito.addColumn("CodigoVendedor");
	modelocarrito.addColumn("Fecha de Venta");
	modelocarrito.addColumn("Cantidad");
	modelocarrito.addColumn("Total Pagar");
	modelocarrito.addColumn("ESTADO");
	tblcarrito = new JTable();
	tblcarrito.setBackground(new Color(255, 255, 255));
	tblcarrito.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			mouseClickedTblcarrito(e);
		}
	});
	tblcarrito.setFillsViewportHeight(true);
	scrollPane_3.setViewportView(tblcarrito);
	tblcarrito.setModel(modelocarrito);
	
	lblAadidosAlCarrito = new JLabel("A\u00D1ADIDOS AL CARRITO");
	lblAadidosAlCarrito.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblAadidosAlCarrito.setBounds(628, 303, 138, 16);
	getContentPane().add(lblAadidosAlCarrito);
	
	btnHabilitarClienteCasual = new JButton("HABILITAR CLIENTE CASUAL");
	btnHabilitarClienteCasual.setBackground(new Color(245, 255, 250));
	btnHabilitarClienteCasual.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			actionPerformedBtnHabilitarClienteCasual(arg0);
		}
	});
	btnHabilitarClienteCasual.setBounds(291, 100, 245, 82);
	getContentPane().add(btnHabilitarClienteCasual);
	
	lblPagarConPuntos = new JLabel("PAGAR CON PUNTOS");
	lblPagarConPuntos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblPagarConPuntos.setBounds(12, 492, 128, 16);
	getContentPane().add(lblPagarConPuntos);
	
	txtpuntos = new JTextField();
	txtpuntos.setEditable(false);
	txtpuntos.setBounds(161, 489, 116, 22);
	getContentPane().add(txtpuntos);
	txtpuntos.setColumns(10);
	
	btnPagarConPunto = new JButton("PAGAR CON PUNTO");
	btnPagarConPunto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			actionPerformedBtnPagarConPunto(arg0);
		}
	});
	btnPagarConPunto.setBounds(153, 513, 172, 25);
	getContentPane().add(btnPagarConPunto);
	
	btnaceptarpunto = new JButton("ACEPTAR RESTADO PUNTOS");
	btnaceptarpunto.setBackground(new Color(245, 255, 250));
	btnaceptarpunto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			actionPerformedBtnaceptarpunto(arg0);
		}
	});
	btnaceptarpunto.setEnabled(false);
	btnaceptarpunto.setBounds(289, 488, 233, 25);
	getContentPane().add(btnaceptarpunto);
	
	lblTotalAPagar = new JLabel("TOTAL A PAGAR");
	lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblTotalAPagar.setBounds(15, 322, 105, 16);
	getContentPane().add(lblTotalAPagar);
	
	lblcotizaciontotalapagar = new JLabel("0.0");
	lblcotizaciontotalapagar.setBounds(130, 322, 48, 16);
	getContentPane().add(lblcotizaciontotalapagar);
	
	label_5 = new JLabel("S/.");
	label_5.setBounds(195, 322, 38, 16);
	getContentPane().add(label_5);
	
	btnRetirarDelCarrito = new JButton("RETIRAR DEL CARRITO");
	btnRetirarDelCarrito.setIcon(new ImageIcon(Venta.class.getResource("/gui/trash-truck.png")));
	btnRetirarDelCarrito.setBackground(new Color(245, 255, 250));
	btnRetirarDelCarrito.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			mouseClickedBtnRetirarDelCarrito(e);
		}
	});
	btnRetirarDelCarrito.setBounds(565, 219, 201, 51);
	getContentPane().add(btnRetirarDelCarrito);
	
	lblPuntosGanados = new JLabel("PUNTOS GANADOS");
	lblPuntosGanados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblPuntosGanados.setBounds(7, 365, 113, 16);
	getContentPane().add(lblPuntosGanados);
	
	lblpuntosaganar = new JLabel("0");
	lblpuntosaganar.setBounds(132, 365, 38, 16);
	getContentPane().add(lblpuntosaganar);
	
	lblConCuantoPagara = new JLabel("Con cuanto pagara?");
	lblConCuantoPagara.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblConCuantoPagara.setBounds(0, 416, 161, 16);
	getContentPane().add(lblConCuantoPagara);
	
	txtefectivosoles = new JTextField();
	txtefectivosoles.setBounds(139, 408, 116, 33);
	getContentPane().add(txtefectivosoles);
	txtefectivosoles.setColumns(10);
	
	btnYaDeseaVer = new JButton("Eso es todo ?");
	btnYaDeseaVer.setBackground(new Color(245, 255, 250));
	btnYaDeseaVer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			actionPerformedBtnYaDeseaVer(arg0);
		}
	});
	btnYaDeseaVer.setBounds(259, 408, 161, 32);
	getContentPane().add(btnYaDeseaVer);
	
	txtbusquedamedicamento = new JTextField();
	txtbusquedamedicamento.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) {
			keyReleasedTxtbusquedamedicamento(arg0);
		}
	});
	txtbusquedamedicamento.setBounds(478, 549, 240, 22);
	getContentPane().add(txtbusquedamedicamento);
	txtbusquedamedicamento.setColumns(10);
	
	lblMedicamentoABuscar = new JLabel("Medicamento a buscar");
	lblMedicamentoABuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblMedicamentoABuscar.setBounds(341, 546, 133, 28);
	getContentPane().add(lblMedicamentoABuscar);
	
	lblStockMedicamento = new JLabel("Stock Medicamento");
	lblStockMedicamento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblStockMedicamento.setBounds(23, 783, 155, 16);
	getContentPane().add(lblStockMedicamento);
	
	txtStock = new JTextField();
	txtStock.setEditable(false);
	txtStock.setBounds(179, 783, 116, 22);
	getContentPane().add(txtStock);
	txtStock.setColumns(10);
	
	label_6 = new JLabel("");
	label_6.setBackground(Color.WHITE);
	label_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label_6.setIcon(new ImageIcon(Venta.class.getResource("/gui/descarga (2).png")));
	label_6.setBounds(0, 0, 1892, 903);
	getContentPane().add(label_6);
	Seteo();
	inicializacion();
	/////////////////////////////////////
	//CARGAR CLIENTE
	CargarCliente();
	////////////////////////
	//////////////////////////////////////
	//CARGAR PRODUCTOS
	CargarProductos();

	////////////////////////////////////////
	////////////////////////////////////////
	///CARGAR VENTAS
	
	ListarVenta();

	/*CARGAR VENTAS NO PAGADAS*/
	CargarVentasNoPagadas();
	

	
	vercotizaciontotalapagar();
//////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
	
	
	int filaclie=tblcliente.getSelectedRow();
	String punto=tblcliente.getValueAt(0,5).toString();
	int pun=Integer.parseInt(punto);
	puntosactual=pun;
	
	}
	public void inicializacion(){
	
		try {
			Connection conexionpuntos2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callpuntos2=conexionpuntos2.prepareCall("select max(codventa)from venta");
			ResultSet respun2=callpuntos2.executeQuery();
			
			if(respun2.next()){
				
			String sentencia=respun2.getString(1);
		
			
			String ven=sentencia.substring(0,3);
			String num=sentencia.substring(3);
			int num2=Integer.parseInt(num);
			num2++;
			String cadena=ven+num2;
			txtcodigoventa.setText(cadena);	
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			
	}
	public void Seteo(){
		
		if(tblventa.getRowCount()==0){
			txtcodigoventa.setText("VEN1001");
		}
		
	}
	/*ver cotizacion total a pagar label*/
	public void vercotizaciontotalapagar(){
	try {
		Connection conexionpuntos=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callpuntos=conexionpuntos.prepareCall("call TotalaPagar(?)");
		callpuntos.setString(1,txtcodigocliente.getText());
		ResultSet respun=callpuntos.executeQuery();
		if(respun.next()){
			lblcotizaciontotalapagar.setText(""+respun.getDouble(1));
			
			
		}
		else{
			lblcotizaciontotalapagar.setText("0.0");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	public void CargarVentasNoPagadas(){
		try {
			Connection conexionpag=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callpag=conexionpag.prepareCall("select *from venta where estado='FALTA PAGAR'");
			ResultSet respag=callpag.executeQuery();
			modelocarrito.setRowCount(0);
			while(respag.next()){
				Object [] filacarrito={respag.getString(1),respag.getString(2),respag.getString(3),respag.getString(4),respag.getString(5),respag.getInt(6),respag.getDouble(7),respag.getString(8)};
						modelocarrito.addRow(filacarrito);		
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ListarVenta(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexionventa=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			callventa=conexionventa.prepareCall("select *from venta where estado='PAGADO'");
			resventa=callventa.executeQuery();
			modeloventa.setRowCount(0);
			while(resventa.next()){
				Object[]filaventa={resventa.getString(1),resventa.getString(2),resventa.getString(3),resventa.getString(4),resventa.getString(5),resventa.getInt(6),resventa.getDouble(7),resventa.getString(8)};
				modeloventa.addRow(filaventa);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void CargarProductos(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		
		
	CallableStatement cal=conexion.prepareCall("call listarproducto()");
	ResultSet res=cal.executeQuery();
	modelofarmacia.setRowCount(0);
	while(res.next()){
		Object []listar={res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6)};
		
		modelofarmacia.addRow(listar);
	}
	
}

catch(Exception ex ){
	
	
	ex.printStackTrace();
}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////
	
	public void CargarCliente(){
	try {
		modelocliente.setRowCount(0);
		Object[]DatosCliente={codigocliente2,dnicliente2,nombrecliente2,apepaterno2,apematerno2,puntos2};
		modelocliente.addRow(DatosCliente);
	
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Existe un problema te dare una pista");
		e.printStackTrace();
	}
	}
	protected void mouseClickedTblmedicamento(MouseEvent arg0) {
	
		String frase="Hola";
		
		int fila=tblmedicamento.getSelectedRow();
		
		txtcodmedicamento.setText(tblmedicamento.getValueAt(fila,0).toString());
		txttipo.setText(tblmedicamento.getValueAt(fila,1).toString());
		txtdescripcion.setText(tblmedicamento.getValueAt(fila,2).toString());
		txtpresentacion.setText(tblmedicamento.getValueAt(fila,3).toString());
		txtpreciomedicamento.setText(tblmedicamento.getValueAt(fila,4).toString());
		txtcodmedicamento2.setText(tblmedicamento.getValueAt(fila,0).toString());
		txtStock.setText(tblmedicamento.getValueAt(fila,5).toString());
		
		
	}
	protected void actionPerformedBtnAsdad(ActionEvent arg0) {
		//ver cotizacion
		
			
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					
					
				CallableStatement cal=conexion.prepareCall("call cotizacionprecio(?,?)");
				cal.setString(1,txtcodmedicamento2.getText());
				cal.setInt(2,Integer.parseInt(scantidad.getValue().toString()));
				ResultSet res=cal.executeQuery();
				
				if(res.next()){
					lblmontopagar.setText(res.getString(1));
				}
				
			}

			catch(Exception ex ){
				
				
				ex.printStackTrace();
			}
				
				
				
	}
	protected void mouseClickedBtnEntregarBoleta(MouseEvent arg0) {
	codigoclienteventaboleta=txtcodigocliente.getText();
	puntosganados=Integer.parseInt(lblpuntosaganar.getText());
	totalapagardinero=Double.parseDouble(lblcotizaciontotalapagar.getText());
	monedaconquepaga=Double.parseDouble(txtefectivosoles.getText());
	double vuel=monedaconquepaga-totalapagardinero;
	vuelto=vuel;
	
	/*bloque agregar puntos*/
	
	try {
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionventa2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callpuntosactualizar=conexionventa2.prepareCall("update cliente set puntos=puntos+? where codcli=?");
		callpuntosactualizar.setInt(1,Venta.puntosganados);
		callpuntosactualizar.setString(2,txtcodigocliente.getText());
		callpuntosactualizar.executeUpdate();
		
	} catch (Exception ep) {
		// TODO: handle exception
	}
	
	
	
	JOptionPane.showMessageDialog(null,"tu vuelto es  : "+vuelto+" Y tus "+puntosganados+" puntos que ganaste  fueron agregados por la conpra  ");
	
	
	imprimirboleta impboleta=new imprimirboleta();
	impboleta.setVisible(true);
	dispose();
	}
	protected void actionPerformedBtnAgregarAlCarrito(ActionEvent arg0) {
		
		int cantidadstock = 0;
		
		//bloque calcular stock del producto
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cnlistarstock=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement cslistarstock=cnlistarstock.prepareCall("select stock from productos where codpro=?");
			cslistarstock.setString(1,txtcodmedicamento.getText());
			ResultSet rslistarstock=cslistarstock.executeQuery();
			while(rslistarstock.next()){
					cantidadstock=rslistarstock.getInt(1);
			
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		int cantidadsp=Integer.parseInt(scantidad.getValue().toString());
		//bloque restar Stock
		if(cantidadstock>=cantidadsp){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cnrestarstock=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement csrestarstock=cnrestarstock.prepareCall("call RestarStock(?,?)");
				csrestarstock.setString(1,txtcodmedicamento.getText());
				csrestarstock.setInt(2,Integer.parseInt(scantidad.getValue().toString()));
				
				csrestarstock.executeUpdate();
				
				CargarProductos();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}	
			
		}
		else{
			
			JOptionPane.showMessageDialog(null,"Stock Insuficiente , Limite Agotado "+"\n"+"Contactese con el administrador para que amplie el stock");
			return;
		}
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexionventa2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callventa2=conexionventa2.prepareCall("call agregarventa2(?,?,?,?,?,?,?,?)");
			callventa2.setString(1,txtcodigoventa.getText());
			callventa2.setString(2,txtcodigocliente.getText());
			callventa2.setString(3,txtcodmedicamento.getText());
			callventa2.setString(4,txtvendedor.getText());
			callventa2.setString(5,txtfecha.getText());
			callventa2.setInt(6,Integer.parseInt(scantidad.getValue().toString()));
			callventa2.setDouble(7,Double.parseDouble(lblmontopagar.getText()));
			callventa2.setString(8,EstadoNo);
			callventa2.executeUpdate();
			
			CargarVentasNoPagadas();
			/*vercarrito();
			*/
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,"Algo esta mal , arreglalo");
		}
		
	
		
		vercotizaciontotalapagar();
		double numdou=Double.parseDouble(lblcotizaciontotalapagar.getText());
		int nu=(int)(numdou);
		lblpuntosaganar.setText(""+nu);
		
		inicializacion();
		
	}
	public void vercarrito(){
		Connection conexioncarrito;
		try {
			conexioncarrito = DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callcarrito=conexioncarrito.prepareCall("CALL verestado()");
			ResultSet resulcarrito=callcarrito.executeQuery();
			modelocarrito.setRowCount(0);
			
			while(resulcarrito.next()){
				Object [] filacarrito={resulcarrito.getString(1),resulcarrito.getString(2),resulcarrito.getString(3),resulcarrito.getString(4),resulcarrito.getString(5),resulcarrito.getInt(6),resulcarrito.getDouble(7),resulcarrito.getString(8)
				
				};
				modelocarrito.addRow(filacarrito);
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	protected void actionPerformedBtnHabilitarClienteCasual(ActionEvent arg0) {
	txtcodigocliente.setText("codC001");
	btnPagarConPunto.setEnabled(false);
	Cliente.validar2=false;
	
	modelocliente.setRowCount(0);
	
	}
	protected void actionPerformedBtnPagarConPunto(ActionEvent arg0) {
	btnaceptarpunto.setEnabled(true);
	txtpuntos.setEditable(true);
	
	}
	public void ActualizarPuntos(int puntos){
		try {
			Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callsta=conexion.prepareCall("call actualizarpuntos(?,?)");
			callsta.setString(1,txtcodigocliente.getText());
			callsta.setInt(2,puntos);
			
			callsta.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void actionPerformedBtnaceptarpunto(ActionEvent arg0) {
		
		
		try {
			
			int actualpuntos=Integer.parseInt(txtpuntos.getText());
			Connection conexionpuntos=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callpuntos=conexionpuntos.prepareCall("call buscarpuntos(?)");
		callpuntos.setString(1,txtcodigocliente.getText());
			ResultSet resultado=callpuntos.executeQuery();
			int PuntosClienteahora = 0;
			
			while(resultado.next()){
				PuntosClienteahora=resultado.getInt(1);
	
			}
			int puntosresultado=PuntosClienteahora-actualpuntos;
			
			if(actualpuntos==50 && puntosresultado>=0){
				descuentomonto=Double.parseDouble(lblcotizaciontotalapagar.getText())*0.15;
				
				ActualizarPuntos(actualpuntos);
				validar=true;
				JOptionPane.showMessageDialog(null,"Te quedan "+puntosresultado+" puntos");
			
			}
			
			else if(actualpuntos==100 && puntosresultado>=0){
				descuentomonto=Double.parseDouble(lblcotizaciontotalapagar.getText())*0.20;
				ActualizarPuntos(actualpuntos);
				validar=true;
				JOptionPane.showMessageDialog(null,"Te quedan "+puntosresultado+" puntos");
			}
			
			else if(actualpuntos==150 && puntosresultado>=0){
				descuentomonto=Double.parseDouble(lblcotizaciontotalapagar.getText())*0.25;
				ActualizarPuntos(actualpuntos);
				validar=true;
				JOptionPane.showMessageDialog(null,"Te quedan "+puntosresultado+" puntos");
			}
			else if(actualpuntos==200 && puntosresultado>=0){
				descuentomonto=Double.parseDouble(lblcotizaciontotalapagar.getText())*0.30;
				ActualizarPuntos(actualpuntos);
				validar=true;
				JOptionPane.showMessageDialog(null,"Te quedan "+puntosresultado+" puntos");
			}
			else if(actualpuntos==250 && puntosresultado>=0){
				descuentomonto=Double.parseDouble(lblcotizaciontotalapagar.getText())*0.35;
				ActualizarPuntos(actualpuntos);
				validar=true;
				JOptionPane.showMessageDialog(null,"Te quedan "+puntosresultado+" puntos");
			}
			else if(actualpuntos==300 && puntosresultado>=0){
				descuentomonto=Double.parseDouble(lblcotizaciontotalapagar.getText())*0.40;
				ActualizarPuntos(actualpuntos);
				validar=true;
				JOptionPane.showMessageDialog(null,"Te quedan "+puntosresultado+" puntos");
			}
			
			else{
				JOptionPane.showMessageDialog(null,"Tus Puntos deben ser mayor a 0 , Recuerda solo puedes Restar 50 , 100 , 150, 200 , 250 , 300 puntos");
				
			}
			
				
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	protected void mouseClickedBtnRetirarDelCarrito(MouseEvent e) {
		
		
		
		
		
		
		int val=JOptionPane.showConfirmDialog(null,"Deseas eliminar el codigo de venta  "+codigoañadidoalcarro+"?");
		if(val==0){
			//bloque restablecer stock 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cnrestablecerstock=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement csrestablecerstock=cnrestablecerstock.prepareCall("call RestablecerStock(?,?)");
				
				csrestablecerstock.setString(1,txtcodmedicamento.getText());
				csrestablecerstock.setInt(2,cantidadarestablecer);
				csrestablecerstock.executeUpdate();
				
				CargarProductos();
				
				
			} catch (Exception ex) {
				// TODO: handle exception
			}
			
			
			
			
			
			
			
			
			
			try {
				Connection conexionpuntos=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement calleliminarcarrito=conexionpuntos.prepareCall("delete from venta where codventa=? and estado='FALTA PAGAR'");
				calleliminarcarrito.setString(1,codigoañadidoalcarro);
				calleliminarcarrito.executeUpdate();
				CargarVentasNoPagadas();
				vercotizaciontotalapagar();
				inicializacion();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"asdasd");
		}
		
	}
	protected void mouseClickedTblcarrito(MouseEvent e) {
		
		int fila=tblcarrito.getSelectedRow();
		codigoañadidoalcarro=tblcarrito.getValueAt(fila, 0).toString();
		
		cantidadarestablecer=Integer.parseInt(tblcarrito.getValueAt(fila, 5).toString());
		
		
	}
	protected void actionPerformedBtnYaDeseaVer(ActionEvent arg0) {
	
	btnEntregarBoleta.setEnabled(true);
	
	
	}
	protected void keyReleasedTxtbusquedamedicamento(KeyEvent arg0) {
		String medicamento=txtbusquedamedicamento.getText();
		String descripcion=txtbusquedamedicamento.getText();
		if(txtbusquedamedicamento.getText().equals("")){
			CargarProductos();
		}
		else{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				
				
			CallableStatement cal=conexion.prepareCall("select *from productos where descripcion like '%"+medicamento+"%' or tipopro like '%"+descripcion+"%'");
			ResultSet res=cal.executeQuery();
			modelofarmacia.setRowCount(0);
			while(res.next()){
				Object []listar={res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6)};
				
				modelofarmacia.addRow(listar);
			}
			
		}

		catch(Exception ex ){
			
			
			ex.printStackTrace();
		}
		}
	}
}
