package bank.Model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AcoountTest {

    @Test
    // not_be_able_to_create_account_with_null_initial_amount
    public void acountTestWithNullParameter() {
        assertThrows(IllegalArgumentException.class, () -> new Account(null));
    }

    @Test
    // Not_be_able_to_negative_initial_amounts
    public void accountTestWithNagtiveIntialAmount(){
        assertThrows(IllegalArgumentException.class, () -> new Account(new BigDecimal("-765")));
    }


    @Test
    // Not_be_able_to_withDraw_negative_amounts
    public void withDrawTestWithNegativeAmount() {
        // given
        Account account = new Account(new BigDecimal("1000"));
        // then
       assertThrows(IllegalArgumentException.class, () -> account.withDraw(new BigDecimal("-20")));
    }

    @Test
   // Not_be_able_to_deposit_negative_amounts
    public void withDrawTestWithNegativeWithDraw() {
        // given
        Account account = new Account(new BigDecimal("100"));
        // then
        assertThrows(IllegalArgumentException.class, () -> account.deposit(new BigDecimal("-20")));
    }

    @Test
    // Get_1000_balance_given_initial_amount_800_and_deposit_200
   public void accountTestCountBalanceWithDepositAmount() {
        // given
        Account account = new Account(new BigDecimal("800"));
        // when
        account.deposit(new BigDecimal("200"));
        // then
        assertEquals(new BigDecimal("1000"), account.getBalance());
    }

    @Test
    // Get_600_balance_given_initial_amount_800_and_withDraw_200
    public void accountTestCountBalanceWithDrawAmount() {
        // given
        Account account = new Account(new BigDecimal("800"));
        // when
        account.withDraw(new BigDecimal("200"));
        // then
        assertEquals(new BigDecimal("600"), account.getBalance());
    }
}
