package me.sparky983.profanityfilter;

/**
 * Checks to see if a word loosely resembles another word.
 * <p>
 * For example in a specific implementation {@code "h3ll0"} may resemble {@code "hello"}.
 *
 * @author Sparky983
 */
interface WordChecker {
    /**
     * Checks to see if a resembles another word.
     *
     * @param profanity the profanity word.
     * @param word the other word.
     * @return whether the word loosely resembles the profanity word.
     * @throws NullPointerException if the profanity word or the word is {@code null}.
     */
    boolean check(String profanity, String word);

    /**
     * Creates a new word checker.
     *
     * @return the word checker.
     */
    static WordChecker create() {
        return new WordCheckerImpl();
    }
}
