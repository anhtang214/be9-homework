package be9.BT10suabai;

import java.io.IOException;
import java.util.Scanner;

import be9.BT10suabai.model.BaseUser;
import be9.BT10suabai.service.ANZBankService;
import be9.BT10suabai.service.BankService;
import be9.BT10suabai.service.CWBankService;
import be9.BT10suabai.service.NABBankService;

public class Main {
    public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
        BankService bankService = null;
        boolean userExited = false;

        System.out.println("Enter a number to select one of the banks below:\n" +
                    "1. NAB\n" +
                    "2. CommonWealth Bank\n" +
                    "3. ANZ");

        int bankInput = scanner.nextInt();
        scanner.nextLine();
        switch (bankInput) {
            case 1:
                bankService = new NABBankService();
                break;
            case 2:
                bankService = new CWBankService();
                break;
            case 3:
                bankService = new ANZBankService();
                break;
            default:
                break;
        }

        while (!userExited) {
            System.out.println("Enter a number to select one of the options below:\n" +
                    "1. Register\n" +
                    "2. View Users\n" +
                    "3. Login\n" +
                    "4. Quit");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 4:
                    userExited = true;
                    break;
                case 1:  // register
                    bankService.getInfoAndRegisterUser(scanner);
                    break;
                case 2:  // view user
                    bankService.viewAllUsers();
                    break;
                case 3:  // login
                    bankService.userLogin(getLoginInput(scanner));
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }

    static private BaseUser getLoginInput(Scanner scanner) {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        return new BaseUser(username, password);
    }
}

