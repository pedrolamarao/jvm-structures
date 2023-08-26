// Copyright (C) 2023 Pedro Lamarão <pedro.lamarao@gmail.com>
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

package br.dev.pedrolamarao.structure;

import java.util.Comparator;
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
        return accumulate(structure.forward(),operator,initial);
    }

    public static <A,T> A accumulate (final UniTraversal<T> start, final BiFunction<A, T, A> operator, final A initial)
    {
        A tmp = initial;
        for (var i = start; i != null; i = i.next()) {
            tmp = operator.apply(tmp, i.value());
        }
        return tmp;
    }

    /**
     * Test if any element matches predicate.
     *
     * @param structure  traversable structure
     * @param operator   predicate
     * @return           true if and only if any element match predicate
     * @param <T>        structure element type
     */
    public static <T> boolean any (final TraversableUniLinear<T> structure, final Predicate<T> operator)
    {
        return any(structure.forward(),operator);
    }

    public static <T> boolean any (final UniTraversal<T> start, final Predicate<T> operator)
    {
        for (var i = start; i != null; i = i.next()) {
            if (operator.test(i.value()))
                return true;
        }
        return false;
    }

    /**
     * Count elements.
     *
     * @param structure  traversable structure
     * @return           element count
     */
    public static long count (final TraversableUniLinear<?> structure)
    {
        return count(structure.forward());
    }

    public static long count (final UniTraversal<?> start)
    {
        long counter = 0;
        for (var i = start; i != null; i = i.next()) {
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
        return countIf(structure.forward(),operator);
    }

    public static <T> long countIf (final UniTraversal<T> start, final Predicate<T> operator)
    {
        long counter = 0;
        for (var i = start; i != null; i = i.next()) {
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
        return every(structure.forward(),operator);
    }

    public static <T> boolean every (final UniTraversal<T> start, final Predicate<T> operator)
    {
        for (var i = start; i != null; i = i.next()) {
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
    public static <T> UniTraversal<T> find (final TraversableUniLinear<T> structure, final T target)
    {
        return find(structure.forward(),target);
    }

    public static <T> UniTraversal<T> find (final UniTraversal<T> start, final T target)
    {
        for (var i = start; i != null; i = i.next()) {
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
    public static <T> UniTraversal<T> findIf (final TraversableUniLinear<T> structure, final Predicate<T> operator)
    {
        return findIf(structure.forward(),operator);
    }

    public static <T> UniTraversal<T> findIf (final UniTraversal<T> start, final Predicate<T> operator)
    {
        for (var i = start; i != null; i = i.next()) {
            if (operator.test(i.value())) return i;
        }
        return null;
    }

    public static <T> boolean sorted (final TraversableUniLinear<T> structure, final Comparator<T> comparator)
    {
        return sorted(structure.forward(),comparator);
    }

    public static <T> boolean sorted (final UniTraversal<T> start, final Comparator<T> comparator)
    {
        if (start == null) return true;
        for (UniTraversal<T> i = start, j = i.next(); j != null; i = i.next(), j = j.next()) {
            if (comparator.compare(i.value(),j.value()) >= 0)
                return false;
        }
        return true;
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
        visit(structure.forward(),operator);
    }

    public static <T> void visit (final UniTraversal<T> start, final Consumer<T> operator)
    {
        for (var i = start; i != null; i = i.next()) {
            operator.accept(i.value());
        }
    }
}
