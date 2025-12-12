package be9.BT10suabai.service;

import java.util.Scanner;

import be9.BT10suabai.model.ANZUser;
import be9.BT10suabai.model.BaseUser;

public class ANZBankService extends BankService {
    public ANZBankService() {
        this.filename = "be9/BT10suabai/ANZ.txt";
        this.maxAttempts = 3;
    }

    @Override
    public BaseUser getUserInputForRegister(Scanner scanner) {
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
    public BaseUser getUserFromLine(String line) {
        return new ANZUser(line);
    }
}
