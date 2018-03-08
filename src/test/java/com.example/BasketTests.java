package com.example;

import org.junit.Test;

import static com.example.BigDecimalHelpers.bd;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public final class BasketTests {

    private Basket givenBasket() {
        return new Basket(mock(Tax.class));
    }

    @Test
    public void canAddToBasketAndGetSubtotal() {
        final Basket basket = givenBasket();
        basket.add(new Item(bd(1.23)));
        assertEquals(bd(1.23), basket.subTotal());
    }

    @Test
    public void canAddTwoItemsToBasketAndGetSubtotal() {
        final Basket basket = givenBasket();
        final double val = 1.23;
        basket.add(new Item(bd(val)));
        basket.add(new Item(bd(2.34)));
        assertEquals(bd(3.57), basket.subTotal());
    }
}