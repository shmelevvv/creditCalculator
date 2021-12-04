package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
        // метод округления, используемый при расчетах
        public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

        // количество знаков после запятой, выводимых в результат расчета для сумм
        public static int OUTPUT_AMOUNT_SCALE = 0;

        // количество знаков после запятой, выводимых в результат процента ЭПС
        public static int OUTPUT_PERCENT_SCALE = 3;

    public static BigDecimal getMonthlyPayment(BigDecimal amount, BigDecimal rate, int term) {
        if (amount.compareTo(new BigDecimal(0)) < 0) throw new IllegalArgumentException("Сумма кредита д.б. > 0");
        if (rate.compareTo(new BigDecimal(0)) < 0) throw new IllegalArgumentException("Процентная ставка д.б. > 0");
        if (term < 0) throw new IllegalArgumentException("Период д.б. > 0");

        //R = A * (r / 100 / 12) / (1 - (1 + (r / 100 / 12)) ^ -n )

        // месячная ставка по кредиту   r / 100 / 12
        BigDecimal monthlyRate = rate.divide(new BigDecimal(100)).divide(new BigDecimal(12), RoundingMode.HALF_UP);
        //  (1 + (r * 100 / 12)) ^ -n
        BigDecimal pow = new BigDecimal(1).add(monthlyRate).pow(-term, MathContext.DECIMAL32).setScale(OUTPUT_PERCENT_SCALE, ROUNDING_MODE);
        //  1 - (1 + (r * 100 / 12)) ^ -n
        BigDecimal denominator = new BigDecimal(1).subtract(pow);
        //result
        return amount.multiply(monthlyRate).divide(denominator, OUTPUT_AMOUNT_SCALE, ROUNDING_MODE);
    }

    public static BigDecimal getTotalAmount(BigDecimal amount, BigDecimal rate, int term) {
        return getMonthlyPayment(amount,rate, term).multiply(new BigDecimal(term));
    }


    public static BigDecimal getOverPayment(BigDecimal amount, BigDecimal rate, int term) {
        return getMonthlyPayment(amount,rate, term).multiply(new BigDecimal(term)).subtract(amount);
    }
}
