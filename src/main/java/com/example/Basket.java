package com.example;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public final class Basket {

    private final List<Item> items = new LinkedList<>();
    private final Tax tax;

    Basket(final Tax tax) {
        this.tax = tax;
    }

    public void add(final Item item) {
        items.add(item);
    }

    public BigDecimal subTotal() {
        BigDecimal subTotal = BigDecimal.ZERO;
        for (final Item item : items) {
            subTotal = subTotal.add(item.getValue());
        }
        return subTotal;
    }

    public BigDecimal total() {
        return tax.applyTo(subTotal());
    }
}
