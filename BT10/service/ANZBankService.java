package be9.BT10.service;

import java.util.Scanner;

import be9.BT10.model.ANZUser;

public class ANZBankService extends BankService {
    public ANZBankService() {
        this.filename = "be9/BT10/ANZ.txt";
        this.MAX_FAILED_ATTEMPTS = 3;
    }

    @Override
    public ANZUser getUserInputForRegister(Scanner scanner) {
        ANZUser user = new ANZUser();
        System.out.println("Enter your name: ");
        user.name = scanner.nextLine();
        System.out.println("Enter your username: ");
        user.loginId = scanner.nextLine();
        System.out.println("Enter your password: ");
        user.password = scanner.nextLine();
        user.failedLoginAttempts = 0;

        return user;
    }

    @Override
    public void printViewUsers(String[] userInfo) {
        System.out.printf("Name: %s, Username: %s, Password: %s\n",
                                userInfo[0],
                                userInfo[1],
                                userInfo[2].substring(userInfo[2].length() - 2));
    }

    @Override
    public ANZUser getUserFromFile(String[] userInfo, String username, String password) {
        ANZUser user = new ANZUser();
        user.name = userInfo[0];
        user.loginId = userInfo[1];
        user.password = userInfo[2];
        user.failedLoginAttempts = Integer.parseInt(userInfo[3]);
        return user;
    }
}
