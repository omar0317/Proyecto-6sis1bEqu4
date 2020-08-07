import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingresar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					Ingresar frame = new Ingresar();
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
	public Ingresar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Direcci\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Direccion dig = new Direccion();
				dig.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(48, 48, 128, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Taquilla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Taquilla taq = new Taquilla();
				taq.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(212, 48, 128, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Animales ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cuidadores cui = new Cuidadores();
				cui.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(212, 178, 128, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mantenimiento ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mantenimiento man = new Mantenimiento();
				man.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(48, 178, 128, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario reg = new Usuario();
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(57, 248, 89, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setForeground(new Color(244, 164, 96));
		lblOpciones.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblOpciones.setBounds(142, 11, 111, 24);
		contentPane.add(lblOpciones);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra com = new Compra();
				com.setVisible(true);
				dispose();
			}
		});
		btnVentas.setBounds(125, 110, 128, 36);
		contentPane.add(btnVentas);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\zoo3.jpg"));
		lblNewLabel.setBounds(0, 0, 421, 310);
		contentPane.add(lblNewLabel);
	}
}
