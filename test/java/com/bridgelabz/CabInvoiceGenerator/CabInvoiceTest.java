package com.bridgelabz.CabInvoiceGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    CabInvoice cabInvoice;

    @BeforeEach
    public void init() {
        cabInvoice = new CabInvoice();
    }

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        double fare = cabInvoice.calculateFares(20, 5);
        Assertions.assertEquals(205, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare() {
        double fare = cabInvoice.calculateFares(0.2, 1);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnAggregateFare() {
        Ride ride1 = new Ride(20, 5);
        Ride ride2 = new Ride(0.2, 1);
        Ride ride3 = new Ride(0.5, 2);
        Ride ride4 = new Ride(10, 5);
        Ride[] rides = {ride1, ride2, ride3, ride4};
        double aggregateFare = cabInvoice.calculateFares(rides);
        Assertions.assertEquals(322, aggregateFare);
    }

    @Test
    public void givenMultipleRidesShouldReturnInvoice() {
        Ride ride1 = new Ride(20, 5);
        Ride ride2 = new Ride(0.2, 1);
        Ride ride3 = new Ride(0.5, 2);
        Ride ride4 = new Ride(10, 5);
        Ride[] rides = {ride1, ride2, ride3, ride4};
        Invoice expectedInvoice = new Invoice(4, 322.0, 322.0 / 4);
        Invoice invoice = cabInvoice.generatesInvoice(rides);
        Assertions.assertEquals(expectedInvoice, invoice);
    }

    @Test
    public void givenUserShouldReturnInvoice() {
        Ride ride1 = new Ride(20, 5);
        Ride ride2 = new Ride(0.2, 1);
        Ride ride3 = new Ride(0.5, 2);
        Ride ride4 = new Ride(10, 5);
        Ride[] rides = {ride1, ride2, ride3, ride4};
        RiderRepository riderRepository = new RiderRepository();
        Invoice expectedInvoice = new Invoice(4, 322.0, 322.0 / 4, 1122);
        Invoice invoice = riderRepository.generatesInvoice(1122, rides);
        Assertions.assertEquals(expectedInvoice, invoice);
    }

    @Test
    public void givenRideCategoryShouldReturnInvoice() {
        Ride ride1 = new Ride(20, 5, RideCategory.PREMIUM);
        Ride ride2 = new Ride(0.2, 1, RideCategory.NORMAL);
        Ride ride3 = new Ride(0.5, 2, RideCategory.PREMIUM);
        Ride ride4 = new Ride(10, 5, RideCategory.NORMAL);
        Ride[] rides = {ride1, ride2, ride3, ride4};
        RiderRepository riderRepository = new RiderRepository();
        Invoice expectedInvoice = new Invoice(4, 440, 440.0 / 4, 1122);
        Invoice invoice = riderRepository.generateInvoice(1122, rides);
        Assertions.assertEquals(expectedInvoice, invoice);
    }
}

