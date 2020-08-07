import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Direccion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");

					Direccion frame = new Direccion();
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
	public Direccion() {
		setTitle("Direcci\u00F3n:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSleccionaUnCuidador = new JLabel("Descubre que animale hay en cada area:");
		lblSleccionaUnCuidador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblSleccionaUnCuidador.setBounds(12, 13, 408, 22);
		contentPane.add(lblSleccionaUnCuidador);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.ORANGE);
		comboBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Area de Anfibios", "Area de Reptiles", "Area de Aves", "Area de Mam\u00EDferos"}));
		comboBox.setBounds(12, 42, 139, 22);
		contentPane.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Item;
				Item= comboBox.getSelectedItem().toString();
				if (Item.equalsIgnoreCase("Area de Reptiles")) {
					JOptionPane.showMessageDialog(null, "Testudines, quelonios o tortugas. Aquí se incluyen las tortugas marinas, las tortugas terrestres y las que habitan ecosistemas de aguas dulces.\r\n");
					JOptionPane.showMessageDialog(null,"Squamata (escamados) son aquellos reptiles que presentan escamas, por ejemplo los lagartos, anfisbaenas (anfisbenas) y las serpientes.\r\n");
					JOptionPane.showMessageDialog(null, "Crocodylia representado por los cocodrilos, caimanes y gaviales.");
				} else
				if (Item.equalsIgnoreCase("Aves")) {
					JOptionPane.showMessageDialog(null, "Galliformes (pavos, perdices, faisanes)");
					JOptionPane.showMessageDialog(null, "Anseriformes (patos, gansos, cisnes)");
				} else
				if (Item.equalsIgnoreCase("Anfibios")) {
					JOptionPane.showMessageDialog(null, "Anuros son los anfibios que no tienen cola (del griego an: no, ourá: cola) como los sapos y ranas.");
					JOptionPane.showMessageDialog(null, "Caudados son aquellos anfibios que poseen cola como las salamandras y tritones.");
					JOptionPane.showMessageDialog(null, "Gimnofiones (del griego gymnos: desnuda, ofis: serpiente) son anfibios que tienen un aspecto parecido al de algunos gusanos (vermiformes), por lo tanto no tienen extremidades. En este grupo encontramos a las cecilias.");
				} else
				if (Item.equalsIgnoreCase("Mamíferos")) {
					JOptionPane.showMessageDialog(null, "León Africano,Oso polar,Chachalaca, Águila Real,Loro cabeza amarilla,Tigre de bengala, Jirafa reticulada y Leopardo");
				}
			}
		});
		btnAceptar.setBounds(12, 77, 97, 25);
		contentPane.add(btnAceptar);
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cuidadores regresar = new Cuidadores();
				regresar.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(288, 330, 97, 25);
		contentPane.add(btnRegresar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\ni\u00F1o (1).jpg"));
		label.setBounds(197, 81, 159, 159);
		contentPane.add(label);
		
		JButton btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Cuidadores regresar = new Cuidadores();
					regresar.setVisible(true);
					dispose();
	
			}
		});
		btnRegresar_1.setBounds(88, 215, 97, 25);
		contentPane.add(btnRegresar_1);
	}
}
