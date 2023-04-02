import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
public class MyATM {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyATM window = new MyATM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	int[] arr=new int[4];
	Scanner sc=new Scanner(System.in);
	 double balance;
     double depositeAmt;
     double withdrawAmount;
     Map<Double,String> TransHistory=new HashMap<>();
    //default constructor
    
	private JTextField ATMno;
	
	public MyATM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 1020, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ATMno = new JTextField();
		ATMno.setBounds(368, 169, 231, 20);
		frame.getContentPane().add(ATMno);
		ATMno.setColumns(10);
		
		JLabel Screen = new JLabel("Enter 4 Digit Pin Number");
		Screen.setFont(new Font("Product Sans", Font.BOLD, 14));
		Screen.setForeground(new Color(0, 0, 0));
		Screen.setBounds(368, 27, 220, 131);
		frame.getContentPane().add(Screen);
		
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no=ATMno.getText();
				int pin = Integer.parseInt(no);
				Screen.setText(no+" Welcome to ATM Machine !!!");
			}
		});
		submit.setBounds(446, 207, 89, 23);
		frame.getContentPane().add(submit);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Screen.setText("Enter Amount to deposit");
				String Amt=ATMno.getText();
				depositeAmt=Integer.parseInt(Amt);
				balance=balance+depositeAmt;
				Screen.setText(depositeAmt+"Deposited");
				TransHistory.put(depositeAmt, " Amount Deposited");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\lArrow.png"));
		btnNewButton_1.setBounds(104, 91, 80, 53);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Amt=ATMno.getText();
				withdrawAmount=Integer.parseInt(Amt);
				if(withdrawAmount<=balance) {
				balance=balance-withdrawAmount;
				Screen.setText(withdrawAmount+"Withdrawed");
				TransHistory.put(withdrawAmount, " Amount Withdrawn");
				}else {
					Screen.setText("Insufficiant Balance..");
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\lArrow.png"));
		btnNewButton_1_1.setBounds(104, 153, 80, 53);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("New button");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Map.Entry<Double,String> m:TransHistory.entrySet()){
		            System.out.println(m.getKey()+""+m.getValue());
		        }
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\lArrow.png"));
		btnNewButton_1_2.setBounds(104, 27, 80, 53);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JLabel lblNewLabel = new JLabel("Trandaction History");
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel.setBounds(194, 27, 164, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Deposit");
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1.setBounds(194, 85, 164, 47);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lablscreen = new JLabel("");
		lablscreen.setIcon(new ImageIcon("D:\\Shrads\\OasisInternship\\images (1).jpeg"));
		lablscreen.setEnabled(false);
		lablscreen.setBackground(new Color(176, 196, 222));
		lablscreen.setBounds(368, 27, 231, 131);
		frame.getContentPane().add(lablscreen);
		
		JLabel lblNewLabel_1_1 = new JLabel("Withdraw");
		lblNewLabel_1_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(194, 143, 164, 47);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblViewBalance = new JLabel("View Balance");
		lblViewBalance.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblViewBalance.setBounds(623, 27, 89, 47);
		frame.getContentPane().add(lblViewBalance);
		
		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblTransfer.setBounds(623, 85, 164, 47);
		frame.getContentPane().add(lblTransfer);
		
		JLabel lblQuit = new JLabel("Quit");
		lblQuit.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblQuit.setBounds(623, 142, 68, 47);
		frame.getContentPane().add(lblQuit);
		
		JButton btnNewButton_1_2_1 = new JButton("New button");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//balance=balance+depositeAmt;
				Screen.setText("Total: "+balance);
				}
		});
		btnNewButton_1_2_1.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\rArrow.png"));
		btnNewButton_1_2_1.setBounds(724, 27, 80, 53);
		frame.getContentPane().add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_2 = new JButton("New button");
		btnNewButton_1_2_2.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\rArrow.png"));
		btnNewButton_1_2_2.setBounds(724, 91, 80, 53);
		frame.getContentPane().add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_2_3 = new JButton("New button");
		btnNewButton_1_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screen.setText("Collect your ATM Card\n Thank you for using ATM Machine!!");
                System.exit(0);
			}
		});
		btnNewButton_1_2_3.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\rArrow.png"));
		btnNewButton_1_2_3.setBounds(724, 153, 80, 53);
		frame.getContentPane().add(btnNewButton_1_2_3);
		
		JButton btnNewButton_1_2_4 = new JButton("New button");
		btnNewButton_1_2_4.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\one.png"));
		btnNewButton_1_2_4.setBounds(251, 252, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_4);
		
		JButton btnNewButton_1_2_5 = new JButton("New button");
		btnNewButton_1_2_5.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\two.png"));
		btnNewButton_1_2_5.setBounds(359, 252, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_5);
		
		JButton btnNewButton_1_2_6 = new JButton("New button");
		btnNewButton_1_2_6.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\three.png"));
		btnNewButton_1_2_6.setBounds(461, 252, 92, 53);
		frame.getContentPane().add(btnNewButton_1_2_6);
		
		JButton btnNewButton_1_2_7 = new JButton("New button");
		btnNewButton_1_2_7.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\cancel.png"));
		btnNewButton_1_2_7.setBounds(563, 252, 92, 53);
		frame.getContentPane().add(btnNewButton_1_2_7);
		
		JButton btnNewButton_1_2_8 = new JButton("New button");
		btnNewButton_1_2_8.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\four.png"));
		btnNewButton_1_2_8.setBounds(251, 322, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_8);
		
		JButton btnNewButton_1_2_9 = new JButton("New button");
		btnNewButton_1_2_9.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\five.png"));
		btnNewButton_1_2_9.setBounds(359, 322, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_9);
		
		JButton btnNewButton_1_2_10 = new JButton("New button");
		btnNewButton_1_2_10.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\six.png"));
		btnNewButton_1_2_10.setBounds(461, 322, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_10);
		
		JButton btnNewButton_1_2_11 = new JButton("New button");
		btnNewButton_1_2_11.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\clear.png"));
		btnNewButton_1_2_11.setBounds(563, 322, 90, 53);
		frame.getContentPane().add(btnNewButton_1_2_11);
		
		JButton btnNewButton_1_2_12 = new JButton("New button");
		btnNewButton_1_2_12.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\seven.png"));
		btnNewButton_1_2_12.setBounds(251, 394, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_12);
		
		JButton btnNewButton_1_2_13 = new JButton("New button");
		btnNewButton_1_2_13.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\eight.png"));
		btnNewButton_1_2_13.setBounds(359, 394, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_13);
		
		JButton btnNewButton_1_2_14 = new JButton("New button");
		btnNewButton_1_2_14.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\nine.png"));
		btnNewButton_1_2_14.setBounds(461, 394, 92, 53);
		frame.getContentPane().add(btnNewButton_1_2_14);
		
		JButton btnNewButton_1_2_15 = new JButton("New button");
		btnNewButton_1_2_15.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\enter.png"));
		btnNewButton_1_2_15.setBounds(563, 394, 92, 53);
		frame.getContentPane().add(btnNewButton_1_2_15);
		
		JButton btnNewButton_1_2_16 = new JButton("New button");
		btnNewButton_1_2_16.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\empty.png"));
		btnNewButton_1_2_16.setBounds(251, 465, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_16);
		
		JButton btnNewButton_1_2_17 = new JButton("New button");
		btnNewButton_1_2_17.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\zero.png"));
		btnNewButton_1_2_17.setBounds(359, 465, 89, 53);
		frame.getContentPane().add(btnNewButton_1_2_17);
		
		JButton btnNewButton_1_2_18 = new JButton("New button");
		btnNewButton_1_2_18.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\empty.png"));
		btnNewButton_1_2_18.setBounds(461, 465, 92, 53);
		frame.getContentPane().add(btnNewButton_1_2_18);
		
		JButton btnNewButton_1_2_19 = new JButton("New button");
		btnNewButton_1_2_19.setIcon(new ImageIcon("D:\\Shrads\\JAVA\\ATMtask\\ATM_Images\\empty.png"));
		btnNewButton_1_2_19.setBounds(563, 465, 92, 53);
		frame.getContentPane().add(btnNewButton_1_2_19);
	}
}
