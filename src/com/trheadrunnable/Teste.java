package com.trheadrunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class Teste {
    private static int number = 0;

    private static AtomicInteger numberAtomic = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i <= 100_000; i++) {
                // number++; // Pode sair desincronizado com o dec
                numberAtomic.incrementAndGet();
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i <= 100_000; i++) {
                // number--; // Pode sair desincronizado com o inc
                numberAtomic.decrementAndGet();
            }
        };

        Runnable show = () -> {
            for (int i = 0; i <= 100_000; i++) {
                System.out.println(numberAtomic);
            }
        };

        var valueInc = new Thread(show);
        var valueDec = new Thread(inc);
        var valueShow = new Thread(dec);
        valueInc.start();
        valueDec.start();
        valueShow.start();

//        System.out.println(valueInc.getName());
//        System.out.println(valueDec.getName());
//        System.out.println(valueShow.getName());
    }
}
