package br.dev.pedrolamarao.structure;

/**
 * Bidirectional linear-traversable structure.
 *
 * @param <T> element type
 */
public interface TraversableBiLinear<T> extends TraversableUniLinear<T>
{
    /**
     * Backward linear traversal start iterator.
     *
     * @return iterator
     */
    BiIterator<T> backward ();
}
