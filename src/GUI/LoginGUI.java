package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI implements ActionListener {

    private JPanel panel;
    private JFrame frame;
    private JLabel userLabel, passwordLabel, successLabel;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;

    public LoginGUI() {
        // Initialise components
        panel = new JPanel();
        frame = new JFrame();
        userLabel = new JLabel("User:");
        userText = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordText = new JPasswordField();
        loginButton = new JButton("Login");
        successLabel = new JLabel("");

        // Set up panel
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(successLabel);

        // Set up frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Login");
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);

        // Add action listener to login button
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = new String(passwordText.getPassword());
        boolean loginSuccessful = user.equals("Owen") && password.equals("Pass");

        setSuccessText(loginSuccessful);
        if (loginSuccessful) {
            closeLogin();
        }
    }

    private void closeLogin() {
        // Close the login window after 3 seconds
        Timer timer = new Timer(3000, (e) -> frame.dispose());
        timer.setRepeats(false);
        timer.start();
    }

    private void setSuccessText(boolean success) {
        if (success) {
            successLabel.setForeground(Color.GREEN);
            successLabel.setText("Login successful!");
        } else {
            successLabel.setForeground(Color.RED);
            successLabel.setText("Login unsuccessful!");
        }
    }

}
