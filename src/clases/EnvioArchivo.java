package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class EnvioArchivo extends JFrame {

	private JPanel contentPane;
	private JLabel lblRuta;
	private JButton btnEscogerArchivoA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnvioArchivo frame = new EnvioArchivo();
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
	public EnvioArchivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRuta = new JLabel("RUTA");
		lblRuta.setBounds(12, 314, 56, 16);
		contentPane.add(lblRuta);
		
		btnEscogerArchivoA = new JButton("ESCOGER ARCHIVO A DUPLICAR");
		btnEscogerArchivoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnEscogerArchivoA(arg0);
			}
		});
		btnEscogerArchivoA.setBounds(175, 310, 319, 25);
		contentPane.add(btnEscogerArchivoA);
	}
	protected void actionPerformedBtnEscogerArchivoA(ActionEvent arg0) {
	
	JFileChooser file=new JFileChooser();
	FileNameExtensionFilter extension=new FileNameExtensionFilter("Solo texto", "txt");
	file.setFileFilter(extension);
	
	if(file.showSaveDialog(file.getParent())==file.APPROVE_OPTION){
			try {
				Socket socaloenviar=new Socket("192.168.1.31",6834);
				ObjectOutputStream salidaflujo=new ObjectOutputStream(socaloenviar.getOutputStream());
				
				FileInputStream archivoleer=new FileInputStream(file.getSelectedFile().getPath());
				
				//FileOutputStream archivosalida=new FileOutputStream("C:/Users/Daniel Go/Downloads/Compressed/duplicadoarchivo2019.txt");
				
				int binarios=0;
				while(binarios!=-1){
					binarios=archivoleer.read();
					
					salidaflujo.write(binarios);
					
					
				}
				archivoleer.close();
				salidaflujo.close();
				socaloenviar.close();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	
	
	}
}
