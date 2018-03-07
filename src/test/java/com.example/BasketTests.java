package com.example;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public final class BasketTests {

    @Test
    public void canAddToBasketAndGetSubtotal() {
        final Basket basket = new Basket();
        basket.add(new Item(bd(1.23)));
        assertEquals(bd(1.23), basket.subTotal());
    }

    @Test
    public void canAddTwoItemsToBasketAndGetSubtotal() {
        final Basket basket = new Basket();
        final double val = 1.23;
        basket.add(new Item(bd(val)));
        basket.add(new Item(bd(2.34)));
        assertEquals(bd(3.57), basket.subTotal());
    }

    @Test
    public void canGetTotalWith20PercentTax() {
        final Basket basket = new Basket();
        basket.add(new Item(bd(10)));
        assertEquals(bd(12), basket.total());
    }

    @Test
    public void canGetTotalWith20PercentTaxRoundedDown() {
        final Basket basket = new Basket();
        basket.add(new Item(bd(1.10)));
        assertEquals(bd(1.32), basket.total());
    }

    private BigDecimal bd(final double val) {
        return BigDecimal
                .valueOf(val)
                .setScale(2, BigDecimal.ROUND_UNNECESSARY);
    }
}