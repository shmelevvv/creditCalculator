package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;


public class CreditCalculatorTest
{
    @Test
    public void testCalculation_validArgument_getMonthlyPayment_success() {
        BigDecimal amount = new BigDecimal(20000);
        BigDecimal rate = new BigDecimal(12);
        int term = 36;

        BigDecimal subResult = Calculator.getMonthlyPayment(amount, rate, term);
        Assertions.assertTrue(new BigDecimal(664).compareTo(subResult) == 0);
    }

    @Test
    public void testCalculation_negativeRate_getMonthlyPayment_trowsException() {
        BigDecimal amount = new BigDecimal(20000);
        BigDecimal rate = new BigDecimal(-12);
        int term = 36;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.getMonthlyPayment(amount, rate, term));
    }

    @Test
    public void testCalculation_negativeAmount_getMonthlyPayment_trowsException() {
        BigDecimal amount = new BigDecimal(-20000);
        BigDecimal rate = new BigDecimal(12);
        int term = 36;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.getMonthlyPayment(amount, rate, term));
    }

    @Test
    public void testCalculation_negativeTerm_getMonthlyPayment_trowsException() {
        BigDecimal amount = new BigDecimal(20000);
        BigDecimal rate = new BigDecimal(12);
        int term = -36;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.getMonthlyPayment(amount, rate, term));
    }

    @Test
    public void testCalculation_validArguments_getTotalAmount_success() {
        BigDecimal amount = new BigDecimal(20000);
        BigDecimal rate = new BigDecimal(12);
        int term = 36;

        BigDecimal subResult = Calculator.getTotalAmount(amount, rate, term);
        Assertions.assertTrue(new BigDecimal(23904).compareTo(subResult) == 0);
    }

    @Test
    public void testCalculation_validArguments_getOverPayment_success() {
        BigDecimal amount = new BigDecimal(20000);
        BigDecimal rate = new BigDecimal(12);
        int term = 36;

        BigDecimal subResult = Calculator.getOverPayment(amount, rate, term);
        Assertions.assertTrue(new BigDecimal(3904).compareTo(subResult) == 0);
    }
}
