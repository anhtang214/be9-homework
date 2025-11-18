package be9.BT8;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Java bat em throws Exception vi co FileWriter
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        UserSystem userSystem = new UserSystem();

        boolean userExited = false;

        while (!userExited) {
            System.out.println("Enter a number to select one of the banks below:\n" +
                    "1. NAB\n" +
                    "2. CommonWealth Bank\n" +
                    "3. ANZ");
            int bankInput = scanner.nextInt();
            scanner.nextLine();
            if (bankInput < 1 || bankInput > 3) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            userSystem.setBank(bankInput - 1);

            System.out.println("Enter a number to select one of the options below:\n" +
                    "1. Register\n" +
                    "2. View Users\n" +
                    "3. Login\n" +
                    "4. Quit");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 4:
                    userExited = true;
                    break;
                case 1:  // register
                    System.out.println("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();

                    userSystem.registerUser(name, username, password);
                    break;
                case 2:  // view user
                    userSystem.viewAllUsers();
                    break;
                case 3:  // login
                    System.out.println("Enter your username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    userSystem.userLogin(loginUsername, loginPassword);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }
}
