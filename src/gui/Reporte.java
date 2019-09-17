package gui;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
public class Reporte extends JDialog {
	public static JPanel panelReporte;
	private JComboBox cbocodigo;
	private Connection con;
	private CallableStatement cal;
	private String url="jdbc:mysql://localhost:3306/farmacia";
	private String usuario="root";
	private String contra="123456789";
	private ResultSet resul;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnImprimir;
	private JLabel lblFecha;
	private JComboBox cbodia;
	private JComboBox cbomes;
	private JComboBox cboaño;
	private JButton btnVerReporte;
	private JButton btnClickParaIngresa;
	private JButton btnPorAo;
	private JButton btnPorMes;
	private JButton btnPorDia;
	private JButton btnPorMesY;
	private JButton btnActivar;
	private JButton btnDesactivar;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JLabel label;
	private JButton btnAoActual;
	private JButton btnDelMes;
	private JButton btnDeHoyDia;
	private JButton button_5;
	private JButton button_6;
	private JTextArea textArea;
	
	

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte dialog = new Reporte();
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
	
	public Reporte() {
		getContentPane().setBackground(new Color(255, 255, 0));
		
		

		
		setBounds(100, 100, 889, 639);
		getContentPane().setLayout(null);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Codigo del Trabajador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelReporte.setBounds(12, 40, 741, 473);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 178, 637, 282);
		panelReporte.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
		scrollPane.setViewportView(txtS);
		
