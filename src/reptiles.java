import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class reptiles extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					reptiles frame = new reptiles();
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
	public reptiles() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eduar\\OneDrive\\Im\u00E1genes\\rl.jpg"));
		setTitle("Reptiles\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSleccionaUnCuidador = new JLabel("Reptiles\r\n");
		lblSleccionaUnCuidador.setVerticalAlignment(SwingConstants.TOP);
		lblSleccionaUnCuidador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblSleccionaUnCuidador.setBounds(12, 13, 105, 28);
		contentPane.add(lblSleccionaUnCuidador);
		
		JLabel lblNewLabel = new JLabel("<html>Son animales vertebrados que se caracterizan por su especial manera de andar, ya que andan arrastrando el vientre por el suelo, Su piel est\u00E1 recubierta de escamas o tienen caparaz\u00F3n (las tortugas), su respiraci\u00F3n es pulmonar, tienen circulaci\u00F3n doble e incompleta por no haber  separaci\u00F3n total entre la sangre arterial y la venosa, son carn\u00EDvoros y cazadores, tienen dientes que cortan pero no mastican y en algunos casos son venenosos, la temperatura del cuerpo es muy variable. Son ov\u00EDparos. Todos tienen cuatro patas excepto las serpientes.<html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(12, 54, 259, 278);
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
		
		JLabel lblL = new JLabel("");
		lblL.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\reptiles (1).jpg"));
		lblL.setBounds(283, 157, 102, 100);
		contentPane.add(lblL);
		
	}
}