package be9.BT10.service;

import java.util.Scanner;

import be9.BT10.model.NABUser;

public class NABBankService extends BankService {
    public NABBankService() {
        this.filename = "be9/BT10/NAB.txt";
        this.MAX_FAILED_ATTEMPTS = 5;
    }

    @Override
    public NABUser getUserInputForRegister(Scanner scanner) {
        NABUser user = new NABUser();
        System.out.println("Enter your name: ");
        user.name = scanner.nextLine();
        System.out.println("Enter your username: ");
        user.loginId = scanner.nextLine();
        System.out.println("Enter your password: ");
        user.password = scanner.nextLine();
        System.out.println("Enter your phone number: ");
        user.phone = scanner.nextLine();
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
    public NABUser getUserFromFile(String[] userInfo, String username, String password) {
        NABUser user = new NABUser();
        user.name = userInfo[0];
        user.loginId = userInfo[1];
        user.password = userInfo[2];
        user.phone = userInfo[3];
        user.failedLoginAttempts = Integer.parseInt(userInfo[4]);
        return user;
    }
}
