package me.sparky983.profanityfilter;

import java.util.Objects;

/**
 * The default {@link ProfanityFilter} implementation.
 *
 * @author Sparky983
 */
final class ProfanityFilterImpl implements ProfanityFilter {
    private final WordCombinations wordCombinations;
    private final WordFilter wordChecker;

    /**
     * Constructs a new profanity filter with the specified word combinations and word checker.
     *
     * @author Sparky983
     * @param wordCombinations the word combinations.
     * @param wordFilter the word checker.
     * @throws NullPointerException if the word combinations or word checker is {@code null}.
     */
    ProfanityFilterImpl(WordCombinations wordCombinations, WordFilter wordFilter) {
        this.wordCombinations = Objects.requireNonNull(wordCombinations, "wordCombinations");
        this.wordChecker = Objects.requireNonNull(wordFilter, "wordFilter");
    }

    @Override
    public boolean filter(String message) {
        Objects.requireNonNull(message, "message");
        return wordCombinations.getWordCombinations(message)
                .stream()
                .anyMatch(wordChecker::filter);
    }
}
