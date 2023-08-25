package br.dev.pedrolamarao.structure.editable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.traversable.UniTraversable;

/**
 * Editable unidirectional structure.
 *
 * @param <T>  element type
 */
public interface UniEditable<T> extends UniTraversable<T>
{
    /**
     * Swap the position of two elements.
     *
     * @param x  element
     * @param y  element
     */
    void swap (UniIterator<T> x, UniIterator<T> y);
}
