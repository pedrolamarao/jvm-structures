package br.dev.pedrolamarao.structure2;

record LineArrayNode<T> (T[] array, int position) implements BiLineNode<T>
{
    public LineArrayNode<T> next ()
    {
        return position + 1 == array.length ? null : new LineArrayNode<>(array,position + 1);
    }

    public LineArrayNode<T> previous ()
    {
        return position == 0 ? null : new LineArrayNode<>(array,position + 1);
    }

    public T value ()
    {
        return array[position];
    }
}
