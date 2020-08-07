import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	private JLabel lblNewLabel;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");

					Usuario frame = new Usuario();
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
	

	 
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel t1 = new JLabel("Usuario");
		t1.setForeground(new Color(255, 215, 0));
		t1.setBounds(35, 127, 65, 24);
		t1.setFont(new Font("Times New Roman", 1, 20));
		contentPane.add(t1);
		
		JLabel t2 = new JLabel("Contrase\u00F1a");
		t2.setForeground(new Color(255, 215, 0));
		t2.setBounds(35, 200, 97, 24);
		t2.setBackground(Color.WHITE);
		t2.setFont(new Font("Times New Roman", 1, 20));
		contentPane.add(t2);
		
		JLabel lblZoolgicoUtc = new JLabel("Zool\u00F3gico UTC");
		lblZoolgicoUtc.setForeground(new Color(0, 255, 102));
		lblZoolgicoUtc.setFont(new Font("MV Boli", Font.PLAIN, 25));
		lblZoolgicoUtc.setBounds(164, 22, 197, 41);
		contentPane.add(lblZoolgicoUtc);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(110, 132, 197, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(142, 205, 165, 20);
		contentPane.add(txtPass);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(75, 268, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrarte = new JButton("Registrarte");
		btnRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarte reg = new Registrarte();
				reg.setVisible(true);
				dispose();
				
			}
		});
		btnRegistrarte.setBounds(228, 268, 107, 23);
		contentPane.add(btnRegistrarte);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\zoo1.jpg"));
		lblNewLabel.setBounds(0, 0, 540, 348);
		contentPane.add(lblNewLabel);
		
	}
}
