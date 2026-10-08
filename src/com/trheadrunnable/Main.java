package com.trheadrunnable;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Integer> numbers = new ArrayList<>();


    private synchronized static void inc(int number) {
        numbers.add(number);
    }


    private synchronized static void show() {
        System.out.println(numbers);
    }


    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i <= 500; i++) {
                inc(i);
            }
        };

        Runnable dec = () -> {
            for (int i = 500; i >= 0; i--) {
                inc(i);
            }
        };

        Runnable show = () -> {
            for (int i = 0; i <= 1_100; i++) {
                show();
            }
        };

        new Thread(show).start();
        new Thread(inc).start();
        new Thread(dec).start();



    } // End of main()
} // End of class
