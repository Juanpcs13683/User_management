package Users;

import java.sql.*;
import java.util.ArrayList;



public class UserController {
	

	// Cargamos la libreria
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
	
	Connection conexion; // sentencia que permite la conexion a la base de datos
	Statement sentencia; // permite hacer sentencias o escritos a la base de datos sql
	ResultSet resultado; // Objeto que donde se almacenan los resusltados de las solicitudes
	
	//conectar y crear db en caso de no existencia
	void conectar() {
		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:DBusers");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
	//int en numeros xq es lo mismo para long
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
	ArrayList<UserVO> consultarTodo(){
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
	void updateUser(String email, long number, String company) {
		try {
			sentencia.execute("UPDATE users"
					+"SET email ='" + email + "',"
					+"number = " + number + ","
					+"company = '" + company + "'"
					+"WERE email = '" + email + "';");
			
		}catch(SQLException ex) {
			System.out.println("Error al actualizar: "+ex.getMessage());
		}
	}
	
	// eliminar
	void elimina(String email){
		try {
			sentencia.execute("DELETE FROM users WHERE email = '" + email + "';");
		}catch(SQLException ex) {
		System.out.println("Error al eliminar usuario: "+ex.getMessage());
		}
	}
}
