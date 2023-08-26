package br.dev.pedrolamarao.structure;

record DualNodeIterator<T>(DualNode<T> node) implements BiIterator<T>
{
    @Override
    public BiIterator<T> next ()
    {
        return node.first() == null ? null : new DualNodeIterator<>(node.first());
    }

    @Override
    public BiIterator<T> previous ()
    {
        return node.second() == null ? null : new DualNodeIterator<>(node.second());
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
