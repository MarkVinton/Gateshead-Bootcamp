
import java.util.Scanner;

public class login {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Allows the users to login 3 times before rejecting the user.
        for (int i = 3; i > 0; i--) {

        //User can input their username
        System.out.println("Enter username");
        String user = scanner.nextLine();
        
        //User can input their password
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        //Loops throguh all the usernames and passwords to see if there is any matches
        int userNum = -1;
        for (Object[] credentials : pretendDatabase.userInfo) {
            userNum += 1;
            Object correctUser = credentials[0];
            Object correctPassword = credentials[1];

        if (user.equals(correctUser) && password.equals(correctPassword)) {
            //Checks the amount of signatories that each users has
            if(((Integer)pretendDatabase.userInfo[userNum][10]) > 1){

                //Asks the user for the secondary password
                System.out.println("Please enter your secondary password, you only have 1 attempt at this");
                String extraPass = scanner.nextLine();
                
                //Checks the inputed extra password vs the stored password
                if(!extraPass.equals(pretendDatabase.userInfo[userNum][15])){
                    System.out.println("Incorrect, you will be redirected back to the login menu");
                }
                else{
                    //If succesfull you will be redirected to the account management
                    System.out.println("Login Successful");
                    System.out.println("Welcome " +(String)pretendDatabase.userInfo[userNum][0]);
                    Account.main(args);
                    return;
                }

        }else{
            //If succesfull will direct the user straight to the account management menu with the extra password
            System.out.println("Login Successful");
            System.out.println("Welcome " +(String)pretendDatabase.userInfo[userNum][0]);
            Account.main(args);
            return;
            }
        }
            
    }
        //Calculating the amount of attempts the user has remaining
        System.out.println("You have " + (i - 1) + " attempts remaining" );
}       //If the users runs out of attempts they will be asked if they want to create an account
        System.out.println("Login Failed, would you like to create an account? (yes/no)");
        String response = scanner.nextLine();
        //Sends the user to the create account menu if input is yes
        if (response.equals("yes")) {
            createAccount.main(args);
        //Tells the users to wait 5 minutes to try again
        } else {
            System.out.println("Goodbye, Please try again in 5 minutes");
        }
        scanner.close();
    }
}