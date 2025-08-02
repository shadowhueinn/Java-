 package BankingClass.java;

public class bankingClass {
    private final int accountNo = 10001;
    private String name;
    private final float initialBalance = 0;
    private final int pin = 1234;
    private int pinAttempts = 0;
    private final int MAX_ATTEMPTS = 3;

    public boolean verifyAccount(int acc, int pn) {
        if (acc == accountNo && pn == pin) {
            pinAttempts = 0; // Reset attempts on successful login
            return true;
        } else {
            pinAttempts++;
            if (pinAttempts >= MAX_ATTEMPTS) {
                System.out.println("Too many incorrect PIN attempts. System will now close.");
                System.exit(0); // Terminate the program
            }
            return false;
        }
    }

    public int setAccount() {
        return accountNo;
    }

    public void viewBalance() {
        System.out.println("Current Balance: $" + initialBalance);
    }
}