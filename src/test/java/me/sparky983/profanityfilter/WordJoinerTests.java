package me.sparky983.profanityfilter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class WordJoinerTests {
    WordJoiner wordJoiner;

    @BeforeEach
    void setUp() {
        wordJoiner = WordJoiner.create();
    }

    @Test
    void testJoinWhenWordsIsNull() {
        assertThrows(NullPointerException.class, () -> wordJoiner.join(null, 1));
    }

    @Test
    void testJoinWhenWordsContainsNull() {
        List<String> words = Collections.singletonList(null);

        assertThrows(NullPointerException.class, () -> wordJoiner.join(words, 1));
    }

    @Test
    void testJoinWhenJoinLengthIsNegative() {
        List<String> words = List.of("Hello", "world");

        assertThrows(IllegalArgumentException.class, () -> wordJoiner.join(words, -1));
    }

    @Test
    void testJoinWhenJoinLengthIsZero() {
        List<String> words = List.of("Hello", "world");

        assertThrows(IllegalArgumentException.class, () -> wordJoiner.join(words, 0));
    }

    @Test
    void testJoinWhenJoinLengthIsGreaterThanWordsLength() {
        List<String> words = List.of("Hello", "world");

        assertThrows(IllegalArgumentException.class, () -> wordJoiner.join(words, 3));
    }

    @Test
    void testJoinWhenJoinLengthIsOne() {
        List<String> joinedWords = wordJoiner.join(List.of("Hello", "world"), 1);

        assertEquals(List.of("Hello", "world"), joinedWords);
    }

    @Test
    void testJoinWhenJoinLengthIsWordsLength() {
        List<String> joinedWords = wordJoiner.join(List.of("Hello", "world"), 2);

        // noinspection SpellCheckingInspection
        assertEquals(List.of("Helloworld"), joinedWords);
    }

    @Test
    void testJoinWhenJoin() {
        List<String> joinedWords = wordJoiner.join(
                List.of("Hello", "can", "you", "friend", "me"), 3);

        // noinspection SpellCheckingInspection
        assertEquals(
                List.of("Hellocanyou",
                        "canyoufriend",
                        "youfriendme"),
                joinedWords);
    }
}
