package me.sparky983.profanityfilter;

import java.util.List;

/**
 * Gets a list of all possible combination of words in a string.
 * <p>
 * For example in the sentence {@code "Hello world"}, a possible implementation may decide that
 * {@code ["Hello", "world", "Helloworld"]} are all valid combinations.
 *
 * @author Sparky983
 */
interface WordCombinations {

    /**
     * Gets a list of all possible combination of words in a string.
     *
     * @param message the message.
     * @return a list of all possible combination of words in a string.
     * @throws NullPointerException if the message is {@code null}.
     */
    List<String> getWordCombinations(String message);

    /**
     * Creates a new word combinations.
     *
     * @param wordJoiner the word joiner.
     * @param wordSplitter the word splitter.
     * @return the word combinations.
     * @throws NullPointerException if the word joiner or word splitter is {@code null}.
     */
    static WordCombinations create(WordJoiner wordJoiner, WordSplitter wordSplitter) {
        return new WordCombinationsImpl(wordJoiner, wordSplitter);
    }
}
