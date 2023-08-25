package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.traversable.UniTraversable;

import static java.util.Objects.requireNonNull;

public record TraversableArray<T>(T[] array, int limit) implements UniTraversable<T>
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
        return limit == 0 ? null : new IterableArray<>(array, 0, limit - 1);
    }
}
