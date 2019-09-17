package gui;

import java.awt.EventQueue;
import java.awt.image.renderable.RenderableImageProducer;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerSocketServidor extends JDialog {
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerSocketServidor dialog = new ServerSocketServidor();
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
	public ServerSocketServidor() {
		setBounds(100, 100, 804, 672);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 41, 734, 571);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		ReproducirMensajeArchivo comienso2=new ReproducirMensajeArchivo();
		comienso2.start();
		
		ReproductorHilo  comienso=new ReproductorHilo();
		comienso.start();
	}
	class ReproductorHilo extends Thread{
		
		
		public void run(){
			try {
				EnvioInformacion2 recibirinfo;
				String ip;
				String msj;
				String persona;
				ServerSocket servidor1=new ServerSocket(5522);
				
				while(true){
					Socket socketserv=servidor1.accept();
					ObjectInputStream flujoentrada=new ObjectInputStream(socketserv.getInputStream());
					recibirinfo=(EnvioInformacion2)flujoentrada.readObject();
					ip=recibirinfo.getIp();
					msj=recibirinfo.getMsg();
					persona=recibirinfo.getNombre();
					
					txtS.append("\n"+"Su Nombre : "+persona+" MSG : "+msj+" PARA  : "+ip+"\n");
					
					Socket socketsegundo=new Socket(ip,5544);
					ObjectOutputStream reenvioinfo=new ObjectOutputStream(socketsegundo.getOutputStream());
					reenvioinfo.writeObject(recibirinfo);
					reenvioinfo.close();
					socketsegundo.close();
					socketserv.close();
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

	class ReproducirMensajeArchivo extends Thread{
		
		public void run (){
			
		try {
			EnvioInformacion2 recibirarchivo;
			String ip;
			String msj;
			String nombrearchivo;
			String nombrePersona;
			ArrayList<Integer>vectorsalida5=new ArrayList<Integer>();
			ServerSocket ServidorArchivo=new ServerSocket(5511);
			
			
			while(true){
				Socket serverarchivo=ServidorArchivo.accept();
				ObjectInputStream salidaarchivo=new ObjectInputStream(serverarchivo.getInputStream());
				recibirarchivo =(EnvioInformacion2)salidaarchivo.readObject();
				
				ip=recibirarchivo.getIp();
				nombrePersona=recibirarchivo.getNombre();
				nombrearchivo=recibirarchivo.getNombrearchivo();
				msj=recibirarchivo.getMsg();
				vectorsalida5=recibirarchivo.getVector();
				
				txtS.append("\n"+"De : "+nombrePersona+"  Para: "+ip+"  Se envia un archivo :  "+nombrearchivo);
				
				Socket EnvioInformacion=new Socket(ip,5533);
				
				ObjectOutputStream enviotexto=new  ObjectOutputStream(EnvioInformacion.getOutputStream());
				
				enviotexto.writeObject(recibirarchivo);
				
				
						
		
			
				
			enviotexto.close();
			salidaarchivo.close();
			serverarchivo.close();
			
			
			
		
			
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
			
		}
	}
	
}
