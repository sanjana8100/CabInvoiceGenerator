package com.bridgelabz.CabInvoiceGenerator;

public class CabInvoice {
    public static final int NORMAL_COST_PER_KILOMETER = 10;
    public static final int NORMAL_COST_PER_MINUTE = 1;
    public static final int NORMAL_MINIMUM_FARE = 5;

    public static final int PREMIUM_COST_PER_KILOMETER = 15;
    public static final int PREMIUM_COST_PER_MINUTE = 2;
    public static final int PREMIUM_MINIMUM_FARE = 20;

    public double calculateFares(double distance, double time) {
        double fare = (distance * NORMAL_COST_PER_KILOMETER) + (time * NORMAL_COST_PER_MINUTE);
        return (fare < NORMAL_MINIMUM_FARE)? NORMAL_MINIMUM_FARE : fare;
    }

    public double calculateFare(double distance, double time,RideCategory rideCategory) {
        if (RideCategory.NORMAL.equals(rideCategory)) {
            double fare = (distance * NORMAL_COST_PER_KILOMETER) + (time * NORMAL_COST_PER_MINUTE);
            return (fare < NORMAL_MINIMUM_FARE) ? NORMAL_MINIMUM_FARE : fare;
        } else {
            double fare = (distance * PREMIUM_COST_PER_KILOMETER) + (time * PREMIUM_COST_PER_MINUTE);
            return (fare < PREMIUM_MINIMUM_FARE) ? PREMIUM_MINIMUM_FARE : fare;
        }
    }

    public double calculateFares(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride: rides) {
            aggregateFare += calculateFares(ride.getDistance(),ride.getTime());
        }
        return aggregateFare;
    }

    public double calculateFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride: rides) {
            aggregateFare += calculateFare(ride.getDistance(),ride.getTime(),ride.getRideCategory());
        }
        return aggregateFare;
    }

    public Invoice generatesInvoice(Ride[] rides) {
        int totalRides = rides.length;
        double totalFare = calculateFares(rides);
        double averageFare =(totalFare/totalRides);
        return new Invoice(totalRides,totalFare,averageFare);
    }

    public Invoice generateInvoice(Ride[] rides) {
        int totalRides = rides.length;
        double totalFare = calculateFare(rides);
        double averageFare =(totalFare/totalRides);
        return new Invoice(totalRides,totalFare,averageFare);
    }
}
