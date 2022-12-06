package me.sparky983.profanityfilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The default implementation of {@link ProfanityFilter}.
 * <p>
 * Splits messages at spaces and punctuation marks.
 *
 * @author Sparky983
 */
final class WordSplitterImpl implements WordSplitter {
    private static final Pattern SPLIT_PATTERN = Pattern.compile("[^A-Za-z\\d]+");

    @Override
    public List<String> split(String message) {
        Objects.requireNonNull(message, "message");
        return List.of(SPLIT_PATTERN.split(message));
    }
}
