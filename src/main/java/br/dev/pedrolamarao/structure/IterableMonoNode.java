package br.dev.pedrolamarao.structure;

record IterableMonoNode<T>(MonoNode<T> node) implements UniIterator<T>
{
    @Override
    public UniIterator<T> next ()
    {
        return node.link() == null ? null : new IterableMonoNode<>(node.link());
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
