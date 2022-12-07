package me.sparky983.profanityfilter;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.List;

@State(Scope.Benchmark)
public class ProfanityFilterFilterBenchmark {

    private static final ProfanityFilter FILTER = ProfanityFilter.create(List.of("truck"));

    @Param({
            "This message contains profanity (truck)",
            "Attempt to bypass - T,R U C-K",

            // this won't count because firetruck and truck are different words
            "A different word - firetruck"
    })
    public String message;

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void filter() {
        FILTER.filter(message);
    }
}
