package forms.entities;
import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

	import entities.*;

	public class customersform implements ActionListener{
		JFrame frame;
		JLabel id_lb=new JLabel("customers_id");
		JLabel fname_lb=new JLabel("last_name");
		JLabel lname_lb=new JLabel("first_name");
		JLabel emai_lb=new JLabel("emai");
		JLabel phone_lb=new JLabel("phone");
		JLabel adr_lb=new JLabel("address");
		JLabel payment_method_lb=new JLabel("payment_method");

		JTextField id_txf=new JTextField();
		JTextField fname_txf=new JTextField();
		JTextField lname_txf=new JTextField();
		JTextField emai_txf=new JTextField();
		JTextField phone_txf=new JTextField();
		JTextField adr_txf=new JTextField();
		String []payment_method={"MTN", "TIGO","BK", "EQUETY","A$MBANK", "UMUTANGUHA"};
		JComboBox<String> payment_methodBox = new JComboBox<>(payment_method);

		//Buttons CRUD
		JButton INSERT_btn=new JButton("INSERT");
		JButton READ_btn=new JButton("View");
		JButton UPDATE_tbtn=new JButton("UPDATE");
		JButton DELETE_btn=new JButton("DELETE");
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=(int) screensize.getWidth();
		int h=(int) screensize.getHeight();
		public customersform() {
			createForm();

		}
		private void ActionEvent() {
			INSERT_btn.addActionListener(this);
			READ_btn.addActionListener(this);
			UPDATE_tbtn.addActionListener(this);
			DELETE_btn.addActionListener(this);
			//payment_methodBox.addActionListener(this);
		}
		private void createForm() {
			frame=new JFrame();
			frame.setTitle("customers form");
			frame.setBounds(0, 0, 700, 400);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			setLocationandSize();
		}


		private void setLocationandSize() {
			id_lb.setBounds(10, 10, 150, 30);
			fname_lb.setBounds(10, 50, 100, 30);
			lname_lb.setBounds(10, 90, 100, 30);
			emai_lb.setBounds(10, 130, 100, 30);
			phone_lb.setBounds(10, 170, 100, 30);
			adr_lb.setBounds(10, 210, 100, 30);
			payment_method_lb.setBounds(10, 250, 180, 30);
			id_txf.setBounds(180, 10, 300, 30);
			fname_txf.setBounds(180, 50, 300, 30);
			lname_txf.setBounds(180, 90, 300, 30);
			emai_txf.setBounds(180, 130, 300, 30);
			phone_txf.setBounds(180, 170, 300, 30);
			adr_txf.setBounds(180, 210, 300, 30);
			payment_methodBox.setBounds(180, 250, 300, 30);
			//Buttons CRUD
			INSERT_btn.setBounds(10,290, 85, 30);
			READ_btn.setBounds(100,290, 85, 30);
			UPDATE_tbtn.setBounds(190,290, 85, 30);
			DELETE_btn.setBounds(280,290, 85, 30);
			setFontforall();
			addcomponentforFrame();

		}
		private void setFontforall() {
			Font font = new Font("Georgia", Font.BOLD, 18);

			id_lb.setFont(font);
			fname_lb.setFont(font);
			lname_lb.setFont(font);
			emai_lb.setFont(font);
			phone_lb.setFont(font);
			adr_lb.setFont(font);

			id_txf.setFont(font);
			fname_txf.setFont(font);
			lname_txf.setFont(font);
			emai_txf.setFont(font);
			phone_txf.setFont(font);
			adr_txf.setFont(font);
			payment_method_lb.setFont(font);
			payment_methodBox.setFont(font);
			//Buttons CRUD
			Font fonti = new Font("Courier New", Font.ITALIC, 12);

			INSERT_btn.setFont(fonti);
			READ_btn.setFont(fonti);
			UPDATE_tbtn.setFont(fonti);
			DELETE_btn.setFont(fonti);

		}
		private void addcomponentforFrame() {
			frame.add(id_lb);
			frame.add(fname_lb);
			frame.add(lname_lb);
			frame.add(emai_lb);
			frame.add(phone_lb);
			frame.add(adr_lb);
			frame.add(payment_method_lb);
			frame.add(id_txf);
			frame.add(fname_txf);
			frame.add(lname_txf);
			frame.add(emai_txf);
			frame.add(phone_txf);
			frame.add(adr_txf);
			frame.add(payment_methodBox);
			//Buttons CRUD
			frame.add(INSERT_btn);
			frame.add(READ_btn);
			frame.add(UPDATE_tbtn);
			frame.add(DELETE_btn);
			ActionEvent();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			customers cust=new customers();
			if(e.getSource()==INSERT_btn) {
				cust.setfirst_name(fname_txf.getText());
				cust.setlast_name(lname_txf.getText());
				cust.setemai(emai_txf.getText());
				cust.setphone(phone_txf.getText());
				cust.setaddress(adr_txf.getText());
				String selectedOption = (String) payment_methodBox.getSelectedItem();
				cust.setpayment_method(selectedOption);
				cust.insertDataa();
			}else if (e.getSource()==READ_btn) {
				int id=Integer.parseInt(id_txf.getText());
				cust.readwithcustomers_id(id);
				id_txf.setText(String.valueOf(cust.getcustomers_id()));
				fname_txf.setText(cust.getfirst_name());
				lname_txf.setText(cust.getlast_name());
				emai_txf.setText(cust.getemai());
				phone_txf.setText(cust.getphone());
				adr_txf.setText(cust.getaddress());
				
				
			}else if (e.getSource()==UPDATE_tbtn) {
				int id=Integer.parseInt(id_txf.getText());
				cust.setfirst_name(fname_txf.getText());
				cust.setlast_name(lname_txf.getText());
				cust.setemai(emai_txf.getText());
				cust.setphone(phone_txf.getText());
				cust.setaddress(adr_txf.getText());
				cust.setpayment_method(cust.getpayment_method());
		
				cust.update1(id);
			}else {
				int id=Integer.parseInt(id_txf.getText());
				cust.delete(id);
			}

		}
		public static void main(String[] args) {
			
			customersform cusfcusf=new customersform();
			System.out.println(cusfcusf);

		}

	}

	

	        

