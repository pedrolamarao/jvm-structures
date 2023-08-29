package br.dev.pedrolamarao.structure2;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Algorithms on linear structures.
 */
class Linear
{
    /**
     * Accumulate elements.
     * @param first
     * @param initial
     * @param accumulator
     * @return
     * @param <T>
     * @param <U>
     */
    static <T,U> U accumulate (UniLinearCursor<T> first, U initial, BiFunction<U,T,U> accumulator)
    {
        var tmp = initial;
        for (var i = first; i != null; i = i.next()) {
            tmp = accumulator.apply(tmp,i.value());
        }
        return tmp;
    }

    /**
     * True if any element matches a predicate.
     * @param first
     * @param predicate
     * @return
     * @param <T>
     */
    static <T> boolean any (UniLinearCursor<T> first, Predicate<T> predicate)
    {
        for (var i = first; i != null; i = i.next()) {
            if (predicate.test(i.value()))
                return true;
        }
        return false;
    }

    /**
     * Count occurrences of an element.
     * @param first
     * @param value
     * @return
     * @param <T>
     */
    static <T> long count (UniLinearCursor<T> first, T value)
    {
        long counter = 0;
        for (var i = first; i != null; i = i.next()) {
            if (Objects.equals(value,i.value()))
                ++counter;
        }
        return counter;
    }

    /**
     * Count occurrences of elements that match a predicate.
     * @param first
     * @param predicate
     * @return
     * @param <T>
     */
    static <T> long countIf (UniLinearCursor<T> first, Predicate<T> predicate)
    {
        long counter = 0;
        for (var i = first; i != null; i = i.next()) {
            if (predicate.test(i.value()))
                ++counter;
        }
        return counter;
    }

    /**
     * Count the distance between two cursors.
     * @param first
     * @param last
     * @return
     * @param <T>
     */
    static <T> long distance (UniLinearCursor<T> first, UniLinearCursor<T> last)
    {
        long counter = 0;
        for (var i = first; i != last; i = i.next()) {
            ++counter;
        }
        return counter;
    }

    /**
     * True if every element matches a predicate.
     * @param first
     * @param predicate
     * @return
     * @param <T>
     */
    static <T> boolean every (UniLinearCursor<T> first, Predicate<T> predicate)
    {
        for (var i = first; i != null; i = i.next()) {
            if (! predicate.test(i.value()))
                return false;
        }
        return true;
    }

    /**
     * Find an element.
     * @param first
     * @param value
     * @return
     * @param <T>
     */
    static <T> UniLinearCursor<T> find (UniLinearCursor<T> first, T value)
    {
        for (var i = first; i != null; i = i.next()) {
            if (Objects.equals(i.value(),value))
                return i;
        }
        return null;
    }

    /**
     * Find an element that matches a predicate.
     * @param first
     * @param predicate
     * @return
     * @param <T>
     */
    static <T> UniLinearCursor<T> findIf (UniLinearCursor<T> first, Predicate<T> predicate)
    {
        for (var i = first; i != null; i = i.next()) {
            if (predicate.test(i.value()))
                return i;
        }
        return null;
    }

    /**
     * Visit every element.
     * @param first
     * @param visitor
     * @param <T>
     */
    static <T> void visit (UniLinearCursor<T> first, Consumer<T> visitor)
    {
        for (var i = first; i != null; i = i.next()) {
            visitor.accept(i.value());
        }
    }
}
