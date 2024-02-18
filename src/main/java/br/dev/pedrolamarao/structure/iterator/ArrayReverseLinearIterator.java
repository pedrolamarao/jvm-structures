package br.dev.pedrolamarao.structure.iterator;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;

/**
 * Iterates the positions of a linear traversal of an array.
 *
 * @param <T> value type
 */
public class ArrayReverseLinearIterator<T> implements Iterator<T>
{
    final T[] array;

    final int base;

    int position;

    ArrayReverseLinearIterator (T[] array, int base, int position)
    {
        this.array = array;
        this.base = base;
        this.position = position;
    }

    public static <T> ArrayReverseLinearIterator<T> of (T[] array, int base, int position)
    {
        requireNonNull(array);
        if (0 > base) throw new IllegalArgumentException();
        if (base > position) throw new IllegalArgumentException();
        if (position > array.length) throw new IllegalArgumentException();
        return new ArrayReverseLinearIterator<>(array,base,position);
    }

    @Override
    public boolean hasNext ()
    {
        return base <= position;
    }

    @Override
    public T next ()
    {
        return array[--position];
    }
}
