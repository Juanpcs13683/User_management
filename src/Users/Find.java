package Users;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Find {
	public static void main(String[] args) {
		Find find = new Find();
		find.find();
	}
	
	public void find() {
		JFrame window = new JFrame("Find User");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel labelfind = new JLabel("Email to search");
		JTextField find = new JTextField(15);
		
		JLabel labelname = new JLabel("Name");
		JTextField name = new JTextField(15);
		name.setEnabled(false);
		
		JLabel labellastName = new JLabel("Last Name");
		JTextField lastName = new JTextField(15);
		lastName.setEnabled(false);
		
		JLabel labelbirthday = new JLabel("Birthday");
		JTextField birthday = new JTextField(15);
		birthday.setEnabled(false);
		
		JLabel labelemail = new JLabel("Email");
		JTextField email = new JTextField(15);
		email.setEnabled(false);
		
		JLabel labelnumber = new JLabel("Number");
		JTextField number = new JTextField(15);
		number.setEnabled(false);
		
		JLabel labelcompany = new JLabel("Company");
		JTextField company = new JTextField(15);
		company.setEnabled(false);
		
		JButton findButton = new JButton("Find");
		findButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserVO user = null;
				UserController db = new UserController();
				try {
					db.conectar();
					db.sentencia = db.conexion.createStatement();
					user = db.findUser(find.getText());
					name.setText(user.getName());
					lastName.setText(user.getLastName());
					birthday.setText(user.getBirthday());
					email.setText(user.getEmail());
					number.setText(Long.toString(user.getNumber()));
					company.setText(user.getCompany());
					db.conexion.close();
					db.resultado.close();
					db.sentencia.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panel.add(labelfind);
		panel.add(find);
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
		panel.add(findButton);
		
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		window.setSize(200, 390);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
