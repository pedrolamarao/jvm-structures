package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public class EditableArray<T> implements EditableUniLinear<T>, EditableBiLinear<T>
{
    int limit;

    T[] root;

    public EditableArray ()
    {
        this.root = null;
        this.limit = 0;
    }

    public EditableArray (T[] root, int limit)
    {
        this.root = requireNonNull(root);
        this.limit = limit;
    }

    public static <U> EditableArray<U> of (U[] array)
    {
        return new EditableArray<>(array,array.length);
    }

    //

    @Override
    public BiIterator<T> forward ()
    {
        return limit == 0 ? null : new IterableArray<>(root, 0, limit - 1);
    }

    @Override
    public BiIterator<T> backward ()
    {
        return limit == 0 ? null : new IterableArray<>(root, limit - 1, limit - 1);
    }

    //

    @Override
    public void set (Iterator<T> position, T value)
    {
        if (! (position instanceof IterableArray<T> p))
            throw new RuntimeException("illegal iterator");
        root[p.position()] = value;
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof IterableArray<T> xx && y instanceof IterableArray<T> yy))
            throw new RuntimeException("illegal iterators");
        final var tmp = root[xx.position()];
        root[xx.position()] = root[yy.position()];
        root[yy.position()] = tmp;
    }
}
