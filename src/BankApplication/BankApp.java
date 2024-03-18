package BankApplication;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class BankApp {
    private List<BankAccount> accounts = new ArrayList<>();
    private final List<Customer> customer = new ArrayList<>();

    public BankApp(String name) {

    }


    public BankAccount registerCustomer(String firstName, String lastName, String pin) {
        String name = firstName + " " + lastName;
        int accountNumber = generateAccountNumber();
        BankAccount account = new BankAccount(name, 0, pin, accountNumber);
        accounts.add(account);
        return account;
    }

    public int generateAccountNumber() {// make sure the same Account number cannot be generated. call contains method to loop through the accounts
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(1_000_000_000, 2_000_000_000);
    }

    public BankAccount findAccount(int accountNumber) throws InvalidAccountException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new InvalidAccountException("Account does not exist");
    }

    public int checkBalance(int accountNumber, String pin) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == (accountNumber))
                if(validatePin(pin))  return account.getBalance();
        }
        throw new InvalidAccountException("Account not created");
    }
    public boolean validatePin(String fromPin) throws InvalidPinException {
        if (fromPin == null) {
            throw new InvalidPinException("PIN cannot be null");
        }
        if (fromPin.length() != 4) {
            throw new InvalidPinException("PIN must be 4 digits long");
        }
        if (!fromPin.matches("\\d{4}")) {
            throw new InvalidPinException("PIN must contain only digits");
        }
        return true;
    }
    public void removeAccount(int number, String pin) {
        if (findAccount(number) == null) throw new InvalidAccountException("Account Not Found");
        BankAccount account = findAccount(number);
        if (validatePin(pin))  accounts.remove(account);
    }

    public void depositCash(int accountNumber, int amount) throws InvalidAmountException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) account.deposit(amount);
        }
    }

    public void withdrawCash(int number, int withdrawalAmount, String pin) throws InsufficientFundsException {
        if (findAccount(number) == null) throw new InvalidAccountException("Account Not Found");
        BankAccount account = findAccount(number);
        account.withdraw(withdrawalAmount, pin);

    }

    public void transferCash(int fromAccount, int toAccount, int withdrawalAmount, String senderAccountPin) throws InsufficientFundsException { /// change withdrawal amount
        BankAccount sourceAccount = findAccount(fromAccount);
        BankAccount destinationAccount = findAccount(toAccount);

        if (sourceAccount == null || destinationAccount == null) throw new InvalidAccountException("Accounts do not exist");

        if (!sourceAccount.validatePin(senderAccountPin)) throw new InvalidPinException("Invalid PIN for source account");

        if (withdrawalAmount <= 0) throw new InvalidAmountException("Invalid transfer amount");

        if (sourceAccount.getBalance() < withdrawalAmount) throw new InsufficientFundsException("Insufficient funds in the source account");

        sourceAccount.withdraw(withdrawalAmount, senderAccountPin);
        destinationAccount.deposit(withdrawalAmount);
    }

    public void addAccount(BankAccount account1) {
        accounts.add(account1);
    }

    public int getCustomerCount() {
        return customer.size();
    }

}
