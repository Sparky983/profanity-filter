package me.sparky983.profanityfilter;

import java.util.List;

/**
 * Checks whether a single word is a profanity.
 *
 * @author Sparky983
 */
interface WordFilter {
    /**
     * Checks whether a single word is a profanity.
     *
     * @param word the word.
     * @return whether the word is a profanity.
     * @throws NullPointerException if the word is {@code null}.
     */
    boolean filter(String word);

    /**
     * Creates a new word filter.
     *
     * @param wordChecker the word checker.
     * @param profanities the profanities.
     * @return the word filter.
     * @throws NullPointerException if the word checker or profanities is {@code null}.
     */
    static WordFilter create(WordChecker wordChecker, List<String> profanities) {
        return new WordFilterImpl(wordChecker, profanities);
    }
}
