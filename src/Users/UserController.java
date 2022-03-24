package Users;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * Clase que representa el controlador en el cual se realizan todas las operaciones CRUD
 * asociadas al usuario en la base de datos.
 * @author juanpcs
 *
 */
public class UserController {
	

	// Cargamos la libreria
	/**
	 * Metodo constructor que permite instanciar la clase, y que ademas carga la libreria
	 * que permite a java la conexion a Sql.
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar la libreria");
		}	
	}
	
	//para bases de datos 3 sentencias especiales
	// Connection: para indicar donde esta la base de datos
	//Statement: para usar enuncuados en sql
	//ResltSet: para traer las respuestas del enunciado
	
	/**
	 * Instancia del objeto connection que permite la conexion a la base de datos.
	 */
	Connection conexion; // sentencia que permite la conexion a la base de datos
	
	/**
	 * Instancia del obtejo Statement que permite realizar sentencias con peticiones
	 *  a la base de datos.
	 */
	Statement sentencia; // permite hacer sentencias o escritos a la base de datos sql
	
	/**
	 * Instancia del objeto ResultSet que permite almacenar los resultados de las peticiones
	 * a la base de datos.
	 */
	ResultSet resultado; // Objeto que donde se almacenan los resusltados de las solicitudes
	
	//conectar y crear db en caso de no existencia
	/**
	 * Metodo que permite inicializar la conexion entre Java y la base de datos sql.
	 */
	void conectar() {
		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:DBusers");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
	//int en numeros xq es lo mismo para long
	/**
	 * Metodo que crea la base de datos en caso de no existir, y crea consigo una tabla
	 * donde se almacenaran los datos de los usuarios.
	 */
	void createTable() {
		try {
			sentencia = conexion.createStatement();
			sentencia.execute("create table if not exists users("
					+ "name varchar,"
					+ "lastName varchar,"
					+ "birthday varchar,"
					+ "email varchar,"
					+ "number int,"
					+ "company varchar"
					+")");
		}catch(SQLException ex) {
			System.out.println("Error al crear tabla: "+ex.getMessage());
		}
	}
	
	//insertar nuevo usuario
	/**
	 * Metodo que permite insertar un usuario en la base de datos creada anteriormente.
	 * @param name Nombre del usuario.
	 * @param lastName Apellido del usuario.
	 * @param birthday Fecha de nacimiento del usuario.
	 * @param email Correo electronico del usuario.
	 * @param number Numero telefonico del usuario.
	 * @param company Compañia de trabajo del usuario.
	 */
	void insert(String name, String lastName, String birthday, String email, long number, String company) {
		try {	
			sentencia = conexion.createStatement();
			sentencia.execute("insert into users values("
					+ "'" + name + "',"
					+ "'" + lastName + "',"
					+ "'" + birthday + "',"
					+ "'" + email +"',"
					+ "" + number +","
					+ "'" + company +"'"
					+")");
		}catch(SQLException ex) {
			System.out.println("Error al insertar usuario: "+ex.getErrorCode());
		}
	}
	
	//consultar todo
	/**
	 * Metodo que permite consutar todos los usuario existentes en la base de datos.
	 * @return Arreglo de usuarios.
	 */
	ArrayList<UserVO> allUsers(){
		ArrayList<UserVO> lista_usuarios = new ArrayList<>();
		try {
			resultado = sentencia.executeQuery("select * from users ;");
			while(resultado.next()) {
				lista_usuarios.add(new UserVO(
						resultado.getString(1),
						resultado.getString(2),
						resultado.getString(3),
						resultado.getString(4),
						resultado.getLong(5),
						resultado.getString(6)
						));
			}
		}catch(SQLException ex) {
			System.out.println("Error al listar usuarios: "+ex.getMessage());
		}
		return lista_usuarios;
	}
	
	
	//buscar usuario
	/**
	 * Metodo que permite consultar si existe un usuario tomando como parametro el correo electronico del mismo.
	 * @param email Correo electronico del usuario a buscar.
	 * @return Usuario.
	 */
	UserVO findUser(String email) {
		UserVO user = null;
		try {
			resultado = sentencia.executeQuery("select * from users WHERE email ='"+ email + "'");
			while(resultado.next()) {
				user = new UserVO(
						resultado.getString(1),
						resultado.getString(2),
						resultado.getString(3),
						resultado.getString(4),
						resultado.getLong(5),
						resultado.getString(6));
			}
		}catch(SQLException ex) {
			System.out.println("Error al buscar usuario: "+ex.getMessage());
		}
		return user;
	}
	
	//modificar usuario
	/**
	 * Metodo que permite modificar algunos atributos de un usuario almacenado en la base de datos.
	 * @param email Correo electronico actual del usuario.
	 * @param number Numero telefonico a actualizar del usuario.
	 * @param company Compañia de trabajo a actualizar del usuario. 
	 * @param newEmail Correo electronico a actualizar del usuario.
	 */
	void updateUser(String email, long number, String company, String newEmail) {
		try {
			sentencia.execute("UPDATE users "
					+"SET email ='" + newEmail + "',"
					+"number = " + number + ","
					+"company = '" + company + "'"
					+"WHERE email = '" + email + "';");
			
		}catch(SQLException ex) {
			System.out.println("Error al actualizar: "+ex.getMessage());
		}
	}
	
	// eliminar
	/**
	 * Metodo que permite eliminar un usuario existente en la base de datos tomando como parametro su correo electronico.
	 * @param email Correo electronico del usuario.
	 */
	void elimina(String email){
		try {
			sentencia.execute("DELETE FROM users WHERE email = '" + email + "';");
		}catch(SQLException ex) {
		System.out.println("Error al eliminar usuario: "+ex.getMessage());
		}
	}
	
	// cerrar la conexion
	/**
	 * Metodo que permite cerrar las conexiones a la base de datos.
	 */
	void close() {
		try {
			sentencia.close();
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			conexion.close();
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			resultado.close();
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
