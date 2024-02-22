package bankaccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class BankAppGUI {

    private final JFrame frame;
    private final JPanel accountPanel, transactionPanel;
    private final JTextField existingAccountNumberTextField, nameTextField, balanceTextField, amountTextField;
    private final JButton createAccountButton, retreiveAccountButton, depositButton, withdrawButton, logButton;
    private BankAccount currentAccount; // the current account
    private LinkedList<BankAccount> accounts = new LinkedList<>(); // stores accounts
    private Random rand = new Random();


    public BankAppGUI() {

        for (int i = 0; i < 100; i++) {
            accounts.add(new BankAccount(rand.nextDouble() * 1000));
        }

        frame = new JFrame("Bank App");
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
        retreiveAccountButton = new JButton("Get Account");
        accountPanel.add(retreiveAccountButton);

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

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        mainPanel.add(accountPanel);
        mainPanel.add(transactionPanel);

        // Event Listeners
        createAccountButton.addActionListener(new CreateAccountListener());
        retreiveAccountButton.addActionListener(new RetrieveAccountListener());
        depositButton.addActionListener(new DepositListener());
        withdrawButton.addActionListener(new WithdrawListener());
        logButton.addActionListener(new LogListener());

        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private class CreateAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentAccount = new BankAccount(); // Create new account
            nameTextField.setText(String.valueOf(currentAccount.getAccountNumber()));
            balanceTextField.setText(String.format("%.2f", currentAccount.getBalance()));
            existingAccountNumberTextField.setText("");
            accounts.add(currentAccount);
            JOptionPane.showMessageDialog(frame, "Account created! ");
        }
    }

    public class RetrieveAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String existingAccountNumber = existingAccountNumberTextField.getText();

            if (existingAccountNumber.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter an account number.");
                return;
            }

            try {
                int accountNumber = Integer.parseInt(existingAccountNumber);
                for (BankAccount account : accounts) {
                    if (account.getAccountNumber() == accountNumber) {
                        currentAccount = account;
                        nameTextField.setText(String.valueOf(currentAccount.getAccountNumber()));
                        balanceTextField.setText(String.format("%.2f", currentAccount.getBalance()));
                        existingAccountNumberTextField.setText("");
                        JOptionPane.showMessageDialog(frame, "Account retrieved successfully.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Account not found.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid account number. Please enter a valid number.");
            }
        }
    }

    private class DepositListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentAccount == null) {
                JOptionPane.showMessageDialog(frame, "Please select an account first.");
                return;
            }
            try {
                double amount = Double.parseDouble(amountTextField.getText());
                currentAccount.deposit(amount);
                balanceTextField.setText(String.format("%.2f", currentAccount.getBalance()));
                amountTextField.setText("");
                JOptionPane.showMessageDialog(frame, "Deposit successful!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a number.");
            }
        }
    }

    private class WithdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentAccount == null) {
                JOptionPane.showMessageDialog(frame, "Please select an account first.");
                return;
            }
            try {
                double amount = Double.parseDouble(amountTextField.getText());
                if (amount > currentAccount.getBalance()) {
                    JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                    return;
                }
                currentAccount.withdraw(amount);
                balanceTextField.setText(String.format("%.2f", currentAccount.getBalance()));
                amountTextField.setText("");
                JOptionPane.showMessageDialog(frame, "Withdrawal successful!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a number.");
            }
        }
    }

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
        new BankAppGUI();
    }
}