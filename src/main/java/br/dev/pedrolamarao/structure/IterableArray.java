package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.BiIterator;

public record IterableArray<T>(T[] array, int position, int last) implements BiIterator<T>
{
    @Override
    public BiIterator<T> next ()
    {
        return position == last ? null : new IterableArray<>(array, position + 1, last);
    }

    @Override
    public BiIterator<T> previous ()
    {
        return position == 0 ? null : new IterableArray<>(array, position - 1, last);
    }

    @Override
    public T value ()
    {
        return array[position];
    }
}
