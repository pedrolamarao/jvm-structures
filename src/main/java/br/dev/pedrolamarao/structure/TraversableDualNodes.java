package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public record TraversableDualNodes<T>(DualNode<T> root) implements TraversableUniLinear<T>
{
    public static <U> TraversableDualNodes<U> empty ()
    {
        return new TraversableDualNodes<>(null);
    }

    public static <U> TraversableDualNodes<U> of (DualNode<U> node)
    {
        requireNonNull(node);
        return new TraversableDualNodes<>(node);
    }

    public BiIterator<T> forward ()
    {
        return root == null ? null : new IterableDualNode<>(root);
    }
}
