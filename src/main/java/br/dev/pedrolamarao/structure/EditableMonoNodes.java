package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public class EditableMonoNodes<T> implements EditableUniLinear<T>
{
    private MonoNode<T> root;

    private EditableMonoNodes (MonoNode<T> root)
    {
        this.root = root;
    }

    public static <U> EditableMonoNodes<U> empty ()
    {
        return new EditableMonoNodes<>(null);
    }

    public static <U> EditableMonoNodes<U> of (MonoNode<U> root)
    {
        return new EditableMonoNodes<>( requireNonNull(root) );
    }

    //

    @Override
    public UniIterator<T> forward ()
    {
        return root == null ? null : new MonoNodeIterator<>(root);
    }

    MonoNode<T> previous (MonoNode<T> target)
    {
        MonoNode<T> node = root;
        while (node != null && node.link() != target)
            node = node.link();
        return node;
    }

    //

    @Override
    public void erase (Iterator<T> position)
    {
        if (! (position instanceof MonoNodeIterator<T>(MonoNode<T> node)))
            throw new RuntimeException("incompatible position");
        final var previous = previous(node);
        if (previous == null)
            throw new RuntimeException("invalid position");
        previous.link(node.link());
    }

    @Override
    public void set (Iterator<T> position, T value)
    {
        if (! (position instanceof MonoNodeIterator<T>(MonoNode<T> node)))
            throw new RuntimeException("incompatible iterator");
        node.value(value);
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof MonoNodeIterator<T>(MonoNode<T> xx) && y instanceof MonoNodeIterator<T>(MonoNode<T> yy)))
            throw new RuntimeException("incompatible iterator");
        final T tmp = x.value();
        xx.value(yy.value());
        yy.value(tmp);
    }
}
