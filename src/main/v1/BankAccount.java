package main.v1;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BankAccount {
  DecimalFormat df = new DecimalFormat("0.00");

  protected double balance;
  protected ArrayList<Double> transactionHistory = new ArrayList<Double>();

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public void checkBalance() {
    System.out.println("Your balance is: £" + df.format(balance));
  }

  public void newBalance() {
    System.out.println("Your new balance is: £" + df.format(balance));
  }

  public void deposit(double amountToDeposit) {
    if (amountToDeposit > 0) {
      balance += amountToDeposit;
      transactionHistory.add(0, amountToDeposit);
    } else if (amountToDeposit < 0) {
      System.out.println("Would you like to make a withdrawal?");
    } else {
      System.out.println("Thanks for nothing...");
    }
  }

  public void withdraw(double amountToWithdraw) {
    if (amountToWithdraw <= balance) {
      balance -= amountToWithdraw;
      transactionHistory.add(0, -amountToWithdraw);
    } else {
      System.out.println();
      System.out.println("Insufficient funds!");
    }
  }

  public void checkTransactionHistory() {
    double totalDeposited = 0;
    double totalWithdrawn = 0;

    System.out.println("Your recent transactions:");
    System.out.println();
    if (transactionHistory.size() == 0) {
      System.out.println("No recent transactions...");
    } else {
      for (double transaction : transactionHistory) {
        if (transaction > 0) {
          System.out.println("Deposited £" + df.format(transaction));
          totalDeposited += transaction;
        } else {
          System.out.println("Withdrew £" + df.format(Math.abs(transaction)));
          totalWithdrawn += Math.abs(transaction);
        }
      }
      System.out.println();
      System.out.println("You have deposited £" + df.format(totalDeposited) + " and withdrawn £" + df.format(
          totalWithdrawn));
    }
  }
}
