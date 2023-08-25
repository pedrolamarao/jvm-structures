package br.dev.pedrolamarao.structure;

/**
 * Structural root with one link.
 */
public class MonoNode<T>
{
    MonoNode<T> link;

    T value;

    public MonoNode (MonoNode<T> link, T value)
    {
        this.link = link;
        this.value = value;
    }

    public MonoNode<T> link ()
    {
        return link;
    }

    public void link (MonoNode<T> link)
    {
        this.link = link;
    }

    public T value ()
    {
        return value;
    }

    public void value (T value)
    {
        this.value = value;
    }
}
