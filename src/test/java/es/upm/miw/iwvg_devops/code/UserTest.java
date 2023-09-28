package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;


    @BeforeEach
    void before() {
        List<Fraction> fractions = new ArrayList<>();
        user1 = new User("1", "Frederick", "Battin", fractions);
        user2 = new User("2", "Calvin", "Day", fractions);
        user3 = new User("3", "Celia", "Wang", fractions);
        user4 = new User("4", "Anas", "Lloyd", fractions);
        user5 = new User("5", "Mike", "Reynolds", fractions);
    }

    @Test
    void testFullName() {
        assertEquals("Frederick Battin", user1.fullName());
        assertEquals("Calvin Day", user2.fullName());
        assertEquals("Celia Wang", user3.fullName());
        assertEquals("Anas Lloyd", user4.fullName());
        assertEquals("Mike Reynolds", user5.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("F.", user1.initials());
        assertEquals("C.", user2.initials());
        assertEquals("C.", user3.initials());
        assertEquals("A.", user4.initials());
        assertEquals("M.", user5.initials());
    }

    @Test
    void testUser() {
        assertEquals("1", user1.getId());
        assertEquals("Frederick", user1.getName());
        assertEquals("Battin", user1.getFamilyName());
        user5.setName("Name");
        user5.setFamilyName("FamilyName");
        assertEquals("Name", user5.getName());
        assertEquals("FamilyName", user5.getFamilyName());
    }
}