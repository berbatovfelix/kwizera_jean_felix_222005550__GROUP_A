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

import entities.driver;
public class DriverForm implements ActionListener {
    JFrame frame;
    JLabel id_lb = new JLabel("driver_id ");
    JLabel fname_lb = new JLabel("first_name");
    JLabel lname_lb = new JLabel("last_name");
    JLabel phone_lb = new JLabel(" phone");
    JLabel lince_lb = new JLabel("licence_number");
    JLabel vehicle_id_lb = new JLabel(" vehicle_id ");

    JTextField id_txf = new JTextField();
    JTextField fname_txf = new JTextField();
    JTextField lname_txf = new JTextField();
    JTextField phone_txf = new JTextField();
    JTextField licence_number_txf = new JTextField();
    JTextField vehicle_id_txf = new JTextField();
	//Buttons CRUD
    JButton INSERT_btn = new JButton("INSERT");
    JButton READ_btn = new JButton("View");
    JButton UPDATE_tbtn = new JButton("UPDATE");
    JButton DELETE_btn = new JButton("DELETE");
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getHeight();
    public DriverForm() {
        createForm();
    }
    private void ActionEvent() {
        INSERT_btn.addActionListener(this);
        READ_btn.addActionListener(this);
        UPDATE_tbtn.addActionListener(this);
        DELETE_btn.addActionListener(this);
        // placeBox.addActionListener(this);
    }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("driver form");
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
		phone_lb.setBounds(10, 130, 100, 30);
		lince_lb.setBounds(10, 170, 100, 30);
		vehicle_id_lb.setBounds(10, 210, 100, 30);
		id_txf.setBounds(180, 10, 300, 30);
		fname_txf.setBounds(180, 50, 300, 30);
		lname_txf.setBounds(180, 90, 300, 30);
		phone_txf.setBounds(180, 130, 300, 30);
		licence_number_txf.setBounds(180, 170, 300, 30);
		vehicle_id_txf.setBounds(180, 210, 300, 30);
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
		phone_lb.setFont(font);
		lince_lb.setFont(font);
		vehicle_id_lb.setFont(font);

		id_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		phone_txf.setFont(font);
		licence_number_txf.setFont(font);
		vehicle_id_txf.setFont(font);
		
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
		frame.add(phone_lb);
		frame.add(lince_lb);
		frame.add(vehicle_id_lb);
		frame.add(id_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(phone_txf);
		frame.add(licence_number_txf);
		frame.add(vehicle_id_txf);
		//Buttons CRUD
		frame.add(INSERT_btn);
		frame.add(READ_btn);
		frame.add(UPDATE_tbtn);
		frame.add(DELETE_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		driver supl=new driver();
		if(e.getSource()==INSERT_btn) {
			supl.setFirst_name(fname_txf.getText());
			supl.setLast_name(lname_txf.getText());
			supl.setPhone(phone_txf.getText());
			supl.setLicence_number (licence_number_txf.getText());
			supl.setVehicle_id(vehicle_id_txf.getText());
			
			supl.insertData();
		}else if (e.getSource()==READ_btn) {
			int id=Integer.parseInt(id_txf.getText());
			supl.readwithdriver_id  (id);
			id_txf.setText(String.valueOf(supl.getDriver_id  ()));
			fname_txf.setText(supl.getFirst_name());
			lname_txf.setText(supl.getLast_name());
			phone_txf.setText(supl.getPhone());
			vehicle_id_txf.setText(supl.getVehicle_id ());
			licence_number_txf.setText(supl.getLicence_number());
			
		}else if (e.getSource()==UPDATE_tbtn) {
			int id=Integer.parseInt(id_txf.getText());
			supl.setFirst_name(fname_txf.getText());
			supl.setLast_name(lname_txf.getText());
			supl.setPhone(phone_txf.getText());
			supl.setLicence_number (licence_number_txf.getText());
			supl.setVehicle_id(vehicle_id_txf.getText());
			
			supl.update(id);
		}else {
			int id=Integer.parseInt(id_txf.getText());
			supl.delete(id);
		}

	}
	public static void main(String[] args) {
		DriverForm cusf=new DriverForm();
		System.out.println(cusf);

	}



}



