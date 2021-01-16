package com.intercom.utility;

import com.intercom.model.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceHelperTest {

    @Test
    void getDistance_DistanceBetweenTwoKnownPoint_KnownDistance() {
        double actual = DistanceHelper.getDistance(new Location(52.986375, -6.043701), new Location(53.339428, -6.257664));
        assertEquals(41.769, actual, "Incorrect distance between two locations");
    }

    @Test
    void getDistance_DistanceBetweenSameCoordinates_ZeroKM(){
        double actualSameLocation = DistanceHelper.getDistance(new Location(53.339428, -6.257664), new Location(53.339428, -6.257664));
        assertEquals(0, actualSameLocation, "Incorrect distance between two locations");
    }
}