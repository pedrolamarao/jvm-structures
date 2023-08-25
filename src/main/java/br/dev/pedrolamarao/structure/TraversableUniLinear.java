package br.dev.pedrolamarao.structure;

/**
 * Unidirectional linear-traversable structure.
 *
 * @param <T> element type
 */
public interface TraversableUniLinear<T>
{
    /**
     * Forward traversal start iterator.
     *
     * @return iterator
     */
    UniIterator<T> forward ();
}