		cbocodigo = new JComboBox();
		cbocodigo.setBounds(122, 16, 291, 31);
		panelReporte.add(cbocodigo);
		cbocodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedCbocodigo(arg0);
			}
		});
		cbocodigo.setSelectedIndex(-1);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(63, 100, 49, 23);
		panelReporte.add(lblFecha);
		
		cbodia = new JComboBox();
		cbodia.setBounds(111, 101, 40, 22);
		panelReporte.add(cbodia);
		cbodia.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		cbomes = new JComboBox();
		cbomes.setBounds(165, 101, 122, 22);
		panelReporte.add(cbomes);
		cbomes.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
		
		cboaño = new JComboBox();
		cboaño.setBounds(299, 100, 97, 22);
		panelReporte.add(cboaño);
		cboaño.setModel(new DefaultComboBoxModel(new String[] {"2018"}));
		
		btnVerReporte = new JButton("VER REPORTE");
		btnVerReporte.setBounds(465, 99, 133, 25);
		panelReporte.add(btnVerReporte);
		
		btnClickParaIngresa = new JButton("Click para ingresa fecha Precisa");
		btnClickParaIngresa.setBounds(479, 60, 239, 37);
		panelReporte.add(btnClickParaIngresa);
		
		btnPorAo = new JButton("Por A\u00F1o");
		btnPorAo.setBounds(249, 66, 97, 25);
		panelReporte.add(btnPorAo);
		btnPorAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnPorAo(arg0);
			}
		});
		btnPorAo.setEnabled(false);
		
		btnPorMes = new JButton("Por Mes");
		btnPorMes.setBounds(140, 66, 97, 25);
		panelReporte.add(btnPorMes);
		btnPorMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnPorMes(arg0);
			}
		});
		btnPorMes.setEnabled(false);
		
		btnPorDia = new JButton("Por Dia");
		btnPorDia.setBounds(31, 63, 97, 25);
		panelReporte.add(btnPorDia);
		btnPorDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnPorDia(arg0);
			}
		});
		btnPorDia.setEnabled(false);
		
		btnPorMesY = new JButton("Por Mes y A\u00F1o");
		btnPorMesY.setBounds(348, 66, 119, 25);
		panelReporte.add(btnPorMesY);
		btnPorMesY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnPorMesY(arg0);
			}
		});
		btnPorMesY.setEnabled(false);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(249, 135, 97, 25);
		panelReporte.add(btnImprimir);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnImprimir(arg0);
			}
		});
		btnClickParaIngresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnClickParaIngresa(e);
			}
		});
		btnVerReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnVerReporte(e);
			}
		});
		
		
		
		try {
			con=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			cal=con.prepareCall("select codvendedor from vendedor");
			resul=cal.executeQuery();
			
			while(resul.next()){
				     cbocodigo.addItem(resul.getString(1));
				     
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			
			
		}
		
		btnActivar = new JButton("VER REPORTE POR TRABAJADOR");
		btnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActivar(e);
			}
		});
		btnActivar.setBounds(38, 543, 223, 25);
		getContentPane().add(btnActivar);
		
		btnDesactivar = new JButton("VER REPORTE TOTAL");
		btnDesactivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnDesactivar(arg0);
			}
		});
		btnDesactivar.setBounds(317, 543, 201, 25);
		getContentPane().add(btnDesactivar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REPORTE TOTAL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 40, 852, 484);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(84, 144, 637, 282);
		panel.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		label = new JLabel("Fecha");
		label.setBounds(51, 71, 49, 23);
		panel.add(label);
		
		btnAoActual = new JButton("A\u00F1o actual");
		btnAoActual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAoActual(e);
			}
		});
		btnAoActual.setBounds(282, 37, 97, 25);
		panel.add(btnAoActual);
		
		btnDelMes = new JButton("De este mes");
		btnDelMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnDelMes(e);
			}
		});
		btnDelMes.setBounds(155, 37, 115, 25);
		panel.add(btnDelMes);
		
		btnDeHoyDia = new JButton("De hoy dia");
		btnDeHoyDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnDeHoyDia(e);
			}
		});
		btnDeHoyDia.setBounds(19, 34, 97, 25);
		panel.add(btnDeHoyDia);
		
		button_5 = new JButton("Por Mes y A\u00F1o");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_5(e);
			}
		});
		button_5.setBounds(407, 37, 119, 25);
		panel.add(button_5);
		
		button_6 = new JButton("Imprimir");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_6(e);
			}
		});
		button_6.setBounds(584, 37, 97, 25);
		panel.add(button_6);
		
		
	}
	
	protected void actionPerformedCbocodigo(ActionEvent arg0) {
		
		
		
	
	
	}
	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
	
		JFileChooser file=new JFileChooser();
		
		FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo textos","txt");
		file.setFileFilter(extension);
	try {
			if(file.showSaveDialog(file.getParent())==JFileChooser.APPROVE_OPTION){
				BufferedWriter escritura=new BufferedWriter(new FileWriter(file.getSelectedFile().getPath()));
				txtS.write(escritura);
				
				escritura.close();
				
			}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	
	
	protected void actionPerformedBtnVerReporte(ActionEvent e) {
		txtS.setText("");
		String dia=(String)cbodia.getSelectedItem().toString();
		int mes=cbomes.getSelectedIndex();
		String año=(String)cboaño.getSelectedItem().toString();
	
		String fechaac=año+"-"+mes+"-"+dia;
		txtS.append("Reporte del "+dia+" de "+(String)cbomes.getSelectedItem().toString()+" del "+año+" : "+"\n");
		txtS.append("Las ventas y cantidades que se vendio"+"\n");
		txtS.append("Cantidad"+"\t"+"Productos"+"\n");
		
		 try {
			 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
				CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where venta.codvendedor=? and venta.fech_venta like '%"+fechaac+"%'");
				callrepor2.setString(1,(String)cbocodigo.getSelectedItem().toString());
				ResultSet resultadorepor2=callrepor2.executeQuery();
				while(resultadorepor2.next()){
					txtS.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
				}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
			CallableStatement callrepor=conexionrepor.prepareCall("select sum(totalpagar)from venta where codvendedor=? and fech_venta like '%"+fechaac+"%'");
			callrepor.setString(1,(String)cbocodigo.getSelectedItem().toString());
			ResultSet resrepor=callrepor.executeQuery();
			while(resrepor.next()){
			
			txtS.append("La Suma vendida  por el trabajador con codigo "+(String)cbocodigo.getSelectedItem().toString()+" es: 	"+ resrepor.getString(1));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
		
	}
	protected void actionPerformedBtnClickParaIngresa(ActionEvent e) {
	btnPorAo.setEnabled(true);
	btnPorMes.setEnabled(true);
	btnPorDia.setEnabled(true);
	btnPorMesY.setEnabled(true);
		
		
		
	}
	protected void actionPerformedBtnPorDia(ActionEvent arg0) {
		txtS.setText("");
		try {
		//solo por dia 
			txtS.append("Reporte del "+(String)cbodia.getSelectedItem().toString()+" : "+"\n");
			txtS.append("Las ventas y cantidades que se vendio"+"\n");
			txtS.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where venta.codvendedor=? and  day(fech_venta)='"+(String)cbodia.getSelectedItem().toString()+"'");
					callrepor2.setString(1,(String)cbocodigo.getSelectedItem().toString());
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						txtS.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where codvendedor=? and day(fech_venta)='"+(String)cbodia.getSelectedItem().toString()+"'");
		callrepor.setString(1,(String)cbocodigo.getSelectedItem().toString());
		ResultSet resrepor=callrepor.executeQuery();
		while(resrepor.next()){
		txtS.append("El monto acumulado que se hicieron el dia  : "+(String)cbodia.getSelectedItem().toString()+" : "+"\n");
		txtS.append("La Suma vendida  por el trabajador con codigo "+(String)cbocodigo.getSelectedItem().toString()+" es: "+ resrepor.getString(1));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	protected void actionPerformedBtnPorMes(ActionEvent arg0) {
	
		txtS.setText("");
		try {
		//solo por mes 
			txtS.append("Reporte del mes   "+(String)cbomes.getSelectedItem().toString()+" : "+"\n");
			txtS.append("Las ventas y cantidades que se vendio"+"\n");
			txtS.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where venta.codvendedor=? and  month(fech_venta)='"+cbomes.getSelectedIndex()+"'");
					callrepor2.setString(1,(String)cbocodigo.getSelectedItem().toString());
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						txtS.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where codvendedor=? and month(fech_venta)='"+cbomes.getSelectedIndex()+"'");
		callrepor.setString(1,(String)cbocodigo.getSelectedItem().toString());
		ResultSet resrepor=callrepor.executeQuery();
		txtS.append("El monto acumulado que se hicieron en el mes: "+(String)cbomes.getSelectedItem().toString()+" : "+"\n");
		while(resrepor.next()){
		
		txtS.append("La Suma vendida  por el trabajador con codigo "+(String)cbocodigo.getSelectedItem().toString()+" es: "+ resrepor.getString(1));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	protected void actionPerformedBtnPorAo(ActionEvent arg0) {
		txtS.setText("");
		try {
		//solo por mes 
			txtS.append("Reporte del año   "+(String)cboaño.getSelectedItem().toString()+" : "+"\n");
			txtS.append("Las ventas y cantidades que se vendio"+"\n");
			txtS.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where venta.codvendedor=? and  year(fech_venta)='"+cboaño.getSelectedItem().toString()+"'");
					callrepor2.setString(1,(String)cbocodigo.getSelectedItem().toString());
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						txtS.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where codvendedor=? and year(fech_venta)='"+cboaño.getSelectedItem().toString()+"'");
		callrepor.setString(1,(String)cbocodigo.getSelectedItem().toString());
		ResultSet resrepor=callrepor.executeQuery();
		txtS.append("El monto acumulado que se hicieron en el año : "+(String)cboaño.getSelectedItem().toString()+" : "+"\n");
		while(resrepor.next()){
		
		txtS.append("La Suma vendida  por el trabajador con codigo "+(String)cbocodigo.getSelectedItem().toString()+" es: "+ resrepor.getString(1));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	}
	protected void actionPerformedBtnPorMesY(ActionEvent arg0) {
	
		txtS.setText("");
		try {
		//solo por mes y año 
			txtS.append("Reporte del mes de "+(String)cbomes.getSelectedItem().toString()+" del "+(String)cboaño.getSelectedItem().toString()+" : "+"\n");
			txtS.append("Las ventas y cantidades que se vendio"+"\n");
			txtS.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where venta.codvendedor=? and month(fech_venta)='"+cbomes.getSelectedIndex()+"' and year(fech_venta)='"+cboaño.getSelectedItem().toString()+"'");
					callrepor2.setString(1,(String)cbocodigo.getSelectedItem().toString());
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						txtS.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where codvendedor=? and month(fech_venta)='"+cbomes.getSelectedIndex()+"' and year(fech_venta)='"+cboaño.getSelectedItem().toString()+"'");
		callrepor.setString(1,(String)cbocodigo.getSelectedItem().toString());
		ResultSet resrepor=callrepor.executeQuery();
		txtS.append("Reporte total del  mes de "+(String)cbomes.getSelectedItem().toString()+" del "+(String)cboaño.getSelectedItem().toString()+" : "+"\n");
		while(resrepor.next()){
		
		txtS.append("La Suma vendida  por el trabajador con codigo "+(String)cbocodigo.getSelectedItem().toString()+" es: "+ resrepor.getString(1));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}
	protected void actionPerformedBtnDesactivar(ActionEvent arg0) {
	panel.setVisible(true);
	panelReporte.setVisible(false);
	}
	protected void actionPerformedBtnActivar(ActionEvent e) {
	panelReporte.setVisible(true);
	panel.setVisible(false);
	}
	protected void actionPerformedBtnDeHoyDia(ActionEvent e) {
		textArea.setText("");
		Date da=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("dd");
		String dato=simple.format(da);
		try {
		//solo por dia 
			textArea.append("Reporte del dia  "+simple.format(da)+" : "+"\n");
			textArea.append("Las ventas y cantidades que se vendio"+"\n");
			textArea.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where day(fech_venta)='"+dato+"'");
					
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						textArea.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where day(fech_venta)='"+dato+"'");

		ResultSet resrepor=callrepor.executeQuery();
		
		
		while(resrepor.next()){
			textArea.append("El monto acumulado que se hicieron el dia  : "+simple.format(da)+" es : "+resrepor.getString(1)+"\n");
			
		}
		
	} catch (Exception ex) {
		// TODO: handle exception
	}
	}
	protected void actionPerformedBtnDelMes(ActionEvent e) {
		textArea.setText("");
		Date da=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("MM");
		String dato=simple.format(da);
		
		try {
		//mes  
			textArea.append("Reporte del mes "+dato+" : "+"\n");
			textArea.append("Las ventas y cantidades que se vendio"+"\n");
			textArea.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where month(fech_venta)='"+dato+"'");
					
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						textArea.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where month(fech_venta)='"+dato+"'");

		ResultSet resrepor=callrepor.executeQuery();
		
		
		while(resrepor.next()){
			textArea.append("El monto acumulado que se hicieron el mes  : "+simple.format(da)+" es : "+resrepor.getString(1)+"\n");
			
		}
		
	} catch (Exception ex) {
		// TODO: handle exception
	}
	}
	protected void actionPerformedBtnAoActual(ActionEvent e) {
		textArea.setText("");
		Date da=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("YYYY");
		String dato=simple.format(da);
		
		try {
		//mes  
			textArea.append("Reporte del año "+dato+" : "+"\n");
			textArea.append("Las ventas y cantidades que se vendio"+"\n");
			textArea.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where year(fech_venta)='"+dato+"'");
					
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						textArea.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where year(fech_venta)='"+dato+"'");

		ResultSet resrepor=callrepor.executeQuery();
		
		
		while(resrepor.next()){
			textArea.append("El monto acumulado que se hicieron el año  : "+simple.format(da)+" es : "+resrepor.getString(1)+"\n");
			
		}
		
	} catch (Exception ex) {
		// TODO: handle exception
	}
	}
	protected void actionPerformedButton_6(ActionEvent e) {
JFileChooser file=new JFileChooser();
		
		FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo textos","txt");
		file.setFileFilter(extension);
	try {
			if(file.showSaveDialog(file.getParent())==JFileChooser.APPROVE_OPTION){
				BufferedWriter escritura=new BufferedWriter(new FileWriter(file.getSelectedFile().getPath()));
				textArea.write(escritura);
				
				escritura.close();
				
			}
	} catch (Exception eX) {
		// TODO: handle exception
	}
	}
	protected void actionPerformedButton_5(ActionEvent e) {
		textArea.setText("");
		Date da=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("YYYY");
		SimpleDateFormat simple2=new SimpleDateFormat("MM");
		String dato=simple.format(da);
		String dato2=simple2.format(da);
		
		try {
		//mes y año  
			textArea.append("Reporte del mes "+dato2+" año "+dato+" : "+"\n");
			textArea.append("Las ventas y cantidades que se vendio"+"\n");
			textArea.append("Cantidad"+"\t"+"Productos"+"\n");
			
			 try {
				 Connection conexionrepor=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
					CallableStatement callrepor2=conexionrepor.prepareCall("select venta.cantidad,productos.descripcion from productos join venta on productos.codpro=venta.codpro where month(fech_venta)='"+dato2+"' and year(fech_venta)='"+dato+"'");
					
					ResultSet resultadorepor2=callrepor2.executeQuery();
					while(resultadorepor2.next()){
						textArea.append(resultadorepor2.getString(1)+"\t"+resultadorepor2.getString(2)+"\n");
					}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
			 
			 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexionrepor2=DriverManager.getConnection(LasConexiones.URLBD,LasConexiones.usuario,LasConexiones.password);
		CallableStatement callrepor=conexionrepor2.prepareCall("select sum(totalpagar)from venta where month(fech_venta)='"+dato2+"' and year(fech_venta)='"+dato+"'");

		ResultSet resrepor=callrepor.executeQuery();
		
		
		while(resrepor.next()){
			textArea.append("El monto acumulado que se hicieron en el mes "+dato2+" en  el año  : "+simple.format(da)+" es : "+resrepor.getString(1)+"\n");
			
		}
		
	} catch (Exception ex) {
		// TODO: handle exception
	}
	}
}
