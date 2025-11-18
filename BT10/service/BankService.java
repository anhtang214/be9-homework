package be9.BT10.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import be9.BT10.model.BaseUser;

public abstract class BankService {
    public String filename;
    public int MAX_FAILED_ATTEMPTS;

    public abstract BaseUser getUserInputForRegister(Scanner scanner);
    public abstract void printViewUsers(String[] userInfo);
    public abstract BaseUser getUserFromFile(String[] userInfo, String username, String password);

    public void getInfoAndRegisterUser(Scanner scanner) throws IOException {
        BaseUser user = getUserInputForRegister(scanner);
    
        FileWriter writer = new FileWriter(filename, true);
        writer.append(user.getUserInfoToFile());
        writer.close();
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

    public void userLogin(String username, String password) throws IOException {
        File readFile = new File(filename);
        Scanner fileReader = new Scanner(readFile);
        int lineNum = 0;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            lineNum += 1;
            String[] userInfo = line.split(",");
            BaseUser user = getUserFromFile(userInfo, username, password);

            if (username.equals(user.loginId)) {
                if (user.failedLoginAttempts == MAX_FAILED_ATTEMPTS) {
                    System.out.println("USER IS BLOCKED");
                } else if (!password.equals(user.password)) {
                    user.failedLoginAttempts += 1;
                    updateLoginAttemptsToFile(user, lineNum);
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

    public void updateLoginAttemptsToFile(BaseUser user, int modifiedLine) throws IOException {
        File readFile = new File(filename);
        Scanner fileReader = new Scanner(readFile);
        String newFileContent = "";
        int lineNum = 0;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            lineNum += 1;
            if (lineNum == modifiedLine) {
                newFileContent += user.getUserInfoToFile();
            } else {
                newFileContent += line + System.lineSeparator();
            }
        }
        FileWriter writer = new FileWriter(filename, false);
        writer.write(newFileContent);
        writer.close();
        fileReader.close();
    }
}
