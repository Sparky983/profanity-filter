package me.sparky983.profanityfilter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class WordFilterTest {

    WordFilter wordFilter;

    WordChecker wordChecker;
    final List<String> profanities = List.of("truck", "duck", "pit");

    @BeforeEach
    void setUp() {
        wordChecker = mock(WordChecker.class);

        wordFilter = WordFilter.create(wordChecker, profanities);
    }

    @Test
    void testCreateWhenWordCheckerIsNull() {
        assertThrows(NullPointerException.class, () -> WordFilter.create(null, profanities));
    }

    @Test
    void testCreateWhenProfanitiesIsNull() {
        assertThrows(NullPointerException.class, () -> WordFilter.create(wordChecker, null));
    }

    @Test
    void testCreateWhenProfanitiesContainsNull() {
        List<String> profanities = Collections.singletonList(null);

        assertThrows(NullPointerException.class, () -> WordFilter.create(wordChecker, profanities));
    }

    @Test
    void testFilterWhenWordIsNull() {
        assertThrows(NullPointerException.class, () -> wordFilter.filter(null));
    }

    @Test
    void testFilterWhenWordIsNotProfanity() {
        when(wordChecker.check("duck", "hello")).thenReturn(false);
        boolean isProfanity = wordFilter.filter("hello");

        assertFalse(isProfanity);
    }

    @Test
    void testFilterWhenWordIsProfanity() {
        when(wordChecker.check("duck", "dukk")).thenReturn(true);
        boolean isProfanity = wordFilter.filter("dukk");

        assertTrue(isProfanity);
    }
}
