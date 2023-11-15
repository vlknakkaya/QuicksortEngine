package com.quicksortengine.model;

public enum Destination {

    NEW_YORK("New York"),
    MIAMI("Miami"),
    NEW_ORLEANS("New Orleans"),
    HOUSTON("Houston"),
    LOS_ANGELES("Los Angeles");

    private String name;

    Destination(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Destination getDestination(String name) {
        for (Destination destination : values()) {
            if (name.equals(destination.getName())) return destination;
        }

        return null;
    }

}
