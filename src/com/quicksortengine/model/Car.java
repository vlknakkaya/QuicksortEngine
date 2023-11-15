package com.quicksortengine.model;

import com.quicksortengine.util.Util;

public class Car implements Comparable<Car> {

    private long rec_id;
    private String serial;
    private Color color;
    private String destination;

    public Car() {
        this.serial = Util.generateSerial();
    }

    public Car(long rec_id, Color color, String destination) {
        this();
        this.rec_id = rec_id;
        this.color = color;
        this.destination = destination;
    }

    public Car(long rec_id, String serial, Color color, String destination) {
        this.rec_id = rec_id;
        this.serial = serial;
        this.color = color;
        this.destination = destination;
    }

    public long getRec_id() {
        return rec_id;
    }

    public void setRec_id(long rec_id) {
        this.rec_id = rec_id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getDestination())
                .append(Util.TAB)
                .append(this.getColor().name())
                .append(Util.TAB)
                .append(this.getSerial())
                .append(Util.TAB)
                .append(this.getRec_id());

        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Car o) {
        int compare = Destination.getDestination(o.getDestination()).compareTo(Destination.getDestination(this.destination));
        if (compare != 0) return compare;

        compare = o.getColor().compareTo(this.getColor());
        if (compare != 0) return compare;

        return this.getSerial().compareTo(o.getSerial());
    }
}
