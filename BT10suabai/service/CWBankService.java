package be9.BT10suabai.service;

import java.util.Scanner;

import be9.BT10suabai.model.BaseUser;
import be9.BT10suabai.model.CWUser;

public class CWBankService extends BankService {
    public CWBankService() {
        this.filename = "be9/BT10suabai/CW.txt";
        this.maxAttempts = 5;
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
    public BaseUser getUserFromLine(String line) {
        return new CWUser(line);
    }
}
