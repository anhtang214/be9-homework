package be9.BT7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Java bat em throws Exception vi co FileWriter
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        UserSystem userSystem = new UserSystem();

        FileWriter writer = new FileWriter("userFile.txt");
        writer.write("userID,name,username,password\n");  // initialise with headers for readability
        writer.close();

        boolean userExited = false;

        while (!userExited) {
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
