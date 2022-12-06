package me.sparky983.profanityfilter;

import java.util.Objects;

/**
 * The default {@link WordChecker} implementation.
 * <p>
 * Simply checks whether the expected word equals the word.
 *
 * @author Sparky983
 */
final class WordCheckerImpl implements WordChecker {
    @Override
    public boolean check(String profanity, String word) {
        Objects.requireNonNull(profanity, "profanity");
        Objects.requireNonNull(word, "word cannot be null");
        return profanity.equalsIgnoreCase(word);
    }
}
