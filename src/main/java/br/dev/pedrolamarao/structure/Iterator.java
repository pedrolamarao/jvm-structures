package br.dev.pedrolamarao.structure;

/**
 * Position in traversal.
 *
 * @param <T> element type
 */
public interface Iterator <T>
{
    /**
     * Element at position.
     *
     * @return element
     */
    T value ();
}
