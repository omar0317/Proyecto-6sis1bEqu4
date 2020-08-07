import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;	
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Cuidadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					Cuidadores frame = new Cuidadores();
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
	public Cuidadores() {
		setTitle("Animales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 252);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSleccionaUnCuidador = new JLabel("Slecciona un tipo de Animal:\r\n");
		lblSleccionaUnCuidador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblSleccionaUnCuidador.setBounds(12, 13, 199, 22);
		contentPane.add(lblSleccionaUnCuidador);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.ORANGE);
		comboBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Anfibios", "Reptiles", "Aves", "Mam\u00EDferos"}));
		comboBox.setBounds(12, 42, 139, 22);
		contentPane.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Item;
				Item= comboBox.getSelectedItem().toString();
				if (Item.equalsIgnoreCase("Reptiles")) {
					reptiles rep = new reptiles();
					rep.setVisible(true);
					dispose();
				} else
				if (Item.equalsIgnoreCase("Aves")) {
					aves av = new aves();
					av.setVisible(true);
					dispose();
				} else
				if (Item.equalsIgnoreCase("Anfibios")) {
					anfibios anf = new anfibios();
					anf.setVisible(true);
					dispose();
				} else
				if (Item.equalsIgnoreCase("Mamíferos")) {
					mamiferos mam = new mamiferos();
					mam.setVisible(true);
					dispose();
				}
			}
		});
		btnAceptar.setBounds(12, 77, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnRegresar = new JButton("regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingresar ing = new Ingresar();
				ing.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(12, 179, 89, 23);
		contentPane.add(btnRegresar);
	}
}