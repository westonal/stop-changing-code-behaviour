package com.example;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public final class Basket {
    private final List<Item> items = new LinkedList<>();

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
        return subTotal()
                .multiply(BigDecimal.valueOf(1.15))
                .setScale(2, BigDecimal.ROUND_DOWN);
    }
}
