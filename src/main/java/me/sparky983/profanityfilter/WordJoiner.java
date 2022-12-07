package me.sparky983.profanityfilter;

import java.util.List;

/**
 * Turns a list of words into a list of words joined together.
 * <p>
 * For example, if the input is {@code (["Can", "you", "friend", "me], 1)}, the output would be
 * {@code ["Can you", "you friend", "friend me"]}.
 *
 * @author Sparky983
 */
interface WordJoiner {
    /**
     * Joins a list of words together.
     * <p>
     * For example, if the words is {@code (["Can", "you", "friend", "me], 1)}, the output would be
     * {@code ["Can you", "you friend", "friend me"]}.
     *
     * @param words the words.
     * @param joinLength the length of the words to join together.
     * @return the joined words.
     * @throws IllegalArgumentException if the join length is less than 1 or if the join length is
     * greater than the words list length.
     * @throws NullPointerException if the words is or contains {@code null}.
     */
    List<String> join(List<String> words, int joinLength);

    static WordJoiner create() {
        return new WordJoinerImpl();
    }
}
