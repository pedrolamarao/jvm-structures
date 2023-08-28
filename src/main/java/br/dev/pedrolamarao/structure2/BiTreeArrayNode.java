package br.dev.pedrolamarao.structure2;

record BiTreeArrayNode<T> (T[] array, int position) implements BiTreeNode<T>
{
    public BiTreeNode<T> parent ()
    {
        final int p = (position - 1) / 2;
        return p < 0 || array[p] == null ? null : new BiTreeArrayNode<>(array,p);
    }

    @Override
    public BiTreeNode<T> left ()
    {
        final int p = (2 * position) + 1;
        return array.length <= p || array[p] == null ? null :  new BiTreeArrayNode<>(array,p);
    }

    @Override
    public BiTreeNode<T> right ()
    {
        final int p = (2 * position) + 2;
        return array.length <= p || array[p] == null ? null : new BiTreeArrayNode<>(array,p);
    }

    public T value ()
    {
        return array[position];
    }
}
