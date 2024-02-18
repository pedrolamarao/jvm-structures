package br.dev.pedrolamarao.structure.position;

import static java.util.Objects.requireNonNull;

/**
 * Position in a bi-branched traversal of an array.
 *
 * @param <T> value type
 */
public class ArrayBiBranchedPosition <T>
{
    final T[] array;

    final int base;

    int position;

    final int limit;

    ArrayBiBranchedPosition (T[] array, int base, int position, int limit)
    {
        this.array = array;
        this.base = base;
        this.position = position;
        this.limit = limit;
    }

    public static <T> ArrayBiBranchedPosition<T> of (T[] array)
    {
        requireNonNull(array);
        return new ArrayBiBranchedPosition<>(array,0,0,array.length);
    }

    public static <T> ArrayBiBranchedPosition<T> of (T[] array, int limit)
    {
        requireNonNull(array);
        if (limit < 0) throw new IllegalArgumentException();
        return new ArrayBiBranchedPosition<>(array,0,0,limit);
    }

    public ArrayBiBranchedPosition<T> parent ()
    {
        final int p = (position - 1) / 2;
        return p < base ? null : new ArrayBiBranchedPosition<>(array,base,p,limit);
    }

    public ArrayBiBranchedPosition<T> leftChild ()
    {
        final int p = (2 * position) + 1;
        return p >= limit ? null : new ArrayBiBranchedPosition<>(array,base,p,limit);
    }

    public ArrayBiBranchedPosition<T> rightChild ()
    {
        final int p = (2 * position) + 2;
        return p >= limit ? null : new ArrayBiBranchedPosition<>(array,base,p,limit);
    }

    public T value ()
    {
        return array[position];
    }
}
