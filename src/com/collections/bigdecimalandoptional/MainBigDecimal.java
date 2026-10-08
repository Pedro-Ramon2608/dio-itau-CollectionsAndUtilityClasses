package com.collections.bigdecimalandoptional;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainBigDecimal {
    public static void main(String[] args) {
//        System.out.println("-".repeat(25));
//        System.out.println("Tipos double\n");
//        double value1 = 0.1;
//        double value2 = 0.2;
//
//        System.out.println(value1 + value2);
//
//        System.out.println(2.00 - 1.1);
//        System.out.println(2.00 - 1.2);
//        System.out.println(2.00 - 1.3);
//        System.out.println(2.00 - 1.4);
//        System.out.println(2.00 - 1.5);
//        System.out.println(2.00 - 1.6);
//        System.out.println(2.00 - 1.7);
//        System.out.println(2.00 - 1.8);
//        System.out.println(2.00 - 1.9);
//        System.out.println("-".repeat(25));
//
//
//        System.out.println("-".repeat(25));
//        System.out.println("Tipos BigDecimal\n");
//        var valueBigDecimal1 = new BigDecimal("0.1");
//        var valueBigDecimal2 = new BigDecimal("0.2");
//
//        System.out.println(valueBigDecimal1.add(valueBigDecimal2));
//
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.2")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.3")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.4")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.5")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.6")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.7")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.8")));
//        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.9")));
//        System.out.println("-".repeat(25));

        var number = new BigDecimal("125");
        System.out.println(number.sqrt(new MathContext(4)));

        BigDecimal raizQuinta = new BigDecimal(Math.pow(number.doubleValue(), 1.0 / 3), new MathContext(4));
        System.out.println(raizQuinta);
    }
}
