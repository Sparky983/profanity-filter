package me.sparky983.profanityfilter;

import java.util.List;

/**
 * Splits a string into a list of words.
 * <p>
 * The implementation may use any technique to find barriers of words, most commonly by simply using
 * spaces.
 *
 * @author Sparky983
 */
interface WordSplitter {

    /**
     * Splits a string into a list of words.
     *
     * @author Sparky983
     * @param message the message.
     * @return the words.
     * @throws NullPointerException if the message is {@code null}.
     */
    List<String> split(String message);

    /**
     * Creates a new word splitter.
     *
     * @return the word splitter.
     */
    static WordSplitter create() {
        return new WordSplitterImpl();
    }
}
