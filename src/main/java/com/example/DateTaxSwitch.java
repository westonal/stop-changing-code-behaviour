package com.example;

import java.math.BigDecimal;
import java.util.Date;

public final class DateTaxSwitch implements Tax {
    private final Date switchDate;
    private final Tax oldTax;
    private final Tax newTax;

    public DateTaxSwitch(
            final Tax oldTax,
            final Date switchDate,
            final Tax newTax
    ) {
        this.oldTax = oldTax;
        this.newTax = newTax;
        this.switchDate = switchDate;
    }

    @Override
    public BigDecimal applyTo(final BigDecimal subTotal) {
        return getActiveTaxRate().applyTo(subTotal);
    }

    private Tax getActiveTaxRate() {
        return new Date().before(switchDate) ? oldTax : newTax;
    }
}
