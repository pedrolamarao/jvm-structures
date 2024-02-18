package br.dev.pedrolamarao.structure.iterator;

import br.dev.pedrolamarao.structure.UniNode;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;

/**
 * Iterates the positions of a linear traversal of a uni-node structure.
 *
 * @param <T> value type
 */
public class UniNodeLinearIterator<T> implements Iterator<T>
{
    UniNode<T> node;

    UniNodeLinearIterator (UniNode<T> node)
    {
        this.node = node;
    }

    public static <T> UniNodeLinearIterator<T> of (UniNode<T> node)
    {
        requireNonNull(node);
        return new UniNodeLinearIterator<>(node);
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
        node = node.link();
        return value;
    }
}
