package be9.BT10suabai.service;

import java.util.Scanner;

import be9.BT10suabai.model.BaseUser;
import be9.BT10suabai.model.NABUser;

public class NABBankService extends BankService {
    public NABBankService() {
        this.filename = "be9/BT10suabai/NAB.txt";
        this.maxAttempts = 5;
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
    public BaseUser getUserFromLine(String line) {
        return new NABUser(line);
    }
}
