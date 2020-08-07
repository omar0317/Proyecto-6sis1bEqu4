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

public class aves extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					aves frame = new aves();
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
	public aves() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eduar\\OneDrive\\Im\u00E1genes\\ave.jpg"));
		setTitle("Aves");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSleccionaUnCuidador = new JLabel("Aves");
		lblSleccionaUnCuidador.setVerticalAlignment(SwingConstants.TOP);
		lblSleccionaUnCuidador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblSleccionaUnCuidador.setBounds(12, 13, 105, 28);
		contentPane.add(lblSleccionaUnCuidador);
		
		JLabel lblNewLabel = new JLabel("<html>Son animales vertebrados, de sangre caliente, que caminan, saltan o se mantienen s\u00F3lo sobre las extremidades posteriores, mientras que las extremidades anteriores est\u00E1n modificadas como alas que, al igual que muchas otras caracter\u00EDsticas anat\u00F3micas \u00FAnicas, son adaptaciones para volar, aunque no todas vuelan. El cuerpo de las aves se divide en cabeza, tronco y extremidades, las plumas de algunas especies son de colores muy variados: rojas, verdes, amarillas, azules. Las aves viven pr\u00E1cticamente en todas las regiones del mundo.<html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(12, 54, 259, 241);
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\avl.png"));
		lblNewLabel_1.setBounds(272, 54, 113, 241);
		contentPane.add(lblNewLabel_1);
	}

}