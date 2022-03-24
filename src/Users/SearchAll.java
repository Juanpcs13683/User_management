package Users;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Clase que contiene el entorno grafico que permite buscar todos los usuarios existentes en la base de datos.
 * @author juanpcs
 *
 */
public class SearchAll {
	public static void main(String[] args) {
		SearchAll findAll = new SearchAll();
		findAll.findAll();
	}
	
	/**
	 * Metodo que contiene los elementos del entorno grafico tales como cuadros de texto y botones.
	 */
	public void findAll() {
		JFrame window = new JFrame("All Users");
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setResizable(false);
		List<String> columns = new ArrayList<>();
		List<String[]> values = new ArrayList<>();
		
		window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//adding titles
		columns.add("Name");
		columns.add("Last Name");
		columns.add("Birth Day");
		columns.add("Email");
		columns.add("Number");
		columns.add("Company");
		
		//adding dates and connecting
		UserController db = new UserController();
		
		try {
			db.conectar();
			db.sentencia = db.conexion.createStatement();
			ArrayList<UserVO> users_list = db.allUsers();
			for(UserVO user: users_list) {
				values.add(new String[] {
					user.getName(),
					user.getLastName(),
					user.getBirthday(),
					user.getEmail(),
					Long.toString(user.getNumber()),
					user.getCompany()
				});
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
		
		//  creating a new table model about given data
		TableModel tablemodel1 = new DefaultTableModel(values.toArray(new Object[][] {}),columns.toArray());
		
		// giving model to table
		JTable table = new JTable(tablemodel1);
		
		// configurando el ordenamiento en la tabla
		window.setLayout(new BorderLayout());
		
		// adding scroll to window
		window.add(new JScrollPane(table), BorderLayout.CENTER);
		
		// configurando cabecera de la tabla
		window.add(table.getTableHeader(), BorderLayout.NORTH);
		
		// window now visible
		window.setVisible(true);
		
		// cerrando conexion con tabla
		db.close();
	}
}
