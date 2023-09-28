package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchesTest {
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
}
