package com.example;

import java.math.BigDecimal;

public interface Tax {
    BigDecimal applyTo(final BigDecimal subTotal);
}
