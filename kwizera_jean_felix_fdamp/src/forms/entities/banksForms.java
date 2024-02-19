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

import entities.banks;
public class banksForms implements ActionListener {
	
	JFrame frame;
	JLabel id_lb=new JLabel("banks_id");
	JLabel name_lb=new JLabel("name");
	JLabel address_lb=new JLabel("address");
	JLabel phone_lb=new JLabel("phone_number");
	JLabel acca_lb=new JLabel("account_number");
	
	JLabel bankname_lb=new JLabel("bankname");

	JTextField id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField address_txf=new JTextField();
	JTextField phone_number_txf=new JTextField();
	JTextField account_number_txf=new JTextField();
	String []bankname={"BNR", "EQUITY BANK","BPR", "SACCO","ZIGAMA", "A&M BANK"};
	JComboBox<String> banknameBox = new JComboBox<>(bankname);

	//Buttons CRUD
	JButton INSERT_btn=new JButton("INSERT");
	JButton READ_btn=new JButton("View");
	JButton UPDATE_tbtn=new JButton("UPDATE");
	JButton DELETE_btn=new JButton("DELETE");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public  banksForms() {
		createForm();

	}
	private void ActionEvent() {
		INSERT_btn.addActionListener(this);
		READ_btn.addActionListener(this);
		UPDATE_tbtn.addActionListener(this);
		DELETE_btn.addActionListener(this);
		//banknameBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle(" banks");
		frame.setBounds(0, 0, 700, 400);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
	}


	private void setLocationandSize() {
		id_lb.setBounds(10, 10, 130, 30);
		name_lb.setBounds(10, 50, 130, 30);
		address_lb.setBounds(10, 90, 130, 30);
		phone_lb.setBounds(10, 130, 170, 30);
		acca_lb.setBounds(10, 170, 130, 30);
		bankname_lb.setBounds(10, 210, 130, 30);
		//text
		id_txf.setBounds(180, 10, 300, 30);
		name_txf.setBounds(180, 50, 300, 30);
		address_txf.setBounds(180, 90, 300, 30);
		phone_number_txf.setBounds(180, 130, 300, 30);
		account_number_txf.setBounds(180, 170, 300, 30);
		banknameBox.setBounds(180, 210, 300, 30);
		//Buttons CRUD
		INSERT_btn.setBounds(10,260, 85, 30);
		READ_btn.setBounds(100,260, 85, 30);
		UPDATE_tbtn.setBounds(190,260, 85, 30);
		DELETE_btn.setBounds(280,260, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		id_lb.setFont(font);
		name_lb.setFont(font);
		address_lb.setFont(font);
		phone_lb.setFont(font);
		acca_lb.setFont(font);
		

		id_txf.setFont(font);
		name_txf.setFont(font);
		address_txf.setFont(font);
		phone_number_txf.setFont(font);
		account_number_txf.setFont(font);
		bankname_lb.setFont(font);
		banknameBox.setFont(font);
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		INSERT_btn.setFont(fonti);
		READ_btn.setFont(fonti);
		UPDATE_tbtn.setFont(fonti);
		DELETE_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(id_lb);
		frame.add(name_lb);
		frame.add(address_lb);
		frame.add(phone_lb);
		frame.add(acca_lb);
		
		frame.add(bankname_lb);
		frame.add(id_txf);
		frame.add(name_txf);
		frame.add(address_txf);
		frame.add(phone_number_txf);
		frame.add(account_number_txf);
		frame.add(banknameBox);
		//Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}
	public void actionPerformed(ActionEvent e) {
		 banks  banks=new  banks();
		if(e.getSource()==INSERT_btn) {
		
			 banks.setname(name_txf.getText());
			 banks.setaddress(address_txf.getText());
			 banks.setphone_number(phone_number_txf.getText());
			 banks.setaccount_number(account_number_txf.getText());
			
			String selectedOption = (String) banknameBox.getSelectedItem();
			 banks.setbankname(selectedOption);
			 banks.insertData();
		}else if (e.getSource()==READ_btn) {
			int id=Integer.parseInt(id_txf.getText());
			 banks.readwithbanks_id(id);
			id_txf.setText(String.valueOf( banks.getbanks_id()));
			name_txf.setText( banks.getname());
			address_txf.setText( banks.getaddress());
			phone_number_txf.setText( banks.getphone_number());
			account_number_txf.setText( banks.getaccount_number());
			
			 banks.setbankname( banks.getbankname());
			
		}else if (e.getSource()==UPDATE_tbtn) {
			int id=Integer.parseInt(id_txf.getText());
			 banks.setname(name_txf.getText());
			 banks.setaddress(address_txf.getText());
			 banks.setphone_number(phone_number_txf.getText());
			 banks.setaccount_number(account_number_txf.getText());
	
			 banks.update(id);
		}else {
			int id=Integer.parseInt(id_txf.getText());
			 banks.delete(id);
		}

	}
	public static void main(String[] args) {
		banksForms banks=new banksForms();
	System.out.println(banks);
	}



}


	


