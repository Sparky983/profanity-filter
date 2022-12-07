package me.sparky983.profanityfilter;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.List;

@State(Scope.Benchmark)
public class ProfanityFilterCreateBenchmark {
    private static final List<List<String>> WORDS_LIST_LIST = List.of(
            List.of(),
            List.of("word 1"),
            List.of("word 1", "word 2", "word 3", "word 4", "word 5", "word 6", "word 7", "word 8", "word 9", "word 10")
    );

    @Param({"0", "1", "2"})
    public int numberOfWords;

    private List<String> words;

    @Setup
    public void setUp() {
        // make sure the #create isn't timed on how long List.get() takes
        words = WORDS_LIST_LIST.get(numberOfWords);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void create() {
        ProfanityFilter.create(words);
    }
}
