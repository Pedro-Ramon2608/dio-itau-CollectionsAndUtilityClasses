package com.collections.strings;

import java.time.Duration;
import java.time.OffsetDateTime;

/**
 * Comparação de desempenho entre String, StringBuilder e StringBuffer
 */
public class TypeOfStrings {
    public static void main(String[] args) {

        // Desempenho da String normal
        var stringStart = OffsetDateTime.now();
        String stringConcat = "";

        for (int i = 0; i < 1_000_000; i++) {
            stringConcat += i;
        }
        var stringEnd = OffsetDateTime.now();
        System.out.printf("String: %s\n", getInterval(stringStart, stringEnd));


        // Desempenho do StringBuilder
        var builderStart = OffsetDateTime.now();
        var builderConcat = new StringBuilder();

        for (int i = 0; i < 1_000_000; i++) {
            builderConcat.append(i);
        }
        var builderEnd = OffsetDateTime.now();
        System.out.printf("Builder (Single Thread): %s\n", getInterval(builderStart, builderEnd));


        // Desempenho do StringBuffer
        var bufferStart = OffsetDateTime.now();
        var bufferConcat = new StringBuffer();

        for (int i = 0; i < 1_000_000; i++) {
            bufferConcat.append(i);
        }
        var bufferEnd = OffsetDateTime.now();
        System.out.printf("Buffer (Multiple Threads): %s\n", getInterval(bufferStart, bufferEnd));
    }

    private static long getInterval(OffsetDateTime stringStart, OffsetDateTime stringEnd) {
        return Duration.between(stringStart, stringEnd).toMillis();
    }
}
