package test.v2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.v2.BankAccount;

public class BankAccountTest {

  // #checkBalance
  @Test
  void checkBalanceShouldReturnCorrectFormat() {
    var bankAccount = new BankAccount(200);
    assertEquals("200.00", bankAccount.checkBalance());
  }

  @Test
  void checkBalanceAfterDeposit() {
    var bankAccount = new BankAccount(200);
    bankAccount.deposit(100);
    assertEquals("300.00", bankAccount.checkBalance());
  }

  @Test
  void checkBalanceAfterWithdraw() {
    var bankAccount = new BankAccount(200);
    bankAccount.withdraw(100);
    assertEquals("100.00", bankAccount.checkBalance());
  }

  // #deposit
  @Test
  void depositNegativeOneShouldReturnIllegalArgumentException() {
    var bankAccount = new BankAccount(200);
    assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-1));
  }

  // #withdraw
  @Test
  void withdrawNegativeOneShouldReturnIllegalArgumentException() {
    var bankAccount = new BankAccount(200);
    assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-1));
  }

  // #transactionHistory
}
