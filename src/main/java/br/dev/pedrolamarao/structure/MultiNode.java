package br.dev.pedrolamarao.structure;

/**
 * Structural root with many links.
 */
public class MultiNode<T>
{
    private MultiNode<T>[] links;

    private T value;

    public MultiNode (MultiNode<T>[] links, T value)
    {
        this.links = links;
        this.value = value;
    }

    public MultiNode<T>[] links ()
    {
        return links;
    }

    public void links (MultiNode<T>[] links)
    {
        this.links = links;
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
