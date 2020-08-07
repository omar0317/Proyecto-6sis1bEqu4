import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Compra extends JFrame {

	private JPanel contentPane;
	private JTextField num_com;
	private JTextField nombre;
	private JTextField nu_tar;
	private JTextField fecha;
	private JTextField rv;
	private JTextField articulo;
	private JTextField cantidad;
	private String metodo;
	private JTable table;

	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/Zoo?useSSL=false";
	private static final String USUARIO = "root";
    private static final String CLAVE ="12345";
    
    PreparedStatement ps;
    ResultSet rs;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField Buscar;
	private JRadioButton tarjeta;
	private JRadioButton efectivo;

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
    	num_com.setText(null);
    	nombre.setText(null);
    	nu_tar.setText(null);
    	fecha.setText(null);
    	rv.setText(null);
    	articulo.setText(null);
    	cantidad.setText(null);
    	buttonGroup.clearSelection();
    	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					Compra frame = new Compra();
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
	public Compra() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1365, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblElijaUnaForma = new JLabel("Forma de pago");
		lblElijaUnaForma.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblElijaUnaForma.setForeground(new Color(255, 255, 255));
		lblElijaUnaForma.setBounds(37, 98, 123, 23);
		contentPane.add(lblElijaUnaForma);
		
		JLabel lblFormasDePago = new JLabel("Formas de pago");
		lblFormasDePago.setForeground(new Color(255, 0, 0));
		lblFormasDePago.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblFormasDePago.setBounds(148, 11, 213, 34);
		contentPane.add(lblFormasDePago);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conexion = null;
				try {
					conexion = conectar();
					ps = conexion.prepareStatement("INSERT INTO pago (ID_de_compra, Forma_de_Pago, Nombre_del_titular, Número_de_tarjeta, Fecha_de_vencimiento, RV, Articulo, Cantidad_a_pagar) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, num_com.getText());
				    ps.setString(2, metodo);
					ps.setString(3, nombre.getText());
					ps.setString(4, nu_tar.getText());
					ps.setString(5, fecha.getText());
					ps.setString(6, rv.getText());
					ps.setString(7, articulo.getText());
					ps.setString(8, cantidad.getText());
					
					
					int res = ps.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(null, "Dato Guardado Correctamente");
						limpiartodo();
					} else {
						JOptionPane.showMessageDialog(null, "Error al guardar el dato");
					}
					conexion.close();
				} catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		btnPagar.setBounds(272, 328, 89, 23);
		contentPane.add(btnPagar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresar ing = new Ingresar();
				ing.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(506, 406, 89, 23);
		contentPane.add(btnRegresar);
		
		efectivo = new JRadioButton("Efectivo");
		efectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodo="Efectivo";
				 if (metodo.equals("Efectivo")) {
					 efectivo.setSelected(true); 
				    } else {
				    	tarjeta.setSelected(true); 
				    } 
			}
		});
		buttonGroup.add(efectivo);
		efectivo.setBounds(204, 96, 73, 25);
		contentPane.add(efectivo);
		
		JLabel lblNDeTarjeta = new JLabel("N\u00FAmero de tarjeta");
		lblNDeTarjeta.setForeground(new Color(255, 255, 255));
		lblNDeTarjeta.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNDeTarjeta.setBounds(37, 160, 117, 23);
		contentPane.add(lblNDeTarjeta);
		
		nu_tar = new JTextField();
		nu_tar.setBounds(204, 160, 157, 20);
		contentPane.add(nu_tar);
		nu_tar.setColumns(10);
		
		JLabel lblRv = new JLabel("RV");
		lblRv.setForeground(new Color(255, 255, 255));
		lblRv.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblRv.setBounds(37, 232, 46, 14);
		contentPane.add(lblRv);
		
		rv = new JTextField();
		rv.setBounds(204, 228, 69, 20);
		contentPane.add(rv);
		rv.setColumns(10);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento ");
		lblFechaDeVencimiento.setForeground(new Color(255, 255, 255));
		lblFechaDeVencimiento.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblFechaDeVencimiento.setBounds(37, 196, 117, 23);
		contentPane.add(lblFechaDeVencimiento);
		
		fecha = new JTextField();
		fecha.setBounds(204, 196, 89, 20);
		contentPane.add(fecha);
		fecha.setColumns(10);
		
		tarjeta = new JRadioButton("Tarjeta");
		tarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodo="Tarjeta";

			}
		});
		buttonGroup.add(tarjeta);
		tarjeta.setBounds(290, 96, 71, 25);
		contentPane.add(tarjeta);
		
		num_com = new JTextField();
		num_com.setBounds(204, 58, 157, 22);
		contentPane.add(num_com);
		num_com.setColumns(10);
		
		JLabel lblNmeroDeCompra = new JLabel("N\u00FAmero de Venta");
		lblNmeroDeCompra.setForeground(Color.WHITE);
		lblNmeroDeCompra.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNmeroDeCompra.setBounds(37, 58, 123, 23);
		contentPane.add(lblNmeroDeCompra);
		
		JLabel lblNombreDelTitular = new JLabel("Nombre del Titular");
		lblNombreDelTitular.setForeground(Color.WHITE);
		lblNombreDelTitular.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNombreDelTitular.setBounds(37, 134, 123, 23);
		contentPane.add(lblNombreDelTitular);
		
		nombre = new JTextField();
		nombre.setBounds(204, 133, 157, 22);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblIngresaElArticulo = new JLabel("Ingresa el art\u00EDculo");
		lblIngresaElArticulo.setForeground(Color.WHITE);
		lblIngresaElArticulo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblIngresaElArticulo.setBounds(37, 262, 117, 23);
		contentPane.add(lblIngresaElArticulo);
		
		articulo = new JTextField();
		articulo.setBounds(204, 261, 157, 22);
		contentPane.add(articulo);
		articulo.setColumns(10);
		
		JLabel lblIngresaLaCantidad = new JLabel("Ingresa la cantidad a pagar");
		lblIngresaLaCantidad.setForeground(Color.WHITE);
		lblIngresaLaCantidad.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblIngresaLaCantidad.setBounds(37, 294, 150, 23);
		contentPane.add(lblIngresaLaCantidad);
		
		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(204, 293, 157, 22);
		contentPane.add(cantidad);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion  = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("UPDATE pago SET ID_de_compra=?, Forma_de_Pago=?, Nombre_del_titular=?, Número_de_tarjeta=?, Fecha_de_vencimiento=?, RV=?, Articulo=?, Cantidad_a_pagar=? WHERE ID_de_compra=?");
					ps.setString(1, num_com.getText());
				    ps.setString(2, metodo);
					ps.setString(3, nombre.getText());
					ps.setString(4, nu_tar.getText());
					ps.setString(5, fecha.getText());
					ps.setString(6, rv.getText());
					ps.setString(7, articulo.getText());
					ps.setString(8, cantidad.getText());
					ps.setString(9, Buscar.getText());
					
					int res=ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "El pago a sido modificado");
						limpiartodo();
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al modificar el pago");
					}
					conexion.close();
				}catch(Exception e1) {
					System.err.println();
				}
			}
		});
		btnModificar.setBounds(37, 406, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("DELETE FROM pago WHERE ID_de_compra=?");
					ps.setInt(1, Integer.parseInt(Buscar.getText()));
					int res = ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null, "La compra se a cancelado");
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
		btnNewButton.setBounds(37, 368, 89, 25);
		contentPane.add(btnNewButton);
		
		Buscar = new JTextField();
		Buscar.setBounds(290, 406, 73, 22);
		contentPane.add(Buscar);
		Buscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = conectar();
					ps=conexion.prepareStatement("SELECT * FROM pago WHERE ID_de_compra = ?");
					ps.setString(1, Buscar.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
						num_com.setText(rs.getString("ID_de_compra"));
						if (metodo ==("Tarjeta")) {
							efectivo.setSelected(false);
							tarjeta.setSelected(true);
						}
						else {
							tarjeta.setSelected(false);
							efectivo.setSelected(true);
						}
						nombre.setText(rs.getString("Nombre_del_titular"));
						nu_tar.setText(rs.getString("Número_de_tarjeta"));
						fecha.setText(rs.getString("Fecha_de_vencimiento"));
						rv.setText(rs.getString("RV"));
						articulo.setText(rs.getString("Articulo"));
						cantidad.setText(rs.getString("Cantidad_a_pagar"));
						
					} else {
						JOptionPane.showMessageDialog(null, "No existe ese registro, favor de verificar");
					}
				}catch (Exception e1) {
					System.err.println(e1);
				}
			}
		});
		btnBuscar.setBounds(180, 405, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiartodo();	
			}
		});
		btnLimpiar.setBounds(148, 368, 97, 25);
		contentPane.add(btnLimpiar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(613, 0, 734, 351);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_de_compra", "Forma_de_Pago", "Nombre_del_titular", "Número_de_tarjeta", "Fecha_de_vencimiento", "RV", "Articulo", "Cantidad_a_pagar"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JLabel efec = new JLabel("");
		efec.setIcon(new ImageIcon("C:\\Users\\Eduar\\Downloads\\prt.jpg"));
		efec.setBounds(0, -35, 613, 514);
		contentPane.add(efec);
		
		JButton button = new JButton("Cancelar");
		button.setBounds(403, 327, 89, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Mostrar Base de datos");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					DefaultTableModel modelo = (DefaultTableModel)table.getModel();
					
					conexion = conectar();
					ps=conexion.prepareStatement("SELECT * FROM pago");
					
					rs.first();
					
					do {
						String[] fila = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
						modelo.addRow(fila);
					}while(rs.next());

					
				}catch (Exception e1) {
					System.err.println(e1);
				}
		
			}
		});
		button_1.setBounds(920, 394, 188, 25);
		contentPane.add(button_1);
	}
}
