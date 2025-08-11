import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class Account {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal failed: Insufficient balance.");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
        System.out.println("Amount withdrawn successfully.");
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayTransactions() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Main Class
public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double initBalance = sc.nextDouble();

            Account account = new Account(accNo, initBalance);

            while (true) {
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Balance\n4. Transactions\n5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        try {
                            account.withdraw(withdrawAmount);
                        } catch (InsufficientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        account.displayBalance();
                        break;

                    case 4:
                        account.displayTransactions();
                        break;

                    case 5:
                        System.out.println("Exiting. Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
