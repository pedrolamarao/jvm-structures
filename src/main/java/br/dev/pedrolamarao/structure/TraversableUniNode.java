package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.node.UniNode;
import br.dev.pedrolamarao.structure.traversable.UniLinearTraversable;

import static java.util.Objects.requireNonNull;

public record TraversableUniNode<T>(UniNode<T> node) implements UniLinearTraversable<T>
{
    public static <U> TraversableUniNode<U> empty ()
    {
        return new TraversableUniNode<>(null);
    }

    public static <U> TraversableUniNode<U> of (UniNode<U> node)
    {
        requireNonNull(node);
        return new TraversableUniNode<>(node);
    }

    public UniIterator<T> forward ()
    {
        return node == null ? null : new IterableUniNode<>(node);
    }
}
