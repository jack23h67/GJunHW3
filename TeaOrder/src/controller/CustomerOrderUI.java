package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Order;
import model.Product;
import service.Impl.OrderServiceImpl;
import service.Impl.ProductServiceImpl;
import util.Cal1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CustomerOrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-12,29
	 */
	private JTextField customerName;
	private JTextField bubbleTeaNum;
	private JTextField blackTeaNum;
	private JTextField pekoeNum;
	private JTextField fourSeasonOolongTeaNum;
	private JTextField greenMilkTeaNum;
	private JTextField kumquatLemonadeNum;
	private JTextField payMoney;
	private int sum = 0;
	private double discount = 1.0;
	String changeMoneyInfo = "";
	private static Cal1 cal = new Cal1();
	private String customerinfo = "";

	private static OrderServiceImpl os1 = new OrderServiceImpl();
	private static ProductServiceImpl ps1 = new ProductServiceImpl();  
	List<Product>  pl1 = ps1.findAll();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeaOrderUI frame = new TeaOrderUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

//	public String show()
//	{
//		String showInfoString = "";
//		showInfoString += this.customerName + " 客戶，您好,您的購買清單如下\n品項:\t數量:\t小計:\n";
//		if(this.getBubbleTeaNum()<=0)  			
//			this.bubbleTeaName="";
//		else
//			this.bubbleTeaName+="\t"+this.getBubbleTeaNum()+"\t"+(this.bubbleTeaNum*this.bubbleTeaPrice)+"\n";
//		
//		if(this.getBlackTeaNum()<=0)			
//			this.blackTeaName="";
//		else
//			this.blackTeaName+="\t"+this.getBlackTeaNum()+"\t"+(this.blackTeaNum*this.blackTeaPrice)+"\n";
//		
//		if(this.getPekoeNum()<=0)				
//			this.pekoeName="";
//		else
//			this.pekoeName+="\t"+this.getPekoeNum()+"\t"+(this.pekoeNum*this.pekoePrice)+"\n";
//		
//		if(this.getFourSeasonOolongTeaNum()<=0)	
//			this.fourSeasonOolongTeaName="";
//		else
//			this.fourSeasonOolongTeaName+="\t"+this.getFourSeasonOolongTeaNum()+"\t"+(this.fourSeasonOolongTeaNum*this.fourSeasonOolongTeaPrice)+"\n";
//		
//		if(this.getGreenMilkTeaNum()<=0)		
//			this.greenMilkTeaName="";
//		else
//			this.greenMilkTeaName+="\t"+this.getGreenMilkTeaNum()+"\t"+(this.greenMilkTeaNum*this.greenMilkTeaPrice)+"\n";
//		
//		if(this.getKumquatLemonadeNum()<=0)		
//			this.kumquatLemonadeName="";
//		else
//			this.kumquatLemonadeName+="\t"+this.getKumquatLemonadeNum()+"\t"+(this.kumquatLemonadeNum*this.kumquatLemonadePrice)+"\n";
//		
//		showInfoString+=this.bubbleTeaName+this.blackTeaName+this.pekoeName+this.fourSeasonOolongTeaName+this.greenMilkTeaName+this.kumquatLemonadeName;
//		showInfoString+="-----------------------------------------------------------------------\n"
//		+"原價:$"+this.originalPrice;
//
//		showInfoString += "\t折扣:"+(this.discount*100)+"%";	
//		showInfoString += "\t折扣後:$"+(Math.floor(this.originalPrice*this.discount));
//		showInfoString += "\n運費:$39\t總計:$"+this.oSum;
//		//System.out.println(showInfoString);
//		return showInfoString;
//	}
	
	/*
	 * @input 找零金額 
	 * @return 找零訊息
	 * */
	public String makeChange(Integer payMoneyInt)
	{
		int tmp1=0,tmp2=0,tmp3=0, makeChange=payMoneyInt,
			oneThousand=0,fiveHundred=0,oneHundred=0,
			fiftyCoin=0,tenCoin=0,fiveCoin=0,oneCoin=0;
		tmp1 = makeChange/1000;
		tmp2 = makeChange%1000;
		oneThousand = tmp1;
		tmp3 = tmp2;

		tmp1 = tmp3/500;
		tmp2 = tmp3%500;
		fiveHundred = tmp1;
		tmp3 = tmp2;

		tmp1 = tmp3/100;
		tmp2 = tmp3%100;
		oneHundred= tmp1;
		tmp3 = tmp2;

		tmp1 = tmp3/50;
		tmp2 = tmp3%50;
		fiftyCoin= tmp1;
		tmp3 = tmp2;

		tmp1 = tmp3/10;
		tmp2 = tmp3%10;
		tenCoin= tmp1;
		tmp3 = tmp2;

		tmp1 = tmp3/5;
		tmp2 = tmp3%5;
		fiveCoin= tmp1;
		tmp3 = tmp2;

		tmp1 = tmp3/1;
		tmp2 = tmp3%1;
		oneCoin= tmp1;
		tmp3 = tmp2;

		String changeMoneyInfo = "需要找您:\t"+makeChange+
								"\n-----------------------------------------------------------------------\n"+
								"1000元鈔票:\t"+oneThousand+"\t50元硬幣:\t"+fiftyCoin+
								"\n500元鈔票:\t"+fiveHundred+"\t10元硬幣:\t"+tenCoin+
								"\n100元鈔票:\t"+oneHundred+"\t5元硬幣:\t"+fiveCoin+
								"\n\t\t元硬幣:\t"+oneCoin;
								
		return changeMoneyInfo;
	}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public CustomerOrderUI() {
		try {
			customerinfo = cal.getCustomer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] words = customerinfo.split(",");
		String cName = words[0];
		String no	 = words[1];
		String level = words[2];
		int ilevel = Integer.parseInt(level);
		
		setTitle("先喝道台北誠品站前店點餐系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 440);
		setLocation(680,345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 10, 235, 385);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("客戶姓名:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 10, 130, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("珍珠奶茶/一杯50");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 40, 130, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("白毫/一杯40");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 100, 130, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("奶綠/一杯45");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 160, 130, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("金桔檸檬/一杯60");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 190, 130, 30);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("四季春/一杯55");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(20, 130, 130, 30);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("紅茶/一杯25");
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(20, 70, 130, 30);
		panel_1.add(lblNewLabel_6);
		
		customerName = new JTextField();
		customerName.setEditable(false);
		customerName.setEnabled(false);
		customerName.setBounds(140, 18, 79, 21);
		customerName.setText(cName);
		customerName.disable();
		panel_1.add(customerName);
		customerName.setColumns(10);
		
		bubbleTeaNum = new JTextField();
		bubbleTeaNum.setBounds(140, 48, 79, 21);
		panel_1.add(bubbleTeaNum);
		bubbleTeaNum.setColumns(10);
		
		blackTeaNum = new JTextField();
		blackTeaNum.setBounds(140, 78, 79, 21);
		panel_1.add(blackTeaNum);
		blackTeaNum.setColumns(10);
		
		pekoeNum = new JTextField();
		pekoeNum.setBounds(140, 108, 79, 21);
		panel_1.add(pekoeNum);
		pekoeNum.setColumns(10);
		
		fourSeasonOolongTeaNum = new JTextField();
		fourSeasonOolongTeaNum.setBounds(140, 140, 79, 21);
		panel_1.add(fourSeasonOolongTeaNum);
		fourSeasonOolongTeaNum.setColumns(10);
		
		greenMilkTeaNum = new JTextField();
		greenMilkTeaNum.setBounds(140, 168, 79, 21);
		panel_1.add(greenMilkTeaNum);
		greenMilkTeaNum.setColumns(10);
		
		kumquatLemonadeNum = new JTextField();
		kumquatLemonadeNum.setBounds(140, 198, 79, 21);
		panel_1.add(kumquatLemonadeNum);
		kumquatLemonadeNum.setColumns(10);
		
		JButton clear = new JButton("清空");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		clear.setBounds(20, 274, 73, 23);
		panel_1.add(clear);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.setBounds(103, 274, 66, 23);
		panel_1.add(btnNewButton);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		if(ilevel==1) {
			comboBox.addItem("一般會員");
		}else if(ilevel==2) {
			comboBox.addItem("銀卡會員");	
		}else if(ilevel==3) {
			comboBox.addItem("金卡會員");
		}else {
			comboBox.addItem("非會員");
		}
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBox.setBounds(103, 230, 116, 30);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("會員等級");
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(20, 230, 112, 30);
		panel_1.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(245, 10, 336, 385);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea output_01 = new JTextArea();
		output_01.setBounds(10, 10, 319, 205);
		panel_2.add(output_01);
		
		JLabel lblNewLabel_7 = new JLabel("請輸入您付款的金額");
		lblNewLabel_7.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 225, 141, 31);
		panel_2.add(lblNewLabel_7);
		
		payMoney = new JTextField();
		payMoney.setText("0");
		payMoney.setBounds(145, 225, 80, 29);
		panel_2.add(payMoney);
		payMoney.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("結帳");
		btnNewButton_1.setBounds(235, 225, 87, 31);
		panel_2.add(btnNewButton_1);
		
		JTextArea output_02 = new JTextArea();
		output_02.setBounds(10, 266, 319, 109);
		panel_2.add(output_02);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean complete = output_01.print();
					if(complete)
						{JOptionPane.showMessageDialog(null,"列印完成","Information",
								JOptionPane.INFORMATION_MESSAGE);}
					else {
						JOptionPane.showMessageDialog(null,"列印...","Printer",JOptionPane.ERROR_MESSAGE);
					}
				}catch(PrinterException ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
				
			}
		});
		btnNewButton_2.setBounds(169, 274, 66, 23);
		panel_1.add(btnNewButton_2);
		
		/*
		 * pay btn
		 * 計算找零 輸出output02
		 * */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String payMoneyStr = payMoney.getText();
				output_02.setText("");
				int payMoneyInt = 0;
				
				try {
					payMoneyInt= Integer.parseInt(payMoneyStr);
					if(payMoneyInt<=0) {payMoneyInt=0;payMoney.setText("0");}
				}catch(NumberFormatException e7)
				{payMoneyInt=0;payMoney.setText("0");}
				
				if(payMoneyInt<sum)
				{
					String warningMessage = "客官，付的錢不夠啊~";
					output_02.setText(warningMessage);
				}
				else
				{
					payMoneyInt -= sum;
					changeMoneyInfo = makeChange(payMoneyInt);
					output_02.setText(changeMoneyInfo);
				}
			}
		});

		/*
		 * clear btn
		 * 清空input output
		 * */
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bubbleTeaNum.setText("0");
				blackTeaNum.setText("0");
				pekoeNum.setText("0");
				fourSeasonOolongTeaNum.setText("0");
				greenMilkTeaNum.setText("0");
				kumquatLemonadeNum.setText("0");
				comboBox.setSelectedIndex(0);
				payMoney.setText("0");
				output_02.setText("");
				output_01.setText("");	
				sum=0;
			}
		});
		
		/*
		 * confirm btn
		 * 計算及輸出output_01
		 * */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 接 input String
				String CustomerName = customerName.getText();
				String BubbleTeaNum = bubbleTeaNum.getText();
				String BlackTeaNum = blackTeaNum.getText();
				String PekoeNum = pekoeNum.getText();
				String FourSeasonOolongTeaNum = fourSeasonOolongTeaNum.getText();
				String GreenMilkTeaNum = greenMilkTeaNum.getText();
				String KumquatLemonadeNum = kumquatLemonadeNum.getText();
				
				int pl1len = pl1.size();
				int[] teanum = new int[pl1len];
				String[] teaname  = new String[pl1len];
				double[] teaprice = new double[pl1len];
				String[] teaInfo  = new String[pl1len];
				double originalPrice = 0.0;
				
				for(int j=0;j<pl1len;j++)
				{
					teanum[j] = 0;
					teaname[j]  = pl1.get(j).getProductname();
					teaprice[j] = pl1.get(j).getProductprice();
				}
				
				/*
				 * 轉型檢查 begin
				 * */
				try {
					teanum[0] = Integer.parseInt(BubbleTeaNum);
					if(teanum[0]<=0) {teanum[0]=0; bubbleTeaNum.setText("0");}
				}catch(NumberFormatException e1)
				{teanum[0] = 0;bubbleTeaNum.setText("0");}
				
				try {
					teanum[1] = Integer.parseInt(BlackTeaNum);
					if(teanum[1]<=0) {teanum[1]=0;blackTeaNum.setText("0");}
				}catch(NumberFormatException e2)
				{teanum[1] = 0;blackTeaNum.setText("0");}
				
				try {
					teanum[2] = Integer.parseInt(PekoeNum);
					if(teanum[2]<=0) {teanum[2]=0;pekoeNum.setText("0");}
				}catch(NumberFormatException e3)
				{teanum[2] = 0;pekoeNum.setText("0");}
				
				try {
					teanum[3] = Integer.parseInt(FourSeasonOolongTeaNum);
					if(teanum[3]<=0) {teanum[0]=0;fourSeasonOolongTeaNum.setText("0");}
				}catch(NumberFormatException e4)
				{teanum[3] = 0;fourSeasonOolongTeaNum.setText("0");}
				
				try {
					teanum[4] = Integer.parseInt(GreenMilkTeaNum);
					if(teanum[4]<=0) {teanum[0]=0;greenMilkTeaNum.setText("0");}
				}catch(NumberFormatException e5)
				{teanum[4] = 0;greenMilkTeaNum.setText("0");}
				
				try {
					teanum[5] = Integer.parseInt(KumquatLemonadeNum);
					if(teanum[5]<=0) {teanum[5]=0;kumquatLemonadeNum.setText("0");}
				}catch(NumberFormatException e6)
				{teanum[5] = 0;kumquatLemonadeNum.setText("0");}
				/*
				 * 轉型檢查 END
				 * */
				
				
