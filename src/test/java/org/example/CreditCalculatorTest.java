package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;


public class CreditCalculatorTest
{
    @Test
    public void testCalculation_validArgument_getMonthlyPayment_success() {
        BigDecimal amount = new BigDecimal(10000000L);
        BigDecimal rate = new BigDecimal(9.5);
        int term = 180;

        BigDecimal subResult = Calculator.getMonthlyPayment(amount, rate, term);
        Assertions.assertTrue(new BigDecimal(104422).compareTo(subResult) == 0);
    }

    @Test
    public void testCalculation_negativeRate_getMonthlyPayment_trowsException() {
        BigDecimal amount = new BigDecimal(10000000L);
        BigDecimal rate = new BigDecimal(-9.5);
        int term = 180;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.getMonthlyPayment(amount, rate, term));
    }

    @Test
    public void testCalculation_negativeAmount_getMonthlyPayment_trowsException() {
        BigDecimal amount = new BigDecimal(-10000000L);
        BigDecimal rate = new BigDecimal(9.5);
        int term = 180;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.getMonthlyPayment(amount, rate, term));
    }

    @Test
    public void testCalculation_negativeTerm_getMonthlyPayment_trowsException() {
        BigDecimal amount = new BigDecimal(-10000000L);
        BigDecimal rate = new BigDecimal(9.5);
        int term = -180;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.getMonthlyPayment(amount, rate, term));
    }

    @Test
    public void testCalculation_negativeTerm_getMonthlyPayment_trowsException() {
        BigDecimal amount = new BigDecimal(-10000000L);
        BigDecimal rate = new BigDecimal(9.5);
        int term = -180;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.getMonthlyPayment(amount, rate, term));
    }

    @Test
    public void testCalculation_validArguments_getTotalAmount() {
        BigDecimal amount = new BigDecimal(10000000L);
        BigDecimal rate = new BigDecimal(9.5);
        int term = 180;

        BigDecimal subResult = Calculator.getMonthlyPayment(amount, rate, term).multiply(term);
        Assertions.assertTrue(new BigDecimal(18795960).compareTo(subResult) == 0);
    }

    @Test
    public void testCalculation_validArguments_getOverPayment() {
        BigDecimal amount = new BigDecimal(10000000L);
        BigDecimal rate = new BigDecimal(9.5);
        int term = 180;

        BigDecimal subResult = Calculator.getMonthlyPayment(amount, rate, term).multiply(term).subtract(amount);
        Assertions.assertTrue(new BigDecimal(18795960).compareTo(subResult) == 0);
    }
}
