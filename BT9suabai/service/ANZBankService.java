package be9.BT9suabai.service;

import java.util.Scanner;

import be9.BT9suabai.model.ANZUser;
import be9.BT9suabai.model.BaseUser;

public class ANZBankService extends BankService {
    public ANZBankService() {
        this.filename = "be9/BT9suabai/ANZ.txt";
        this.MAX_FAILED_ATTEMPTS = 3;
    }

    @Override
    protected BaseUser getUserInputForRegister(Scanner scanner) {
        ANZUser user = new ANZUser();
        System.out.println("Enter your name: ");
        user.name = scanner.nextLine();
        System.out.println("Enter your username: ");
        user.loginId = scanner.nextLine();
        System.out.println("Enter your password: ");
        user.password = scanner.nextLine();

        return user;
    }
}
