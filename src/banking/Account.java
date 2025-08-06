package banking;

public class Account {
    private int accountNo;
    private String name;
    private float initialBalance;
    private int pin;

    
    public Account() {
        this.initialBalance = 0;
    }

    
    public Account(int accountNo, String name, float initialBalance, int pin) {
        this.accountNo = accountNo;
        this.name = name;
        this.initialBalance = initialBalance;
        this.pin = pin;
    }

    
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInitialBalance(float initialBalance) {
        this.initialBalance = initialBalance;
    }

    public float getInitialBalance() {
        return initialBalance;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

 
    public boolean verifyAccount(int acc, int pn) {
        return this.accountNo == acc && this.pin == pn;
    }

    
    public void displayAccount() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: $" + initialBalance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", name='" + name + '\'' +
                ", balance=" + initialBalance +
                '}';
    }
}