package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ClienteCasual extends JFrame {

	private JPanel contentPane;
	private final JLabel lblGenerarCodigoCliente = new JLabel("Generar Codigo Cliente Casual");
	private JTextField txtcodigocasual;
	private JButton btnMandarParaLa;
	public  String clientecasual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCasual frame = new ClienteCasual();
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
	public ClienteCasual() {
		setTitle("Cliente Anonimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 172);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblGenerarCodigoCliente.setBounds(12, 13, 192, 36);
		contentPane.add(lblGenerarCodigoCliente);
		
		txtcodigocasual = new JTextField();
		txtcodigocasual.setEditable(false);
		txtcodigocasual.setText("codC001");
		txtcodigocasual.setBounds(251, 20, 160, 22);
		contentPane.add(txtcodigocasual);
		txtcodigocasual.setColumns(10);
		
		btnMandarParaLa = new JButton("Mandar para la venta");
		btnMandarParaLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnMandarParaLa(arg0);
			}
		});
		btnMandarParaLa.setBounds(454, 19, 192, 25);
		contentPane.add(btnMandarParaLa);
	}
	public boolean filtro(){
		boolean c = false;
		int p=3;
		int d=4;
		if(d>p){
			String cli=clientecasual;
			clientecasual="codC001";
			c=true;
		}

		return c;
		
	}
	protected void actionPerformedBtnMandarParaLa(ActionEvent arg0) {
	filtro();
	JOptionPane.showMessageDialog(null,"Datos mandados a la venta");
	Venta ven=new Venta();
	ven.setVisible(true);
	dispose();
	}
}
