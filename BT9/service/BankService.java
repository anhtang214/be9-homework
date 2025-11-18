package be9.BT9.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BankService {
    protected HashMap<String, Integer> failedLoginAttempts = new HashMap<>();
    protected String filename;
    protected int MAX_FAILED_ATTEMPTS;

    // Helper function for getInfoAndRegisterUser
    protected String getExtraUserInfo(Scanner scanner) {
        return "";
    }

    public void getInfoAndRegisterUser(Scanner scanner) throws IOException {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        // Get extra info like phone number or email
        String extraInfo = getExtraUserInfo(scanner);
        String stringToFile = name + "," + username + "," + password + extraInfo + "\n";
        failedLoginAttempts.put(username, 0);  // initialise failed login attempts to 0
    
        // Write to file
        FileWriter writer = new FileWriter(filename, true);
        writer.write(stringToFile);
        writer.close();
    }

    // Helper function for viewAllUsers
    protected void printViewUsers(String[] userInfo) {
        System.out.printf("Name: %s, Username: %s, Password: %s\n",
                                userInfo[0],
                                userInfo[1],
                                userInfo[2].substring(userInfo[2].length() - 2));
    }

    public void viewAllUsers() {
        try {
            File readFile = new File(filename);
            Scanner fileReader = new Scanner(readFile);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] userInfo = line.split(",");
                printViewUsers(userInfo);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No users in the system.");
        }
    }

    public void userLogin(String username, String password) throws FileNotFoundException {
        File readFile = new File(filename);
        Scanner fileReader = new Scanner(readFile);

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] userInfo = line.split(",");

            if (username.equals(userInfo[1])) {  // if correct username
                int previousLoginAttempt = failedLoginAttempts.get(username);
                if (previousLoginAttempt == MAX_FAILED_ATTEMPTS) {
                    System.out.println("USER IS BLOCKED");
                } else if (!password.equals(userInfo[2])) {  // if incorrect password
                    failedLoginAttempts.put(username, previousLoginAttempt + 1);
                    System.out.println("Incorrect password.");
                } else {
                    System.out.println("Login successful!");
                }
                fileReader.close();
                return;
            }
        }
        fileReader.close();
        System.out.println("Username doesn't exist.");
    }
}
