package br.dev.pedrolamarao.structure.traversable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;

/**
 * Tree traversable structure.
 *
 * @param <T> element type
 */
public interface TreeTraversable<T>
{
    /**
     * Pre-ordered traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> preOrder ();

    /**
     * In-ordered traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> inOrder ();

    /**
     * Post-ordered traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> postOrder ();
}
