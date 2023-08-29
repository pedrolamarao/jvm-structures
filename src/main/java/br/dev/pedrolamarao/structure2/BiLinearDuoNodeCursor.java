package br.dev.pedrolamarao.structure2;

/**
 * Cursor on a linear structure made of nodes with two links.
 * @param node
 * @param <T> element type
 */
record BiLinearDuoNodeCursor<T> (DuoNode<T> node) implements BiLinearCursor<T>
{
    @Override
    public BiLinearCursor<T> next ()
    {
        return node.first() == null ? null : new BiLinearDuoNodeCursor<>(node.first());
    }

    @Override
    public BiLinearCursor<T> previous ()
    {
        return node.second() == null ? null : new BiLinearDuoNodeCursor<>(node.second());
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
