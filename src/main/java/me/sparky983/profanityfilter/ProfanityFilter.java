package me.sparky983.profanityfilter;

import java.util.List;

/**
 * Filters profanity.
 *
 * @author Sprky983
 * @since 1.0
 */
public interface ProfanityFilter {

    /**
     * Filters profanity from a string.
     *
     * @param message the message.
     * @return whether the message contains profanity.
     * @throws NullPointerException if the message is {@code null}.
     * @since 1.0
     */
    boolean filter(String message);

    /**
     * Creates a new profanity filter.
     *
     * @param profanities the profanities.
     * @return the profanity filter.
     * @throws NullPointerException if the profanities list is or contains {@code null}.
     * @since 1.0
     */
    static ProfanityFilter create(List<String> profanities) {
        return new ProfanityFilterImpl(
                WordCombinations.create(WordJoiner.create(), WordSplitter.create()),
                WordFilter.create(WordChecker.create(), profanities)
        );
    }
}
