package be9.BT9.service;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Java bat em throws Exception vi co FileWriter
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        NABBankService nabBankService = new NABBankService();
        CWBankService cwBankService = new CWBankService();
        ANZBankService anzBankService = new ANZBankService();
        BankService bankService = anzBankService;
        boolean userExited = false;

        while (!userExited) {
            System.out.println("Enter a number to select one of the banks below:\n" +
                    "1. NAB\n" +
                    "2. CommonWealth Bank\n" +
                    "3. ANZ");

            int bankInput = scanner.nextInt();
            scanner.nextLine();
            if (bankInput < 1 || bankInput > 3) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            switch (bankInput) {
                case 1:
                    bankService = nabBankService;
                    break;
                case 2:
                    bankService = cwBankService;
                    break;
                case 3:
                    bankService = anzBankService;
                    break;
                default:
                    break;
            }

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
                    System.out.println("Enter your username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    bankService.userLogin(loginUsername, loginPassword);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }
}

