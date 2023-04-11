package com.bridgelabz.CabInvoiceGenerator;

public class RiderRepository {

    public RiderRepository() {
    }

    public Invoice generatesInvoice(int userId, Ride[] rides) {
        CabInvoice cabInvoice = new CabInvoice();
        int totalRides = rides.length;
        double totalFare = cabInvoice.calculateFares(rides);
        double averageFare = (totalFare/totalRides);
        return new Invoice (totalRides,totalFare,averageFare,userId);
    }

    public Invoice generateInvoice(int userId, Ride[] rides) {
        CabInvoice cabInvoice = new CabInvoice();
        int totalRides = rides.length;
        double totalFare = cabInvoice.calculateFare(rides);
        double averageFare = (totalFare/totalRides);
        return new Invoice (totalRides,totalFare,averageFare,userId);
    }
}
