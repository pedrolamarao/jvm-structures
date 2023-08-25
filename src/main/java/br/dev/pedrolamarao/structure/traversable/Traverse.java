package br.dev.pedrolamarao.structure.traversable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;

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
     * @param structure  traversable structure
     * @param operator   accumulator
     * @param initial    initial value
     * @return           accumulated value
     * @param <T>        structure element type
     */
    public static <T> T accumulate (final UniLinearTraversable<T> structure, final BiFunction<T, T, T> operator, final T initial)
    {
        T tmp = initial;
        for (var i = structure.forward(); i != null; i = i.next()) {
            tmp = operator.apply(tmp, i.value());
        }
        return tmp;
    }

    /**
     * Count elements.
     *
     * @param structure  traversable structure
     * @return           element count
     */
    public static long count (final UniLinearTraversable<?> structure)
    {
        long counter = 0;
        for (var i = structure.forward(); i != null; i = i.next()) {
            ++counter;
        }
        return counter;
    }

    /**
     * Count elements that match predicate.
     *
     * @param structure   traversable structure
     * @param operator    predicate
     * @return            element count
     * @param <T>         structure element type
     */
    public static <T> long countIf (final UniLinearTraversable<T> structure, final Predicate<T> operator)
    {
        long counter = 0;
        for (var i = structure.forward(); i != null; i = i.next()) {
            if (operator.test(i.value())) ++counter;
        }
        return counter;
    }

    /**
     * Find element.
     *
     * @param structure  traversable structure
     * @param target     target value
     * @return           element, or null if not found
     * @param <T>        structure element type
     */
    public static <T> UniIterator<T> find (final UniLinearTraversable<T> structure, final T target)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            if (i.value().equals(target)) return i;
        }
        return null;
    }

    /**
     * Find element that matches predicate.
     *
     * @param structure   traversable structure
     * @param operator    predicate
     * @return            element, or null if not found
     * @param <T>         structure element type
     */
    public static <T> UniIterator<T> findIf (final UniLinearTraversable<T> structure, final Predicate<T> operator)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            if (operator.test(i.value())) return i;
        }
        return null;
    }

    /**
     * Visit elements.
     *
     * @param structure  traversable structure
     * @param operator   visitor
     * @param <T>        structure element type
     */
    public static <T> void visit (final UniLinearTraversable<T> structure, final Consumer<T> operator)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            operator.accept(i.value());
        }
    }
}
