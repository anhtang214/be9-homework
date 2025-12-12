package be9.BT9suabai.service;

import java.util.Scanner;

import be9.BT9suabai.model.BaseUser;
import be9.BT9suabai.model.NABUser;

public class NABBankService extends BankService {
    public NABBankService() {
        this.filename = "be9/BT9suabai/NAB.txt";
        this.MAX_FAILED_ATTEMPTS = 5;
    }

    @Override
    protected BaseUser getUserInputForRegister(Scanner scanner) {
        NABUser user = new NABUser();
        System.out.println("Enter your name: ");
        user.name = scanner.nextLine();
        System.out.println("Enter your username: ");
        user.loginId = scanner.nextLine();
        System.out.println("Enter your password: ");
        user.password = scanner.nextLine();
        System.out.println("Enter your phone number: ");
        user.phone = scanner.nextLine();
        return user;
    }
}
