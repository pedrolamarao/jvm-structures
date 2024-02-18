package br.dev.pedrolamarao.structure.iterator;

import java.util.Iterator;

/**
 * Iterates the positions of a bi-branched, pre-ordered traversal of an array.
 *
 * @param <T> value type
 */
public class ArrayBiBranchedPreOrderIterator <T> implements Iterator<T>
{
    final T[] array;

    int position;

    final int limit;

    public ArrayBiBranchedPreOrderIterator (T[] array, int position, int limit)
    {
        this.array = array;
        this.position = position;
        this.limit = limit;
    }

    @Override
    public boolean hasNext ()
    {
        return position < limit; // TODO
    }

    @Override
    public T next ()
    {
        return null; // TODO
    }
}
