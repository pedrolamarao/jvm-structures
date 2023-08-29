package br.dev.pedrolamarao.structure2;

/**
 * Cursor on binary branched structures.
 * @param <T> element type
 */
interface BiBranchedCursor<T>
{
    BiBranchedCursor<T> left ();

    BiBranchedCursor<T> right ();

    T value ();
}
