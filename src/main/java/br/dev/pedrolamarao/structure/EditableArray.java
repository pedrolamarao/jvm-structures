package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.editable.BiLinearEditable;
import br.dev.pedrolamarao.structure.iterator.BiIterator;
import br.dev.pedrolamarao.structure.iterator.Iterator;

public class EditableArray<T> implements BiLinearEditable<T>
{
    T[] array;

    int limit;

    public EditableArray ()
    {
        this.array = null;
        this.limit = 0;
    }

    public EditableArray (T[] array, int limit)
    {
        this.array = array;
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
        return limit == 0 ? null : new IterableArray<>(array, 0, limit - 1);
    }

    @Override
    public BiIterator<T> backward ()
    {
        return limit == 0 ? null : new IterableArray<>(array, limit - 1, limit - 1);
    }

    //

    @Override
    public void set (Iterator<T> iterator, T value)
    {
        if (! (iterator instanceof IterableArray<T> arrayIt)) throw new RuntimeException("illegal iterator");
        array[arrayIt.position()] = value;
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof IterableArray<T> arrayX && y instanceof IterableArray<T> arrayY)) throw new RuntimeException("illegal iterators");
        swap(array,arrayX.position(),arrayY.position());
    }

    static <U> void swap (U[] array, int x, int y)
    {
        final var tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
