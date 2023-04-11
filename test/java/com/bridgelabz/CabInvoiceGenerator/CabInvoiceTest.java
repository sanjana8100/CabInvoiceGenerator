package com.bridgelabz.CabInvoiceGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    CabInvoice cabInvoice = new CabInvoice();

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare(){
        double fare = cabInvoice.calculateFare(20,5);
        Assertions.assertEquals(205,fare,0.0);
    }
}
