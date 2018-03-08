package com.example;

import org.junit.Test;

import static com.example.BigDecimalHelpers.bd;
import static org.junit.Assert.assertEquals;

public final class BasketTaxIntegrationTests {

    private Basket givenBasket(final Tax tax) {
        return new Basket(tax);
    }

    private Basket givenBasketWith15PercentTax() {
        return givenBasket(new Tax15PCRoundedDown());
    }

    private Basket givenBasketWith20PercentTax() {
        return givenBasket(new Tax20PCRoundedDown());
    }

    @Test
    public void canGetTotalWith15PercentTax() {
        final Basket basket = givenBasketWith15PercentTax();
        basket.add(new Item(bd(10)));
        assertEquals(bd(11.5), basket.total());
    }

    @Test
    public void canGetTotalWith15PercentTaxRoundedDown() {
        final Basket basket = givenBasketWith15PercentTax();
        basket.add(new Item(bd(1.10)));
        assertEquals(bd(1.26), basket.total());
    }

    @Test
    public void canGetTotalWith20PercentTax() {
        final Basket basket = givenBasketWith20PercentTax();
        basket.add(new Item(bd(10)));
        assertEquals(bd(12), basket.total());
    }
}