package br.dev.pedrolamarao.structure;

record ArrayIterator<T>(T[] array, int position, int last) implements BiIterator<T>
{
    @Override
    public BiIterator<T> next ()
    {
        return position == last ? null : new ArrayIterator<>(array, position + 1, last);
    }

    @Override
    public BiIterator<T> previous ()
    {
        return position == 0 ? null : new ArrayIterator<>(array, position - 1, last);
    }

    @Override
    public T value ()
    {
        return array[position];
    }
}
