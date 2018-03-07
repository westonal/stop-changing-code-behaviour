package com.example;

import java.math.BigDecimal;

public final class Item {
    private final BigDecimal value;

    public Item(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
