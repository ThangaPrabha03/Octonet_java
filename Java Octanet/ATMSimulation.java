import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {

    private static double balance = 1000.00;
    private static String pin = "1234";
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Account Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. PIN Change");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash(scanner);
                    break;
                case 3:
                    depositCash(scanner);
                    break;
                case 4:
                    changePin(scanner);
                    break;
                case 5:
                    printTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting ATM. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked Balance: $" + balance);
    }

    private static void withdrawCash(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance. Try a lower amount.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            transactionHistory.add("Withdrew: $" + amount);
        }
    }

    private static void depositCash(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Successfully deposited: $" + amount);
        transactionHistory.add("Deposited: $" + amount);
    }

    private static void changePin(Scanner scanner) {
        System.out.print("Enter current PIN: ");
        String currentPin = scanner.next();

        if (currentPin.equals(pin)) {
            System.out.print("Enter new PIN: ");
            String newPin = scanner.next();
            pin = newPin;
            System.out.println("PIN successfully changed.");
            transactionHistory.add("PIN changed.");
        } else {
            System.out.println("Incorrect current PIN. Please try again.");
        }
    }

    private static void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions made.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}