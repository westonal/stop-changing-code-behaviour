package com.example;

import java.math.BigDecimal;

public final class BigDecimalHelpers {

    public static BigDecimal bd(final double val) {
        return BigDecimal
                .valueOf(val)
                .setScale(2, BigDecimal.ROUND_UNNECESSARY);
    }
}
