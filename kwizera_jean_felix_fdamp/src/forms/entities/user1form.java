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

import entities.user1;
public class user1form implements ActionListener{
	JFrame frame;
	JLabel id_lb=new JLabel("user1_id");
	JLabel fname_lb=new JLabel("first_name");
	JLabel lname_lb=new JLabel("last_name");
	JLabel phone_number_lb=new JLabel("phone_number");
	JLabel email_lb=new JLabel("email");
	
	JLabel role_lb=new JLabel("role");

	JTextField id_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField phone_number_txf=new JTextField();
	JTextField email_txf=new JTextField();
	String []role={"Admin", "Administrator","Administrator", "driver","fuel_suppler", "communicator"};
	JComboBox<String> roleBox = new JComboBox<>(role);

	//Buttons CRUD
	JButton INSERT_btn=new JButton("INSERT");
	JButton READ_btn=new JButton("View");
	JButton UPDATE_tbtn=new JButton("UPDATE");
	JButton DELETE_btn=new JButton("DELETE");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public user1form() {
		createForm();

	}
	private void ActionEvent() {
	    INSERT_btn.addActionListener(this);
	    READ_btn.addActionListener(this);
	    UPDATE_tbtn.addActionListener(this);  // Update to UPDATE_btn
	    DELETE_btn.addActionListener(this);
	    //roleBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("user1");
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
		fname_lb.setBounds(10, 50, 130, 30);
		lname_lb.setBounds(10, 90, 130, 30);
		phone_number_lb.setBounds(10, 130, 170, 30);
		email_lb.setBounds(10, 170, 130, 30);
		role_lb.setBounds(10, 210, 130, 30);
		//text
		id_txf.setBounds(180, 10, 300, 30);
		fname_txf.setBounds(180, 50, 300, 30);
		lname_txf.setBounds(180, 90, 300, 30);
		phone_number_txf.setBounds(180, 130, 300, 30);
		email_txf.setBounds(180, 170, 300, 30);
		roleBox.setBounds(180, 210, 300, 30);
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
		fname_lb.setFont(font);
		lname_lb.setFont(font);
		phone_number_lb.setFont(font);
		email_lb.setFont(font);
		

		id_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		phone_number_txf.setFont(font);
		email_txf.setFont(font);
		role_lb.setFont(font);
		roleBox.setFont(font);
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
		frame.add(phone_number_lb);
		frame.add(email_lb);
		
		frame.add(role_lb);
		frame.add(id_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(phone_number_txf);
		frame.add(email_txf);
		frame.add(roleBox);
		//Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		user1 user1=new user1();
		if(e.getSource()==INSERT_btn) {
			user1 user11 = new user1();
			user11.setFname(fname_txf.getText());
			user11.setLname(lname_txf.getText());
			user11.setphone_number(phone_number_txf.getText());
			user11.setemail(email_txf.getText());
			
			String selectedOption = (String) roleBox.getSelectedItem();
			user1.setrole(selectedOption);
			user1.insertData();
		}else if (e.getSource()==READ_btn) {
			int id=Integer.parseInt(id_txf.getText());
			user1.readWithuser1Id(id);
			id_txf.setText(String.valueOf(user1.getuser1_id()));
			fname_txf.setText(user1.getFname());
			lname_txf.setText(user1.getLname());
			phone_number_txf.setText(user1.getphone_number());
			email_txf.setText(user1.getemail());
			
			user1.setrole(user1.getrole());
			
		}else if (e.getSource()==UPDATE_tbtn) {
			int id=Integer.parseInt(id_txf.getText());
			user1.setFname(fname_txf.getText());
			user1.setLname(lname_txf.getText());
			user1.setphone_number(phone_number_txf.getText());
			user1.setemail(email_txf.getText());
	
			user1.update(id);
		}else {
			int id=Integer.parseInt(id_txf.getText());
			user1.delete(id);
		}

	}
	public static void main(String[] args) {
		user1form user1=new user1form();
	System.out.println(user1);

	}



}




