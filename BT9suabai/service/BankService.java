package be9.BT9suabai.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import be9.BT9suabai.model.BaseUser;

public class BankService {
    protected HashMap<String, Integer> failedLoginAttempts = new HashMap<>();
    protected String filename;
    protected int MAX_FAILED_ATTEMPTS;

    protected BaseUser getUserInputForRegister(Scanner scanner) {
        return null;
    }

    public void getInfoAndRegisterUser(Scanner scanner) throws IOException {
        BaseUser user = getUserInputForRegister(scanner);
    
        FileWriter writer = new FileWriter(filename, true);
        writer.append(user.getUserInfoToFile());
        writer.close();
    }

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
