package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchesTest {
    private Searches search;
        
    @BeforeEach
    void before() {
        search = new Searches();
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        assertEquals(0, search.findFirstProperFractionByUserId("1").getNumerator());
        assertEquals(1, search.findFirstProperFractionByUserId("1").getDenominator());
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        List<Double> result = search.findDecimalFractionByNegativeSignFraction().collect(Collectors.toList());
        List<Double> expectedResult = List.of(-0.2, -0.5);
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        List<String> result = search.findUserFamilyNameByAllNegativeSignFractionDistinct().collect(Collectors.toList());
        List<String> expectedResult = List.of("Blanco", "López");
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindFractionAdditionByUserId() {
        Fraction result = search.findFractionAdditionByUserId("1");
        Fraction expectedResult = new Fraction(3, 1);
        assertEquals(expectedResult.getNumerator(), result.getNumerator());
        assertEquals(expectedResult.getDenominator(), result.getDenominator());
    }
}