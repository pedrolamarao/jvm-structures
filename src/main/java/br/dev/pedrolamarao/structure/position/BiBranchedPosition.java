package br.dev.pedrolamarao.structure.position;

/**
 * Position in a bi-branched traversal of some structure.
 *
 * @param <T> value type
 */
public interface BiBranchedPosition <T> extends Position<T>
{
    BiBranchedPosition<T> parent ();

    BiBranchedPosition<T> leftChild ();

    BiBranchedPosition<T> rightChild ();
}
