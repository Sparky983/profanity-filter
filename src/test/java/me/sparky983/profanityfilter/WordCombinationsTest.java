package me.sparky983.profanityfilter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordCombinationsTest {
    WordCombinations wordCombinations;

    WordJoiner wordJoiner;
    WordSplitter wordSplitter;

    @BeforeEach
    void setUp() {
        wordJoiner = mock(WordJoiner.class);
        wordSplitter = mock(WordSplitter.class);

        wordCombinations = WordCombinations.create(wordJoiner, wordSplitter);
    }

    @Test
    void testCreateWhenWordJoinerIsNull() {
        assertThrows(NullPointerException.class, () -> WordCombinations.create(null, wordSplitter));
    }

    @Test
    void testCreateWhenWordSplitterIsNull() {
        assertThrows(NullPointerException.class, () -> WordCombinations.create(wordJoiner, null));
    }

    @Test
    void testGetWordCombinationsWhenMessageIsNull() {
        assertThrows(NullPointerException.class, () -> wordCombinations.getWordCombinations(null));
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void testGetWordCombinations() {
        when(wordSplitter.split("can you friend me"))
                .thenReturn(List.of("pls", "friend", "me"));
        when(wordJoiner.join(List.of("pls", "friend", "me"), 1))
                .thenReturn(List.of("pls", "friend", "me"));
        when(wordJoiner.join(List.of("pls", "friend", "me"), 2))
                .thenReturn(List.of("plsfriend", "friendme"));

        List<String> combinations = wordCombinations.getWordCombinations("can you friend me");

        assertEquals(List.of("pls", "friend", "me", "plsfriend", "friendme"), combinations);
    }
}
