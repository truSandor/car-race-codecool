package com.codecool.car_race;

public class Race {
    private final int raceTime = 50;
    public Race() {
    }

    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */
    public void simulateRace() {
        for (int i = 0; i < raceTime; i++) {
            Weather.advance();
            for (Vehicle vehicle: racers) {
                vehicle.moveForAnHour();
            }
        }
    }

    /**
     * Prints the state of all vehicles. Called at the end of the
     * race.
     */
    public void printRaceResults() {
    }

}
