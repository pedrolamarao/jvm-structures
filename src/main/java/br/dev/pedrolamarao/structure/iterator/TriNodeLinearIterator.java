package br.dev.pedrolamarao.structure.iterator;

import br.dev.pedrolamarao.structure.TriNode;

import java.util.Iterator;

/**
 * Iterates the positions of a linear third-link traversal of a tri-node structure.
 *
 * @param <T> value type
 */
public class TriNodeLinearIterator<T> implements Iterator<T>
{
    TriNode<T> node;

    public TriNodeLinearIterator (TriNode<T> node) 
    {
        this.node = node;
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
        node = node.third();
        return value;
    }
}
