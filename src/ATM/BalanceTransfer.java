package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class BalanceTransfer extends JFrame {

	private JPanel contentPane;
	private JTextField Accountno;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceTransfer frame = new BalanceTransfer();
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
	public BalanceTransfer() {
		setTitle("Balance Transfer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNo = new JLabel("Account No:");
		lblAccountNo.setForeground(Color.WHITE);
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccountNo.setBounds(70, 57, 95, 14);
		contentPane.add(lblAccountNo);
		
		Accountno = new JTextField();
		Accountno.setForeground(new Color(255, 255, 255));
		Accountno.setBackground(Color.BLACK);
		Accountno.setBounds(171, 43, 157, 40);
		contentPane.add(Accountno);
		Accountno.setColumns(10);
		
		JLabel balancelabel = new JLabel("Balance:");
		balancelabel.setForeground(Color.WHITE);
		balancelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		balancelabel.setBounds(94, 118, 63, 14);
		contentPane.add(balancelabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(171, 104, 157, 40);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String bal=textField.getText();
				String account=Accountno.getText();
				int balance=Integer.parseInt(bal);
				try {
					BufferedReader br = new BufferedReader(new FileReader("clients.txt"));
					BufferedReader out = new BufferedReader(new FileReader("account.txt"));
					BufferedWriter wr = new BufferedWriter(new FileWriter("update.txt"));
					String line="";
					try {
						String linep=out.readLine();
						try {
							
							while((line=br.readLine())!=null) {
								
								String [] s=line.split(" ");
								int balance1=Integer.parseInt(s[2]);
								if(s[0].compareTo(linep)!=0) {
									wr.write(line);
									wr.newLine();
											
									}
								else {
									
									if(balance1>balance) {
										while((line=br.readLine())!=null) {
											
											String [] s1=line.split(" ");
											if(s1[0].equals(account)) {
												int total_balance_s=balance1-balance;
												String a1 = s[0]+" "+s[1]+" "+total_balance_s;
												wr.write(a1);
												wr.newLine();
												int s1_bal =Integer.parseInt(s1[2]);
											int	total_balance_s1=s1_bal+balance;
											String a = s1[0]+" "+s1[1]+" "+total_balance_s1;
											wr.write(a);
											wr.newLine();
											Accountno.setText(null);
											textField.setText(null);
											JOptionPane.showMessageDialog(null,"successfully transfer : "+balance+"tk");

											}
										}
										}	
									
									
								}
									
								}
								
							wr.close();	
							
						} catch (IOException e) {
						
							e.printStackTrace();
						}
						
						
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					String upda;
					BufferedReader up = new BufferedReader(new FileReader("update.txt"));
					BufferedWriter ws = new BufferedWriter(new FileWriter("clients.txt"));
					while((upda=up.readLine())!=null) {
						ws.write(upda);	
						ws.newLine();
					}
					ws.close();
			
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(100, 187, 89, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Menu frame = new Menu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(225, 186, 89, 33);
		contentPane.add(btnNewButton_1);
	}

}
