package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel frmmenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 338);
		frmmenu = new JPanel();
		frmmenu.setBackground(Color.GRAY);
		frmmenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frmmenu);
		frmmenu.setLayout(null);

//Account details label	
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setForeground(Color.WHITE);
		lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAccountDetails.setBounds(135, 21, 190, 27);
		frmmenu.add(lblAccountDetails);
		
//balance button
		
		JButton balancebtn = new JButton("Balance");
		balancebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balance bala=new balance();
				bala.setVisible(true);
				dispose();
				
			}
		});
		balancebtn.setForeground(Color.WHITE);
		balancebtn.setBackground(Color.BLACK);
		balancebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		balancebtn.setBounds(27, 71, 147, 37);
		frmmenu.add(balancebtn);
		
//changepin button		
		
		JButton changepinbtn = new JButton("Change Pin");
		changepinbtn.setForeground(new Color(255, 255, 255));
		changepinbtn.setBackground(Color.BLACK);
		changepinbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		changepinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePin frame = new ChangePin();
				frame.setVisible(true);
				dispose();
			}
		});
		changepinbtn.setBounds(270, 150, 139, 37);
		frmmenu.add(changepinbtn);

//balancetransfer button
		
		JButton balancetransferbtn = new JButton("Money Transfer");
		balancetransferbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceTransfer frame = new BalanceTransfer();
				frame.setVisible(true);
				dispose();
			}
		});
		balancetransferbtn.setBackground(Color.BLACK);
		balancetransferbtn.setForeground(new Color(255, 255, 255));
		balancetransferbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		balancetransferbtn.setBounds(27, 150, 147, 37);
		frmmenu.add(balancetransferbtn);

//Withdrew button		
		
		JButton withdrewbtn = new JButton("Withdrew");
		withdrewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Withdrew with=new Withdrew();
				with.setVisible(true);
				dispose();
			}
		});
		withdrewbtn.setForeground(Color.WHITE);
		withdrewbtn.setBackground(Color.BLACK);
		withdrewbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		withdrewbtn.setBounds(270, 71, 139, 37);
		frmmenu.add(withdrewbtn);
		
//Exit button		
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitbtn.setForeground(new Color(255, 255, 255));
		exitbtn.setBackground(Color.BLACK);
		exitbtn.setBounds(176, 225, 89, 37);
		frmmenu.add(exitbtn);
	}
}
