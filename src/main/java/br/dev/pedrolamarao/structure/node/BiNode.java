package br.dev.pedrolamarao.structure.node;

/**
 * Structural node with two peers.
 *
 * @param first   first peer
 * @param second  second peer
 * @param value   value
 * @param <T>     value type
 */
public record BiNode<T>(BiNode<T> first, BiNode<T> second, T value)
{
}
