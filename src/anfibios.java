import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class anfibios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					anfibios frame = new anfibios();
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
	public anfibios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eduar\\OneDrive\\Im\u00E1genes\\al.jpg"));
		setTitle("Anfibios\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSleccionaUnCuidador = new JLabel("Anfibios\r\n");
		lblSleccionaUnCuidador.setVerticalAlignment(SwingConstants.TOP);
		lblSleccionaUnCuidador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblSleccionaUnCuidador.setBounds(12, 13, 105, 28);
		contentPane.add(lblSleccionaUnCuidador);
		
		JLabel lblNewLabel = new JLabel("<html>Los anfibios son animales vertebrados tienen la piel desnuda, respiran por branquias y no tienen patas cuando son j\u00F3venes; cuando son adultos respiran por pulmones y tienen cuatro patas con membrana interdigitales. <html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(12, 47, 204, 168);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\rana (1).jpg"));
		label.setBounds(233, 130, 152, 100);
		contentPane.add(label);
		
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
		
		
		
		
	}
}
