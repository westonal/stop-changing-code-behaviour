package com.example;

import java.math.BigDecimal;

public final class Tax15PCRoundedDown implements Tax {
    @Override
    public BigDecimal applyTo(final BigDecimal subTotal) {
        return subTotal
                .multiply(BigDecimal.valueOf(1.15))
                .setScale(2, BigDecimal.ROUND_DOWN);

    }
}