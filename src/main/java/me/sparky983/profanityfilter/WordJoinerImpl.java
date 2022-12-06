package me.sparky983.profanityfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The default implementation of {@link WordJoiner}.
 *
 * @author Sparky983
 * @see WordJoiner#create()
 */
final class WordJoinerImpl implements WordJoiner {
    // TODO(Sparky983): optimize for non random access lists
    @Override
    public List<String> join(List<String> words, int joinLength) {
        Objects.requireNonNull(words, "words");

        if (joinLength < 1) {
            throw new IllegalArgumentException("joinLength must be greater than 0");
        }

        if (joinLength > words.size()) {
            throw new IllegalArgumentException("joinLength must be less than or equal to words.size()");
        }

        for (int i = 0; i < words.size(); i++) {
            Objects.requireNonNull(words.get(i), "words[" + i + "]");
        }

        ArrayList<String> joinedWords = new ArrayList<>(words.size() - joinLength + 1);

        for (int i = 0; i <= words.size() - joinLength; i++) {
            joinedWords.add(String.join("", words.subList(i, i + joinLength)));
        }

        return joinedWords;
    }
}
