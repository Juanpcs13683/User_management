package Users;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PrincipalVista {
	public static void main(String[] args) {
		JFrame window = new JFrame("Users management");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton InsertButton = new JButton("Insert");
		InsertButton.setBackground(Color.blue);
		InsertButton.setForeground(Color.white);
		InsertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Insert insert = new Insert();
					insert.insert();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton searchButton = new JButton("Search User");
		searchButton.setBackground(Color.green);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Search search = new Search();
					search.find();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton searchAllButton = new JButton("Search All");
		searchAllButton.setBackground(Color.CYAN);
		searchAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					SearchAll searchall = new SearchAll();
					searchall.findAll();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton updateButton = new JButton("Update User");
		updateButton.setBackground(Color.yellow);
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Update update = new Update();
					update.update();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton deleteButton = new JButton("Delete User");
		deleteButton.setBackground(Color.red);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Delete delete = new Delete();
					delete.delete();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panel.add(InsertButton);
		panel.add(searchButton);
		panel.add(searchAllButton);
		panel.add(updateButton);
		panel.add(deleteButton);
		
		window.add(panel);
		window.setSize(200,200);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
}
