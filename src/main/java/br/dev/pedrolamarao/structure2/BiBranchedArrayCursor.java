package br.dev.pedrolamarao.structure2;

/**
 * Cursor on a binary branched structure made of one array.
 * @param array
 * @param position
 * @param <T> element type
 */
record BiBranchedArrayCursor<T> (T[] array, int position) implements BiBranchedCursor<T>
{
    public BiBranchedCursor<T> parent ()
    {
        final int p = (position - 1) / 2;
        return p < 0 || array[p] == null ? null : new BiBranchedArrayCursor<>(array,p);
    }

    @Override
    public BiBranchedCursor<T> left ()
    {
        final int p = (2 * position) + 1;
        return array.length <= p || array[p] == null ? null :  new BiBranchedArrayCursor<>(array,p);
    }

    @Override
    public BiBranchedCursor<T> right ()
    {
        final int p = (2 * position) + 2;
        return array.length <= p || array[p] == null ? null : new BiBranchedArrayCursor<>(array,p);
    }

    public T value ()
    {
        return array[position];
    }
}
