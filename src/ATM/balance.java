package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class balance extends JFrame {

	private JPanel ftmbalance;
	private JTextField balancefield;
	private JButton balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					balance frame = new balance();
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
	public balance() {
		setTitle("Balance Check");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 275);
		ftmbalance = new JPanel();
		ftmbalance.setBackground(Color.GRAY);
		ftmbalance.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ftmbalance);
		ftmbalance.setLayout(null);
	
//Back Button		
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame = new Menu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(268, 138, 89, 41);
		ftmbalance.add(btnBack);
		
//Balance Check field	
		
		JLabel lblYourAvailableBalance = new JLabel("Your Available Balance :");
		lblYourAvailableBalance.setForeground(Color.WHITE);
		lblYourAvailableBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourAvailableBalance.setBounds(23, 65, 196, 41);
		ftmbalance.add(lblYourAvailableBalance);
		
		balancefield = new JTextField();
		balancefield.setForeground(new Color(255, 255, 255));
		balancefield.setBackground(Color.BLACK);
		balancefield.setBounds(216, 65, 159, 41);
		ftmbalance.add(balancefield);
		balancefield.setColumns(10);
		
		balance = new JButton("Check Balance");
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						BufferedReader br = new BufferedReader(new FileReader("clients.txt"));
						BufferedReader out = new BufferedReader(new FileReader("account.txt"));
						String line="";
						String linep=out.readLine();
						
						
						try {
							while((line=br.readLine())!=null) {
								
								String [] s=line.split(" ");
								
								if(linep.equals(s[0])) {
									balancefield.setText(s[2]);
								}
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
			}
		});
		balance.setForeground(Color.WHITE);
		balance.setFont(new Font("Tahoma", Font.BOLD, 14));
		balance.setBackground(Color.BLACK);
		balance.setBounds(92, 138, 145, 41);
		ftmbalance.add(balance);
	}
}

