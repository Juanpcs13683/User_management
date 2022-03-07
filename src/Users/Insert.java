package Users;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Insert {
	public static void main(String[] args) {
		Insert i = new Insert();
		i.insert();
	}
	
	public void insert() {
		JFrame window = new JFrame("Insert");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel labelname = new JLabel("Name");
		JTextField name = new JTextField(15);
		
		JLabel labellastName = new JLabel("Last Name");
		JTextField lastName = new JTextField(15);
		
		JLabel labelbirthday = new JLabel("Birthday");
		JTextField birthday = new JTextField(15);
		
		JLabel labelemail = new JLabel("Email");
		JTextField email = new JTextField(15);
		
		JLabel labelnumber = new JLabel("Number");
		JTextField number = new JTextField(15);
		
		JLabel labelcompany = new JLabel("Company");
		JTextField company = new JTextField(15);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserController db = new UserController();
				try {
					db.conectar();
					db.sentencia = db.conexion.createStatement();
					db.createTable();
					db.insert(
							name.getText(),
							lastName.getText(),
							birthday.getText(),
							email.getText(),
							Long.parseLong(number.getText()),
							company.getText());
							db.conexion.close();
							db.sentencia.close();
							JOptionPane.showMessageDialog(null, "Usuario creado con exito");
							
							//get textField vacio
							name.setText(null);
							lastName.setText(null);
							birthday.setText(null);
							email.setText(null);
							number.setText(null);
							company.setText(null);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panel.add(labelname);
		panel.add(name);
		panel.add(labellastName);
		panel.add(labellastName);
		panel.add(lastName);
		panel.add(labelbirthday);
		panel.add(birthday);
		panel.add(labelemail);
		panel.add(email);
		panel.add(labelbirthday);
		panel.add(birthday);
		panel.add(labelnumber);
		panel.add(number);
		panel.add(labelcompany);
		panel.add(company);
		panel.add(saveButton);
		
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		window.setSize(200, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
