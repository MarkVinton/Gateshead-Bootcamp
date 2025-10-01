
import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 3; i > 0; i--) {
        System.out.println("Enter username");
        String user = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();
        int userNum = -1;
        for (Object[] credentials : pretendDatabase.userInfo) {
            userNum += 1;
            Object correctUser = credentials[0];
            Object correctPassword = credentials[1];

        if (user.equals(correctUser) && password.equals(correctPassword)) {
            System.out.println("Signatories: " + pretendDatabase.userInfo[userNum][11]);
            if(((Integer)pretendDatabase.userInfo[userNum][10]) > 1){
                System.out.println("Please enter your secondary password");
                String extraPass = scanner.nextLine();
                System.out.println("Extra Password:" + pretendDatabase.userInfo[userNum][15]);
                if(!extraPass.equals(pretendDatabase.userInfo[userNum][15])){
                    System.out.println("Incorrect");
                }
                else{
                    System.out.println("Login Successful");
                    System.out.println("Welcome " +(String)pretendDatabase.userInfo[userNum][0] + pretendDatabase.userInfo[userNum][1]);
                    Account.main(args);
                    return;
                }
        }else{
            System.out.println("Login Successful");
            System.out.println("Welcome " +(String)pretendDatabase.userInfo[userNum][0]);
            Account.main(args);
            return;
            }
        }
            
    }
        System.out.println("You have " + (i - 1) + " attempts remaining" );
}
        System.out.println("Login Failed, would you like to create an account? (yes/no)");
        String response = scanner.nextLine();
        if (response.equals("yes")) {
            createAccount.main(args);
        } else {
            System.out.println("Goodbye, Please try again in 5 minutes");
        }
    }
}