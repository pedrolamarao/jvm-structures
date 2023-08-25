package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public record TraversableMonoNodes<T>(MonoNode<T> root) implements TraversableUniLinear<T>
{
    public static <U> TraversableMonoNodes<U> empty ()
    {
        return new TraversableMonoNodes<>(null);
    }

    public static <U> TraversableMonoNodes<U> of (MonoNode<U> node)
    {
        requireNonNull(node);
        return new TraversableMonoNodes<>(node);
    }

    public UniIterator<T> forward ()
    {
        return root == null ? null : new IterableMonoNode<>(root);
    }
}
