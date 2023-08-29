package br.dev.pedrolamarao.structure2;

class LinearDuoNodeEditor<T>
{
    static <T> void erase (DuoNode<T> node)
    {
        final var previous = node.first;
        final var next = node.second;
        previous.second = next;
        next.first = previous;
    }

    static <T> void insert (DuoNode<T> node, T value)
    {
        final var previous = node.first;
        previous.second = ( node.first = new DuoNode<T>(previous,node,value) );
    }

    static <T> void swap (DuoNode<T> x, DuoNode<T> y)
    {
        final var tmp = x.value;
        x.value = y.value;
        y.value = tmp;
    }
}
