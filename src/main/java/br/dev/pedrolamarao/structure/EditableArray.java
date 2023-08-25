package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.editable.UniEditable;
import br.dev.pedrolamarao.structure.iterator.UniIterator;

public class EditableArray<T> implements UniEditable<T>
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
        return new EditableArray<U>(array,array.length);
    }

    //

    public UniIterator<T> forward ()
    {
        return limit == 0 ? null : new IterableArray<>(array, 0, limit - 1);
    }

    //

    public void swap (UniIterator<T> x, UniIterator<T> y)
    {
        if (x instanceof IterableArray<T> arrayX && y instanceof IterableArray<T> arrayY) {
            swap(arrayX.position(),arrayY.position());
        } else {
            throw new RuntimeException("illegal iterators");
        }
    }

    void swap (int x, int y)
    {
        final var tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
