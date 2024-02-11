package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI implements ActionListener {

    //Attributes
    private JFrame frame;
    private JPanel panel, statusPanel;
    private JLabel userLabel, passwordLabel, statusLabel;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;

    /**
     * Constructs a new instance of the login Graphical interface
     */
    public LoginGUI() {

        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Main panel containing login input fields
        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        userLabel = new JLabel("Username:");
        userText = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordText = new JPasswordField();
        loginButton = new JButton("Login");

        loginButton.addActionListener(this);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(userLabel);
        inputPanel.add(userText);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordText);

        panel.add(inputPanel, BorderLayout.CENTER);

        // Panel for status message and login button
        statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusLabel = new JLabel();
        statusPanel.add(loginButton);
        statusPanel.add(statusLabel);


        frame.add(panel, BorderLayout.CENTER);
        frame.add(statusPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    /**
     * Handles actions performed by login button.
     * @param e Action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = new String(passwordText.getPassword());

        if (isValidLogin(username, password)) {
            showStatusMessage("Login Successful!", Color.GREEN);
            closeLogin();
        } else {
            showStatusMessage("Login Unsuccessful!", Color.RED);
            // Shake and highlight the text fields
            shakeAndHighlightFields();
        }
    }

    /**
     * Validates the login credentials.
     * @param username Username
     * @param password Password
     * @return true if login is valid, false otherwise
     */
    private boolean isValidLogin(String username, String password) {
        // Perform actual validation, for simplicity, checking hardcoded values
        return username.equals("Owen") && password.equals("Pass");
    }

    /**
     * Displays a status message with a given color.
     * @param message Message to display
     * @param color Color of the message
     */
    private void showStatusMessage(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setForeground(color);
    }

    /**
     * Closes the login window after a delay.
     */
    private void closeLogin() {
        Timer timer = new Timer(2000, (e) -> frame.dispose()); // Close the login window after 2 seconds
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Animates the text fields by shaking and highlighting them.
     */
    private void shakeAndHighlightFields() {
        // Shake and highlight animation for text fields
        shakeComponent(userText);
        shakeComponent(passwordText);
    }

    /**
     * Animates a component by shaking it horizontally.
     * @param component Component to shake
     */
    private void shakeComponent(Component component) {
        final int shakeDistance = 2;
        final int shakeCount = 5;
        Point originalLocation = component.getLocation();
        Color originalColor = component.getBackground();
        Timer timer = new Timer(50, null);
        timer.addActionListener(new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                int dx = (count % 2 == 0 ? shakeDistance : -shakeDistance);
                component.setLocation(originalLocation.x + dx, originalLocation.y);
                count++;
                if (count == shakeCount * 2) {
                    timer.stop();
                    component.setLocation(originalLocation);
                    component.setBackground(originalColor); // Revert the background color
                } else {
                    // Change foreground color to red during the shake
                    if (count % 2 == 0) {
                        component.setForeground(Color.RED);
                    } else {
                        component.setBackground(originalColor);
                    }
                }
            }
        });
        timer.start();
    }
}
