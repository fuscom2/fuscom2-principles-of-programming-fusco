import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private bankaccount.BankAccount account;

    @BeforeEach
    void setUp() {
        // Starts each test with a fresh account of 100.0
        account = new bankaccount.BankAccount(100.0);
    }

    /** 1. Add an @AfterEach annotation and method to delete the current bank account to make it available for garbage collection */
    @AfterEach
    void clean() {
        account = null;
    }

    @Test
    void testDeposit() {
        /** 2. Adeposit $50 and check that the balance is 150 */
        account.deposit(50);
        assertEquals(account.getBalance(), 150);
    }

    @Test
    void testWithdraw() {
        /** 3. withdraw $40 and check that the balance is $60; remember that each test is done on a fresh instance of bank account */
        account.withdraw(40);
        assertEquals(account.getBalance(), 60);
    }

    @Test
    void testInvalidDeposit() {
        /** 4. Deposit a negative amount and check if an exception is thrown */


        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testOverdraft() {
        /** 5. Verify that Withdrawing more than the current balance
         throws an exception */
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));
    }

    /** 6. Add a test to check that an Exception is thrown when
     trying to create a new bankaccout with a negaive initial balance */
    @Test
    void testNewAccountWithNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new bankaccount.BankAccount(-100));
    }

    @Test
    void testTransfer() {
        bankaccount.BankAccount newAccount = new bankaccount.BankAccount(100.0);

        account.transfer(newAccount, 50);

        assertAll(() -> assertEquals(newAccount.getBalance(), 150),
                () -> assertEquals(account.getBalance(), 50));
    }
}