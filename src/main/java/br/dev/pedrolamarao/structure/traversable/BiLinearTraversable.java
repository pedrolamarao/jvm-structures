package br.dev.pedrolamarao.structure.traversable;

import br.dev.pedrolamarao.structure.iterator.BiIterator;

/**
 * Bidirectional linear-traversable structure.
 *
 * @param <T> element type
 */
public interface BiLinearTraversable<T> extends UniLinearTraversable<T>
{
    /**
     * Backward linear traversal start iterator.
     *
     * @return iterator
     */
    BiIterator<T> backward ();
}
