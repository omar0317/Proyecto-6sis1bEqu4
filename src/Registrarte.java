import java.awt.BorderLayout;	
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import com.mysql.fabric.xmlrpc.base.Data;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrarte extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField Nombre;
	private JTextField Apellido;
	private JTextField usuario;
	private JTextField contraseña;
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/Zoo?useSSL=false";
	private static final String USUARIO = "root";
    private static final String CLAVE ="12345";
    
    PreparedStatement ps;
    ResultSet rs;
    private JTextField Buscar;
	private JDateChooser fechadeNacimiento;
	private JTextField Fecha;
	
	private JTable table;
 
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
    	ID.setText(null);
    	Nombre.setText(null);
    	Apellido.setText(null);
    	usuario.setText(null);
    	contraseña.setText(null);
    	Buscar.setText(null);
    	Fecha.setText(null);
    	fechadeNacimiento.setDate(null);    }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					Registrarte frame = new Registrarte();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Registrarte() {
		setTitle("Registro para nuevos Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegstrate = new JLabel("Reg\u00EDstrate");
		lblRegstrate.setForeground(new Color(220, 20, 60));
		lblRegstrate.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 30));
		lblRegstrate.setBounds(10, 11, 172, 29);
		contentPane.add(lblRegstrate);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(10, 69, 64, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(10, 92, 64, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setBounds(10, 116, 64, 14);
		contentPane.add(lblApellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setBounds(10, 170, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(10, 197, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBounds(10, 224, 64, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblDeNacimiento = new JLabel("Fecha de nacimiento");
		lblDeNacimiento.setForeground(Color.WHITE);
		lblDeNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDeNacimiento.setBounds(10, 143, 137, 14);
		contentPane.add(lblDeNacimiento);
		
		JComboBox edad = new JComboBox();
		edad.setModel(new DefaultComboBoxModel(new String[] {"", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		edad.setToolTipText("");
		edad.setBounds(166, 166, 205, 22);
		contentPane.add(edad);
		
		Nombre = new JTextField();
		Nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Nombre.setText("");
			}
		});
		Nombre.setText("Ingrese su nombre completo");
		Nombre.setBounds(166, 89, 205, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Apellido.setText("");
			}
		});
		Apellido.setText("Ingrese sus apellidos ");
		Apellido.setBounds(166, 113, 205, 20);
		contentPane.add(Apellido);
		Apellido.setColumns(10);
		
		ID = new JTextField();
		ID.setBounds(166, 61, 103, 22);
		contentPane.add(ID);
		ID.setColumns(10);
		
		usuario = new JTextField();
		usuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				usuario.setText("");
			}
		});
		usuario.setText("Nombre de usuario a su elecci\u00F3n");
		usuario.setBounds(166, 194, 205, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		contraseña = new JTextField();
		contraseña.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				contraseña.setText("");
			}
		});
		contraseña.setText("Contrase\u00F1a Unica y personal");
		contraseña.setBounds(166, 221, 205, 20);
		contentPane.add(contraseña);
		contraseña.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				int year = fechadeNacimiento.getCalendar().get(Calendar.YEAR);
				int mes = fechadeNacimiento.getCalendar().get(Calendar.MONTH);
				int dia = fechadeNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fechadeNacimiento= ""+year+"-"+mes+"-"+dia;
				
				try {
					conexion = conectar();
					ps = conexion.prepareStatement("INSERT INTO registro (ID, Nombres, Apellidos, Fecha_de_nacimiento, Edad, Usuario, Contraseña) VALUES(?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, ID.getText());
					ps.setString(2, Nombre.getText());
					ps.setString(3, Apellido.getText());
					ps.setString(4, fechadeNacimiento);
					ps.setString(5, edad.getSelectedItem().toString());
					ps.setString(6, usuario.getText());
					ps.setString(7, contraseña.getText());
					
					int res = ps.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(null, "Dato Guardado Correctamente");
						limpiartodo();
						edad.setSelectedIndex(0);

						
					} else {
						JOptionPane.showMessageDialog(null, "Error al guardar el dato");
					}
					conexion.close();
				} catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		
		Buscar = new JTextField();
		Buscar.setBounds(221, 336, 56, 22);
		contentPane.add(Buscar);
		Buscar.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("DELETE FROM registro WHERE ID=?");
					ps.setInt(1, Integer.parseInt(Buscar.getText()));
					int res = ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "El registro se a eliminado");
						limpiartodo();
						edad.setSelectedIndex(0);
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
						
					}
					conexion.close();
				}catch(Exception e1) {
					System.err.println();
				}
			}
		});
		btnEliminar.setBounds(10, 335, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				
				
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("SELECT * FROM registro WHERE ID = ?");
					ps.setString(1, Buscar.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
						ID.setText(rs.getString("ID"));
						Nombre.setText(rs.getString("Nombres"));
						Apellido.setText(rs.getString("Apellidos"));
						Fecha.setText(rs.getString("Fecha_de_nacimiento"));
						edad.setSelectedItem(rs.getString("Edad"));
						usuario.setText(rs.getString("Usuario"));
						contraseña.setText(rs.getString("Contraseña"));
						
					} else {
						JOptionPane.showMessageDialog(null, "No existe ese registro, favor de verificar");
					}
				}catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		btnBuscar.setBounds(113, 335, 89, 25);
		contentPane.add(btnBuscar);
		btnNewButton.setBounds(274, 254, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiartodo();
				edad.setSelectedIndex(0);

			
				
			}
			
		});
		btnNewButton_1.setBounds(113, 299, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario reg = new Usuario();
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(421, 336, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnActualizae = new JButton("Actualizar");
		btnActualizae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion  = null;
				int year = fechadeNacimiento.getCalendar().get(Calendar.YEAR);
				int mes = fechadeNacimiento.getCalendar().get(Calendar.MONTH);
				int dia = fechadeNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fechadeNacimiento= ""+year+"-"+mes+"-"+dia;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("UPDATE registro SET ID=?, Nombres=?, Apellidos=?, Fecha_de_nacimiento=?, Edad=?, Usuario=?, Contraseña=? WHERE ID=?");
					ps.setString(1, ID.getText());
					ps.setString(2, Nombre.getText());
					ps.setString(3, Apellido.getText());
					ps.setString(4, fechadeNacimiento);
					ps.setString(7, edad.getSelectedItem().toString());
					ps.setString(8, usuario.getText());
					ps.setString(9, contraseña.getText());
					ps.setString(10, Buscar.getText());
					
					int res=ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "El dato a sido modificado");
						limpiartodo();
						edad.setSelectedIndex(0);
					}else {
						JOptionPane.showMessageDialog(null, "Error al modificar el dato");
					}
					conexion.close();
				}catch(Exception e1) {
					System.err.println();
				}
			}
		});
		btnActualizae.setBounds(10, 298, 97, 25);
		contentPane.add(btnActualizae);
		
		fechadeNacimiento = new JDateChooser();
		fechadeNacimiento.setToolTipText("");
		fechadeNacimiento.setBounds(274, 139, 97, 22);
		contentPane.add(fechadeNacimiento);
		
		Fecha = new JTextField();
		Fecha.setColumns(10);
		Fecha.setBounds(166, 139, 97, 22);
		contentPane.add(Fecha);
		
		JLabel label = new JLabel("");
		label.setBounds(146, 291, 56, 16);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\zoo1.jpg"));
		lblNewLabel.setBounds(0, 0, 535, 385);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(536, 0, 669, 314);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "Fecha_de_nacimiento", "Edad", "Usuario", "Contrase\u00F1a"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton Btn = new JButton("Mostrar Base de datos");
		Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					DefaultTableModel modelo = (DefaultTableModel)table.getModel();
					
					conexion = conectar();
					ps=conexion.prepareStatement("SELECT * FROM registro");
					
					rs.first();
					
					do {
						String[] fila = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
						modelo.addRow(fila);
					}while(rs.next());

					
				}catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		Btn.setBounds(727, 335, 188, 25);
		contentPane.add(Btn);
	}
}
