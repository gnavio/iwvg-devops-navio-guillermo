package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FractionTest {
    private Fraction f1;
    private Fraction f2;
    private Fraction f3;

    @BeforeEach
    void before() {
        f1 = new Fraction(3, 2);
        f2 = new Fraction(5, 2);
        f3 = new Fraction(9, 6);
    }

    @Test
    void testDecimal() {
        assertEquals(1.5, f1.decimal());
        assertEquals(2.5, f2.decimal());
        assertEquals(1.5, f3.decimal());
    }

    @Test
    void testFraction() {
        f3.setNumerator(1);
        f3.setDenominator(2);
        assertEquals(1, f3.getNumerator());
        assertEquals(2, f3.getDenominator());

    }
}