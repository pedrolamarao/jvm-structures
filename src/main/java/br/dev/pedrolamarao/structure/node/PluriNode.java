package br.dev.pedrolamarao.structure.node;

/**
 * Structural node with many peers.
 *
 * @param peers  peers
 * @param value  value
 * @param <T>    value type
 */
public record PluriNode<T>(PluriNode<T>[] peers, T value)
{
}
