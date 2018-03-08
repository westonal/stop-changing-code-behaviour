package com.example;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public final class DateTaxSwitchTests {

    private final Tax oldRate = mock(Tax.class);
    private final Tax newRate = mock(Tax.class);

    private Tax givenTax(final Date switchDate) {
        return new DateTaxSwitch(oldRate, switchDate, newRate);
    }

    @Test
    public void afterACertainDateSecondTaxIsUsed() {
        givenSwitchDateExpectToUseRate(today(), newRate);
    }

    @Test
    public void beforeACertainDateFirstTaxIsUsed() {
        givenSwitchDateExpectToUseRate(tomorrow(), oldRate);
    }

    private void givenSwitchDateExpectToUseRate(
            final Date switchDate,
            final Tax expectedRateToBeUsed
    ) {
        final BigDecimal subTotal = BigDecimal.ONE;
        final BigDecimal expected = BigDecimal.TEN;
        when(expectedRateToBeUsed.applyTo(subTotal))
                .thenReturn(expected);
        final Tax t = givenTax(switchDate);
        assertSame(t.applyTo(subTotal), expected);
        verify(otherRate(expectedRateToBeUsed), never()).applyTo(any());
    }

    private Tax otherRate(final Tax expected) {
        return expected == newRate ? oldRate : newRate;
    }

    private static Date tomorrow() {
        return todayPlusDays(1);
    }

    private static Date todayPlusDays(final int deltaDays) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(today());
        cal.add(Calendar.DATE, deltaDays);
        return cal.getTime();
    }

    private static Date today() {
        return new Date();
    }
}
