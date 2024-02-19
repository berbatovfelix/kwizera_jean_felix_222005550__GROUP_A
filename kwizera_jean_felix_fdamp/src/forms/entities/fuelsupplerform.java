package forms.entities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.*;


public class fuelsupplerform implements ActionListener{
	JFrame frame;
	JLabel id_lb=new JLabel("fuelsup_id");
	JLabel fname_lb=new JLabel("last_name");
	JLabel lname_lb=new JLabel("first_name");
	JLabel email_lb=new JLabel(" email");
	JLabel adr_lb=new JLabel("address");
	JLabel phon_lb=new JLabel(" phone_number");
	

	JTextField id_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField telephone_txf=new JTextField();
	JTextField adr_txf=new JTextField();

	//Buttons CRUD
	JButton INSERT_btn=new JButton("INSERT");
	JButton READ_btn=new JButton("View");
	JButton UPDATE_tbtn=new JButton("UPDATE");
	JButton DELETE_btn=new JButton("DELETE");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public fuelsupplerform() {
		createForm();

	}
	private void ActionEvent() {
		INSERT_btn.addActionListener(this);
		READ_btn.addActionListener(this);
		UPDATE_tbtn.addActionListener(this);
		DELETE_btn.addActionListener(this);
		//placeBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("fuelsuppler form");
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
		fname_lb.setBounds(10, 50, 150, 30);
		lname_lb.setBounds(10, 90, 100, 30);
		email_lb.setBounds(10, 130, 100, 30);
		phon_lb.setBounds(10, 170, 100, 30);
		adr_lb.setBounds(10, 210, 100, 30);
		id_txf.setBounds(180, 10, 300, 30);
		fname_txf.setBounds(180, 50, 300, 30);
		lname_txf.setBounds(180, 90, 300, 30);
		email_txf.setBounds(180, 130, 300, 30);
		telephone_txf.setBounds(180, 170, 300, 30);
		adr_txf.setBounds(180, 210, 300, 30);
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
		email_lb.setFont(font);
		phon_lb.setFont(font);
		adr_lb.setFont(font);

		id_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		email_txf.setFont(font);
		telephone_txf.setFont(font);
		adr_txf.setFont(font);
		
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
		frame.add(email_lb);
		frame.add(phon_lb);
		frame.add(adr_lb);
		frame.add(id_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(email_txf);
		frame.add(telephone_txf);
		frame.add(adr_txf);
		//Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		fuel_suppler supl=new fuel_suppler();
		if(e.getSource()==INSERT_btn) {
			supl.setfirst_name(fname_txf.getText());
			supl.setlast_name(lname_txf.getText());
			supl.setemail(email_txf.getText());
			supl.setphone_number(telephone_txf.getText());
			supl.setaddress(adr_txf.getText());
			
			supl.insertData();
		}else if (e.getSource()==READ_btn) {
			int id=Integer.parseInt(id_txf.getText());
			supl.readwithfuelsup_id (id);
			id_txf.setText(String.valueOf(supl.getfuelsup_id ()));
			fname_txf.setText(supl.getfirst_name());
			lname_txf.setText(supl.getlast_name());
			email_txf.setText(supl.getemail());
			telephone_txf.setText(supl.getphone_number());
			adr_txf.setText(supl.getaddress());
			
		}else if (e.getSource()==UPDATE_tbtn) {
			int id=Integer.parseInt(id_txf.getText());
			supl.setfirst_name(fname_txf.getText());
			supl.setlast_name(lname_txf.getText());
			supl.setemail(email_txf.getText());
			supl.setaddress(adr_txf.getText());
			supl.setphone_number(telephone_txf.getText());
			
			supl.update(id);
		}else {
			int id=Integer.parseInt(id_txf.getText());
			supl.delete(id);
		}

	}
	public static void main(String[] args) {
		fuelsupplerform cusf=new fuelsupplerform();
		System.out.println(cusf);

	}



}





	


