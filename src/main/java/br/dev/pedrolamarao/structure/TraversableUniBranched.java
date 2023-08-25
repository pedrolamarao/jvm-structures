package br.dev.pedrolamarao.structure;

/**
 * Unidirectional branch-traversable structure.
 *
 * @param <T> element type
 */
public interface TraversableUniBranched<T>
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
