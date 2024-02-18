package br.dev.pedrolamarao.structure.application;

import br.dev.pedrolamarao.structure.BiNode;
import br.dev.pedrolamarao.structure.iterator.BiNodeSecondLinearIterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.SequencedCollection;

/**
 * Immutable sequence made of bi-nodes.
 *
 * <p>Positions are traversed in second link order.</p>
 *
 * @param <T> value-type
 */
public class ImmutableBiNodeSequence<T> implements SequencedCollection<T>
{
    final BiNode<T> root;

    public ImmutableBiNodeSequence (BiNode<T> root)
    {
        this.root = root;
    }

    @Override
    public SequencedCollection<T> reversed ()
    {
        return new ImmutableBiNodeReverseSequence<>(root);
    }

    @Override
    public int size ()
    {
        int d = 0;
        for (var n = root; n != null; n = n.second()) ++d;
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
        return BiNodeSecondLinearIterator.of(root);
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
