package br.dev.pedrolamarao.structure.application;

import br.dev.pedrolamarao.structure.UniNode;
import br.dev.pedrolamarao.structure.iterator.UniNodeLinearIterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.SequencedCollection;

/**
 * Immutable sequence made of uni-nodes.
 *
 * @param <T> value type
 */
public class ImmutableUniNodeSequence<T> implements SequencedCollection<T>
{
    final UniNode<T> root;

    public ImmutableUniNodeSequence (UniNode<T> root)
    {
        this.root = root;
    }

    @Override
    public SequencedCollection<T> reversed ()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size ()
    {
        int d = 0;
        for (var n = root; n != null; n = n.link()) ++d;
        return d;
    }

    @Override
    public boolean isEmpty ()
    {
        return root == null;
    }

    @Override
    public boolean contains (Object o)
    {
        return false;
    }

    @Override
    public Iterator<T> iterator ()
    {
        return UniNodeLinearIterator.of(root);
    }

    @Override
    public Object[] toArray ()
    {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray (T1[] a)
    {
        return null;
    }

    @Override
    public boolean add (T t)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove (Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll (Collection<?> c)
    {
        for (var e : c)
            if (! contains(e))
                return false;
        return true;
    }

    @Override
    public boolean addAll (Collection<? extends T> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll (Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll (Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear ()
    {
        throw new UnsupportedOperationException();
    }
}
