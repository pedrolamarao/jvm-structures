package br.dev.pedrolamarao.structure2;

/**
 * Cursor on linear structures with unidirectional traversal.
 * @param <T> element type
 */
interface UniLinearCursor<T>
{
    UniLinearCursor<T> next ();

    T value ();
}
