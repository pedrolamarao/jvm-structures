package br.dev.pedrolamarao.structure.position;

import static java.util.Objects.requireNonNull;

/**
 * Position in a linear traversal of an array.
 *
 * @param <T> value type
 */
public class ArrayLinearPosition<T> implements LinearPosition<T>
{
    final T[] array;

    final int base;

    final int position;

    final int limit;

    ArrayLinearPosition (T[] array, int base, int position, int limit)
    {
        this.array = array;
        this.base = base;
        this.position = position;
        this.limit = limit;
    }

    public static <T> ArrayLinearPosition<T> of (T[] array)
    {
        requireNonNull(array);
        return new ArrayLinearPosition<>(array,0,0,array.length);
    }

    public ArrayLinearPosition<T> next ()
    {
        return position == limit ? null : new ArrayLinearPosition<>(array, base, position + 1, limit);
    }

    public ArrayLinearPosition<T> previous ()
    {
        return position == base ? null : new ArrayLinearPosition<>(array, base, position - 1, limit);
    }

    public T value ()
    {
        return array[position];
    }
}
