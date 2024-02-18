package br.dev.pedrolamarao.structure.iterator;

import br.dev.pedrolamarao.structure.BiNode;

import java.util.Iterator;

/**
 * Iterates the positions of a linear second-link traversal of a bi-node structure.
 *
 * @param <T> value type
 */
public class BiNodeSecondLinearIterator<T> implements Iterator<T>
{
    BiNode<T> node;

    BiNodeSecondLinearIterator (BiNode<T> node)
    {
        this.node = node;
    }

    public static <T> BiNodeSecondLinearIterator<T> of (BiNode<T> node)
    {
        return new BiNodeSecondLinearIterator<>(node);
    }

    @Override
    public boolean hasNext ()
    {
        return node != null;
    }

    @Override
    public T next ()
    {
        final var value = node.value();
        node = node.second();
        return value;
    }
}
