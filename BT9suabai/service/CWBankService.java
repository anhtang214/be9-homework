package be9.BT9suabai.service;

import java.util.Scanner;

import be9.BT9suabai.model.BaseUser;
import be9.BT9suabai.model.CWUser;

public class CWBankService extends BankService {
    public CWBankService() {
        this.filename = "be9/BT9suabai/CW.txt";
        this.MAX_FAILED_ATTEMPTS = 5;
    }

    @Override
    protected BaseUser getUserInputForRegister(Scanner scanner) {
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
        return user;
    }

    @Override
    protected void printViewUsers(String[] userInfo) {
        System.out.printf(
            "Name: %s, Username: %s, Password: %s, Phone: %s, Email: %s\n",
            userInfo[0], 
            userInfo[1],
            userInfo[2].substring(userInfo[2].length() - 2),  // last 2 chars
            userInfo[3].substring(userInfo[3].length() - 3),  // last 3 numbers
            userInfo[4]
        );
    }
}
