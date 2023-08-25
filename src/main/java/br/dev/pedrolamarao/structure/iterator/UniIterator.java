package br.dev.pedrolamarao.structure.iterator;

/**
 * Position in unidirectional traversals.
 *
 * @param <T>  element type
 */
public interface UniIterator<T> extends Iterator<T>
{
    /**
     * Next position.
     *
     * @return iterator, or null if end of traversal
     */
    UniIterator<T> next ();
}
