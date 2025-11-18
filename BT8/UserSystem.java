package be9.BT8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserSystem {
    private ArrayList<HashMap<String, Integer>> failedLoginAttemptsByBank = new ArrayList<>();
    private HashMap<String, Integer> failedLoginAttempts;
    private String[] bankFilenames = {"be9/BT8/NAB.txt", "be9/BT8/CW.txt", "be9/BT8/ANZ.txt"};
    private String filename;

    public UserSystem() {
        failedLoginAttemptsByBank.add(new HashMap<>()); // Bank 0
        failedLoginAttemptsByBank.add(new HashMap<>()); // Bank 1
        failedLoginAttemptsByBank.add(new HashMap<>()); // Bank 2
    }

    public void setBank(int bankIndex) {
        filename = bankFilenames[bankIndex];
        failedLoginAttempts = failedLoginAttemptsByBank.get(bankIndex);
    }

    public void registerUser(String name, String username, String password) throws IOException {
        failedLoginAttempts.put(username, 0);  // initialise failed login attempts to 0
        FileWriter writer = new FileWriter(filename, true);
        writer.write(name + "," + username + "," + password + "\n");
        writer.close();
    }

    public void viewAllUsers() throws FileNotFoundException {
        File readFile = new File(filename);
        Scanner fileReader = new Scanner(readFile);

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] userInfo = line.split(",");
            System.out.printf("Name: %s, Username: %s, Password: %s\n", userInfo[0], userInfo[1], userInfo[2]);
        }
        fileReader.close();
    }

    public void userLogin(String username, String password) throws FileNotFoundException {
        File readFile = new File(filename);
        Scanner fileReader = new Scanner(readFile);

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] userInfo = line.split(",");

            if (username.equals(userInfo[1])) {  // if correct username
                int previousLoginAttempt = failedLoginAttempts.get(username);
                if (previousLoginAttempt == 3) {
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
