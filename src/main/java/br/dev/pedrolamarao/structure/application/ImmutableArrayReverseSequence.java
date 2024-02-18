package br.dev.pedrolamarao.structure.application;

import br.dev.pedrolamarao.structure.iterator.ArrayReverseLinearIterator;

import java.util.*;

/**
 * Immutable sequence made of an array.
 *
 * <p>Positions are traversed in decreasing order.</p>
 *
 * @param <T> value type
 */
public class ImmutableArrayReverseSequence<T> implements SequencedCollection<T>
{
    final T[] array;

    final int base;

    final int limit;

    ImmutableArrayReverseSequence (T[] array, int base, int limit)
    {
        this.array = array;
        this.base = base;
        this.limit = limit;
    }

    @Override
    public SequencedCollection<T> reversed ()
    {
        return new ImmutableArrayReverseSequence<>(array,base,limit);
    }

    @Override
    public int size ()
    {
        return limit - base;
    }

    @Override
    public boolean isEmpty ()
    {
        return limit == base;
    }

    @Override
    public boolean contains (Object o)
    {
        for (int i = base; i != limit; ++i)
            if (Objects.equals(o,array[i]))
                return true;
        return false;
    }

    @Override
    public Iterator<T> iterator ()
    {
        return ArrayReverseLinearIterator.of(array,base,limit);
    }

    @Override
    public Object[] toArray ()
    {
        return Arrays.copyOf(array,limit);
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
