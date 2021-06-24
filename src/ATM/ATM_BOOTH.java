package ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class ATM_BOOTH {

	public JFrame frmAtmbooth;
	private JTextField accounttxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM_BOOTH window = new ATM_BOOTH();
					window.frmAtmbooth.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM_BOOTH() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAtmbooth = new JFrame();
		frmAtmbooth.setTitle("ATM_BOOTH");
		frmAtmbooth.getContentPane().setBackground(Color.GRAY);
		frmAtmbooth.setBounds(450, 200, 450, 380);
		frmAtmbooth.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAtmbooth.getContentPane().setLayout(null);
		
//ATM BOOTH SYSTEM label
		
		JLabel lblNewLabel = new JLabel("ATM BOOTH SYSTEM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(103, 29, 248, 24);
		frmAtmbooth.getContentPane().add(lblNewLabel);
		
//Account No label
		
		JLabel lblAccountNo = new JLabel("Account No:");
		lblAccountNo.setForeground(Color.WHITE);
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccountNo.setBounds(93, 101, 86, 14);
		frmAtmbooth.getContentPane().add(lblAccountNo);
		
//account no field		
		
		accounttxt = new JTextField();
		accounttxt.setForeground(Color.WHITE);
		accounttxt.setBackground(Color.BLACK);
		accounttxt.setBounds(189, 93, 137, 34);
		frmAtmbooth.getContentPane().add(accounttxt);
		accounttxt.setColumns(10);
		
//Password label
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(99, 164, 78, 26);
		frmAtmbooth.getContentPane().add(lblPassword);
		
//password field
		
		passwordtxt = new JPasswordField();
		passwordtxt.setForeground(Color.WHITE);
		passwordtxt.setBackground(Color.BLACK);
		passwordtxt.setBounds(189, 162, 137, 34);
		frmAtmbooth.getContentPane().add(passwordtxt);
		
//submit button
		
		JButton submit = new JButton("Submit");
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setBackground(Color.BLACK);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String account=accounttxt.getText();
				String pass=passwordtxt.getText();
			     try {
					BufferedReader br=new BufferedReader(new FileReader("clients.txt"));
					String line="";
					try {
						while((line=br.readLine())!=null) {
							String [] s=line.split(" ");
							if((account.equals(s[0]) && (pass.equals(s[1])))) {
								frmAtmbooth.setVisible(false);
							       Menu frame = new Menu();
									frame.setVisible(true);
									return;
							}
							
						}
						accounttxt.setText(null);
					    passwordtxt.setText(null);
					    JOptionPane.showMessageDialog(null,"Invalid ! Try Again !!");    
					
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}  
			}
		});
		submit.setBounds(73, 251, 89, 34);
		frmAtmbooth.getContentPane().add(submit);
		
//reset button
		
		JButton reset = new JButton("Reset");
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Tahoma", Font.BOLD, 14));
		reset.setBackground(Color.BLACK);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accounttxt.setText(null);
				passwordtxt.setText(null);
			}
		});
		reset.setBounds(178, 251, 89, 34);
		frmAtmbooth.getContentPane().add(reset);	
		
//Exit button
		
		JButton exit = new JButton("Exit");
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		exit.setBackground(Color.BLACK);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(288, 251, 89, 34);
		frmAtmbooth.getContentPane().add(exit);
	}
}
