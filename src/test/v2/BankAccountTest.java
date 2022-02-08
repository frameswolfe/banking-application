package test.v2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.v2.BankAccount;

public class BankAccountTest {

  @Test
  void checkBalanceShouldReturnCorrectFormat() {
    var bankAccount = new BankAccount(200);
    assertEquals("200.00", bankAccount.checkBalance());
  }
}
