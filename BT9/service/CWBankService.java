package be9.BT9.service;

import java.util.Scanner;

public class CWBankService extends BankService {
    public CWBankService() {
        this.filename = "be9/BT9/CW.txt";
        this.MAX_FAILED_ATTEMPTS = 5;
    }

    // Helper function for getInfoAndRegisterUser
    @Override
    protected String getExtraUserInfo(Scanner scanner) {
        System.out.println("Enter your phone number: ");
        String number = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        return "," + number + "," + email;
    }

    // Helper function for viewAllUsers
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
