package br.dev.pedrolamarao.structure2;

/**
 * Cursor on a linear structure made of nodes with one link.
 * @param node
 * @param <T> element type
 */
record LinearMonoNodeCursor<T> (MonoNode<T> node) implements UniLinearCursor<T>
{
    @Override
    public UniLinearCursor<T> next ()
    {
        return node.link() == null ? null : new LinearMonoNodeCursor<>(node.link());
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
