package synchronisation;

public class Users {

    static final BankAccount account = new BankAccount(50);
    static final BankAccount account2 = new BankAccount(50);
    static final BankAccount account3 = new BankAccount(50);

    public static void main(String[] args) {

        account.topUp(100 );
        account2.topUp(100 );
        account3.topUp(100 );

        Thread t1 = new Thread(() -> ATM.withdraw(account, 100));
        Thread t2 = new Thread(() -> ATM.withdraw(account, 100));

        Thread t3 = new Thread(() -> ATM.withdraw(account2, 100));
        Thread t5 = new Thread(() -> ATM.withdraw(account2, 100));

        Thread t4 = new Thread(() -> ATM.withdraw(account3, 100));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
