package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class imprimirboleta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnImprimirBoleta;
	private JButton btnGuardarArchivo;
	private JTextField txtcodigocliente;
	
	private Connection conexionboleta;
	private CallableStatement callboleta;
	private ResultSet resboleta;
	private String url="jdbc:mysql://localhost:3306/farmacia?useSSL=false";
	private String usuario5="root";
	//private String contraseña5="123456789";
	private JTextArea txt1;
	private JButton btnFinalizarCompra;
	private JLabel label;
	public  double totalapagarcondescuento;
	private JScrollPane scrollPane;
	private String rutapath;
	private String contenidocompleto;
	private JLabel lblSiHarasOtra;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			imprimirboleta dialog = new imprimirboleta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public imprimirboleta() {
		setBounds(100, 100, 1037, 899);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPanel.setLayout(null);
		{
			JLabel lblListaDeClientes = new JLabel("CLIENTE");
			lblListaDeClientes.setBounds(28, 13, 78, 41);
			contentPanel.add(lblListaDeClientes);
		}
		
		btnImprimirBoleta = new JButton("GUARDAR EN ARCHIVO TXT");
		btnImprimirBoleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnImprimirBoleta(arg0);
			}
		});
		btnImprimirBoleta.setBounds(264, 107, 260, 41);
		contentPanel.add(btnImprimirBoleta);
		
		btnGuardarArchivo = new JButton("IMPRESION DE BOLETA");
		btnGuardarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnGuardarArchivo(arg0);
			}
		});
		btnGuardarArchivo.setBounds(0, 107, 260, 41);
		contentPanel.add(btnGuardarArchivo);
		
		txtcodigocliente = new JTextField();
		txtcodigocliente.setEditable(false);
		txtcodigocliente.setBounds(147, 13, 130, 41);
		contentPanel.add(txtcodigocliente);
		txtcodigocliente.setColumns(10);
		txtcodigocliente.setText(Venta.codigoclienteventaboleta);
		
		btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnFinalizarCompra(e);
			}
		});
		btnFinalizarCompra.setBounds(536, 107, 235, 41);
		contentPanel.add(btnFinalizarCompra);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLabel(e);
			}
		});
		label.setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 191, 927, 667);
		contentPanel.add(scrollPane);
		
		txt1 = new JTextArea();
		txt1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		scrollPane.setViewportView(txt1);
		
		lblSiHarasOtra = new JLabel("Si haras otra operacion puedes cerrar la ventana --->");
		lblSiHarasOtra.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		lblSiHarasOtra.setForeground(Color.RED);
		lblSiHarasOtra.setBounds(503, 38, 436, 16);
		
		lblSiHarasOtra.setVisible(false);
		contentPanel.add(lblSiHarasOtra);
		
		label.setIcon(new ImageIcon(imprimirboleta.class.getResource("/gui/cancelar.png")));
		label.setBounds(947, 13, 90, 70);
		contentPanel.add(label);
		
		
		boletacliente();
	}
	
	public void boletacliente(){
		String procedimiento;
		
		if(txtcodigocliente.getText().equals("codC001")){
			procedimiento="call imprimirboletaanonimo(?)";
		}
		else{
			procedimiento="call VerOtraImpresion(?)";
		}
		try {
			
			Date dia=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy hh:mm:s a");
		
			
			Class.forName("com.mysql.jdbc.Driver");
			conexionboleta=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			callboleta=conexionboleta.prepareCall(procedimiento);
			
			callboleta.setString(1,txtcodigocliente.getText());
			
			resboleta=callboleta.executeQuery();
			
			
			txt1.append("                    FARMACIA HUESOS QUEBRADOS → ☻"+"\n"+"\n");
			txt1.append("                          HUESOS QUEBRADOS S.A.C.  - RUC: 20512002090"+"\n");
			txt1.append("                          CAL. LANA RHOADES NRO. 69 URB. LOS CASCOS"+"\n");
			txt1.append("                          LIMA - SAN JUAN DE LURIGANCHO"+"\n");
			txt1.append("                          BOLETA ELECTRONICA "+"\n");
			txt1.append("         FECHA DE EMISION: "+sdf.format(dia)+"\n");
			txt1.append("----------------------------------------------------------------------"+"\n");
			txt1.append("CODIGO	 CANT	P.UNIT	IMPORTE	DETALLE	DESCRIPCION"+"\n");
			while(resboleta.next()){
				/*
				String descripcion=resboleta.getString(2);
			
				int guardar;
				String espacio=" ";
				String espacio2=".";
				if(descripcion.length()<85){//57
					guardar=85-descripcion.length();
					for (int i = 1; i <=guardar; i++) {
						espacio+=espacio2;
					}
					descripcion=descripcion+espacio;
					
				
				}
				else{
					descripcion.trim();
				}
				*/
			//txt1.append(resboleta.getString(1)+"   "+descripcion/*" "+resboleta.getString(3)/*+"  "+resboleta.getString(4)+"   "+resboleta.getString(5)*/+"\n");
				txt1.append(resboleta.getString(1)+"\t"+resboleta.getInt(4)+"\t"+resboleta.getInt(5)+"\t"+resboleta.getInt(6)+"\t"+resboleta.getString(3)+"\t"+resboleta.getString(2)+"\t"+
						"\n");
			
			//txt2.append(resboleta.getString(4)/*+"  "+resboleta.getString(4)+"   "+resboleta.getString(5)*/+"\n");
		//txt3.append(resboleta.getString(5)+"\n");
			//txt4.append(resboleta.getString(6)+"\n");
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txt1.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n");
		try {
			Connection conexionbol=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callboleta2=conexionbol.prepareCall("call TotalaPagar(?)");
			callboleta2.setString(1,txtcodigocliente.getText());
			ResultSet resboleta2=callboleta2.executeQuery();
			while(resboleta2.next()){
				txt1.append("                                                                                                                        MONTO TOTAL: S/.      "+resboleta2.getDouble(1)+"\n");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txt1.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n");
			try {
				DecimalFormat dec=new DecimalFormat("####.##");
				
				
				Connection conexionsubtotal=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement callsubtotal=conexionsubtotal.prepareCall("call subtotal(?)");
				callsubtotal.setString(1,txtcodigocliente.getText());
				ResultSet ressubtotal=callsubtotal.executeQuery();
				
				while(ressubtotal.next()){
					Double sub=ressubtotal.getDouble(1);
					txt1.append("                                                                                                                        OP.GRAVADAS: S/.        "+dec.format(sub)+"\n");
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			try {
				DecimalFormat dec2=new DecimalFormat("####.##");
				Connection conexionigv=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement calligv=conexionigv.prepareCall("call igv(?)");
				calligv.setString(1,txtcodigocliente.getText());
				ResultSet resigv=calligv.executeQuery();
				while(resigv.next()){
					double igv=resigv.getDouble(1);
					txt1.append("                                                                                                                        IGV-18%: S/.           "+dec2.format(igv)+"\n");
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			/*AQUI ESTA ESTA APARTADO POR TABULACION*/
			if(Venta.validar==true){
			txt1.append("                                                                                                                        DESCUENTO    :        - "+Venta.descuentomonto+"\n");
			
			//Venta.validar=false;
			}
			else if(Venta.validar==false){
				txt1.append("                                                                                                                        DESCUENTO    :       - 0.0"+"\n");
			
			}
			if(Venta.validar==true){
			totalapagarcondescuento=Venta.totalapagardinero-Venta.descuentomonto;
			txt1.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n");
				txt1.append("                                                                                                                        TOTAL A PAGAR:        "+totalapagarcondescuento+"\n");
					
			}
			else if (Venta.validar==false){
				txt1.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n");
				txt1.append("                                                                                                                        TOTAL A PAGAR:        "+Venta.totalapagardinero+"\n");
			}
			txt1.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n");
			txt1.append("                                                                                                                        EFECTIVO SOLES:       "+Venta.monedaconquepaga+"\n");
			
			if(Venta.validar==true){
				double elvueltocondescuento=Venta.monedaconquepaga-totalapagarcondescuento;
			txt1.append("                                                                                                                        Vuelto:               "+elvueltocondescuento+"\n");
			}
			else if(Venta.validar==false){
				txt1.append("                                                                                                                        Vuelto:               "+Venta.vuelto+"\n");
			}
			
			int actuales=Venta.puntosactual+Venta.puntosganados;
			if(Cliente.validar2==false){
				txt1.append("         . ");
			}
			if(Cliente.validar2==true){
				txt1.append("ACUMULACION DE PUNTOS FARMACIA 'NOS HAS SALVADO ESTAMOS AGRADECIDOS ' : "+"\n");
				txt1.append("Puntos Anteriores : "+Venta.puntosactual+"\n");
				txt1.append("En esta compra ganaste  : "+Venta.puntosganados+"\n");
			
				txt1.append("Puntos Actuales : "+actuales);
				
			}
			
			Venta.puntosactual=0;
			Cliente.validar2=false;
			
			Venta.validar=false;
			Venta.descuentomonto=0.0;
			
			
	}
	protected void actionPerformedBtnImprimirBoleta(ActionEvent arg0) {

		JFileChooser fila=new JFileChooser();
	
	if(fila.showSaveDialog(fila.getParent())==fila.APPROVE_OPTION){
		try {
			BufferedWriter imprime=new BufferedWriter(new FileWriter(fila.getSelectedFile().getPath()));
			rutapath=fila.getSelectedFile().getPath();
			txt1.write(imprime);
			contenidocompleto=txt1.getText();
			imprime.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	protected void actionPerformedBtnGuardarArchivo(ActionEvent arg0) {
	/*
		try {
			FileOutputStream salidadatos=new FileOutputStream("ArchivoNombre");
			PrintStream imprimirhoja=new PrintStream(salidadatos);
			imprimirhoja.print(contenidocompleto);
			imprimirhoja.close();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			txt1.print();
			//Boolean complete=txt1.print();
			
			/*if(complete){
				JOptionPane.showMessageDialog(null,"DonePrinting");
			||	
			}
			else{
				JOptionPane.showMessageDialog(null,"Printing");
			}
			*/
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void actionPerformedBtnFinalizarCompra(ActionEvent e) {
	
		lblSiHarasOtra.setVisible(true);
		label.setVisible(true);
		btnFinalizarCompra.setEnabled(false);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexionactualizar =DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callactualizar=conexionactualizar.prepareCall("update venta set estado='PAGADO' where codcli=? ");
			callactualizar.setString(1,txtcodigocliente.getText());
			callactualizar.executeUpdate();
			JOptionPane.showMessageDialog(null,"Datos realizado con exito");
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
			
	}
	protected void mouseClickedLabel(MouseEvent e) {
	dispose();
	}
}












