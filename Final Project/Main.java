import java.util.Scanner; 
//main entry point for the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        System.out.println("Would you like to login or create an account? (login/create)");
        String input = scanner.nextLine();
        if (input.equals("create")) {  //user input management
            createAccount.main(args);  // Call the main method of corresponding file depending on user input
        } else if (input.equals("login")) {
            login.main(args);
        } else {
            System.out.println("Invalid input. Please enter 'login' or 'create'."); // Handle invalid input
        }
    }
}
