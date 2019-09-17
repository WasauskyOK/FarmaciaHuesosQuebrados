package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CambioMoneda extends JDialog {
	private JLabel lblRealizaCambioDe;
	private JComboBox cbomoneda;
	private JLabel lblmonto;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambioMoneda dialog = new CambioMoneda();
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
	public CambioMoneda() {
		getContentPane().setBackground(new Color(204, 255, 204));
		setTitle("CAMBIO DE MONEDA");
		setBounds(100, 100, 735, 158);
		getContentPane().setLayout(null);
		
		lblRealizaCambioDe = new JLabel("REALIZA CAMBIO DE MONEDA");
		lblRealizaCambioDe.setBounds(12, 43, 188, 16);
		getContentPane().add(lblRealizaCambioDe);
		
		cbomoneda = new JComboBox();
		cbomoneda.setBounds(212, 40, 237, 22);
		getContentPane().add(cbomoneda);
		
		lblmonto = new JLabel("0.0");
		lblmonto.setBounds(461, 43, 56, 16);
		getContentPane().add(lblmonto);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(315, 75, 97, 25);
		getContentPane().add(btnAceptar);

	}
}
