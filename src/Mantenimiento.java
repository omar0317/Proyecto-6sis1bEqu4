import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Mantenimiento extends JFrame {

	private JPanel contentPane;
	private JTextField h;
	private JTextField i;
	private JTextField Buscar;

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/Zoo?useSSL=false";
	private static final String USUARIO = "root";
    private static final String CLAVE ="12345";
    PreparedStatement ps;
    ResultSet rs;
	private JComboBox z;
	private JComboBox trabajos;
	private JComboBox especie;
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
    	h.setText(null);
    	i.setText(null);
    	Buscar.setText(null);
    }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					Mantenimiento frame = new Mantenimiento();
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
	@SuppressWarnings({ "unchecked", "rawtypes", "rawtypes" })
	public Mantenimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1225, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHbitad = new JLabel("H\u00E1bitat");
		lblHbitad.setForeground(Color.WHITE);
		lblHbitad.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHbitad.setBounds(10, 91, 46, 14);
		contentPane.add(lblHbitad);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setForeground(Color.WHITE);
		lblEspecie.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEspecie.setBounds(10, 145, 46, 14);
		contentPane.add(lblEspecie);
		
		JLabel lblTrabajos = new JLabel("Trabajos ");
		lblTrabajos.setForeground(Color.WHITE);
		lblTrabajos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrabajos.setBounds(10, 118, 60, 14);
		contentPane.add(lblTrabajos);
		
		JLabel lblZona = new JLabel("Zona");
		lblZona.setForeground(Color.WHITE);
		lblZona.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblZona.setBounds(10, 172, 46, 14);
		contentPane.add(lblZona);
		
		JLabel lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setForeground(Color.ORANGE);
		lblMantenimiento.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblMantenimiento.setBounds(167, 11, 150, 20);
		contentPane.add(lblMantenimiento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(496, 7, 711, 267);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Hábitad", "Especie", "Trabajos", "Zona"
			}
		));
		scrollPane.setViewportView(table);
		
		h = new JTextField();
		h.setBounds(80, 87, 86, 20);
		contentPane.add(h);
		h.setColumns(10);
		
		z = new JComboBox();
		z.setModel(new DefaultComboBoxModel(new String[] {"", "Zona A", "Zona B ", "Zona C"}));
		z.setBounds(80, 168, 86, 20);
		contentPane.add(z);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingresar ing = new Ingresar();
				ing.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(395, 285, 89, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblId.setBounds(10, 68, 46, 14);
		contentPane.add(lblId);
		
		i = new JTextField();
		i.setColumns(10);
		i.setBounds(80, 63, 86, 20);
		contentPane.add(i);
		
		Buscar = new JTextField();
		Buscar.setBounds(398, 196, 86, 22);
		contentPane.add(Buscar);
		Buscar.setColumns(10);
		
		JButton btnIngre = new JButton("Ingresar");
		btnIngre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps = conexion.prepareStatement("INSERT INTO mantenimiento (ID, Hábitad, Trabajos, especie, Zona) VALUES(?, ?, ?, ?, ?)");
					ps.setString(1, i.getText());
					ps.setString(2, h.getText());
					ps.setString(4, trabajos.getSelectedItem().toString());
					ps.setString(3, especie.getSelectedItem().toString());
					ps.setString(5, z.getSelectedItem().toString());
					
					
					int res = ps.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(null, "Dato Guardado Correctamente");
						limpiartodo();
						trabajos.setSelectedIndex(0);
						especie.setSelectedIndex(0);
						
						z.setSelectedIndex(0);
					} else {
						JOptionPane.showMessageDialog(null, "Error al guardar el dato");
					}
					conexion.close();
				} catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		btnIngre.setBounds(167, 195, 97, 25);
		contentPane.add(btnIngre);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion  = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("UPDATE mantenimiento SET ID=?, Hábitad=?, Trabajos=?, especie=?, Zona=? WHERE ID=?");
					ps.setString(1, i.getText());
					ps.setString(2, h.getText());
					ps.setString(3, trabajos.getSelectedItem().toString());
					ps.setString(4, especie.getSelectedItem().toString());
					
					ps.setString(5, z.getSelectedItem().toString());
				
					ps.setString(6, Buscar.getText());
					
					int res=ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "El dato a sido modificado");
						limpiartodo();
						
						trabajos.setSelectedIndex(0);
						especie.setSelectedIndex(0);
						z.setSelectedIndex(0);
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al modificar el dato");
					}
					conexion.close();
				}catch(Exception e1) {
					System.err.println();
				}
			}
		});
		btnModificar.setBounds(10, 232, 97, 25);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("DELETE FROM mantenimiento WHERE ID=?");
					ps.setInt(1, Integer.parseInt(Buscar.getText()));
					int res = ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "El registro se a eliminado");
						limpiartodo();
						trabajos.setSelectedIndex(0);
						especie.setSelectedIndex(0);
						
						z.setSelectedIndex(0);
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
						
					}
					conexion.close();
				}catch(Exception e1) {
					System.err.println();
				}
			}
		});
		btnEliminar.setBounds(10, 267, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("SELECT * FROM mantenimiento WHERE ID = ?");
					ps.setString(1, Buscar.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
						i.setText(rs.getString("ID"));
						h.setText(rs.getString("Hábitad"));
						trabajos.setSelectedItem(rs.getString("Trabajos"));
						especie.setSelectedItem(rs.getString("especie"));
						z.setSelectedItem(rs.getString("Zona"));
				
						
					} else {
						JOptionPane.showMessageDialog(null, "No existe ese registro, favor de verificar");
					}
				}catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		btnBuscar.setBounds(300, 195, 86, 25);
		contentPane.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiartodo();
				trabajos.setSelectedIndex(0);
				especie.setSelectedIndex(0);
				z.setSelectedIndex(0);
			}
		});
		btnLimpiar.setBounds(119, 267, 97, 25);
		contentPane.add(btnLimpiar);
		
		trabajos = new JComboBox();
		trabajos.setModel(new DefaultComboBoxModel(new String[] {"", "Limpieza", "Remodelaci\u00F3n ", "Arreglo"}));
		trabajos.setBounds(80, 115, 86, 20);
		contentPane.add(trabajos);
		
		especie = new JComboBox();
		especie.setModel(new DefaultComboBoxModel(new String[] {"", "Anfibio", "Reptil", "Peces", "Aves"}));
		especie.setBounds(80, 142, 86, 20);
		contentPane.add(especie);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\cholo.jpg"));
		lblNewLabel.setBounds(-14, 0, 510, 335);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Mostrar Base de datos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					DefaultTableModel modelo = (DefaultTableModel)table.getModel();
					
					conexion = conectar();
					ps=conexion.prepareStatement("SELECT * FROM mantenimiento");
					
					rs.first();
					
					do {
						String[] fila = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
						modelo.addRow(fila);
					}while(rs.next());

					
				}catch (Exception e1) {
					System.err.println(e1);
				}
		
			}
		});
		button.setBounds(783, 284, 188, 25);
		contentPane.add(button);
	}
}
