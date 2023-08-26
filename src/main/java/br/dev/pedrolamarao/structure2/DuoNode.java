package br.dev.pedrolamarao.structure2;

record DuoNode<T> (DuoNode<T> next, DuoNode<T> previous, T value) implements BiLineNode<T>
{
}
