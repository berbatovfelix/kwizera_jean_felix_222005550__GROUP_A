package forms.entities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


	public class menuform extends JFrame implements ActionListener {
	    private static final long serialVersionUID = 1L;

	    private JMenuBar menuBar;
	    private JMenu customersMenu;
	    private JMenu fuel_stationMenu;
	    private JMenu fuelsupplerMenu;
	    private JMenu DriverMenu;
	    private JMenu banksMenu;
	    private JMenu logoutMenu;

	    private JMenuItem customersItem;
	    private JMenuItem fuel_stationItem;
	    private JMenuItem fuelsupplerItem;
	    private JMenuItem DriverItem;
	    private JMenuItem banksItem;
	    private JMenuItem logoutItem;

	    private String loggedInUser;

	    public menuform(String username) {
	        this.loggedInUser = username;
	        setTitle("Dashboard");
	        setSize(700, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Create menu bar
	        menuBar = new JMenuBar();

	        // Create menu items
	        customersMenu = new JMenu("customers");
	        customersItem = new JMenuItem("customers Form");
	        customersItem.addActionListener(this);

	        fuel_stationMenu = new JMenu("fuel_station");
	        fuel_stationItem = new JMenuItem("fuel_station Form");
	        fuel_stationItem.addActionListener(this);

	        fuelsupplerMenu = new JMenu("fuelsuppler");
	        fuelsupplerItem = new JMenuItem("fuelsuppler Form");
	        fuelsupplerItem.addActionListener(this);

	        DriverMenu = new JMenu("Driver");
	        DriverItem = new JMenuItem("Driver Form");
	        DriverItem.addActionListener(this);

	        banksMenu = new JMenu("banks");
	        banksItem = new JMenuItem("banks Form");
	        banksItem.addActionListener(this);
	        logoutMenu = new JMenu("Logout");
	        logoutItem = new JMenuItem("Logout");
	        logoutItem.addActionListener(this);
	      
	        // Add menu items to respective menus
	        customersMenu.add(customersItem);
	        fuel_stationMenu.add(fuel_stationItem);
	        fuelsupplerMenu.add(fuelsupplerItem);
	        DriverMenu.add(DriverItem);
	        banksMenu.add(banksItem);
	      

	        // Add menus to menu bar
	        menuBar.add(customersMenu);
	        menuBar.add(fuel_stationMenu);
	        menuBar.add(fuelsupplerMenu);
	        menuBar.add(DriverMenu);
	        menuBar.add(banksMenu);
	      
	        menuBar.add(logoutMenu);

	        // Set menu bar to frame
	        setJMenuBar(menuBar);

	        // Initialize dashboard panel
	        JPanel dashboardPanel = new JPanel();
	        dashboardPanel.setLayout(new BorderLayout());

	        // Add components to dashboard panel
	        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " TO THE fuel_delivery_app_management_project");
	        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 50));
	        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

	        // Add dashboard panel to frame
	        add(dashboardPanel);

	        setVisible(true);
	    }

	    public menuform() {
			// TODO Auto-generated constructor stub
		}

		@Override
	    
	    public void actionPerformed(ActionEvent e) {
	        try {
	            if (e.getSource() == customersItem) {
	                new forms.entities.customersform();
	            } else if (e.getSource() == fuel_stationItem) {
	                new fuel_stationform();
	            } else if (e.getSource() == fuelsupplerItem) {
	                new fuelsupplerform();
	            } else if (e.getSource() == DriverItem) {
	                new DriverForm();
	            } else if (e.getSource() == banksItem) {
	                new banksForms();
	            } else if (e.getSource() == logoutItem) {
	            	int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout",
	                        JOptionPane.YES_NO_OPTION);
	                if (choice == JOptionPane.YES_OPTION) {
	                    dispose();
	                }
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            // Handle the exception (log, display an error message, etc.)
	        }
	    }

	 
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new menuform("fuel_delivery_app_management_project"));
}}
