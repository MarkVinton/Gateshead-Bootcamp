
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

    Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        createAccount newUser = new createAccount();

//Checks the username and password against the pretend database
        newUser.userAndPass();

//Asks the user which account type to create 
        newUser.accountType();

//Asks the user how many Signatories are required
//If more than 2 are required the user is asked for an extra password
        newUser.signatories();

//Generates a random number for the user's account
        newUser.accountNumber();

// Prints out a Summary of the users account information
        newUser.accountSummary();

//Adds the new Users to the pretend database
        addAccount(newUser);

//Allows the users to login with their new account
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

    private void  accountSummary(){
        System.out.println("Account created");
        System.out.println("Username: " + this.customerUsername);
        System.out.println("Password: " + this.customerPassword);
        System.out.println("Account type: " + this.accountType);
        System.out.println("Account number: " + this.AccountNumber);
        System.out.println("Overdraft: " + this.overdraft);
        System.out.println("Balance: " + this.initialDeposit);
        System.out.println("Signatories required: " + this.signatoriesRequired);
    }


    public  void accountType(){
    int i = 0;
        while (i == 0) {   
        System.out.println("Enter account type (Small Business, Community, Client, Charity):");
        this.accountType = scanner.nextLine();
        if (!this.accountType.equals("Small Business") && 
        !this.accountType.equals("Community") && 
        !this.accountType.equals("Client") && 
        !this.accountType.equals("Charity")) {
            System.out.println("Invalid account type. Please enter a valid account.");
        }else{
            i = 1;
            switch (this.accountType) {
                case "Small Business":
                if (smallBusinessAccount == false){
                    smallBusinessAccount = true;
                    this.overdraft = 1000;
                    System.out.println("Enter an initial deposit:");
                    this.initialDeposit = scanner.nextInt();
                    this.balanceSmallBusiness = this.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Small Business account, please select another account type.");
                    i = 0;
                    break;
                }
                case "Community":
                    if (communityAccount == false){
                    communityAccount = true;
                    this.overdraft = 2500;
                    System.out.println("Enter an initial deposit:");
                    this.initialDeposit = scanner.nextInt();
                    this.balanceCommunity = this.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Community account, please select another account type.");
                    i = 0;
                    break;
                }
                case "Client":
                    if (clientAccount == false){
                    clientAccount = true;
                    this.overdraft = 1500;
                    System.out.println("Enter an initial deposit:");
                    this.initialDeposit = scanner.nextInt();
                    this.balanceClient = this.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Client account, please select another account type.");
                    i = 0;
                    break;
                }
                case "Charity": 
                    if (charityAccount == false){
                    charityAccount = true;
                    this.overdraft = 3000;
                    System.out.println("Enter an initial deposit:");
                    this.initialDeposit = scanner.nextInt();
                    this.balanceCharity = this.initialDeposit;
                    break;
                }else{
                    System.out.println("You already have a Charity account, please select another account type");
                    i = 0;
                    break;
                }
            }
        }
    }
}


    private String passwordValidation() { //method to validate password to ensure security
        boolean validPassword = false;
        String inputPassword = "";

        while (validPassword != true) {
            System.out.println("Enter a password (minimum 8 chars, 1 number, and 1 special character):");
            inputPassword = scanner.nextLine();

            if (inputPassword.length() >= 8 &&
                inputPassword.matches(".*\\d.*") && // using regex to check for at least one digit
                inputPassword.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) { // using regex to check for at least one special character
                validPassword = true;
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        }
        
    return inputPassword;
}

    private void userAndPass() {
        System.out.println("Enter a username:");
        this.customerUsername = scanner.nextLine();
        this.customerPassword = passwordValidation();
    }
    public void signatories(){
        System.out.println("How many signatories are required?");
        this.signatoriesRequired = scanner.nextInt();
        scanner.nextLine();

        if ((int)this.signatoriesRequired > 1){
            System.out.println("Please Enter/Create your extra password");
            this.extraPassword = passwordValidation();
        }
    }


    public void accountNumber(){
        this.AccountNumber = (int)(Math.random() * 10000);
    }
}


