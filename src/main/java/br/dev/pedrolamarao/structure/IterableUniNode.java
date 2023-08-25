package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.node.UniNode;

public record IterableUniNode<T>(UniNode<T> node) implements UniIterator<T>
{
    @Override
    public UniIterator<T> next ()
    {
        return node.peer() == null ? null : new IterableUniNode<>(node.peer());
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
