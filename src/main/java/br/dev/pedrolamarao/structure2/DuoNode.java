package br.dev.pedrolamarao.structure2;

/**
 * Node with two links.
 * @param <T> value type
 */
class DuoNode<T>
{
    DuoNode<T> first;

    DuoNode<T> second;

    T value;

    DuoNode (DuoNode<T> first, DuoNode<T> second, T value)
    {
        this.first = first;
        this.second = second;
        this.value = value;
    }

    DuoNode<T> first ()
    {
        return first;
    }

    DuoNode<T> second ()
    {
        return second;
    }

    T value ()
    {
        return value;
    }
}
