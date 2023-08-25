package br.dev.pedrolamarao.structure.traversable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.traversable.UniTraversable;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Structure traversal.
 */
public class Traverse
{
    /**
     * Accumulate elements.
     *
     * @param iterable  structure
     * @param operator  accumulator
     * @param initial   initial value
     * @return          accumulated value
     * @param <T>       structure element type
     */
    public static <T> T accumulate (final UniTraversable<T> iterable, final BiFunction<T, T, T> operator, final T initial)
    {
        T tmp = initial;
        for (var i = iterable.forward(); i != null; i = i.next()) {
            tmp = operator.apply(tmp, i.value());
        }
        return tmp;
    }

    /**
     * Count elements.
     *
     * @param iterable  structure
     * @return          element count
     */
    public static long count (final UniTraversable<?> iterable)
    {
        long counter = 0;
        for (var i = iterable.forward(); i != null; i = i.next()) {
            ++counter;
        }
        return counter;
    }

    /**
     * Count elements that match predicate.
     *
     * @param iterable   structure
     * @param predicate  predicate
     * @return           element count
     * @param <T>        structure element type
     */
    public static <T> long countIf (final UniTraversable<T> iterable, final Predicate<T> predicate)
    {
        long counter = 0;
        for (var i = iterable.forward(); i != null; i = i.next()) {
            if (predicate.test(i.value())) ++counter;
        }
        return counter;
    }

    /**
     * Find element.
     *
     * @param iterable  structure
     * @param target    target value
     * @return          element, or null if not found
     * @param <T>       structure element type
     */
    public static <T> UniIterator<T> find (final UniTraversable<T> iterable, final T target)
    {
        for (var i = iterable.forward(); i != null; i = i.next()) {
            if (i.value().equals(target)) return i;
        }
        return null;
    }

    /**
     * Find element that matches predicate.
     *
     * @param iterable   structure
     * @param predicate  predicate
     * @return           element, or null if not found
     * @param <T>        structure element type
     */
    public static <T> UniIterator<T> findIf (final UniTraversable<T> iterable, final Predicate<T> predicate)
    {
        for (var i = iterable.forward(); i != null; i = i.next()) {
            if (predicate.test(i.value())) return i;
        }
        return null;
    }

    /**
     * Visit elements.
     *
     * @param iterable  structure
     * @param visitor   visitor
     * @param <T>       structure element type
     */
    public static <T> void visit (final UniTraversable<T> iterable, final Consumer<T> visitor)
    {
        for (var i = iterable.forward(); i != null; i = i.next()) {
            visitor.accept(i.value());
        }
    }
}
