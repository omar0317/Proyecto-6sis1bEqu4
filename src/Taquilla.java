import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Taquilla extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField total;
	private JTextField per;
	private JTextField id;
	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/Zoo?useSSL=false";
	private static final String USUARIO = "root";
    private static final String CLAVE ="12345";
    
    PreparedStatement ps;
    ResultSet rs;
    private JTextField Buscar;
    private JTextField adul;
    private JTextField niños;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");

					Taquilla frame = new Taquilla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Connection conectar () {
		Connection conexion =null;
		
		try {
			try {
				Class.forName(CONTROLADOR);
			} catch(ClassNotFoundException e) {
				System.out.println("Error al cargar el controlador");
				e.printStackTrace();
			}
			conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Esta conectado");
		} catch (SQLException e) {
			System.out.println("Error al conectarse");
			e.printStackTrace();
		}
		return conexion;
}
	private void limpiartodo() {
    	id.setText(null);
    	per.setText(null);
    	total.setText(null);
    	adul.setText(null);
    	niños.setText(null);
    }

	/**
	 * Create the frame.
	 */
	public Taquilla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTaquilla = new JLabel("Taquilla");
		lblTaquilla.setForeground(new Color(255, 0, 0));
		lblTaquilla.setFont(new Font("Kristen ITC", 1, 20));
		lblTaquilla.setBounds(180, 11, 127, 36);
		getContentPane().add(lblTaquilla);
		
		JLabel lblPersonas = new JLabel("Personas");
		lblPersonas.setForeground(Color.RED);
		lblPersonas.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPersonas.setBounds(201, 167, 84, 30);
		getContentPane().add(lblPersonas);
		
		JLabel lblAdultos = new JLabel("Adultos");
		lblAdultos.setForeground(new Color(255, 0, 0));
		lblAdultos.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAdultos.setBounds(201, 201, 70, 32);
		getContentPane().add(lblAdultos);
		
		JLabel lblNios = new JLabel("Ni\u00F1os");
		lblNios.setForeground(new Color(255, 0, 0));
		lblNios.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNios.setBounds(201, 238, 58, 24);
		getContentPane().add(lblNios);
		
		JLabel lblNmeroDeBoletos = new JLabel("<html>N\u00FAmero de\r\n          boletos <html>");
		lblNmeroDeBoletos.setForeground(Color.RED);
		lblNmeroDeBoletos.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNmeroDeBoletos.setBounds(201, 261, 106, 62);
		getContentPane().add(lblNmeroDeBoletos);
		
		total = new JTextField();
		total.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Integer valorTextField = Integer.parseInt(adul.getText());
				Integer valorTextField1 = Integer.parseInt(niños.getText());
				int result = valorTextField.intValue()+valorTextField1.intValue();
				total.setText(Integer.toString(result));


			}
		});
		total.setBounds(312, 287, 127, 20);
		getContentPane().add(total);
		total.setColumns(10);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps = conexion.prepareStatement("INSERT INTO taquilla (ID_boleto, Número_de_personas, Número_de_adultos, Número_de_niños, Número_de_boletos) VALUES(?, ?, ?, ?, ?)");
					ps.setString(1, id.getText());
				    ps.setString(2, per.getText());
					ps.setString(3, adul.getText());
					ps.setString(4, niños.getText());
					ps.setString(5, total.getText());
					
					
					int res = ps.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(null, "Compra de boletos exitosa");
						limpiartodo();
					} else {
						JOptionPane.showMessageDialog(null, "Error al realizar la compra");
					}
					conexion.close();
				} catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		btnComprar.setBounds(350, 351, 89, 23);
		getContentPane().add(btnComprar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiartodo();
			}
		});
		btnLimpiar.setBounds(12, 410, 89, 23);
		getContentPane().add(btnLimpiar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresar ing = new Ingresar();
				ing.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(487, 410, 89, 23);
		getContentPane().add(btnRegresar);
		
		JLabel lblIdDeBoleto = new JLabel("ID del boleto");
		lblIdDeBoleto.setForeground(Color.RED);
		lblIdDeBoleto.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblIdDeBoleto.setBounds(201, 134, 106, 30);
		getContentPane().add(lblIdDeBoleto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("DELETE FROM taquilla WHERE ID_boleto=?");
					ps.setInt(1, Integer.parseInt(Buscar.getText()));
					int res = ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "La compra del boleto se a cancelado");
						limpiartodo();

					}else {
						JOptionPane.showMessageDialog(null, "Error al cancelar la compra");
						
					}
					conexion.close();
				}catch(Exception e1) {
					System.err.println();
				}
			}
		});
		btnCancelar.setBounds(12, 374, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("SELECT * FROM taquilla WHERE ID_boleto = ?");
					ps.setString(1, Buscar.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
						id.setText(rs.getString("ID_boleto"));
						per.setText(rs.getString("Número_de_personas"));
						adul.setText(rs.getString("Número_de_adultos"));
						niños.setText(rs.getString("Número_de_niños"));
						total.setText(rs.getString("Número_de_boletos"));
						
						
					} else {
						JOptionPane.showMessageDialog(null, "No existe ese registro, favor de verificar");
					}
				}catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		
		btnNewButton.setBounds(180, 409, 97, 25);
		getContentPane().add(btnNewButton);
		
		per = new JTextField();
		per.setColumns(10);
		per.setBounds(312, 172, 127, 20);
		getContentPane().add(per);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(312, 139, 127, 20);
		getContentPane().add(id);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion  = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("UPDATE taquilla SET ID_boleto=?, Número_de_personas=?, Número_de_adultos=?, Número_de_niños=?, Número_de_boletos=?");
					ps.setString(1, id.getText());
					ps.setString(2, per.getText());
					ps.setString(3, adul.getText());
					ps.setString(4, niños.getText());
					ps.setString(5, total.getText());

					int res=ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "La compra del boleto a sido modificada");
						limpiartodo();
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al modificar la compra del boleto");
					}
					conexion.close();
				}catch(Exception e1) {
					System.err.println();
				}
			}
		});
		btnModificar.setBounds(113, 373, 89, 23);
		getContentPane().add(btnModificar);
		
		Buscar = new JTextField();
		Buscar.setColumns(10);
		Buscar.setBounds(312, 410, 127, 20);
		getContentPane().add(Buscar);
		
		adul = new JTextField();
		adul.setBounds(312, 207, 127, 22);
		getContentPane().add(adul);
		adul.setColumns(10);
		
		niños = new JTextField();
		niños.setBounds(312, 240, 127, 22);
		contentPane.add(niños);
		niños.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\vector-zoo-entrance-with-no-visitors.jpg"));
		lblNewLabel.setBounds(-42, -43, 632, 531);
		getContentPane().add(lblNewLabel);
	}
	}


