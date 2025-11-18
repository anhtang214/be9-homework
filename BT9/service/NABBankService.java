package be9.BT9.service;

import java.util.Scanner;

public class NABBankService extends BankService {
    public NABBankService() {
        this.filename = "be9/BT9/NAB.txt";
        this.MAX_FAILED_ATTEMPTS = 5;
    }

    // Helper function for getInfoAndRegisterUser
    @Override
    protected String getExtraUserInfo(Scanner scanner) {
        System.out.println("Enter your phone number: ");
        String number = scanner.nextLine();
        return "," + number;
    }
}
