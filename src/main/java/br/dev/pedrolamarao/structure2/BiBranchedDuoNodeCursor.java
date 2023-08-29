package br.dev.pedrolamarao.structure2;

/**
 * Cursor on binary branched structure made of nodes with two links.
 * @param node
 * @param <T> element type
 */
record BiBranchedDuoNodeCursor<T> (DuoNode<T> node) implements BiBranchedCursor<T>
{
    @Override
    public BiBranchedCursor<T> left ()
    {
        return node.first() == null ? null : new BiBranchedDuoNodeCursor<>(node.first());
    }

    @Override
    public BiBranchedCursor<T> right ()
    {
        return node.second() == null ? null : new BiBranchedDuoNodeCursor<>(node.second());
    }

    @Override
    public T value ()
    {
        return node.value;
    }
}
