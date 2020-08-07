import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class mamiferos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					mamiferos frame = new mamiferos();
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
	public mamiferos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eduar\\OneDrive\\Im\u00E1genes\\ml.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblSleccionaUnCuidador = new JLabel("Mamiferos");
		lblSleccionaUnCuidador.setVerticalAlignment(SwingConstants.TOP);
		lblSleccionaUnCuidador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblSleccionaUnCuidador.setBounds(12, 13, 105, 28);
		contentPane.add(lblSleccionaUnCuidador);
		
		JLabel lblNewLabel = new JLabel("<html>Los mamíferos pertenecen al grupo de los vertebrados. Se caracterizan por tener el cuerpo cubierto de pelaje, por nacer del vientre materno (vivíparos) y por alimentar a las crias con leche por medio de glándulas mamarias. Los mamíferos son animales de sangre caliente, es decir, que son capaces de regular la temperatura de su cuerpo para que se mantenga constante independientemente de que haga frío o calor, y respiran a través de pulmones.<html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(12, 37, 373, 156);
		contentPane.add(lblNewLabel);
		
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
		label.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\mam\u00EDferos.png"));
		label.setBounds(12, 206, 252, 162);
		contentPane.add(label);
		
		
	}
}
