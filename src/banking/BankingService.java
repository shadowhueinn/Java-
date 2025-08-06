package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingService {
    private ArrayList<Account> accounts;
    private Scanner scanner;

    public BankingService() {
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    
    public boolean registerAccount() {
        System.out.print("Enter Account No.: ");
        int accountNo = scanner.nextInt();
        
        
        if (findAccountByNumber(accountNo) != null) {
            System.out.println("Account number already exists!");
            return false;
        }

        scanner.nextLine(); 
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Initial Balance: ");
        float balance = scanner.nextFloat();
        
        System.out.print("Enter Account Pin (4 digits): ");
        int pin = scanner.nextInt();

        Account newAccount = new Account(accountNo, name, balance, pin);
        accounts.add(newAccount);
        
        System.out.println("✅ Account registered successfully!");
        System.out.println("Account Details:");
        newAccount.displayAccount();
        return true;
    }

    
    public Account loginAccount() {
        int attempts = 3;
        
        while (attempts > 0) {
            System.out.print("Enter your Account No: ");
            int accountNo = scanner.nextInt();
            System.out.print("Enter your Pin: ");
            int pin = scanner.nextInt();

            Account account = findAccountByNumber(accountNo);
            
            if (account != null && account.verifyAccount(accountNo, pin)) {
                System.out.println("✅ LOGIN SUCCESS!");
                System.out.println("Welcome, " + account.getName());
                return account;
            } else {
                attempts--;
                if (attempts == 0) {
                    System.out.println("❌ ATTEMPT LIMIT REACHED!");
                    return null;
                }
                System.out.println("❌ INVALID ACCOUNT OR PIN!");
                System.out.println("Attempts Left: " + attempts);
            }
        }
        return null;
    }

    
    public void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts registered yet.");
            return;
        }

        System.out.println("\n=== ALL REGISTERED ACCOUNTS ===");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". ");
            accounts.get(i).displayAccount();
            System.out.println("------------------------");
        }
    }

    
    private Account findAccountByNumber(int accountNo) {
        for (Account account : accounts) {
            if (account.getAccountNo() == accountNo) {
                return account;
            }
        }
        return null;
    }

    
    public void bankingOperationsMenu(Account account) {
        int choice;
        do {
            System.out.println("\n=== BANKING OPERATIONS ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Account Details");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Current Balance: $" + account.getInitialBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    float depositAmount = scanner.nextFloat();
                    if (depositAmount > 0) {
                        account.setInitialBalance(account.getInitialBalance() + depositAmount);
                        System.out.println("✅ Deposit successful! New balance: $" + account.getInitialBalance());
                    } else {
                        System.out.println("❌ Invalid amount!");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    float withdrawAmount = scanner.nextFloat();
                    if (withdrawAmount > 0 && withdrawAmount <= account.getInitialBalance()) {
                        account.setInitialBalance(account.getInitialBalance() - withdrawAmount);
                        System.out.println("✅ Withdrawal successful! New balance: $" + account.getInitialBalance());
                    } else if (withdrawAmount > account.getInitialBalance()) {
                        System.out.println("❌ Insufficient balance!");
                    } else {
                        System.out.println("❌ Invalid amount!");
                    }
                    break;
                case 4:
                    account.displayAccount();
                    break;
                case 5:
                    System.out.println("👋 Logged out successfully!");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);
    }

    
    public int getTotalAccounts() {
        return accounts.size();
    }
}