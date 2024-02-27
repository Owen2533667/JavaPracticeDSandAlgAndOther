package bankaccount;

import java.text.NumberFormat;

/**
 * This class represents a bank account with basic functionalities like depositing, withdrawing, and checking balance.
 *
 * @author owenhughes
 */
public class BankAccount {

    // Attributes
    private static int count; // Tracks the number of created accounts

    private final int accountNumber; // Unique account number of this account

    private double balance; // Current balance of the account

    // default constructor
    /**
     * Creates a new `BankAccount` with an initial balance of 0.
     * The account number is automatically assigned based on the number of accounts created previously.
     */
    public BankAccount() {
        this.accountNumber = count + 1;
        this.balance = 0;
        count++;
    }

    // custom constructor
    /**
     * Creates a new `BankAccount` with the specified initial balance.
     * The account number is automatically assigned based on the number of accounts created previously.
     *
     * @param balance The initial balance of the account.
     * @throws IllegalArgumentException If the specified balance is negative.
     */
    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = count + 1;
        this.balance = Math.floor(balance * 100) / 100; // Round to two decimal places
        count++;
    }

    // methods

    /**
     * Gets the account number of this account.
     *
     * @return The account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of this account.
     *
     * @return The balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of this account.
     *
     * @param balance The new balance.
     * @throws IllegalArgumentException If the specified balance is negative.
     */
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    /**
     * Deposits the specified amount into this account.
     *
     * @param amount The amount to deposit.
     * @throws IllegalArgumentException If the specified amount is negative.
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        this.balance += Math.floor(amount * 100) / 100; // Round to two decimal places
    }

    /**
     * Withdraws the specified amount from this account.
     * If the withdrawal amount exceeds the balance, an `ArithmeticException` is thrown.
     *
     * @param amount The amount to withdraw.
     * @throws ArithmeticException If the withdrawal amount exceeds the balance.
     * @throws IllegalArgumentException If the specified amount is negative.
     */
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
        }
        if ((balance - amount) >= 0) {
            this.balance -= Math.floor(amount * 100) / 100; // Round to two decimal places
        } else {
            throw new ArithmeticException("Withdraw failed. Amount exceeds balance!");
        }
    }

    /**
     * Returns a string representation of this account in the format:
     * Account:[Number: {account number}, Balance: £ {balance}]
     *
     * @return The string representation of the account.
     */
    @Override
    public String toString() {
        return String.format("Account:[Number: %d, Balance: £ %s]", accountNumber,
                NumberFormat.getInstance().format(balance));
    }

}
