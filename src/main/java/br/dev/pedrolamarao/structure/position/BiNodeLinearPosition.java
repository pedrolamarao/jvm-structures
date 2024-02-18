package br.dev.pedrolamarao.structure.position;

import br.dev.pedrolamarao.structure.BiNode;

public class BiNodeLinearPosition<T> implements LinearPosition<T>
{
    final BiNode<T> node;

    BiNodeLinearPosition (BiNode<T> node)
    {
        this.node = node;
    }

    @Override
    public LinearPosition<T> next ()
    {
        final var n = node.second();
        return n == null ? null : new BiNodeLinearPosition<>(n);
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
