package me.sparky983.profanityfilter;

import java.util.List;
import java.util.Objects;

/**
 * The default implementation of {@link WordFilter}.
 *
 * @author Sparky983
 */
final class WordFilterImpl implements WordFilter {
    private final WordChecker wordChecker;
    private final List<String> profanities;

    WordFilterImpl(WordChecker wordChecker, List<String> profanities) {
        this.wordChecker = Objects.requireNonNull(wordChecker, "wordChecker");
        this.profanities = List.copyOf(profanities);
    }

    @Override
    public boolean filter(String word) {
        Objects.requireNonNull(word, "word");
        for (String profanity : profanities) {
            if (wordChecker.check(profanity, word)) {
                return true;
            }
        }
        return false;
    }
}
