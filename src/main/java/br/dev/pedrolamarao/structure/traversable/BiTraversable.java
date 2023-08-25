package br.dev.pedrolamarao.structure.traversable;

import br.dev.pedrolamarao.structure.iterator.BiIterator;

/**
 * Bidirectional traversable structure.
 *
 * @param <T> element type
 */
public interface BiTraversable<T>
{
    /**
     * Forward traversal start iterator.
     *
     * @return iterator
     */
    BiIterator<T> forward ();

    /**
     * Backward traversal start iterator.
     *
     * @return iterator
     */
    BiIterator<T> backward ();
}
