package be9.BT10suabai.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import be9.BT10suabai.model.BaseUser;

public abstract class BankService {
    public String filename;
    public int maxAttempts;

    // function with NO BODY
    public abstract BaseUser getUserInputForRegister(Scanner scanner);
    public abstract BaseUser getUserFromLine(String line);

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
                BaseUser user = getUserFromLine(line);
                System.out.println(user.toString());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No users in the system.");
        }
    }

    public void userLogin(BaseUser userLogin) throws IOException {
        File readFile = new File(filename);
        Scanner fileReader = new Scanner(readFile);
        int lineNum = 0;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            lineNum += 1;
            BaseUser userFromLine = getUserFromLine(line);

            if (userLogin.loginId.equals(userFromLine.loginId)) {
                if (userFromLine.failedLoginAttempts == maxAttempts) {
                    System.out.println("USER IS BLOCKED");
                } else if (!userLogin.password.equals(userFromLine.password)) {
                    userFromLine.failedLoginAttempts += 1;
                    updateLoginAttemptsToFile(userFromLine, lineNum);
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
