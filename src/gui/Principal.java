	package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.applet.AudioClip;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.SocketCliente.InfoRecepcionada;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnInicio;
	private JMenu mnConsulta;
	private JMenuItem mntmManipularInformacionClientes;
	private JMenu mnMedicamento;
	private JMenu mnVendedor;
	private JMenu mnCliente;
	private JMenu mnVenta;
	private JMenuItem mntmAccesoALos;
	private JMenuItem mntmAccederInformacionVendedor;
	private JMenuItem mntmAccesoALos_1;
	private JMenuItem mntmRealizarVentaO;
	private JMenu mnReporte;
	private JMenuItem mntmReportePorVenvedor;
	private JMenuItem mntmReporteTotal;
	private JMenu mnImprimirBoleta;
	private JMenuItem mntmImpresionDeBoleta;
	private JMenuItem mntmClienteCasual;
	private JLabel label_1;
	private JLabel label;
	private JPanel panel;
	private JButton btnReproducir;
	private JButton btnPausa;
	private	AudioClip audio;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel label_2;
	private JPanel panel_2;
	private JLabel label_3;
	private JPanel panel_3;
	private JLabel label_4;
	private JPanel panel_5;
	private JLabel label_6;
	private JComboBox comboBox;
	private JPanel panel_4;
	private JButton btnDeseasMusica;
	private JButton btnOcultarPanelDe;
	private JPanel panel_6;
	private JScrollPane scrollPane;
	private JTextField txtip;
	private JScrollPane scrollPane_1;
	private JButton button;
	private JButton button_1;
	private JLabel label_5;
	private JLabel label_7;
	private JTextField txtnombre;
	private JTextArea txtS;
	private JTextArea txtMensaje;
	private JComboBox cboformato;
	public static int portnumber=9650;
	private JPanel panel_7;
	private JLabel label_8;
	private JButton btnVerSlaider;
	//private Dimension dim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Farmacia Huesos Quebrados | By Guardians of virginity");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1750, 786);
		//setBounds(0, 0,MAXIMIZED_HORIZ, MAXIMIZED_VERT);
		// dim=super.getToolkit().getScreenSize();
		// super.setSize(dim);
		//setUndecorated(true);
		//this.setExtendedState(MAXIMIZED_BOTH);
		setSize(getToolkit().getScreenSize());
		
		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(102, 205, 170));
		menuBar.setBackground(new Color(245, 222, 179));
		setJMenuBar(menuBar);
		setResizable(false);
		//setLocationRelativeTo(null);
		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		mnConsulta = new JMenu("CONSULTA");
		mnInicio.add(mnConsulta);
		
		mntmManipularInformacionClientes = new JMenuItem("Manipular Informacion clientes");
		mnConsulta.add(mntmManipularInformacionClientes);
		
		mnMedicamento = new JMenu("Medicamento");
		menuBar.add(mnMedicamento);
		
		mntmAccesoALos = new JMenuItem("Acceso a los medicamentos");
		mntmAccesoALos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedMntmAccesoALos(arg0);
			}
		});
		mnMedicamento.add(mntmAccesoALos);
		
		mnVendedor = new JMenu("Vendedor");
		menuBar.add(mnVendedor);
		
		mntmAccederInformacionVendedor = new JMenuItem("Acceder informacion vendedor");
		mntmAccederInformacionVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAccederInformacionVendedor(e);
			}
		});
		mnVendedor.add(mntmAccederInformacionVendedor);
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		mntmAccesoALos_1 = new JMenuItem("Acceso a los clientes");
		mntmAccesoALos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAccesoALos_1(e);
			}
		});
		mnCliente.add(mntmAccesoALos_1);
		
		mntmClienteCasual = new JMenuItem("Cliente Casual");
		mntmClienteCasual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedMntmClienteCasual(arg0);
			}
		});
		mnCliente.add(mntmClienteCasual);
		
		mnVenta = new JMenu("Venta");
		menuBar.add(mnVenta);
		
		mntmRealizarVentaO = new JMenuItem("Realizar Venta o Pedido");
		mntmRealizarVentaO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmRealizarVentaO(e);
			}
		});
		mnVenta.add(mntmRealizarVentaO);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmReportePorVenvedor = new JMenuItem("Reporte por Venvedor");
		mntmReportePorVenvedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmReportePorVenvedor(e);
			}
		});
		mnReporte.add(mntmReportePorVenvedor);
		
		mntmReporteTotal = new JMenuItem("Reporte Total");
		mnReporte.add(mntmReporteTotal);
		
		mnImprimirBoleta = new JMenu("Imprimir Boleta");
		menuBar.add(mnImprimirBoleta);
		
		mntmImpresionDeBoleta = new JMenuItem("Impresion de Boleta Cliente");
		mnImprimirBoleta.add(mntmImpresionDeBoleta);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLabel_1(arg0);
			}
		});
		label_1.setForeground(new Color(255, 255, 224));
		label_1.setBackground(new Color(255, 255, 240));
		label_1.setIcon(new ImageIcon(Principal.class.getResource("/gui/cerrar.png")));
		label_1.setBounds(1643, 13, 89, 71);
		contentPane.add(label_1);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedPanel(e);
			}
		});
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "MEDICAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(118, 34, 330, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/gui/medicina.png")));
		lblNewLabel.setBounds(54, 12, 192, 192);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedPanel_1(e);
			}
		});
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TRABAJADOR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(486, 34, 306, 271);
		contentPane.add(panel_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Principal.class.getResource("/gui/estate-agent.png")));
		label_2.setBounds(54, 12, 192, 192);
		panel_1.add(label_2);
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedPanel_2(e);
			}
		});
		panel_2.setLayout(null);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(167, 336, 480, 271);
		contentPane.add(panel_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Principal.class.getResource("/gui/shopping-online.png")));
		label_3.setBounds(145, 29, 192, 192);
		panel_2.add(label_3);
		
		panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedPanel_3(e);
			}
		});
		panel_3.setLayout(null);
		panel_3.setForeground(Color.BLACK);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "VENTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(12, 646, 375, 313);
		contentPane.add(panel_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Principal.class.getResource("/gui/divisa (1).png")));
		label_4.setBounds(106, 56, 192, 192);
		panel_3.add(label_4);
		
		panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedPanel_5(e);
			}
		});
		panel_5.setLayout(null);
		panel_5.setForeground(Color.BLACK);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "REPORTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(462, 646, 402, 313);
		contentPane.add(panel_5);
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Principal.class.getResource("/gui/grafico.png")));
		label_6.setBounds(112, 58, 192, 192);
		panel_5.add(label_6);
		
		
		btnDeseasMusica = new JButton("Deseas Musica ? Clic C:");
		btnDeseasMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnDeseasMusica(e);
			}
		});
		btnDeseasMusica.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		btnDeseasMusica.setBounds(1305, 13, 248, 25);
		contentPane.add(btnDeseasMusica);
		
		btnOcultarPanelDe = new JButton("Chat con el Administrador");
		btnOcultarPanelDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOcultarPanelDe(e);
			}
		});
		btnOcultarPanelDe.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		btnOcultarPanelDe.setBounds(1315, 51, 248, 25);
		contentPane.add(btnOcultarPanelDe);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/gui/f7827ba1-f9c4-4598-93f9-bd3b8ccf2693.png")));
		label.setBounds(419, 551, 260, 137);
		contentPane.add(label);
		
		panel_6 = new JPanel();
		panel_6.setBounds(982, 101, 750, 611);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setVisible(false);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 49, 624, 381);
		panel_6.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		txtip = new JTextField();
		txtip.setColumns(10);
		txtip.setBounds(554, 0, 184, 36);
		panel_6.add(txtip);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 455, 471, 143);
		panel_6.add(scrollPane_1);
		
		txtMensaje = new JTextArea();
		scrollPane_1.setViewportView(txtMensaje);
		
		button = new JButton("Enviar Msg");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton(e);
			}
		});
		button.setBounds(495, 443, 154, 35);
		panel_6.add(button);
		
		button_1 = new JButton("Enviar Archivo");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_1(e);
			}
		});
		button_1.setBounds(495, 530, 130, 39);
		panel_6.add(button_1);
		
		label_5 = new JLabel("Ingresa IP");
		label_5.setBounds(412, 2, 130, 33);
		panel_6.add(label_5);
		
		label_7 = new JLabel("Tu Nombre ");
		label_7.setBounds(24, 10, 93, 16);
		panel_6.add(label_7);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(110, 0, 172, 29);
		panel_6.add(txtnombre);
		
		cboformato = new JComboBox();
		cboformato.setModel(new DefaultComboBoxModel(new String[] {"txt", "mp4", "mp3", "pdf", "rar"}));
		cboformato.setBounds(637, 530, 101, 39);
		panel_6.add(cboformato);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(245, 255, 250));
		panel_7.setBounds(992, 104, 883, 902);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		label_8 = new JLabel("");
		
		
		
		label_8.setBounds(12, -15, 900, 937);
		panel_7.add(label_8);
		
		btnVerSlaider = new JButton("Ver Slaider");
		btnVerSlaider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnVerSlaider(arg0);
			}
		});
		btnVerSlaider.setBounds(1152, 52, 127, 25);
		contentPane.add(btnVerSlaider);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "MUSICA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(1031, 80, 363, 199);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"009 Sound System With A Spirit", "Martin Garrix - Proxy (Original Mix) [Free Download]", "Mifarma \u00A1Los expertos usan el monedero del ahorro!"}));
		comboBox.setBounds(26, 39, 328, 67);
		panel_4.add(comboBox);
		
		btnPausa = new JButton("PAUSA");
		btnPausa.setBounds(204, 134, 158, 52);
		panel_4.add(btnPausa);
		
		btnReproducir = new JButton("REPRODUCIR");
		btnReproducir.setBounds(26, 137, 150, 52);
		panel_4.add(btnReproducir);
		btnReproducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnReproducir(e);
			}
		});
		btnPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnPausa(e);
			}
		});
		class HiloIcono extends Thread{
		
			public void run (){
					int num=1;
				for(int i=1;i<=6;i++){
					
					label_8.setIcon(new ImageIcon(Principal.class.getResource("/gui/"+i+".jpg")));
					
					if(i==6){
						i=1;
					}
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		HiloIcono sdf=new HiloIcono();
		sdf.start();
		
		/*
		lblK.getWidth(),lblK.getHeight(),Image.SCALE_DEFAULT;
		*/
		
		class InfoRecepcionada extends Thread{
			public void run(){
				try {
					EnvioInformacion2 recp;
					String laip;
					String elmsj;
					String elname;
					ServerSocket servidorrecep=new ServerSocket(5544);
					
					while(true){
						Socket aceptarservidor=servidorrecep.accept();
						ObjectInputStream leerdatos=new ObjectInputStream(aceptarservidor.getInputStream());
						recp=(EnvioInformacion2)leerdatos.readObject();
						elname=recp.getNombre();
						elmsj=recp.getMsg();
						txtS.append("\n"+elname+" : "+elmsj+"\n");
					leerdatos.close();
					aceptarservidor.close();
					
					
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		InfoRecepcionada info=new InfoRecepcionada();
		info.start();
		
		
		class RecepcionArchivo extends Thread{
			
			public void run (){
				try {
					EnvioInformacion2 recibir;
					
					ServerSocket servidorlectura=new ServerSocket(5533);//informacion
					
					String nombreruta;
					String Persona;
					String msj;
					ArrayList<Integer>vectorsalida=new ArrayList<Integer>();
					
					
					
					while(true){
						Socket aceptarservidor=servidorlectura.accept();
					
						
						
						
						ObjectInputStream leerarchivo=new ObjectInputStream(aceptarservidor.getInputStream());  
						recibir=(EnvioInformacion2)leerarchivo.readObject();
						 nombreruta=recibir.getNombrearchivo();
						 vectorsalida=recibir.getVector();
						 Persona=recibir.getNombre();
						 msj=recibir.getMsg();
						 
						 txtS.append("\n"+"De "+Persona+" :  Te Entrege un Archivo :"+nombreruta);
/*archivo leido*/ 			
						
						 
						 
						FileOutputStream guardararchivo=new FileOutputStream("D:/recibirArchivo/"+nombreruta);
						
						for (int i = 0; i < vectorsalida.size(); i++) {
							guardararchivo.write(vectorsalida.get(i));
							
						}	
					
					
					
					leerarchivo.close();
				
					aceptarservidor.close();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		RecepcionArchivo recoger=new RecepcionArchivo();
		recoger.start();
		
	}

	protected void actionPerformedMntmAccesoALos(ActionEvent arg0) {
	
		//medicamentos acceso
		
		infocli1 me=new infocli1();
		me.setVisible(true);
		
	}
	protected void actionPerformedMntmAccederInformacionVendedor(ActionEvent e) {
	
	//acceso a vendedor
		Vendedor ve=new Vendedor();
		ve.setVisible(true);
		
	}
	protected void actionPerformedMntmAccesoALos_1(ActionEvent e) {
	// acceso a los clientes
		Cliente cl=new Cliente();
		cl.setVisible(true);
		
		
	}
	protected void actionPerformedMntmRealizarVentaO(ActionEvent e) {
	Venta vent=new Venta();
	vent.setVisible(true);
	
	}
	protected void actionPerformedMntmReportePorVenvedor(ActionEvent e) {
	
		//acceso a reporte
		Reporte re=new Reporte();
		re.setVisible(true);

	}
	protected void actionPerformedMntmClienteCasual(ActionEvent arg0) {
			ClienteCasual cas=new ClienteCasual();
			cas.setVisible(true);
			
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
	dispose();
	}
	protected void actionPerformedBtnReproducir(ActionEvent e) {
	
	
	audio=java.applet.Applet.newAudioClip(getClass().getResource("/gui/"+(String)comboBox.getSelectedItem().toString()+".wav"));
	audio.play();
	}
	protected void actionPerformedBtnPausa(ActionEvent e) {
	audio.stop();
	}
	protected void mouseClickedPanel_3(MouseEvent e) {
	Venta ve=new Venta();
		ve.setVisible(true);
	}
	protected void mouseClickedPanel_1(MouseEvent e) {
	Vendedor ven=new Vendedor();
	ven.setVisible(true);
	}
	protected void mouseClickedPanel_2(MouseEvent e) {
	Cliente cli=new Cliente();
	cli.setVisible(true);
	}
	protected void mouseClickedPanel(MouseEvent e) {
	infocli1 in=new infocli1();
	in.setVisible(true);
	}
	protected void mouseClickedPanel_5(MouseEvent e) {
	Reporte re=new Reporte();
	re.setVisible(true);
	}
	protected void actionPerformedBtnDeseasMusica(ActionEvent e) {
	
		panel_4.setVisible(true);
		panel_6.setVisible(false);
		panel_7.setVisible(false);
	}
	protected void actionPerformedBtnOcultarPanelDe(ActionEvent e) {
		panel_6.setVisible(true);
		panel_4.setVisible(false);
		panel_7.setVisible(false);
	}
	protected void actionPerformedButton(ActionEvent e) {
			
		
		
		try {
			
			EnvioInformacion2 env2=new EnvioInformacion2();
			env2.setIp(txtip.getText());
			env2.setMsg(txtMensaje.getText());
			env2.setNombre(txtnombre.getText());
			txtS.append("\n"+"YO : "+txtMensaje.getText());
			
			
			Socket misocket =new Socket("10.143.42.15",5522);
			
			ObjectOutputStream flujosalida=new  ObjectOutputStream(misocket.getOutputStream());
			flujosalida.writeObject(env2);
			
			
			flujosalida.close();
		misocket.close();
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void actionPerformedButton_1(ActionEvent e) {
		String filtro=(String)cboformato.getSelectedItem().toString();
		JFileChooser archivo =new JFileChooser();
	
	FileNameExtensionFilter extension=new FileNameExtensionFilter("Lo que desees c:",filtro);
	archivo.setFileFilter(extension);
	
	String ip;
	ip=txtip.getText();
	String formatos;
	int cont=0;
	if(archivo.showOpenDialog(archivo.getParent())==JFileChooser.APPROVE_OPTION){
		try {
			
		
			ArrayList<Integer>vectorlectura=new ArrayList<Integer>();
			formatos=archivo.getSelectedFile().getName();
			EnvioInformacion2 dato=new EnvioInformacion2();
	
			
		
			txtS.append("\n"+"Estas enviando un archivo con el nombre : "+formatos);
			
			Socket socalomensaje=new Socket("10.143.42.15",5511);//puerto por donde enviare los datos del archivo y destino
			
			
			FileInputStream lecturadatos=new FileInputStream(archivo.getSelectedFile().getPath());
			
			
			while(cont!=-1){
				cont=lecturadatos.read();
				vectorlectura.add(cont);
				
			}
			
			
			dato.setNombrearchivo(formatos);
			dato.setIp(txtip.getText());
			dato.setMsg("Has recibido un archivo con el nombre : "+formatos);
			dato.setNombre(txtnombre.getText());
			dato.setVector(vectorlectura);
			
			
			
			ObjectOutputStream envioarchivo=new ObjectOutputStream(socalomensaje.getOutputStream());
			envioarchivo.writeObject(dato);
			
			
			
			envioarchivo.close();
			lecturadatos.close();
			
			socalomensaje.close();
		
		} catch (IOException e2) {
			// TODO: handle exception
		}
		
		
	
	
	}
	}
	protected void actionPerformedBtnVerSlaider(ActionEvent arg0) {
		panel_6.setVisible(false);
		panel_4.setVisible(false);
		panel_7.setVisible(true);
	}
}

class EnvioInformacion2 implements Serializable{
	private String ip;
	private String msg;
	private String nombre;
	private String nombrearchivo;
	private ArrayList<Integer>vector=new ArrayList<Integer>();
	
	
	
	
	public ArrayList<Integer> getVector() {
		return vector;
	}
	public void setVector(ArrayList<Integer> vector) {
		this.vector = vector;
	}
	
	
	
	public void setNombrearchivo(String nombrearchivo){
		this.nombrearchivo=nombrearchivo;
	}
	public String getNombrearchivo(){
		return nombrearchivo;
	}
	public String getIp() {
		return ip;
	}
	public String getMsg() {
		return msg;
	}
	public String getNombre() {
		return nombre;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
