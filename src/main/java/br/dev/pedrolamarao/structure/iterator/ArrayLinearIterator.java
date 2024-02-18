package br.dev.pedrolamarao.structure.iterator;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;

/**
 * Iterates the positions of a linear traversal of an array.
 *
 * @param <T> value type
 */
public class ArrayLinearIterator<T> implements Iterator<T>
{
    final T[] array;

    int position;

    final int limit;

    ArrayLinearIterator (T[] array, int position, int limit)
    {
        this.array = array;
        this.position = position;
        this.limit = limit;
    }

    public static <T> ArrayLinearIterator<T> of (T[] array, int limit)
    {
        requireNonNull(array);
        if (0 > limit) throw new IllegalArgumentException();
        if (limit > array.length) throw new IllegalArgumentException();
        return new ArrayLinearIterator<>(array,0,limit);
    }

    public static <T> ArrayLinearIterator<T> of (T[] array, int position, int limit)
    {
        requireNonNull(array);
        if (0 > position) throw new IllegalArgumentException();
        if (position > limit) throw new IllegalArgumentException();
        if (limit > array.length) throw new IllegalArgumentException();
        return new ArrayLinearIterator<>(array,position,limit);
    }

    @Override
    public boolean hasNext ()
    {
        return position < limit;
    }

    @Override
    public T next ()
    {
        return array[position++];
    }
}
