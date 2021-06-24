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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.awt.event.ActionEvent;

public class Withdrew extends JFrame {

	private JPanel frmwithdrew;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrew frame = new Withdrew();
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
	public Withdrew() {
		setTitle("Withdrew Balance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 267);
		frmwithdrew = new JPanel();
		frmwithdrew.setBackground(Color.GRAY);
		frmwithdrew.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frmwithdrew);
		frmwithdrew.setLayout(null);
		
//enter balance label		
		
		JLabel enterbalance = new JLabel("Enter Balane :");
		enterbalance.setForeground(Color.WHITE);
		enterbalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		enterbalance.setBounds(56, 58, 125, 20);
		frmwithdrew.add(enterbalance);
		
//enter balance text field		
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(Color.BLACK);
		textField.setBounds(191, 48, 141, 39);
		frmwithdrew.add(textField);
		textField.setColumns(10);
		
//submit button		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("clients.txt"));
					BufferedReader out = new BufferedReader(new FileReader("account.txt"));
					BufferedWriter wr = new BufferedWriter(new FileWriter("update.txt"));
					String line="";
					String linep=out.readLine();
					try {
						while((line=br.readLine())!=null) {
							
							String [] s=line.split(" ");
							
							if(linep.equals(s[0])) {
								String bl=s[2];
								int b=Integer.parseInt(bl);
								String bl2=textField.getText();
								int c=Integer.parseInt(bl2);
								if(c<0) {
									JOptionPane.showMessageDialog(null,"Not Enough Balance For Withdrew");
									textField.setText(null);
									wr.write(line);
								}
								else if(c>b) {
									JOptionPane.showMessageDialog(null,"Your Entered Balance Cross the Current Balance");
									textField.setText(null);
								    wr.write(line);
								}
								else if(c>0 && c<=b) {
								int d=b-c;
								String p= d+ "";
								JOptionPane.showMessageDialog(null,"Available Balance : "+p);
								textField.setText(null);
							    String l1=s[0]+" "+s[1]+" "+ p+" ";
							    wr.write(l1);
							    wr.newLine();
								}
							}
							else {
								wr.write(line);
								wr.newLine();
							}
							
						}
						wr.flush();
						wr.close();
						
						String upda;
						BufferedReader up = new BufferedReader(new FileReader("update.txt"));
						BufferedWriter ws = new BufferedWriter(new FileWriter("clients.txt"));
						while((upda=up.readLine())!=null) {
							ws.write(upda);	
							ws.newLine();
						}
						ws.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					
					e2.printStackTrace();
				}	
		
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(104, 137, 89, 30);
		frmwithdrew.add(btnSubmit);
		
//back button		
		
		JButton btnback = new JButton("Back");
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBackground(Color.BLACK);
		btnback.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame = new Menu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnback.setBounds(229, 137, 89, 30);
		frmwithdrew.add(btnback);
	}

}
