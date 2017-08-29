package com.swipe.jobs.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DistanceCalculatorUtil {

	public static double getDistanceFromLatLonInKm(double latitude1, double longitude1, double latitude2, double longitude2) {
		
		double theta = longitude1 - longitude2;
		double distance = Math.sin(deg2rad(latitude1)) * Math.sin(deg2rad(latitude2))
				+ Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta));
		distance = Math.acos(distance);
		distance = rad2deg(distance);
		distance = distance * 60 * 1.1515;
		distance = distance * 1.609344;
		return new BigDecimal(distance).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
