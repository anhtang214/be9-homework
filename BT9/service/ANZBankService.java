package be9.BT9.service;

public class ANZBankService extends BankService {
    public ANZBankService() {
        this.filename = "be9/BT9/ANZ.txt";
        this.MAX_FAILED_ATTEMPTS = 3;
    }
}
