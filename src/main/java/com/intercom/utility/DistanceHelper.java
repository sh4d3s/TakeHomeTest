package com.intercom.utility;

import com.intercom.model.Location;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DistanceHelper {
    /***
     * Calculates the distance between two coordinates using Great-circle distance (https://en.wikipedia.org/wiki/Great-circle_distance)
     * @param location1 Location of point A
     * @param location2 Location of point B
     * @return Distance between point A and B
     */
    public static double getDistance(Location location1, Location location2) {

        if ((location1.getLatitude() == location2.getLatitude()) && (location1.getLongitude() == location2.getLongitude()))
            return 0;

        else {

            final double radiusEarth = 6371;

            double lat1Rad = Math.toRadians(location1.getLatitude());
            double long1Rad = Math.toRadians(location1.getLongitude());

            double lat2Rad = Math.toRadians(location2.getLatitude());
            double long2Rad = Math.toRadians(location2.getLongitude());

            double latDelta = lat2Rad - lat1Rad;
            double longDelta = long2Rad - long1Rad;

            double a = Math.pow(Math.sin(latDelta / 2), 2)
                    + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                    * Math.pow(Math.sin(longDelta / 2), 2);

            double c = 2 * Math.asin(Math.sqrt(a));

            DecimalFormat df = new DecimalFormat("#.###");
            df.setRoundingMode(RoundingMode.CEILING);

            return Double.parseDouble(df.format(radiusEarth * c));
        }

    }
}
