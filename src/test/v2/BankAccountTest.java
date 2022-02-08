package test.v2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.v2.BankAccount;

public class BankAccountTest {

  final int AMOUNT = 200;
  BankAccount testBankAccount = new BankAccount(AMOUNT);

  // #checkBalance
  @Test
  void checkBalanceShouldReturnCorrectFormat() {
    assertEquals("200.00", testBankAccount.checkBalance());
  }

  @Test
  void checkBalanceAfterDeposit() {
    testBankAccount.deposit(100);
    assertEquals("300.00", testBankAccount.checkBalance());
  }

  @Test
  void checkBalanceAfterWithdraw() {
    testBankAccount.withdraw(100);
    assertEquals("100.00", testBankAccount.checkBalance());
  }

  // #deposit
  @Test
  void depositNegativeOneShouldReturnIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> testBankAccount.deposit(-1));
  }

  // #withdraw
  @Test
  void withdrawNegativeOneShouldReturnIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> testBankAccount.withdraw(-1));
  }

  // #transactionHistory
  @Test
  void checkTotalTransactions() {
    testBankAccount.deposit(100);
    testBankAccount.withdraw(100);
    assertEquals(2, testBankAccount.getTransactionHistory().size());
  }

  @Test
  void depositsAreStoredAsPositive() {
    testBankAccount.deposit(100);
    assertEquals(100.0, testBankAccount.getTransactionHistory().get(0));
  }

  @Test
  void withdrawalsAreStoredAsNegative() {
    testBankAccount.withdraw(100);
    assertTrue(testBankAccount.getTransactionHistory().get(0) == -100.0);
  }

  @Test
  void oldestTransactionIsOneThousand() {
    testBankAccount.deposit(1000);
    testBankAccount.withdraw(100);
    testBankAccount.withdraw(100);
    assertTrue(testBankAccount.getTransactionHistory().get(2) == 1000.0);
  }

  @Test
  void mostRecentTransactionIsNegativeFifty() {
    testBankAccount.deposit(1000);
    testBankAccount.withdraw(100);
    testBankAccount.withdraw(50);
    assertTrue(testBankAccount.getTransactionHistory().get(0) == -50.0);
  }
}
