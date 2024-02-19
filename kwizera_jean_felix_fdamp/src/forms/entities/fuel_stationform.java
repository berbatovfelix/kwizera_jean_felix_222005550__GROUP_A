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

		public class fuel_stationform implements ActionListener{
			JFrame frame;
			JLabel id_lb=new JLabel("fuelsta_id");
			JLabel names_lb=new JLabel("name");
			JLabel adre_lb=new JLabel("address");
			JLabel phon_lb=new JLabel("phone");
			JLabel fuel_type_lb=new JLabel("fuel_type");

			JTextField id_txf=new JTextField();
			JTextField names_txf=new JTextField();
			JTextField adre_txf=new JTextField();
			JTextField phon_txf=new JTextField();
			JTextField adr_txf=new JTextField();
			String []fuel_type={"gaz", "Gasoline","OIL"};
			JComboBox<String> fuel_typeBox = new JComboBox<>(fuel_type);

			//Buttons CRUD
			JButton INSERT_btn=new JButton("INSERT");
			JButton READ_btn=new JButton("View");
			JButton UPDATE_tbtn=new JButton("UPDATE");
			JButton DELETE_btn=new JButton("DELETE");
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			int w=(int) screensize.getWidth();
			int h=(int) screensize.getHeight();
			public fuel_stationform() {
				createForm();

			}
			private void ActionEvent() {
				INSERT_btn.addActionListener(this);
				READ_btn.addActionListener(this);
				UPDATE_tbtn.addActionListener(this);
				DELETE_btn.addActionListener(this);
				//fuel_typeBox.addActionListener(this);
			}
			private void createForm() {
				frame=new JFrame();
				frame.setTitle("fuel_station form");
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
				names_lb.setBounds(10, 50, 100, 30);             				adre_lb.setBounds(10, 90, 100, 30);
				phon_lb.setBounds(10, 130, 100, 30);
				fuel_type_lb.setBounds(10, 170, 180, 30);
				id_txf.setBounds(180, 10, 300, 30);
				names_txf.setBounds(180, 50, 300, 30);
				adre_txf.setBounds(180, 90, 300, 30);
				phon_txf.setBounds(180, 130, 300, 30);
				fuel_typeBox.setBounds(180, 170, 300, 30);
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
				names_lb.setFont(font);
				adre_lb.setFont(font);
				phon_lb.setFont(font);

				id_txf.setFont(font);
				names_txf.setFont(font);
				adre_txf.setFont(font);
				phon_txf.setFont(font);
				
				adr_txf.setFont(font);
				fuel_type_lb.setFont(font);
				fuel_typeBox.setFont(font);
				//Buttons CRUD
				Font fonti = new Font("Courier New", Font.ITALIC, 12);

				INSERT_btn.setFont(fonti);
				READ_btn.setFont(fonti);
				UPDATE_tbtn.setFont(fonti);
				DELETE_btn.setFont(fonti);

			}
			private void addcomponentforFrame() {
				frame.add(id_lb);
				frame.add(names_lb);
				frame.add(adre_lb);
				frame.add(phon_lb);
				frame.add(fuel_type_lb);
				frame.add(id_txf);
				frame.add(names_txf);
				frame.add(adre_txf);
				frame.add(phon_txf);
				frame.add(adr_txf);
				frame.add(fuel_typeBox);
				//Buttons CRUD
				frame.add(INSERT_btn);
				frame.add(READ_btn);
				frame.add(UPDATE_tbtn);
				frame.add(DELETE_btn);
				ActionEvent();
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				fuel_station cust=new fuel_station();
				if(e.getSource()==INSERT_btn) {
					cust.setname(names_txf.getText());
					cust.setaddress(adre_txf.getText());
					cust.setphone(phon_txf.getText());
					String selectedOption = (String) fuel_typeBox.getSelectedItem();
					cust.setfuel_type(selectedOption);
					cust.insertData();
				}else if (e.getSource()==READ_btn) {
					int id=Integer.parseInt(id_txf.getText());
					cust.readwithfuelsta_id(id);
					id_txf.setText(String.valueOf(cust.getfuelsta_id()));
					names_txf.setText(cust.getname());
					adre_txf.setText(cust.getaddress());
					phon_txf.setText(cust.getphone());
					cust.setfuel_type(cust.getfuel_type());
					
				}else if (e.getSource()==UPDATE_tbtn) {
					int id=Integer.parseInt(id_txf.getText());
					cust.setname(names_txf.getText());
					cust.setaddress(adre_txf.getText());
					cust.setphone(phon_txf.getText());
					cust.setfuel_type(fuel_typeBox.getToolTipText());
					
			
					cust.update(id);
				}else {
					int id=Integer.parseInt(id_txf.getText());
					cust.delete(id);
				}

			}
			public static void main(String[] args) {
				fuel_stationform fuel_station=new fuel_stationform();
				System.out.println(fuel_station);

			}



		}

