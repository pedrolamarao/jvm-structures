package br.dev.pedrolamarao.structure.position;

import br.dev.pedrolamarao.structure.UniNode;

public class UniNodeLinearPosition <T> implements LinearPosition<T>
{
    final UniNode<T> node;

    UniNodeLinearPosition (UniNode<T> node)
    {
        this.node = node;
    }

    @Override
    public LinearPosition<T> next ()
    {
        final var n = node.link();
        return n == null ? null : new UniNodeLinearPosition<>(n);
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
