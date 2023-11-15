package com.quicksortengine.engine;

import com.quicksortengine.model.Car;
import com.quicksortengine.model.Color;
import com.quicksortengine.util.Util;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortJob implements Runnable {

    private String fileName;

    public SortJob(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
             FileWriter fileWriter = new FileWriter(fileName.substring(0, fileName.indexOf(".")) + "-sorted.txt")) {
            List<Car> carList = bufferedReader.lines().map(this::readFromLine).collect(Collectors.toList());
            Collections.sort(carList);

            for (Car car : carList) {
                fileWriter.write(car.toString());
                fileWriter.write(Util.NEW_LINE);
                fileWriter.flush();
            }
        } catch (IOException ioException) {
            System.out.println("[SortJob] - Exception while sorting file: " + fileName);
            ioException.printStackTrace();
        }
    }

    private Car readFromLine(String line) {
        String[] values = line.split(Util.TAB);

        Car car = new Car();
        car.setDestination(values[0]);
        car.setColor(Color.valueOf(values[1]));
        car.setSerial(values[2]);
        car.setRec_id(Long.parseLong(values[3]));

        return car;
    }

    public String getFileName() {
        return fileName;
    }

}
