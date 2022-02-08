package main.v1;
import java.util.Scanner;

public class ATM {
  private static void pressEnterToContinue() {
    System.out.println("Press Enter to continue...");
    try {
      System.in.read();
    } catch (Exception e) {
    }
  }

  public static void showMenu(BankAccount bankAccount) {
    int option = 0;
    try (Scanner scanner = new Scanner(System.in)) {

      do {
        System.out.println("========================================");
        System.out.println();
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("========================================");
        System.out.println("1 - Check balance");
        System.out.println("2 - Make a deposit");
        System.out.println("3 - Make a withdrawal");
        System.out.println("4 - Check recent transactions");
        System.out.println("5 - Exit");
        System.out.println("========================================");
        System.out.println();
        System.out.print("Option: ");
        option = scanner.nextInt();
        System.out.println();
        System.out.println("========================================");
        System.out.println();

        switch (option) {
          case 1:
            bankAccount.checkBalance();
            System.out.println();
            System.out.println("========================================");
            System.out.println();
            pressEnterToContinue();
            break;
          case 2:
            System.out.print("Deposit: £");
            double amountToDeposit = scanner.nextDouble();
            bankAccount.deposit(amountToDeposit);
            System.out.println();
            bankAccount.newBalance();
            System.out.println();
            System.out.println("========================================");
            System.out.println();
            pressEnterToContinue();
            break;
            case 3:
            System.out.print("Withdraw: £");
            double amountToWithdraw = scanner.nextDouble();
            bankAccount.withdraw(amountToWithdraw);
            System.out.println();
            bankAccount.newBalance();
            System.out.println();
            System.out.println("========================================");
            System.out.println();
            pressEnterToContinue();
            break;
          case 4:
            bankAccount.checkTransactionHistory();
            System.out.println();
            System.out.println("========================================");
            System.out.println();
            pressEnterToContinue();
            break;
          case 5:
            break;
          default:
            System.out.println("Invalid option - please try again");
            System.out.println();
            break;
        }
      }
      while (option != 5);
    }

    System.out.println("Don't spend it all at once!");
    System.out.println();
    System.out.println("========================================");
  }
    public static void main(String[] args)  {
      BankAccount myAccount = new BankAccount(1000);
      showMenu(myAccount);
    }
}
