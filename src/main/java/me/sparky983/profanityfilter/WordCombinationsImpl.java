package me.sparky983.profanityfilter;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * The default implementation of {@link WordCombinations}.
 *
 * @author Sparky983
 */
final class WordCombinationsImpl implements WordCombinations {
    private final WordJoiner wordJoiner;
    private final WordSplitter wordSplitter;

    WordCombinationsImpl(WordJoiner wordJoiner, WordSplitter wordSplitter) {
        this.wordJoiner = Objects.requireNonNull(wordJoiner, "wordJoiner");
        this.wordSplitter = Objects.requireNonNull(wordSplitter, "wordSplitter");
    }

    @Override
    public List<String> getWordCombinations(String message) {
        Objects.requireNonNull(message, "message");

        final List<String> words = wordSplitter.split(message);

        return IntStream.range(1, words.size())
                .mapToObj(i -> wordJoiner.join(words, i))
                .flatMap(List::stream)
                .toList();
    }
}
