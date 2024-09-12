package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;
import service.Impl.CustomerServiceImpl;
import util.Cal1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class CustomerLoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField customerloginusername;
	private JPasswordField customerloginuserpassword;
	private JPanel panel_1;
	private JPanel panel_2;
	private static CustomerServiceImpl csi = new CustomerServiceImpl();
	private static Cal1 cal = new Cal1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginUI frame = new CustomerLoginUI();
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
	public CustomerLoginUI() {
		setTitle("CustomerLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 300);
		setLocation(700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(81, 63, 186, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 42, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 52, 42, 32);
		panel.add(lblNewLabel_1);
		
		customerloginusername = new JTextField();
		customerloginusername.setBounds(51, 10, 96, 30);
		panel.add(customerloginusername);
		customerloginusername.setColumns(10);
		
		customerloginuserpassword = new JPasswordField();
		customerloginuserpassword.setBounds(51, 52, 96, 31);
		panel.add(customerloginuserpassword);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 241, 336, -50);
		contentPane.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(20, 176, 299, 40);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JButton customerloginregister = new JButton("註冊");
		customerloginregister.setBackground(Color.LIGHT_GRAY);
		customerloginregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				
				cal.gotoAddCustomer();
			}
		});
		customerloginregister.setBounds(107, 10, 87, 23);
		panel_2.add(customerloginregister);
		
		JButton customerloginexit = new JButton("離開");
		customerloginexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		customerloginexit.setForeground(new Color(255, 250, 250));
		customerloginexit.setBackground(new Color(255, 0, 0));
		customerloginexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		customerloginexit.setBounds(204, 10, 87, 23);
		panel_2.add(customerloginexit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 320, 40);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("客戶登入");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(126, 0, 83, 40);
		panel_3.add(lblNewLabel_2);
		
		JButton customerloginlogin = new JButton("登入");
		customerloginlogin.setBackground(Color.LIGHT_GRAY);
		customerloginlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cInputUsername = customerloginusername.getText().trim();
				String cInputPassword = String.valueOf(customerloginuserpassword.getPassword()).trim();
				
				Customer c = csi.login(cInputUsername, cInputPassword);

				if(cInputUsername.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"登入失敗，請輸入帳號","login fail", JOptionPane.ERROR_MESSAGE);
					customerloginregister.setBackground(Color.LIGHT_GRAY);
				}
				else if(cInputPassword.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"登入失敗，請輸入密碼","login fail", JOptionPane.ERROR_MESSAGE);
					customerloginregister.setBackground(Color.LIGHT_GRAY);
				}
				else if(cInputUsername.isEmpty()||cInputPassword.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"登入失敗，請輸入帳號及密碼","login fail", JOptionPane.ERROR_MESSAGE);
					customerloginregister.setBackground(Color.LIGHT_GRAY);
				}
				else if(c!=null)
				{
					try {
						cal.setCustomer(c);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"登入成功","login success", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					dispose();
					// goto order
					cal.gotoCustomerOrdere();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"登入失敗，請先註冊","login fail", JOptionPane.ERROR_MESSAGE);
					customerloginregister.setBackground(Color.GREEN);
					
				}
				
			}
		});
		customerloginlogin.setBounds(10, 10, 87, 23);
		panel_2.add(customerloginlogin);
	}
}
