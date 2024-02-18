package br.dev.pedrolamarao.structure.iterator;

import br.dev.pedrolamarao.structure.BiNode;

import java.util.Iterator;

/**
 * Iterates the positions of a linear first-link traversal of a bi-node structure.
 *
 * @param <T> value type
 */
public class BiNodeFirstLinearIterator<T> implements Iterator<T>
{
    BiNode<T> node;

    BiNodeFirstLinearIterator (BiNode<T> node)
    {
        this.node = node;
    }

    public static <T> BiNodeFirstLinearIterator<T> of (BiNode<T> node)
    {
        return new BiNodeFirstLinearIterator<>(node);
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
        node = node.first();
        return value;
    }
}
