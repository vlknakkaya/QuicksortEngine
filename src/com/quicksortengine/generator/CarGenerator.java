package com.quicksortengine.generator;

import com.quicksortengine.model.Car;
import com.quicksortengine.model.Color;
import com.quicksortengine.util.Util;

import java.io.FileWriter;
import java.io.IOException;

public class CarGenerator {

    public static void generate(int listNumber) {
        long start = System.currentTimeMillis();

        System.out.println("[CarGenerator] - Generation started.");

        for (int i = 0; i < listNumber; i++) {
            String filename = "cars-" + i + ".txt";
            try (FileWriter fileWriter = new FileWriter(filename)) {
                Car car = null;

                for (int j = 0; j < Util.CAR_COUNT_PER_LIST; j++) {
                    car = new Car(j+1, randomColor(), randomDestination());

                    fileWriter.write(car.toString());
                    fileWriter.write(Util.NEW_LINE);
                    fileWriter.flush();
                }
            } catch (IOException e) {
                System.out.println("Exception while creating the list: " + e);
            }

            System.out.println("[CarGenerator] - Generated: " + filename);
        }

        System.out.println("CarGenerator has finished in " + Util.elapsedTime(start) + " ms");

    }

    private static Color randomColor() {
        return Util.COLORS[Util.RANDOM.nextInt(Util.COLORS.length)];
    }

    private static String randomDestination() {
        return Util.DESTINATIONS[Util.RANDOM.nextInt(Util.DESTINATIONS.length)].getName();
    }

}
