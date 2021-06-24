package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ChangePin extends JFrame {

	private JPanel contentPane;
	private JTextField newpin;
	private JTextField confirmpin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePin frame = new ChangePin();
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
	public ChangePin() {
		setTitle("Change Pin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//new pin label		
		
		JLabel lblOldPin = new JLabel("New Pin:");
		lblOldPin.setForeground(Color.WHITE);
		lblOldPin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldPin.setBounds(117, 58, 63, 14);
		contentPane.add(lblOldPin);
		
//confirm pin field		
		
		newpin = new JTextField();
		newpin.setForeground(new Color(255, 255, 255));
		newpin.setBackground(Color.BLACK);
		newpin.setBounds(190, 45, 139, 39);
		contentPane.add(newpin);
		newpin.setColumns(10);
		
//new pin label		
		
		JLabel lblNewPin = new JLabel("Confirm Pin:");
		lblNewPin.setForeground(Color.WHITE);
		lblNewPin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPin.setBounds(91, 121, 89, 14);
		contentPane.add(lblNewPin);
		
//confirm pin field		
		
		confirmpin = new JTextField();
		confirmpin.setBackground(Color.BLACK);
		confirmpin.setForeground(new Color(255, 255, 255));
		confirmpin.setColumns(10);
		confirmpin.setBounds(190, 106, 139, 39);
		contentPane.add(confirmpin);
		
//submit button		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BufferedReader clients = new BufferedReader(new FileReader("clients.txt"));
					BufferedReader password = new BufferedReader(new FileReader("password.txt"));
					BufferedReader account = new BufferedReader(new FileReader("account.txt"));
						BufferedWriter write= new BufferedWriter(new FileWriter("update.txt"));
					
					String line="";
						
						String acc=account.readLine(); //read account no
					
					String pin=newpin.getText(); // getText new pin
					String confirm=confirmpin.getText(); // getText confirm pin
					if(pin.equals(confirm)) {
						try {
							while((line=clients.readLine())!=null) {
								String s[]=line.split(" ");
								if(s[0].equals(acc)) {
									JOptionPane.showMessageDialog(null,"Pin has Changed");
									newpin.setText(null);
									confirmpin.setText(null);
									String l1=s[0]+" "+pin+" "+s[2];
									write.write(l1);
									write.newLine();
								}
								else {
									write.write(line);
									write.newLine();
								}
							}
							write.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Pin not Match");
						newpin.setText(null);
						confirmpin.setText(null);
						while((line=clients.readLine())!=null) {
							write.write(line);	
							write.newLine();
						}
						write.close();
					}
					String upda;
					BufferedReader up = new BufferedReader(new FileReader("update.txt"));
					BufferedWriter ws = new BufferedWriter(new FileWriter("clients.txt"));
					while((upda=up.readLine())!=null) {
						ws.write(upda);	
						ws.newLine();
					}
					ws.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(117, 175, 89, 32);
		contentPane.add(btnSubmit);
		
//back button		
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(240, 175, 89, 32);
		contentPane.add(btnBack);
	}

}
