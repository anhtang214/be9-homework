package be9.BT10.service;

import java.util.Scanner;

import be9.BT10.model.CWUser;

public class CWBankService extends BankService {
    public CWBankService() {
        this.filename = "be9/BT10/CW.txt";
        this.MAX_FAILED_ATTEMPTS = 5;
    }

    @Override
    public CWUser getUserInputForRegister(Scanner scanner) {
        CWUser user = new CWUser();
        System.out.println("Enter your name: ");
        user.name = scanner.nextLine();
        System.out.println("Enter your username: ");
        user.loginId = scanner.nextLine();
        System.out.println("Enter your password: ");
        user.password = scanner.nextLine();
        System.out.println("Enter your phone number: ");
        user.phone = scanner.nextLine();
        System.out.println("Enter your email: ");
        user.email = scanner.nextLine();
        user.failedLoginAttempts = 0;
        return user;
    }

    @Override
    public void printViewUsers(String[] userInfo) {
        System.out.printf(
            "Name: %s, Username: %s, Password: %s, Phone: %s, Email: %s\n",
            userInfo[0], 
            userInfo[1],
            userInfo[2].substring(userInfo[2].length() - 2),  // last 2 chars
            userInfo[3].substring(userInfo[3].length() - 3),  // last 3 numbers
            userInfo[4]
        );
    }

    @Override
    public CWUser getUserFromFile(String[] userInfo, String username, String password) {
        CWUser user = new CWUser();
        user.name = userInfo[0];
        user.loginId = userInfo[1];
        user.password = userInfo[2];
        user.phone = userInfo[3];
        user.email = userInfo[4];
        user.failedLoginAttempts = Integer.parseInt(userInfo[5]);
        return user;
    }
}
