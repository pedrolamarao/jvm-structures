package br.dev.pedrolamarao.structure2;

import java.util.Comparator;

/**
 * Algorithms on binary branched structures.
 */
class BiBranched
{
    /**
     * Find on a sorted structure.
     * @param first
     * @param value
     * @param comparator
     * @return
     * @param <T>
     */
    static <T> BiBranchedCursor<T> findSorted (BiBranchedCursor<T> first, T value, Comparator<T> comparator)
    {
        var i = first;
        while (i != null) {
            final int ci = comparator.compare(value,i.value());
            if (ci == 0) break;
            else if (ci < 0) i = i.left();
            else /* ci > 0 */ i = i.right();
        }
        return i;
    }

    static <T extends Comparable<T>> BiBranchedCursor<T> findSorted (BiBranchedCursor<T> first, T value)
    {
        return findSorted(first,value,Comparator.naturalOrder());
    }
}
