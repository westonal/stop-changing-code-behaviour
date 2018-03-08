package com.example;

import org.junit.Test;

import static com.example.BigDecimalHelpers.bd;
import static org.junit.Assert.assertEquals;

public final class TwentyPercentTaxTests {

    private Tax givenTax() {
        return new Tax20PCRoundedDown();
    }

    @Test
    public void canApply20PercentTax() {
        assertEquals(bd(1.2), givenTax().applyTo(bd(1)));
    }

    @Test
    public void doesRoundDown() {
        assertEquals(bd(12.01), givenTax().applyTo(bd(10.01)));
    }
}