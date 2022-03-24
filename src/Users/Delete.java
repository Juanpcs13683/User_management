package Users;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que contiene el entorno grafico dedicado a la busqueda y eliminacion de un usuario especifico.
 * @author juanpcs
 *
 */
public class Delete {
	public static void main(String[] args) {
		Delete delete = new Delete();
		delete.delete();
	}
	
	/**
	 * Metodo que contiene los elementos graficos del entorno.
	 */
	public void delete() {
		JFrame window = new JFrame("Delete User");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
	JLabel labelsearch = new JLabel("Search user");
	JTextField search = new JTextField(15);
	
	JLabel labelname = new JLabel("Name");
	JTextField name = new JTextField(15);
	name.setEditable(false);
	
	JLabel labelLastName = new JLabel("Last Name");
	JTextField lastName = new JTextField(15);
	lastName.setEditable(false);
	
	JLabel labelbirthday = new JLabel("Birthday");
	JTextField birthday = new JTextField(15);
	birthday.setEditable(false);
	
	JLabel labelemail = new JLabel("Email");
	JTextField email = new JTextField(15);
	email.setEditable(false);
	
	JLabel labelnumber = new JLabel("Number");
	JTextField number = new JTextField(15);
	number.setEditable(false);
	
	JLabel labelcompany = new JLabel("Company");
	JTextField company = new JTextField(15);
	company.setEditable(false);
	
	JButton searchButton = new JButton("Search");
	searchButton.setBackground(Color.BLUE);
	searchButton.setForeground(Color.green);
	searchButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			UserController db = new UserController();
			UserVO user = null;
			try {
				db.conectar();
				db.sentencia = db.conexion.createStatement();
				user = db.findUser(search.getText());
				name.setText(user.getName());
				lastName.setText(user.getLastName());
				birthday.setText(user.getBirthday());
				email.setText(user.getEmail());
				number.setText(Long.toString(user.getNumber()));
				company.setText(user.getCompany());
				db.conexion.close();
				db.sentencia.close();
				db.resultado.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
						"error", JOptionPane.ERROR_MESSAGE);
			}
		}
	});
	
	JButton deleteButton = new JButton("Delete");
	deleteButton.setBackground(Color.red);
	deleteButton.setForeground(Color.yellow);
	deleteButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			UserController db = new UserController();
			try {
				db.conectar();
				db.sentencia = db.conexion.createStatement();
				db.elimina(email.getText());
				JOptionPane.showMessageDialog(null, "Delete succesfully");
				search.setText(null);
				name.setText(null);
				lastName.setText(null);
				birthday.setText(null);
				email.setText(null);
				number.setText(null);
				company.setText(null);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: "+
						ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
		}
	});
	
	panel.add(labelsearch);
	panel.add(search);
	panel.add(labelname);
	panel.add(name);
	panel.add(labelLastName);
	panel.add(lastName);
	panel.add(labelbirthday);
	panel.add(birthday);
	panel.add(labelemail);
	panel.add(email);
	panel.add(labelnumber);
	panel.add(number);
	panel.add(labelcompany);
	panel.add(company);
	panel.add(searchButton);
	panel.add(deleteButton);
	
	window.add(panel);
	window.setBackground(Color.blue);
	window.setSize(200, 390);
	window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	window.setLocationRelativeTo(null);
	window.setVisible(true);
	}
}
