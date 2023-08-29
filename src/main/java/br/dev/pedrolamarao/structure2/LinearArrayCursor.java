package br.dev.pedrolamarao.structure2;

/**
 * Cursor on a linear structure made of one array.
 * @param array
 * @param position
 * @param <T> element type
 */
record LinearArrayCursor<T> (T[] array, int position) implements BiLinearCursor<T>
{
    @Override
    public LinearArrayCursor<T> next ()
    {
        return position == array.length - 1 ? null : new LinearArrayCursor<>(array, position + 1);
    }

    public LinearArrayCursor<T> next (int distance)
    {
        return position >= array.length - distance ? null : new LinearArrayCursor<>(array,position + distance);
    }

    @Override
    public LinearArrayCursor<T> previous ()
    {
        return position == 0 ? null : new LinearArrayCursor<>(array,position - 1);
    }

    public LinearArrayCursor<T> previous (int distance)
    {
        return position < distance ? null : new LinearArrayCursor<>(array,position - distance);
    }

    public T value ()
    {
        return array[position];
    }
}
