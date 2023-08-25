package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.BiIterator;
import br.dev.pedrolamarao.structure.node.BiNode;

public record IterableBiNode<T>(BiNode<T> node) implements BiIterator<T>
{
    @Override
    public BiIterator<T> next ()
    {
        return node.first() == null ? null : new IterableBiNode<>(node.first());
    }

    @Override
    public BiIterator<T> previous ()
    {
        return node.second() == null ? null : new IterableBiNode<>(node.second());
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
