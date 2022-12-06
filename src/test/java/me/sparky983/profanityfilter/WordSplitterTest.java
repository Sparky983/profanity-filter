package me.sparky983.profanityfilter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordSplitterTest {
    WordSplitter wordSplitter;

    @BeforeEach
    void setUp() {
        wordSplitter = WordSplitter.create();
    }

    @Test
    void testSplitWhenMessageIsNull() {
        assertThrows(NullPointerException.class, () -> wordSplitter.split(null));
    }

    @Test
    void testSplit() {
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello,world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello.world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello-world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello_world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello/world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello\\world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello:world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello;world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello!world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello?world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello(world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello)world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello[world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello]world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello{world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello}world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello\"world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello'world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello`world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello~world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello@world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello#world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello$world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello%world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello^world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello&world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello*world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello+world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello=world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello|world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello<world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello>world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello, world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello. world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello- world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello_ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello/ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello\\ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello: world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello; world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello! world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello? world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello( world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello) world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello[ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello] world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello{ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello} world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello\" world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello' world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello` world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello~ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello@ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello# world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello$ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello% world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello^ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello& world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello* world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello+ world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello= world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello| world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello< world"));
        assertEquals(List.of("Hello", "world"), wordSplitter.split("Hello> world"));
    }

    @Test
    void testSplitWhenSingleWord() {
        assertEquals(List.of("single"), wordSplitter.split("single"));
    }
}
