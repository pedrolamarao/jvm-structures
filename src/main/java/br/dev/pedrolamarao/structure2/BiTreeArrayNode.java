package br.dev.pedrolamarao.structure2;

record BiTreeArrayNode<T> (T[] array, int position) implements BiTreeNode<T>
{
    @Override
    public BiTreeNode<T> left ()
    {
        final int p = (2 * position) + 1;
        return p < array.length ? new BiTreeArrayNode<>(array,p) : null;
    }

    @Override
    public BiTreeNode<T> right ()
    {
        final int p = (2 * position) + 2;
        return p < array.length ? new BiTreeArrayNode<>(array,p) : null;
    }

    public T value ()
    {
        return array[position];
    }
}
