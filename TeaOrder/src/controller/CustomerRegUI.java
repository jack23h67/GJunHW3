package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Cal1;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerRegUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField customerregistername;
	private JPasswordField customerregisterpassword;
	private JTextField customerregisteraddress;
	private JTextField customerregisterphone;
	private static Cal1 cal = new Cal1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegUI frame = new CustomerRegUI();
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
	public CustomerRegUI() {
		setTitle("customerRegister");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 426);
		setLocation(750, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 77, 288, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("電話");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(55, 127, 71, 31);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("地址");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(57, 92, 69, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("密碼");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(57, 51, 69, 31);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(57, 10, 69, 31);
		panel.add(lblNewLabel_2);
		
		customerregistername = new JTextField();
		customerregistername.setColumns(10);
		customerregistername.setBounds(122, 18, 96, 21);
		panel.add(customerregistername);
		
		customerregisterpassword = new JPasswordField();
		customerregisterpassword.setBounds(122, 58, 96, 23);
		panel.add(customerregisterpassword);
		
		customerregisteraddress = new JTextField();
		customerregisteraddress.setColumns(10);
		customerregisteraddress.setBackground(Color.WHITE);
		customerregisteraddress.setBounds(122, 97, 96, 21);
		panel.add(customerregisteraddress);
		
		customerregisterphone = new JTextField();
		customerregisterphone.setColumns(10);
		customerregisterphone.setBounds(122, 135, 96, 21);
		panel.add(customerregisterphone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 288, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("客戶註冊");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		lblNewLabel.setBounds(99, 0, 126, 47);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(8, 316, 290, 67);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		

		JButton customerregisterexit = new JButton("離開");
		customerregisterexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object				
			}
		});
		customerregisterexit.setForeground(new Color(255, 250, 250));
		customerregisterexit.setBackground(new Color(255, 0, 0));
		customerregisterexit.setBounds(150, 0, 87, 23);
		panel_2.add(customerregisterexit);
		
		JLabel registerwarning = new JLabel("");
		registerwarning.setForeground(new Color(227, 57, 15));
		registerwarning.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		registerwarning.setBounds(10, 28, 280, 39);
		panel_2.add(registerwarning);
		
		JButton customerregisterregister = new JButton("註冊");
		customerregisterregister.setBackground(Color.LIGHT_GRAY);
		customerregisterregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cInputName = customerregistername.getText().trim();
				String cInputPassword = String.valueOf(customerregisterpassword.getPassword()).trim();
				String cInputAddress = customerregisteraddress.getText().trim();
				String cInputPhone = customerregisterphone.getText().trim();
				System.out.println(cInputName.isEmpty());
				if(cInputName.isEmpty()||cInputPassword.isEmpty()||cInputAddress.isEmpty()||cInputPhone.isEmpty())
				{
					registerwarning.setText("帳號、密碼、地址、電話必須輸入");
				}
				else
				{
					setVisible(false);
					dispose();
					cal.gotoCustomerLogin();
				}
			}
		});
		customerregisterregister.setBounds(53, 0, 87, 23);
		panel_2.add(customerregisterregister);
		
	}

}
