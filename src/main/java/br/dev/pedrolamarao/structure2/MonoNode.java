package br.dev.pedrolamarao.structure2;

record MonoNode<T> (MonoNode<T> next, T value) implements UniLineNode<T>
{
}
