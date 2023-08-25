package br.dev.pedrolamarao.structure.traversable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;

/**
 * Unidirectional traversable structure.
 *
 * @param <T> element type
 */
public interface UniTraversable<T>
{
    /**
     * Forward traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> forward ();
}