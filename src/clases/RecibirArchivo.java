package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Transparency;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class RecibirArchivo extends JFrame {

	private JPanel contentPane;
	private JLabel lblJajajaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecibirArchivo frame = new RecibirArchivo();
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
	public RecibirArchivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJajajaja = new JLabel("JAJAJAJA");
		lblJajajaja.setBounds(397, 168, 56, 16);
		contentPane.add(lblJajajaja);
		
		
	HiloRecibirBinarios sd=new HiloRecibirBinarios();
	sd.start();
		
		
		
	}
	class HiloRecibirBinarios extends Thread{
		public void run(){
			try {
				ServerSocket servidorRecibe=new ServerSocket(6834);
				while(true){
					Socket socalorecibe=servidorRecibe.accept();
					
					ObjectInputStream flujorecibe=new ObjectInputStream(socalorecibe.getInputStream());
			FileOutputStream reconstruirimagen=new FileOutputStream("C:/Duplicados/PrimerArchivoDuplicado.txt");	
			int binariosrecon=0;
			while(binariosrecon!=-1){
				binariosrecon=flujorecibe.read();
				
		reconstruirimagen.write(binariosrecon);

		
			}
			reconstruirimagen.close();
			flujorecibe.close();
			socalorecibe.close();
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
