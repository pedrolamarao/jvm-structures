package br.dev.pedrolamarao.structure.traversable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;

/**
 * Unidirectional branch-traversable structure.
 *
 * @param <T> element type
 */
public interface UniBranchTraversable <T>
{
    /**
     * Pre-ordered branch traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> preOrder ();

    /**
     * In-ordered branch traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> inOrder ();

    /**
     * Post-ordered branch traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> postOrder ();
}
