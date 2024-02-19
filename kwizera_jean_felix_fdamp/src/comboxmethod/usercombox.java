package comboxmethod;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class usercombox {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Combo Box and Check Box Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Combo Box
        String[] options = {" user_id", " first_name", "last_name"," phone_number", "email", "role"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setSelectedIndex(0);

        // Check Box
        JCheckBox checkBox = new JCheckBox("Enable Feature");

        // Button
        JButton button = new JButton("confirm ");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                boolean featureEnabled = checkBox.isSelected();

                JOptionPane.showMessageDialog(frame,
                        "Selected Option: " + selectedOption + "\nFeature Enabled: " + featureEnabled,
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Layout
        frame.setLayout(new GridLayout(4, 1));
        frame.add(comboBox);
        frame.add(checkBox);
        frame.add(button);

        frame.setVisible(true);
    }


	




	}


