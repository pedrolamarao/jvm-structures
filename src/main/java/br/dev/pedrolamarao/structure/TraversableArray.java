package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public record TraversableArray<T>(T[] root, int limit) implements TraversableUniLinear<T>
{
    public static <U> TraversableArray<U> empty ()
    {
        return new TraversableArray<>(null, 0);
    }

    public static <U> TraversableArray<U> of (U[] array)
    {
        requireNonNull(array);
        return new TraversableArray<>(array, array.length);
    }

    public UniIterator<T> forward ()
    {
        return limit == 0 ? null : new ArrayIterator<>(root, 0, limit - 1);
    }
}
