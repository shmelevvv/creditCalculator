package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal(20000);
        BigDecimal rate = new BigDecimal(12);
        int term = 36;
        System.out.println("Ежемесячный платеж: " + Calculator.getMonthlyPayment(amount,rate,term));
        System.out.println("Общая сумма " + Calculator.getTotalAmount(amount,rate,term));
        System.out.println("Переплата: " + Calculator.getOverPayment(amount,rate,term));
    }
}
