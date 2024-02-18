package br.dev.pedrolamarao.structure.position;

import static java.util.Objects.requireNonNull;

/**
 * Position in a circular traversal of an array.
 *
 * @param <T> value type
 */
public class ArrayCircularPosition<T> implements LinearPosition<T>
{
    final T[] array;

    final int base;

    final int position;

    final int limit;

    ArrayCircularPosition (T[] array, int base, int position, int limit)
    {
        this.array = array;
        this.base = base;
        this.position = position;
        this.limit = limit;
    }

    public static <T> ArrayCircularPosition<T> of (T[] array)
    {
        requireNonNull(array);
        return new ArrayCircularPosition<>(array,0,0,array.length);
    }

    public ArrayCircularPosition<T> next ()
    {
        return new ArrayCircularPosition<>(array, base, base + ((position + 1) % (limit - base)), limit);
    }

    public ArrayCircularPosition<T> previous ()
    {
        return new ArrayCircularPosition<>(array, base, base + ((position - 1) % (limit - base)), limit);
    }

    public T value ()
    {
        return array[position];
    }
}
