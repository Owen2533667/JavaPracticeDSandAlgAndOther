package bankaccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * BankAppGUI class provides a graphical user interface for a simple bank application.
 */
public class BankAppGUI {

    // GUI components
    private final JFrame frame;
    private final JPanel accountPanel, transactionPanel;
    private final JTextField existingAccountNumberTextField, nameTextField, balanceTextField, amountTextField;
    private final JButton createAccountButton, retrieveAccountButton, depositButton, withdrawButton, logButton;

    // Current account
    private BankAccount currentAccount;

    // Stores accounts
    private LinkedList<BankAccount> accounts = new LinkedList<>();

    // Random number generator
    private Random rand = new Random();

    /**
     * Constructor to initialise the BankAppGUI.
     */
    public BankAppGUI() {
        // Create sample accounts
        for (int i = 0; i < 100; i++) {
            // Generate random initial balances for sample accounts
            accounts.add(new BankAccount(rand.nextDouble() * 1000));
        }

        // Initialise frame
        frame = new JFrame("Bank App");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Account Panel
        accountPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        accountPanel.setBorder(BorderFactory.createTitledBorder("Account Information"));
        existingAccountNumberTextField = new JTextField(15);
        balanceTextField = new JTextField(15);
        balanceTextField.setEditable(false);
        accountPanel.add(new JLabel("Existing Account Number:"));
        accountPanel.add(existingAccountNumberTextField);
        accountPanel.add(new JLabel("Account number:"));
        nameTextField = new JTextField(15);
        nameTextField.setEditable(false);
        accountPanel.add(nameTextField);
        accountPanel.add(new JLabel("Balance:"));
        accountPanel.add(balanceTextField);
        createAccountButton = new JButton("Create Account");
        accountPanel.add(createAccountButton);
        retrieveAccountButton = new JButton("Get Account");
        accountPanel.add(retrieveAccountButton);

        // Transaction Panel
        transactionPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        transactionPanel.setBorder(BorderFactory.createTitledBorder("Transactions"));
        amountTextField = new JTextField(15);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        logButton = new JButton("Log");
        transactionPanel.add(new JLabel("Amount:"));
        transactionPanel.add(amountTextField);
        transactionPanel.add(depositButton);
        transactionPanel.add(withdrawButton);
        transactionPanel.add(logButton);

        // Main Panel
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        mainPanel.add(accountPanel);
        mainPanel.add(transactionPanel);

        // Event Listeners
        createAccountButton.addActionListener(new CreateAccountListener());
        retrieveAccountButton.addActionListener(new RetrieveAccountListener());
        depositButton.addActionListener(new DepositListener());
        withdrawButton.addActionListener(new WithdrawListener());
        logButton.addActionListener(new LogListener());

        // Set content pane and display frame
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * ActionListener for creating a new account.
     */
    private class CreateAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new account with a random initial balance
            currentAccount = new BankAccount();
            // Set the account number and balance in the text fields
            nameTextField.setText(String.valueOf(currentAccount.getAccountNumber()));
            balanceTextField.setText(String.format("£%.2f", currentAccount.getBalance()));
            existingAccountNumberTextField.setText("");
            // Add the new account to the list of accounts
            accounts.add(currentAccount);
            // Display a confirmation message
            JOptionPane.showMessageDialog(frame, "Account created! ");
        }
    }

    /**
     * ActionListener for retrieving an existing account.
     */
    public class RetrieveAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve the entered account number from the text field
            String existingAccountNumber = existingAccountNumberTextField.getText();

            // Check if the account number field is empty
            if (existingAccountNumber.isEmpty()) {
                // Display an error message if no account number is entered
                JOptionPane.showMessageDialog(frame, "Please enter an account number.");
                return;
            }

            try {
                // Parse the entered account number
                int accountNumber = Integer.parseInt(existingAccountNumber);
                // Iterate through the list of accounts to find the matching account
                for (BankAccount account : accounts) {
                    if (account.getAccountNumber() == accountNumber) {
                        // Set the current account to the retrieved account
                        currentAccount = account;
                        // Display the account details in the text fields
                        nameTextField.setText(String.valueOf(currentAccount.getAccountNumber()));
                        balanceTextField.setText(String.format("£%.2f", currentAccount.getBalance()));
                        existingAccountNumberTextField.setText("");
                        // Display a success message
                        JOptionPane.showMessageDialog(frame, "Account retrieved successfully.");
                        return;
                    }
                }
                // Display an error message if the account is not found
                JOptionPane.showMessageDialog(frame, "Account not found.");
            } catch (NumberFormatException ex) {
                // Display an error message if the entered value is not a valid number
                JOptionPane.showMessageDialog(frame, "Invalid account number. Please enter a valid number.");
            }
        }
    }

    /**
     * ActionListener for depositing funds into the current account.
     */
    private class DepositListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Check if an account is selected
            if (currentAccount == null) {
                // Display an error message if no account is selected
                JOptionPane.showMessageDialog(frame, "Please select an account first.");
                return;
            }
            try {
                // Parse the entered amount
                double amount = Double.parseDouble(amountTextField.getText());
                // Deposit the amount into the current account
                currentAccount.deposit(amount);
                // Update the balance field with the new balance
                balanceTextField.setText(String.format("£%.2f", currentAccount.getBalance()));
                // Clear the amount field
                amountTextField.setText("");
                // Display a success message
                JOptionPane.showMessageDialog(frame, "Deposit successful!");
            } catch (NumberFormatException ex) {
                // Display an error message if the entered value is not a valid number
                JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a number.");
            }
        }
    }

    /**
     * ActionListener for withdrawing funds from the current account.
     */
    private class WithdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Check if an account is selected
            if (currentAccount == null) {
                // Display an error message if no account is selected
                JOptionPane.showMessageDialog(frame, "Please select an account first.");
                return;
            }
            try {
                // Parse the entered amount
                double amount = Double.parseDouble(amountTextField.getText());
                // Check if the withdrawal amount is greater than the balance
                if (amount > currentAccount.getBalance()) {
                    // Display an error message if there are insufficient funds
                    JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                    return;
                }
                // Withdraw the amount from the current account
                currentAccount.withdraw(amount);
                // Update the balance field with the new balance
                balanceTextField.setText(String.format("£%.2f", currentAccount.getBalance()));
                // Clear the amount field
                amountTextField.setText("");
                // Display a success message
                JOptionPane.showMessageDialog(frame, "Withdrawal successful!");
            } catch (NumberFormatException ex) {
                // Display an error message if the entered value is not a valid number
                JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a number.");
            }
        }
    }

    /**
     * ActionListener for logging all accounts and their details.
     */
    private class LogListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("*******************");
            for (BankAccount account : accounts) {
                System.out.println(account);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of BankAppGUI to start the application
        new BankAppGUI();
    }
}
