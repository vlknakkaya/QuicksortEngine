package com.quicksortengine.util;

import com.quicksortengine.model.Color;
import com.quicksortengine.model.Destination;

import java.util.Random;

public final class Util {

    public static final int LIST_NUMBER = 30;
    public static final int CAR_COUNT_PER_LIST = 100000;
    public static final Color[] COLORS = Color.values();
    public static final Destination[] DESTINATIONS = Destination.values();
    public static final Random RANDOM = new Random();
    public static final String TAB = "\t";
    public static final String NEW_LINE = "\n";
    public static final int MAX_THREADS = 5;

    public static String generateSerial() {
        char firstLetter = (char) (RANDOM.nextInt(26) + 65);
        char secondLetter = (char) (RANDOM.nextInt(26) + 65);

        return "" + firstLetter + RANDOM.nextInt(100000) + secondLetter + RANDOM.nextInt(100000);
    }

    public static long elapsedTime(long start) {
        return System.currentTimeMillis() - start;
    }

    private Util() {
        throw new IllegalStateException("Util class");
    }

}
