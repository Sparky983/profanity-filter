package me.sparky983.profanityfilter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProfanityFilterImplTest {
    ProfanityFilter profanityFilter;

    WordCombinations wordCombinations;
    WordFilter wordFilter;

    @BeforeEach
    void setUp() {
        wordCombinations = mock(WordCombinations.class);
        wordFilter = mock(WordFilter.class);

        profanityFilter = new ProfanityFilterImpl(wordCombinations, wordFilter);
    }

    @Test
    void testConstructWhenWordCombinationIsNull() {
        assertThrows(NullPointerException.class, () -> new ProfanityFilterImpl(null, wordFilter));
    }

    @Test
    void testConstructWhenWordCheckerIsNull() {
        assertThrows(NullPointerException.class, () -> new ProfanityFilterImpl(wordCombinations, null));
    }

    @Test
    void testFilterWhenMessageIsNull() {
        assertThrows(NullPointerException.class, () -> profanityFilter.filter(null));
    }

    @Test
    void testFilterWhenWordsIsNoProfanity() {
        when(wordCombinations.getWordCombinations("Hello world"))
                .thenReturn(List.of("Hello", "world", "Helloworld"));
        when(wordFilter.filter(any())).thenReturn(false);

        boolean containsProfanity = profanityFilter.filter("Hello world");

        assertFalse(containsProfanity);
    }

    @Test
    void testFilterWhenWordsIsProfanity() {
        when(wordCombinations.getWordCombinations("Hello world"))
                .thenReturn(List.of("Hello", "world", "Helloworld"));
        when(wordFilter.filter("Helloworld")).thenReturn(true);

        boolean containsProfanity = profanityFilter.filter("Hello world");

        assertTrue(containsProfanity);
    }
}
