
import java.util.Scanner;

public class createAccount {
    String customerUsername;
    String customerPassword;
    String accountType;
    int AccountNumber;
    int overdraft;
    double initialDeposit;
    double balanceCharity = 0;
    double balanceClient = 0;
    double balanceCommunity = 0;
    double balanceSmallBusiness = 0;
    int signatoriesRequired;
    static boolean charityAccount = false;
    static boolean clientAccount = false;
    static boolean communityAccount = false;
    static boolean smallBusinessAccount = false;
    String extraPassword;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//         clientAccount = true;
        createAccount newUser = new createAccount();
        System.out.println("Enter a username:");
        newUser.customerUsername = scanner.nextLine();

        System.out.println("Enter a password:");
        newUser.customerPassword = scanner.nextLine();

        int i = 0;
        while (i == 0) {   
        System.out.println("Enter account type (Small Business, Community, Client, Charity):");
        newUser.accountType = scanner.nextLine();
        if (!newUser.accountType.equals("Small Business") && !newUser.accountType.equals("Community") && !newUser.accountType.equals("Client") && !newUser.accountType.equals("Charity")) {
            System.out.println("Invalid account type. Please enter a valid account.");
        }else{
            i = 1;
            switch (newUser.accountType) {
                case "Small Business":
                if (smallBusinessAccount == false){
                    newUser.overdraft = 1000;
                    System.out.println("Enter an initial deposit:");
                    newUser.initialDeposit = scanner.nextInt();
                    newUser.balanceSmallBusiness = newUser.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Small Business account, please select another account type.");
                    i = 0;
                    break;
                }
                case "Community":
                    if (communityAccount == false){
                    newUser.overdraft = 2500;
                    System.out.println("Enter an initial deposit:");
                    newUser.initialDeposit = scanner.nextInt();
                    newUser.balanceCommunity = newUser.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Community account, please select another account type.");
                    i = 0;
                    break;
                }
                case "Client":
                    if (clientAccount == false){
                    newUser.overdraft = 1500;
                    System.out.println("Enter an initial deposit:");
                    newUser.initialDeposit = scanner.nextInt();
                    newUser.balanceClient = newUser.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Client account, please select another account type.");
                    i = 0;
                    break;
                }
                case "Charity": 
                    if (charityAccount == false){
                    newUser.overdraft = 3000;
                    System.out.println("Enter an initial deposit:");
                    newUser.initialDeposit = scanner.nextInt();
                    newUser.balanceCharity = newUser.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Charity account, please select another account type");
                    i = 0;
                    break;
                }
            }
        }
    }
        System.out.println("How many signatories are required?");
        newUser.signatoriesRequired = scanner.nextInt();
        scanner.nextLine();
        if ((int)newUser.signatoriesRequired > 1){
            System.out.println("Please Enter/Create your extra password");
            newUser.extraPassword = scanner.nextLine();
        }

        newUser.AccountNumber = (int)(Math.random() * 10000);

        System.out.println("Account created");
        System.out.println("Username: " + newUser.customerUsername);
        System.out.println("Password: " + newUser.customerPassword);
        System.out.println("Account type: " + newUser.accountType);
        System.out.println("Account number: " + newUser.AccountNumber);
        System.out.println("Overdraft: " + newUser.overdraft);
        System.out.println("Balance: " + newUser.initialDeposit);
        System.out.println("Signatories required: " + newUser.signatoriesRequired);
        
        addAccount(newUser); 
        login.main(args);       
}
    public static void addAccount(createAccount newAccount) {

        Object[][] oldInfo = pretendDatabase.userInfo;
        Object[][] newInfo = new Object[oldInfo.length + 1][];

        for (int i = 0; i < oldInfo.length; i++) {
            newInfo[i] = oldInfo[i];
        }

        newInfo[oldInfo.length] = new Object[]
        {newAccount.customerUsername, 
        newAccount.customerPassword, 
        newAccount.accountType, 
        newAccount.AccountNumber, 
        newAccount.overdraft,
        newAccount.initialDeposit,  
        newAccount.balanceCharity,
        newAccount.balanceClient,
        newAccount.balanceCommunity,
        newAccount.balanceSmallBusiness,
        newAccount.signatoriesRequired,
        clientAccount, 
        communityAccount, 
        smallBusinessAccount,
        charityAccount, 
        newAccount.extraPassword
        };

        pretendDatabase.userInfo = newInfo;
        //Testing that a new object is added to the pretend database.
        System.out.println(pretendDatabase.userInfo.length);
        System.out.println(pretendDatabase.userInfo[3][1]);
    }
}

