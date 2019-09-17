package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;

public class SocketCliente extends JDialog {
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JTextField txtip;
	private JScrollPane scrollPane_1;
	private JTextArea txtMensaje;
	private JButton btnEnviar;
	private JButton btnEnviarArchivo;
	private JLabel lblIngresaIp;
	private JLabel lblTuNombre;
	private JTextField txtnombre;
	private JComboBox cbopuerto;
	private JLabel lblCambiaPuerto;
	public static int portpuerto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocketCliente dialog = new SocketCliente();
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
	public SocketCliente() {
		
		setBounds(100, 100, 1016, 625);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 62, 624, 381);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		txtip = new JTextField();
		txtip.setBounds(542, 13, 184, 36);
		getContentPane().add(txtip);
		txtip.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 468, 471, 97);
		getContentPane().add(scrollPane_1);
		
		txtMensaje = new JTextArea();
		scrollPane_1.setViewportView(txtMensaje);
		
		btnEnviar = new JButton("Enviar Msg");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEnviar(e);
			}
		});
		btnEnviar.setBounds(533, 478, 154, 35);
		getContentPane().add(btnEnviar);
		
		btnEnviarArchivo = new JButton("Enviar Archivo");
		btnEnviarArchivo.setBounds(533, 526, 163, 39);
		getContentPane().add(btnEnviarArchivo);
		
		lblIngresaIp = new JLabel("Ingresa IP");
		lblIngresaIp.setBounds(400, 15, 130, 33);
		getContentPane().add(lblIngresaIp);
		
		lblTuNombre = new JLabel("Tu Nombre ");
		lblTuNombre.setBounds(12, 23, 93, 16);
		getContentPane().add(lblTuNombre);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(98, 13, 172, 29);
		getContentPane().add(txtnombre);
		txtnombre.setColumns(10);
		
		cbopuerto = new JComboBox();
		cbopuerto.setBounds(816, 133, 154, 36);
		getContentPane().add(cbopuerto);
		for (int i = 4561; i < 9656; i++) {
			cbopuerto.addItem(i);
		}
		
		lblCambiaPuerto = new JLabel("CAMBIA PUERTO");
		lblCambiaPuerto.setBounds(670, 143, 107, 26);
		getContentPane().add(lblCambiaPuerto);
		InfoRecepcionada info=new InfoRecepcionada();
		info.start();
			
		
		RecepcionArchivo  rec=new RecepcionArchivo();
		rec.start();
	}

	class RecepcionArchivo extends Thread{
		
		public void run (){
			try {
				ServerSocket servidoracepta=new ServerSocket(6668);
				
				String forma;
				int num=0;
				while(true){
					Socket aceptarservidor=servidoracepta.accept();
					//DataInputStream leerinfo=new DataInputStream(aceptarservidor.getInputStream());
					//forma=leerinfo.readUTF();
					ObjectInputStream leerarchivo=new ObjectInputStream(aceptarservidor.getInputStream());  
					FileOutputStream guardararchivo=new FileOutputStream("D:/recibirReporte/laprueba.txt");
					while(num!=-1){
						num=leerarchivo.read();
						guardararchivo.write(num);
						
						
					}
					
				guardararchivo.close();
				leerarchivo.close();
				//leerinfo.close();
				aceptarservidor.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	class InfoRecepcionada extends Thread{
		public void run(){
			try {
				EnvioInformacion2 recp5;
				String laip;
				String elmsj;
				String elname;
				ServerSocket servidorrecep=new ServerSocket(6635);
				
				while(true){
					Socket aceptarservidor=servidorrecep.accept();
					ObjectInputStream leerdatos=new ObjectInputStream(aceptarservidor.getInputStream());
					recp5=(EnvioInformacion2)leerdatos.readObject();
					elname=recp5.getNombre();
					elmsj=recp5.getMsg();
					txtS.append("\n"+elname+" : "+elmsj+"\n");
				leerdatos.close();
				aceptarservidor.close();
				
				
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	protected void actionPerformedBtnEnviar(ActionEvent e) {
	
		
		try {
				
			EnvioInformacion env=new EnvioInformacion();
			env.setIp(txtip.getText());
			env.setMsg(txtMensaje.getText());
			env.setNombre(txtnombre.getText());
			txtS.append("\n"+"YO : "+txtMensaje.getText());
			String dirrecion=txtip.getText();
			
			Socket misocket =new Socket(dirrecion,8462);
			
			ObjectOutputStream flujosalida=new  ObjectOutputStream(misocket.getOutputStream());
			flujosalida.writeObject(env);
			
			
			flujosalida.close();
		misocket.close();
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
}
class EnvioInformacion implements Serializable{
	private String ip;
	private String msg;
	private String nombre;
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
