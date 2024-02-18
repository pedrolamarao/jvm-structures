package br.dev.pedrolamarao.structure.position;

/**
 * Position in a forward traversal of some structure.
 *
 * @param <T> value type
 */
public interface LinearPosition<T> extends Position<T>
{
    LinearPosition<T> next ();
}
