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
 * Clase que contiene el entorno grafico que permite la busqueda y actualizacion de un usuario especifico.
 * @author juanpcs
 *
 */
public class Update {
	public static void main(String[] args) {
		Update update = new Update();
		update.update();
	}
	
	/**
	 * Metodo que contiene los elementos del entorno grafico, tales como cuadros de texto y botones.
	 */
	public void update() {
		JFrame window = new JFrame("Update User");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel labelsearch = new JLabel("User for update");
		JTextField search = new JTextField(15);
		
		JLabel labelname = new JLabel("Name");
		JTextField name = new JTextField(15);
		name.setEditable(false);
		
		JLabel labellastName = new JLabel("Last Name");
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
		searchButton.setForeground(Color.GREEN);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserVO user = null;
				UserController db = new UserController();
				try {
					db.conectar();
					db.sentencia = db.conexion.createStatement();
					user = db.findUser(search.getText());
					name.setText(user.getName());
					lastName.setText(user.getLastName());
					birthday.setText(user.getBirthday());
					email.setText(user.getEmail());
					email.setEditable(true);
					number.setText(Long.toString(user.getNumber()));
					number.setEditable(true);
					company.setText(user.getCompany());
					company.setEditable(true);
					db.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton updateButton = new JButton("Update");
		updateButton.setBackground(Color.RED);
		updateButton.setForeground(Color.yellow);
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserController db = new UserController();
				UserVO user = null;
				try {
					db.conectar();
					db.sentencia = db.conexion.createStatement();
					db.updateUser(
							search.getText(),
							Long.parseLong(number.getText()),
							company.getText(),
							email.getText());
					JOptionPane.showMessageDialog(null, "User updated succesfully");
					db.conexion.close();
					db.sentencia.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), 
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panel.add(labelsearch);
		panel.add(search);
		panel.add(labelname);
		panel.add(name);
		panel.add(labellastName);
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
		panel.add(updateButton);
		
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		window.setSize(200, 390);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
	}
}
