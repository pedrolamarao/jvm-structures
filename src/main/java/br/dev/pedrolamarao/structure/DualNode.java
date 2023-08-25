package br.dev.pedrolamarao.structure;

/**
 * Structural root with two links.
 */
public class DualNode<T>
{
    DualNode<T> first;

    DualNode<T> second;

    T value;

    public DualNode (DualNode<T> first, DualNode<T> second, T value)
    {
        this.first = first;
        this.second = second;
        this.value = value;
    }

    public DualNode<T> first ()
    {
        return first;
    }

    public void first (DualNode<T> first)
    {
        this.first = first;
    }

    public DualNode<T> second ()
    {
        return second;
    }

    public void second (DualNode<T> second)
    {
        this.second = second;
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
