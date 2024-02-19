package forms.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel last_namelb = new JLabel("last_name");
    private JLabel first_namelb = new JLabel("Password");
    private JTextField last_nametxf = new JTextField();
    private JPasswordField first_nametxf = new JPasswordField();
    private JButton login_btn = new JButton("Login");

    // Constants for Database Connection
    private static final String DB_URL = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    private static final String DB_USER = "222005550";
    private static final String DB_PASSWORD = "222005550";

    public Login() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();
    }

    private void addActionEvent() {
        login_btn.addActionListener(this);
    }

    private void addComponentsToFrame() {
        frame.add(last_namelb);
        frame.add(first_namelb);
        frame.add(last_nametxf);
        frame.add(first_nametxf);
        frame.add(login_btn);
    }

    private void setLocationAndSize() {
        last_namelb.setBounds(10, 50, 300, 30);
        first_namelb.setBounds(10, 100, 300, 30);
        last_nametxf.setBounds(180, 50, 300, 30);
        first_nametxf.setBounds(180, 100, 300, 30);
        login_btn.setBounds(280, 150, 100, 30);
    }

    private void createWindow() {
        frame = new JFrame();
        frame.setTitle("Welcome to Login Form");
        frame.setForeground(Color.WHITE);
        frame.setFont(new Font("Arial", Font.BOLD, 24));
        frame.setBounds(0, 0, 550, 320);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Buttons CRUD
        Font fonti = new Font("Courier New", Font.BOLD, 12);
        login_btn.setFont(fonti);
        login_btn.setForeground(Color.black);
        login_btn.setBackground(Color.white);
    }

    @Override
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login_btn) {
            String last_name = last_nametxf.getText();
            char[] first_name = first_nametxf.getPassword();

            // Check credentials against database
            if (validateCredentials(last_name, new String(first_name))) {
                JOptionPane.showMessageDialog(this, "Login successful!");

                // Instantiate and show the menuform
                SwingUtilities.invokeLater(() -> {
                    new menuform(last_name).setVisible(true);
                });  
                
                 
                dispose(); // Close the login form
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private boolean validateCredentials(String last_name, String password) {
        String query = "SELECT last_name, first_name FROM customers WHERE last_name = ? AND first_name = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, last_name);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
