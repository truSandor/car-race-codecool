package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;

public abstract class Vehicle {
    protected final String name;
    protected final int normalSpeed;
    protected int actualSpeed;

    protected int distanceTraveled;

    protected Vehicle() {
        this.name = generateName();
        this.normalSpeed = generateNormalSpeed();
        this.distanceTraveled = 0;
    }

    protected abstract String generateName();

    protected abstract int generateNormalSpeed();


    public abstract void prepareForLap(Race race);

    public void moveForAnHour() {
        distanceTraveled += actualSpeed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               " --- Distance travelled: " + distanceTraveled +
               " km --- Vehicle type: " + getClass().getSimpleName() +
               " --- Normal speed: " + normalSpeed + " km/h";
    }
}
