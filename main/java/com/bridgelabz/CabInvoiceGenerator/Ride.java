package com.bridgelabz.CabInvoiceGenerator;

public class Ride {
    private double distance;
    private double time;
    private RideCategory rideCategory;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance, double time, RideCategory rideCategory) {
        this.distance = distance;
        this.time = time;
        this.rideCategory = rideCategory;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public RideCategory getRideCategory() {
        return rideCategory;
    }

    public void setRideCategory(RideCategory rideCategory) {
        this.rideCategory = rideCategory;
    }
}
