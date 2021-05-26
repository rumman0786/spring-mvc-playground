package com.util;

import java.util.Random;

/**
 * @author rumman
 * @since 5/26/21
 */
public class NumberUtils {

    private static Random random = new Random();
    public static int getRandomBetween(int minInclusive, int maxInclusive) {
        return minInclusive + random.nextInt( maxInclusive - minInclusive + 1);
    }
}
