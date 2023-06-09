package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void generateNormalSpeed_run10000Times_NormalSpeedsAreWithinGivenRange() {
        final int TEST_CYCLES = 10000;
        Vehicle testCar = new Car();
        for (int i = 0; i < TEST_CYCLES; i++) {
            testCar.generateNormalSpeed();
            int normalSpeed = testCar.getNormalSpeed();
            assertTrue(normalSpeed > 80 && normalSpeed < 110);
        }
    }

    @Test
    void prepareForLap_IfTruckBrakesDown_SpeedOfCarSetsTo75() {
        final int TEST_CYCLES = 10000;
        final int EXPECTED_SPEED = 75;
        Race testRace = new Race();
        Vehicle testTruck = new Truck();
        Vehicle testCar = new Car();
        testRace.registerRacer(testTruck);
        testRace.registerRacer(testCar);
        for (int i = 0; i < TEST_CYCLES; i++) {
            for (Vehicle vehicle: testRace.getRacers()) {
                if (vehicle instanceof Truck truck) {
                    truck.prepareForLap(testRace);
                    truck.moveForAnHour();
                }
            }
            testRace.setYellowFlag(testRace.areThereBrokenDownTrucks());
            for (Vehicle vehicle: testRace.getRacers()) {
                if (!(vehicle instanceof Truck)) {
                    vehicle.prepareForLap(testRace);
                    vehicle.moveForAnHour();
                }
            }
            if (testRace.isYellowFlagActive()) {
                assertEquals(0, testTruck.getActualSpeed());
                assertEquals(EXPECTED_SPEED, testCar.getActualSpeed());
            }
        }
    }
}