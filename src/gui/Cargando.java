package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Cargando extends JDialog {
	private JLabel lblCargando;
	private JTextField txtloading;
	private JLabel lblcar;
	private JButton btnX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cargando dialog = new Cargando();
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
	public Cargando() {
		setUndecorated(true);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 740, 149);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		lblCargando = new JLabel("CARGANDO");
		lblCargando.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 28));
		lblCargando.setBounds(22, 17, 230, 43);
		getContentPane().add(lblCargando);
		
		txtloading = new JTextField();
		txtloading.setForeground(Color.GREEN);
		txtloading.setBounds(40, 73, 674, 22);
		getContentPane().add(txtloading);
		txtloading.setColumns(10);
		
		lblcar = new JLabel("");
		lblcar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblcar.setBounds(291, 13, 147, 36);
		getContentPane().add(lblcar);
		
		btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnX(arg0);
			}
		});
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(255, 0, 0));
		btnX.setBounds(613, 13, 97, 25);
		getContentPane().add(btnX);
		
		puntos pun=new puntos();
		pun.start();
		
		
		carga cs=new carga();
		cs.start();
		
	}
	public class puntos extends Thread{
		public void run(){
			String punto="•";
			String Acum="";
			int cont;
			for(cont=0;cont<=50;cont++){
			
				Acum+=punto;
				
				
				
				if(cont>=4){
					Acum="";
					cont=0;
				
				}
				lblcar.setText(Acum);
				try {
					sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	

	public class carga extends Thread{
		int contador=1;
		String cad="█";
		String acu="";
		
		
		
		
		String punt=".";
		String log="";
		int con=1;
		
		
		public void run(){
			while(contador<=50){
				/*log+=punt;
				
				lblcar.setText(""+log);
				
				
				if(log.length()==3){
					lblcar.setText(".");
				}
				
				con++;
				*/
				
				 acu+=cad;
				
			txtloading.setText(""+acu);
				contador++;
					if(contador>50){

						Principal obj=new Principal();
						obj.setVisible(true);
						
						dispose();
						
					}
				try {
					sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	protected void actionPerformedBtnX(ActionEvent arg0) {
	dispose();
	}
}
