package main.v2;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BankAccount {
  DecimalFormat df = new DecimalFormat("0.00");

  protected double balance;
  protected ArrayList<Double> transactionHistory = new ArrayList<Double>();

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public String checkBalance() {
    System.out.println("Your balance is: £" + df.format(balance));
    return df.format(balance);
  }

  public void deposit(double amountToDeposit) {
    if (amountToDeposit > 0) {
      balance += amountToDeposit;
      transactionHistory.add(0, amountToDeposit);
    } else if (amountToDeposit < 0) {
      throw new IllegalArgumentException("You cannot deposit a negative amount.");
    } else {
      System.out.println("Thanks for nothing...");
    }
  }

  public void withdraw(double amountToWithdraw) {
    if (amountToWithdraw < 0) {
      throw new IllegalArgumentException("You cannot withdraw a negative amount.");
    } else if (amountToWithdraw <= balance) {
      balance -= amountToWithdraw;
      transactionHistory.add(0, -amountToWithdraw);
    } else {
      System.out.println("OK...");
    }
  }

  public ArrayList<Double> getTransactionHistory() {
    return transactionHistory;
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
