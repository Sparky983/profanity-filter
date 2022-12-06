package me.sparky983.profanityfilter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

/**
 * Tests the entire profanity filter.
 */
class ProfanityFilterAcceptanceTest {

    ProfanityFilter profanityFilter;

    final List<String> profanities = List.of("truck", "duck", "pit");

    @BeforeEach
    void setUp() {
        profanityFilter = ProfanityFilter.create(profanities);
    }

    @Test
    void testCreateWhenProfanitiesIsNull() {
        assertThrows(NullPointerException.class, () -> ProfanityFilter.create(null));
    }

    @Test
    void testCreateWhenProfanitiesContainsNull() {
        List<String> profanities = Collections.singletonList(null);

        assertThrows(NullPointerException.class, () -> ProfanityFilter.create(profanities));
    }

    @Test
    void testFilterWhenMessageContainsProfanity() {
        // final List<String> profanities = List.of("truck", "duck", "pit");
        assertTrue(profanityFilter.filter("I like duck"));
        assertTrue(profanityFilter.filter("I like du ck"));
        assertTrue(profanityFilter.filter("I like tru ck"));
        assertTrue(profanityFilter.filter("I like d u c k"));
        assertTrue(profanityFilter.filter("I like D U CK"));
        assertTrue(profanityFilter.filter("I like D|U,CK"));
        assertTrue(profanityFilter.filter("I'm in a p    it"));
    }

    @Test
    void testFilterWhenMessageDoesNotContainProfanity() {
        assertFalse(profanityFilter.filter("I like hello"));
        assertFalse(profanityFilter.filter("firetruck"));
    }
}
