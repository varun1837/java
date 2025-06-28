import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String name;
    private double balance;

    public Account(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class BankingApp {
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Banking System Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static Account findAccount(String name) {
        for (Account acc : accounts) {
            if (acc.getName().equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }

    public static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        if (findAccount(name) == null) {
            accounts.add(new Account(name));
            System.out.println("Account created successfully for " + name + ".");
        } else {
            System.out.println("Account with this name already exists.");
        }
    }

    public static void deposit() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        Account acc = findAccount(name);
        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            acc.deposit(amount);
            System.out.println("Deposited $" + amount + ". New balance: $" + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void withdraw() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        Account acc = findAccount(name);
        if (acc != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            if (acc.withdraw(amount)) {
                System.out.println("Withdrew $" + amount + ". Remaining balance: $" + acc.getBalance());
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void checkBalance() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        Account acc = findAccount(name);
        if (acc != null) {
            System.out.println("Account balance for " + name + ": $" + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
