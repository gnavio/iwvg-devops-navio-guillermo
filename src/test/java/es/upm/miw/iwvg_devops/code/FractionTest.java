package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FractionTest {
    private Fraction f1;
    private Fraction f2;
    private Fraction f3;
    private Fraction f4;

    @BeforeEach
    void before() {
        f1 = new Fraction(3, 2);
        f2 = new Fraction(5, 2);
        f3 = new Fraction(9, 6);
        f4 = new Fraction();
    }

    @Test
    void testDecimal() {
        assertEquals(1.5, f1.decimal());
        assertEquals(2.5, f2.decimal());
        assertEquals(1.5, f3.decimal());
    }

    @Test
    void testIsProper() {
        assertFalse(f1.isProper());
        assertFalse(f2.isProper());
        assertFalse(f3.isProper());
    }

    @Test
    void testIsImproper() {
        assertTrue(f1.isImproper());
        assertTrue(f2.isImproper());
        assertTrue(f3.isImproper());
    }

    @Test
    void testIsEquivalent() {
        assertTrue(f1.isEquivalent(f3));
        assertFalse(f1.isEquivalent(f2));
    }

    @Test
    void testAdd() {
        assertEquals(16.0, f1.add(f2).getNumerator());
        assertEquals(4.0, f1.add(f2).getDenominator());
    }

    @Test
    void testMultiply() {
        assertEquals(15.0, f1.multiply(f2).getNumerator());
        assertEquals(4.0, f1.multiply(f2).getDenominator());
    }

    @Test
    void testDivide() {
        assertEquals(6.0, f1.divide(f2).getNumerator());
        assertEquals(10.0, f1.divide(f2).getDenominator());
    }

    @Test
    void testFraction() {
        f3.setNumerator(1);
        f3.setDenominator(2);
        assertEquals(1, f3.getNumerator());
        assertEquals(2, f3.getDenominator());
        assertEquals(1, f4.getNumerator());
        assertEquals(1, f4.getDenominator());
    }

    @Test
    void testToString() {
        assertEquals("Fraction{numerator=3, denominator=2}", f1.toString());
    }
}