package br.dev.pedrolamarao.structure.iterator;

import java.util.Iterator;

/**
 * Iterates the positions of a circular traversal of an array.
 *
 * @param <T> value type
 */
public class ArrayCircularIterator<T> implements Iterator<T>
{
    final T[] array;

    final int base;

    int position;

    final int limit;

    public ArrayCircularIterator (T[] array, int base, int position, int limit)
    {
        this.array = array;
        this.base = base;
        this.position = position;
        this.limit = limit;
    }

    @Override
    public boolean hasNext ()
    {
        return true;
    }

    @Override
    public T next ()
    {
        final var value = array[position];
        position = base + ((position + 1) % (limit - base));
        return value;
    }
}
