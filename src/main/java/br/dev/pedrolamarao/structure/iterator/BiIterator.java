package br.dev.pedrolamarao.structure.iterator;

/**
 * Position in bidirectional traversals.
 *
 * @param <T>  element type
 */
public interface BiIterator<T> extends UniIterator<T>
{
    /**
     * Next position.
     *
     * @return iterator, or null if end of traversal
     */
    BiIterator<T> next ();

    /**
     * Previous position.
     *
     * @return iterator, or null if end of traversal
     */
    BiIterator<T> previous ();

    /**
     * Current element.
     *
     * @return element
     */
    T value ();
}
