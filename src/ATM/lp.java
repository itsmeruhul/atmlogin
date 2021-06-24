package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
public class lp extends JFrame {

	private JPanel lp;
	private JTextField accounttxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lp frame = new lp();
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
	public lp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 380);
		lp = new JPanel();
		lp.setBackground(Color.GRAY);
		lp.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(lp);
		lp.setLayout(null);
		
//atm machine label		
		
		JLabel lblAtmMachine = new JLabel("ATM LOGIN SYSTEM");
		lblAtmMachine.setForeground(Color.WHITE);
		lblAtmMachine.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAtmMachine.setBounds(80, 32, 297, 29);
		lp.add(lblAtmMachine);
		
//account no label		
		
		JLabel lblAccountNo = new JLabel("Account No :");
		lblAccountNo.setForeground(Color.WHITE);
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccountNo.setBounds(91, 107, 90, 14);
		lp.add(lblAccountNo);
		
//password label		
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(104, 175, 81, 14);
		lp.add(lblPassword);
		
//account no text field		
		
		accounttxt = new JTextField();
		accounttxt.setForeground(Color.WHITE);
		accounttxt.setBackground(Color.BLACK);
		accounttxt.setBounds(195, 98, 142, 37);
		lp.add(accounttxt);
		accounttxt.setColumns(10);
		
//password text field	
		
		passwordtxt = new JPasswordField();
		passwordtxt.setForeground(Color.WHITE);
		passwordtxt.setBackground(Color.BLACK);
		passwordtxt.setBounds(195, 166, 142, 37);
		lp.add(passwordtxt);
		
//submit button		
		
		JButton submit = new JButton("Submit");
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
								PrintWriter a=new PrintWriter(new FileWriter("account.txt"));
								PrintWriter b=new PrintWriter(new FileWriter("password.txt"));
								a.print(account);
								b.print(pass);
								a.close();
								b.close();
								lp.setVisible(false);
							       Menu frame = new Menu();
									frame.setVisible(true);
									dispose();
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
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.BLACK);
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setBounds(68, 246, 90, 37);
		lp.add(submit);
		
//reset button		
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accounttxt.setText(null);
				passwordtxt.setText(null);
			}
		});
		reset.setFont(new Font("Tahoma", Font.BOLD, 14));
		reset.setBackground(Color.BLACK);
		reset.setForeground(Color.WHITE);
		reset.setBounds(181, 246, 81, 37);
		lp.add(reset);
		
//exit button		
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.BLACK);
		exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		exit.setBounds(282, 246, 81, 37);
		lp.add(exit);
		
	}
}
