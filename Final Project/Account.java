import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Accounts account;   //make a variable of type Accounts, the parent class/ an abstract class that will be used to call the child classes

        System.out.println("Welcome to the Account Manager!");
        System.out.println("Select an account type:");
        System.out.println("1. Small Business");
        System.out.println("2. Community");
        System.out.println("3. Client");
        System.out.println("4. Charity");
        System.out.print("Enter choice 1,2,3,4 or 5");
       
       int choice = sc.nextInt(); // Get user input for account type

        //handle account type selection
        switch(choice) {
            case 1:
                account = new SmallBusiness(); // Instantiate a SmallBusiness object
                System.out.println("This is your Small Business account.");
                createAccount.smallBusinessAccount = true; // Set the flag to true in createAccount so that the user can not create the same account twice.
                System.out.println("Would you like to: 1: Deposit, 2:Withdraw, 3: Exit or 4: Transfer");
                int action = sc.nextInt();

                switch (action) {  // Nested switch statement to handle actions within the selected account type
                    case 1:
                        System.out.println("Enter a value");
                        double amount = sc.nextDouble();
                        account.deposit(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                    case 2:
                        System.out.println("Enter a value");
                        amount = sc.nextDouble();
                        account.withdraw(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                    case 3:
                        System.out.println("Enter what account to transfer to: 1: Community, 2: Client or 3: Charity.");
                        int transferChoice = sc.nextInt();

                        Accounts transferAccount = null; // Null ariable to hold the account to transfer to
                        switch (transferChoice) {
                            case 1: 
                            transferAccount = new Community();  // Instantiate an object of the selected account type 
                            break;
                            case 2: 
                            transferAccount = new Client(); 
                            break;
                            case 3: 
                            transferAccount = new Charity(); 
                            break;
                        }
                        if (transferAccount != null) {
                            System.out.println("Enter amount to transfer"); 
                            double transferAmount = sc.nextDouble();

                        if (account.getBalance() - transferAmount >= account.overdraft) {
                            account.withdraw(transferAmount);
                            transferAccount.deposit(transferAmount);
                            System.out.println("Transfer successful.");
                            System.out.println("Your new balance is £" + account.getBalance());
                        }else {
                            System.out.println("Insufficient funds to transfer.");
                        }

                    }
                        default: System.out.println("Invalid account choice:");
                    case 4:
                        System.out.println("You have chosen to exit.");
                        break;
                    
                }
                break;
            case 2:
                account = new Community();
                System.out.println("This is your Community account.");
                createAccount.communityAccount = true;
                System.out.println("Would you like to: 1: Deposit, 2:Withdraw or 3:Exit");
                int action2 = sc.nextInt();

                    switch (action2) {
                    case 1:
                        System.out.println("Enter a value");
                        double amount = sc.nextDouble();
                        account.deposit(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                    case 2:
                        System.out.println("Enter a value");
                        amount = sc.nextDouble();
                        account.withdraw(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                     case 3:
                        System.out.println("Enter what account to transfer to: 1: Community, 2: Client or 3: Charity.");
                        int transferChoice = sc.nextInt();

                        Accounts transferAccount = null;
                        switch (transferChoice) {
                            case 1: 
                            transferAccount = new SmallBusiness(); 
                            break;
                            case 2: 
                            transferAccount = new Client(); 
                            break;
                            case 3: 
                            transferAccount = new Charity(); 
                            break;
                        }

                        if (transferAccount != null) {
                            System.out.println("Enter amount to transfer");
                            double transferAmount = sc.nextDouble();

                        if (account.getBalance() - transferAmount >= account.overdraft) {
                            account.withdraw(transferAmount);
                            transferAccount.deposit(transferAmount);
                            System.out.println("Transfer successful.");
                            System.out.println("Your new balance is £" + account.getBalance());
                        }else {
                            System.out.println("Insufficient funds to transfer.");
                        }

                    }
                        default: System.out.println("Invalid account choice:");
                    case 4:
                        System.out.println("You have chosen to exit.");
                        break;
                    }
                    break;
            case 3:
                account = new Client();
                System.out.println("This is your Client account.");
                createAccount.clientAccount= true;
                System.out.println("Would you like to: 1: Deposit, 2:Withdraw or 3:Exit");
                int action3 = sc.nextInt();

                switch (action3) {
                    case 1:
                        System.out.println("Enter a value");
                        double amount = sc.nextDouble();
                        account.deposit(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                    case 2:
                        System.out.println("Enter a value");
                        amount = sc.nextDouble();
                        account.withdraw(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                     case 3:
                        System.out.println("Enter what account to transfer to: 1: Community, 2: Client or 3: Charity.");
                        int transferChoice = sc.nextInt();

                        Accounts transferAccount = null;
                        switch (transferChoice) {
                            case 1: 
                            transferAccount = new SmallBusiness(); 
                            break;
                            case 2: 
                            transferAccount = new Community(); 
                            break;
                            case 3: 
                            transferAccount = new Charity(); 
                            break;
                        }

                        if (transferAccount != null) {
                            System.out.println("Enter amount to transfer");
                            double transferAmount = sc.nextDouble();

                        if (account.getBalance() - transferAmount >= account.overdraft) {
                            account.withdraw(transferAmount);
                            transferAccount.deposit(transferAmount);
                            System.out.println("Transfer successful.");
                            System.out.println("Your new balance is £" + account.getBalance());
                        }else {
                            System.out.println("Insufficient funds to transfer.");
                        }

                    }
                        default: System.out.println("Invalid account choice:");
                    case 4:
                        System.out.println("You have chosen to exit.");
                        break;
                }
                break;
            case 4:
                account = new Charity();
                System.out.println("This is your Small Business account.");
                createAccount.charityAccount = true;
                System.out.println("Would you like to: 1: Deposit, 2:Withdraw or 3:Exit");
                int action4 = sc.nextInt();

                switch (action4) {
                    case 1:
                        System.out.println("Enter a value");
                        double amount = sc.nextDouble();
                        account.deposit(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                    case 2:
                        System.out.println("Enter a value");
                        amount = sc.nextDouble();
                        account.withdraw(amount);
                        System.out.println("Your new value is £" + account.balance);
                        break;
                     case 3:
                        System.out.println("Enter what account to transfer to: 1: Community, 2: Client or 3: Charity.");
                        int transferChoice = sc.nextInt();

                        Accounts transferAccount = null;
                        switch (transferChoice) {
                            case 1: 
                            transferAccount = new SmallBusiness(); 
                            break;
                            case 2: 
                            transferAccount = new Community(); 
                            break;
                            case 3: 
                            transferAccount = new Client(); 
                            break;
                        }

                        if (transferAccount != null) {
                            System.out.println("Enter amount to transfer");
                            double transferAmount = sc.nextDouble();

                        if (account.getBalance() - transferAmount >= account.overdraft) {
                            account.withdraw(transferAmount);
                            transferAccount.deposit(transferAmount);
                            System.out.println("Transfer successful.");
                            System.out.println("Your new balance is £" + account.getBalance());
                        }else {
                            System.out.println("Insufficient funds to transfer.");
                        }

                    }
                        default: System.out.println("Invalid account choice:");
                    case 4:
                        System.out.println("You have chosen to exit.");
                        break;
                }
                break;
            case 5:
                System.out.println("New Account");
                createAccount.main(args); 
                break; 
                 
            default:
                    System.out.println("Account not found");
                    System.out.println("Would you like to create an ew account (y/n)");
                    String response = sc.next().toLowerCase();

                    if(!response.equals("yes")){
                        System.out.println("Exiting.");
                        
                        sc.close();
                        
                    }
            }


        }
    }

    abstract class Accounts {  // An abstract modifier prevents the main class to be instantiated, this means that the child classes will be able to call from the parent class with ease.
    protected double balance;  // protected method means that it is accessible by the same class, class in same package and subclasses. Only main classes in other packages can not access it.
    protected double overdraft;

    public Accounts(double overdraftLimit) {
        this.balance = 0;
        this.overdraft = overdraftLimit;
    }

    public void deposit(double amount) {
        if (amount <= 0){
        System.out.println("Desposit must be positive.");
        return;
        }
        balance += amount;
        System.out.println("Deposited £" + amount);

    }
    public void withdraw(double amount) {
        if (amount <= 0) {
        System.out.println("Withdrawal must be positive.");
        return;
        }
        balance -= amount;
        System.out.println("Withdrew £" + amount);
    }

   /* public void transfer(double transferAccount) {
        if (transferAccount != null) {
                            System.out.println("Enter amount to transfer");
                            double transferAmount = sc.nextDouble();

                        if (account.getBalance() - transferAmount >= account.overdraft) {
                            account.withdraw(transferAmount);
                            transferAccount.deposit(transferAmount);
                            System.out.println("Transfer successful.");
                            System.out.println("Your new balance is £" + account.getBalance());
                        }else {
                            System.out.println("Insufficient funds to transfer.");
                        } 

                    }

    } */


    public double getBalance() {
        return balance;
        }

    }

    class SmallBusiness extends Accounts {
    public  SmallBusiness() {
        super(1000);
        } 
    }

    class Community extends Accounts {
        public Community() {
            super(2500);
        }
    }

    class Client extends Accounts {
        public Client() {
            super(1500);
        }
    }

    class Charity extends Accounts {
        public Charity() {
            super(3000);
        }
    }