package BankApplication;
import javax.swing.*;
public class UserApp {

    public static void main(String[] args) {
        bank();
    }

    private static final BankApp bankApp = new BankApp("MiBank");

    private static void print(String output) {
        JOptionPane.showMessageDialog(null, output);
    }

    private static String input(String output) {
        return JOptionPane.showInputDialog(null, output);
    }

    public static void bank() {
        String option = input("""
                Welcome to Puzzle Bank
                1. Register
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Check balance
                6. Close account
                7. Exit
                Select an Option:
                """);

        switch (option) {
            case "1":
                String firstName = input("Enter your first name: ");
                while(firstName.trim().isEmpty()){
                    firstName = input("Enter your first name: ");
                }
                String lastName = input("Enter your last name: ");
                while(lastName.trim().isEmpty()){
                    lastName = input("Enter  your last name: ");
                }
                String pin = input("Enter your pin: ");
                while(pin.trim().isEmpty()){
                    pin = input("Enter  your last name: ");
                }

                try {
                    BankAccount myAccount = bankApp.registerCustomer(firstName, lastName, pin);
                    print("Your account number is " + myAccount.getAccountNumber());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                } finally {
                    bank();
                }
                break;

            case "2":
                String number = input("Enter account number : ").trim();
                String depositAmount = input("How much do you want to deposit: ");

                try {
                    bankApp.depositCash(Integer.parseInt(number), Integer.parseInt(depositAmount));
                    System.out.println("Deposit Successful");
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                } finally {
                    bank();
                }
                break;

            case "3":
                number = input("Enter account number: ");
                String withdrawalAmount = input("How much do you want to withdraw: ");
                pin = input("Enter your pin: ");

                try {
                    bankApp.withdrawCash(Integer.parseInt(number), Integer.parseInt(withdrawalAmount), pin);
                    System.out.println("Withdrawal Successful");
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                } finally {
                    bank();
                }
                break;

            case "4":
                number = input("Enter your account number: ");
                String receiverAccountNumber = input("Enter your account number you want to send to: ");
                String amount = input("How much do you want to transfer: ");
                pin = input("Enter your pin: ");

                try {
                    bankApp.transferCash(Integer.parseInt(number), Integer.parseInt(receiverAccountNumber), Integer.parseInt(amount), pin);
                    System.out.println("Withdrawal Successful");
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                } finally {
                    bank();
                }
                break;

            case "5":
                number = input("Enter your account number: ");
                pin = input("Enter your pin: ");

                try {
                    System.out.println("Your balance is " + bankApp.checkBalance(Integer.parseInt(number), pin));
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                } finally {
                    bank();
                }
                break;

            case "6":
                number = input("Enter your account number: ");
                pin = input("Enter your pin: ");

                try {
                    bankApp.removeAccount(Integer.parseInt(number), pin);
                    System.out.println("Your Account has been closed");
                    System.out.println();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                } finally {
                    bank();
                }
                break;

            case "7":
                System.exit(0);
                break;

            default:
                bank();

        }
    }
}
