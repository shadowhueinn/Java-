import banking.Account;
import banking.BankingService;
import java.util.Scanner;

public class Appsecb {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("🏦 === WELCOME TO MULTI-SERVICE APPLICATION ===");
            System.out.println("1. Banking Application");
            System.out.println("2. Doctors Appointment");
            System.out.println("3. Shopping");
            
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    runBankingApplication(sc);
                    break;
                case 2:
                    System.out.println("🏥 Doctors Appointment feature - Coming Soon!");
                    break;
                case 3:
                    System.out.println("🛒 Shopping feature - Coming Soon!");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
    
    private static void runBankingApplication(Scanner sc) {
        BankingService bankingService = new BankingService();
        int resp;
        
        System.out.println("\n🏦 === BANKING APPLICATION ===");
        
        do {
            System.out.println("\n--- BANKING MENU ---");
            System.out.println("1. Register Account");
            System.out.println("2. Login Account");
            System.out.println("3. View All Accounts");
            System.out.println("4. Exit Banking");
            System.out.print("Enter Selection: ");
            int action = sc.nextInt();
            
            switch(action) {
                case 1:
                    bankingService.registerAccount();
                    break;
                    
                case 2:
                    Account loggedInAccount = bankingService.loginAccount();
                    if (loggedInAccount != null) {
                        bankingService.bankingOperationsMenu(loggedInAccount);
                    }
                    break;
                    
                case 3:
                    bankingService.viewAllAccounts();
                    break;
                    
                case 4:
                    System.out.println("👋 Exiting Banking Application...");
                    return;
                    
                default:
                    System.out.println("❌ Invalid selection!");
            }
            
            System.out.print("\nDo you want to continue with banking? (1/0): ");
            resp = sc.nextInt();
            
        } while(resp == 1);
        
        System.out.println("Thank you for using Banking Application! 🙏");
    }
}
