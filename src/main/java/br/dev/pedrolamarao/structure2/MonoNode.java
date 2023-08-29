package br.dev.pedrolamarao.structure2;

/**
 * Node with one link.
 * @param <T> value type
 */
class MonoNode<T>
{
    MonoNode<T> link;

    T value;

    MonoNode (MonoNode<T> link, T value)
    {
        this.link = link;
        this.value = value;
    }

    MonoNode<T> link ()
    {
        return link;
    }

    T value ()
    {
        return value;
    }
}
