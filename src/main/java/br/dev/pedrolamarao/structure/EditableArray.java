package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public class EditableArray<T> implements EditableUniLinear<T>, EditableBiLinear<T>
{
    private int limit;

    private T[] root;

    private final Class<? super T> type;

    private EditableArray (int limit, T[] root, Class<? super T> type)
    {
        this.root = root;
        this.limit = limit;
        this.type = type;
    }

    public static <U> EditableArray<U> from (Class<? super U> type, U[] array)
    {
        return new EditableArray<>(array.length, array.clone(), requireNonNull(type));
    }

    public static <U> EditableArray<U> from (Class<? super U> type, U[] array, int limit)
    {
        if (limit > array.length) throw new ArrayIndexOutOfBoundsException();
        return new EditableArray<>(limit, array.clone(), requireNonNull(type));
    }

    //

    @Override
    public BiIterator<T> forward ()
    {
        return limit == 0 ? null : new ArrayIterator<>(root, 0, limit - 1);
    }

    @Override
    public BiIterator<T> backward ()
    {
        return limit == 0 ? null : new ArrayIterator<>(root, limit - 1, limit - 1);
    }

    //

    @Override
    public void erase (Iterator<T> position)
    {
        if (! (position instanceof ArrayIterator<T> p))
            throw new RuntimeException("illegal iterator");
        for (int i = p.position(), j = i+1; j != limit; ++i, ++j)
            swap(i,j);
        limit -= 1;
    }

    @Override
    public void set (Iterator<T> position, T value)
    {
        if (! (position instanceof ArrayIterator<T> p))
            throw new RuntimeException("illegal iterator");
        root[p.position()] = value;
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof ArrayIterator<T> xx && y instanceof ArrayIterator<T> yy))
            throw new RuntimeException("illegal iterators");
        swap(xx.position(),yy.position());
    }

    final void swap (int x, int y)
    {
        final var tmp = root[x];
        root[x] = root[y];
        root[y] = tmp;
    }
}
