package br.dev.pedrolamarao.structure.iterator;

/**
 * Position in unidirectional traversals.
 *
 * @param <T>  element type
 */
public interface UniIterator<T>
{
    /**
     * Next position.
     *
     * @return iterator, or null if end of traversal
     */
    UniIterator<T> next ();

    /**
     * Current element.
     *
     * @return element
     */
    T value ();
}
