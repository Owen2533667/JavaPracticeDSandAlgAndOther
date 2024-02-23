package bankaccount;

public class Main {

    public static void main(String[] args) {

        // Create an instance of BankAppGUI to start the application
        new BankAppGUI();

        BankAccount accOne = new BankAccount();
        BankAccount accTwo = new BankAccount();
        BankAccount accThree = new BankAccount();
        BankAccount accFour = new BankAccount();

        accTwo.deposit(22.222);

        try {
            accOne.deposit(-23);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        accOne.deposit(30);

        accThree.deposit(100000);

        accFour.deposit(20.2131234);

        try {
            accOne.withdraw(31);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            accOne.withdraw(29);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println(accOne);
        System.out.println(accTwo);
        System.out.println(accThree);
        System.out.println(accFour);

    }

}
