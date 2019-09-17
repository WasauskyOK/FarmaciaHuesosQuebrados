package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Credenciales extends JDialog {
	private JLabel lblUsuarioBd;
	private JLabel lblPassword;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnGo;
	private JLabel label;
	public static String  usuario;
	public static String password;
	private JButton btnNuevoLimpiar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credenciales dialog = new Credenciales();
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
	public Credenciales() {
		setBounds(100, 100, 450, 266);
		getContentPane().setLayout(null);
		
		lblUsuarioBd = new JLabel("Usuario BD");
		lblUsuarioBd.setBounds(12, 29, 128, 16);
		getContentPane().add(lblUsuarioBd);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 98, 76, 16);
		getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(164, 26, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 95, 116, 22);
		getContentPane().add(textField_1);
		
		btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnGo(arg0);
			}
		});
		btnGo.setBounds(304, 42, 97, 25);
		getContentPane().add(btnGo);
		
		label = new JLabel("");
		label.setBounds(85, 165, 270, 16);
		getContentPane().add(label);
		
		btnNuevoLimpiar = new JButton("Nuevo | Limpiar");
		btnNuevoLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnNuevoLimpiar(arg0);
			}
		});
		btnNuevoLimpiar.setBounds(292, 94, 128, 25);
		getContentPane().add(btnNuevoLimpiar);

	}
	protected void actionPerformedBtnGo(ActionEvent arg0) {
	
		usuario=textField.getText();
		password=textField_1.getText();
	
		textField.setEditable(false);
		textField_1.setEditable(false);
		Login logs=new Login();
		logs.setVisible(true);
		
		
		
	}
	protected void actionPerformedBtnNuevoLimpiar(ActionEvent arg0) {
		textField.setText("");
		textField_1.setText("");
		textField.setEditable(true);
		textField_1.setEditable(true);
	}
}