//				List<Product> l2 =  
//				
//				double bubbleTeaPrice = 50.0, blackTeaPrice = 25.0, pekoePrice = 40.0,
//						fourSeasonOolongTeaPrice = 55.0, GreenMilkTeaPrice = 45.0, kumquatLemonadePrice = 60.0;
//				String bubbleTeaName = "珍珠奶茶", BlackTeaName = "",pekoeName="",
//						fourSeasonOolongTeaName="", GreenMilkTeaName = "", kumquatLemonadeName = "";
				
				String showInfoString = "";
				showInfoString += cName + " 客戶，您好,您的購買清單如下\n品項:\t數量:\t小計:\n";
				
				for(int k=0;k<pl1len;k++)
				{
					if(teanum[k]<=0)  			
						{teaInfo[k]="";}
					else
						{teaInfo[k]=teaname[k]+"\t"+teanum[k]+"\t"+(teanum[k]*teaprice[k])+"\n";}
					showInfoString+=teaInfo[k];
					originalPrice+=(teanum[k]*teaprice[k]);
				}
				
				/*
				if(teanum[0]<=0)  			
					teaInfo[0]="";
				else
					teaInfo[0]+="\t"+teanum[0]+"\t"+(teanum[0]*this.bubbleTeaPrice)+"\n";
				
				if(teanum[0]<=0)			
					this.blackTeaName="";
				else
					this.blackTeaName+="\t"+teanum[0]+"\t"+(teanum[0]*this.blackTeaPrice)+"\n";
				
				if(teanum[0]<=0)				
					this.pekoeName="";
				else
					this.pekoeName+="\t"+teanum[0]+"\t"+(teanum[0]*this.pekoePrice)+"\n";
				
				if(teanum[0]<=0)	
					this.fourSeasonOolongTeaName="";
				else
					this.fourSeasonOolongTeaName+="\t"+teanum[0]+"\t"+(teanum[0]*this.fourSeasonOolongTeaPrice)+"\n";
				
				if(teanum[0]<=0)		
					this.greenMilkTeaName="";
				else
					this.greenMilkTeaName+="\t"+teanum[0]+"\t"+(teanum[0]*this.greenMilkTeaPrice)+"\n";
				
				if(teanum[0]<=0)		
					this.kumquatLemonadeName="";
				else
					this.kumquatLemonadeName+="\t"+teanum[0]+"\t"+(teanum[0]*this.kumquatLemonadePrice)+"\n";
				
				
				
				showInfoString+=this.bubbleTeaName+this.blackTeaName+this.pekoeName+this.fourSeasonOolongTeaName+this.greenMilkTeaName+this.kumquatLemonadeName;
				*/
				showInfoString+="-----------------------------------------------------------------------\n"
				+"原價:$"+originalPrice;
				
				
				String genderSel = (String) comboBox.getSelectedItem();//get the selected item
                switch (genderSel) {
                	case "非會員":
                		discount=1.0;
                		break;
                	case "一般會員":
                		discount=0.9;
                		break;
                	case "銀卡會員":
                		discount=0.7;
                		break;
                	case "金卡會員":
                		discount=0.5;
                		break;
                }
                // Order 建構式
                Order o1 = new Order();
                double osum = Math.floor(originalPrice*discount);
                if(osum>0) osum+=39.0;
                else osum=0.0;
                o1.setCustomerno(no);
                o1.setAmount(originalPrice);
                o1.setDiscount(discount);
                o1.setFreight(39.0);
                o1.setOsum(osum);
                o1.setOrdertime(null);
                o1.setInfo(showInfoString);
                os1.addOrder(o1);
                
//				TeaOrder TO = new TeaOrder(CustomerName, Bubble, Black, Pekoe,
//											FourSeason, GreenMilk, Kumquat, discount);
//				sum=TO.getSum();
//				
				output_01.setText(showInfoString);
				payMoney.setText("0");
				output_02.setText("");		
			}
		});
	}
	
	
}
