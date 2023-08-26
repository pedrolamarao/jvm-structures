package br.dev.pedrolamarao.structure2;

interface BiLineNode<T> extends UniLineNode<T>
{
    BiLineNode<T> next ();

    BiLineNode<T> previous ();

    T value ();
}
