package br.dev.pedrolamarao.structure.node;

/**
 * Structural node with one peer.
 *
 * @param peer   peer
 * @param value  value
 * @param <T>    value type
 */
public record UniNode<T>(UniNode<T> peer, T value)
{
}
