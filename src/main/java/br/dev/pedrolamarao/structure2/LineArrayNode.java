package br.dev.pedrolamarao.structure2;

record LineArrayNode<T> (T[] array, int position) implements BiLineNode<T>
{
    @Override
    public LineArrayNode<T> next ()
    {
        return position == array.length - 1 ? null : new LineArrayNode<>(array, position + 1);
    }

    public LineArrayNode<T> next (int distance)
    {
        return position >= array.length - distance ? null : new LineArrayNode<>(array,position + distance);
    }

    @Override
    public LineArrayNode<T> previous ()
    {
        return position == 0 ? null : new LineArrayNode<>(array,position - 1);
    }

    public LineArrayNode<T> previous (int distance)
    {
        return position < distance ? null : new LineArrayNode<>(array,position - distance);
    }

    public T value ()
    {
        return array[position];
    }
}
