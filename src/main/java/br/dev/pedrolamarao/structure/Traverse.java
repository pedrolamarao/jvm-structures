package br.dev.pedrolamarao.structure;

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
     * @param <A>        accumulator value type
     * @param <T>        structure element type
     */
    public static <A,T> A accumulate (final TraversableUniLinear<T> structure, final BiFunction<A, T, A> operator, final A initial)
    {
        A tmp = initial;
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
    public static long count (final TraversableUniLinear<?> structure)
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
    public static <T> long countIf (final TraversableUniLinear<T> structure, final Predicate<T> operator)
    {
        long counter = 0;
        for (var i = structure.forward(); i != null; i = i.next()) {
            if (operator.test(i.value())) ++counter;
        }
        return counter;
    }

    /**
     * Test if every element matches predicate.
     *
     * @param structure  traversable structure
     * @param operator   predicate
     * @return           true if and only if every element match predicate
     * @param <T>        structure element type
     */
    public static <T> boolean every (final TraversableUniLinear<T> structure, final Predicate<T> operator)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            if (! operator.test(i.value()))
                return false;
        }
        return true;
    }

    /**
     * Find element.
     *
     * @param structure  traversable structure
     * @param target     target value
     * @return           element, or null if not found
     * @param <T>        structure element type
     */
    public static <T> UniIterator<T> find (final TraversableUniLinear<T> structure, final T target)
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
    public static <T> UniIterator<T> findIf (final TraversableUniLinear<T> structure, final Predicate<T> operator)
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
    public static <T> void visit (final TraversableUniLinear<T> structure, final Consumer<T> operator)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            operator.accept(i.value());
        }
    }
}
