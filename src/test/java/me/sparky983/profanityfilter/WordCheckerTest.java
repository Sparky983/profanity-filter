package me.sparky983.profanityfilter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCheckerTest {
    WordChecker wordChecker;

    @BeforeEach
    void setUp() {
        wordChecker = WordChecker.create();
    }

    @Test
    void testCheckWhenProfanityIsNull() {
        assertThrows(NullPointerException.class, () -> wordChecker.check(null, "hello"));
    }

    @Test
    void testCheckWhenWordIsNull() {
        assertThrows(NullPointerException.class, () -> wordChecker.check("duck", null));
    }

    @Test
    void testCheckWhenWordIsNotProfanity() {
        boolean isProfanity = wordChecker.check("duck", "hello");

        assertFalse(isProfanity);
    }

    @Test
    void testCheckWhenWordIsProfanity() {
        boolean isProfanity = wordChecker.check("duck", "DUCK");

        assertTrue(isProfanity);
    }
}
