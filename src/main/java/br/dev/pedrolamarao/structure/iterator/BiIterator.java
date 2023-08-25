package br.dev.pedrolamarao.structure.iterator;

/**
 * Position in bidirectional traversals.
 *
 * @param <T>  element type
 */
public interface BiIterator<T> extends UniIterator<T>
{
    /**
     * Previous position.
     *
     * @return iterator, or null if end of traversal
     */
    BiIterator<T> previous ();
}
