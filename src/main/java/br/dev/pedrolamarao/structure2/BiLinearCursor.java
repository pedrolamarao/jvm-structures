package br.dev.pedrolamarao.structure2;

/**
 * Cursor on linear structures with bidirectional traversal.
 * @param <T> element type
 */
interface BiLinearCursor<T> extends UniLinearCursor<T>
{
    BiLinearCursor<T> next ();

    BiLinearCursor<T> previous ();

    T value ();
}
