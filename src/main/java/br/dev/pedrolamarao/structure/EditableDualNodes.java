package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public class EditableDualNodes<T> implements EditableUniLinear<T>
{
    private DualNode<T> root;

    private EditableDualNodes (DualNode<T> root)
    {
        this.root = root;
    }

    public static <U> EditableDualNodes<U> empty ()
    {
        return new EditableDualNodes<>(null);
    }

    public static <U> EditableDualNodes<U> of (DualNode<U> root)
    {
        return new EditableDualNodes<>( requireNonNull(root) );
    }

    //

    @Override
    public BiIterator<T> forward ()
    {
        return root == null ? null : new DualNodeIterator<>(root);
    }

    //

    @Override
    public void erase (Iterator<T> position)
    {
        if (! (position instanceof DualNodeIterator<T>(DualNode<T> node)))
            throw new RuntimeException("incompatible iterator");
        final var previous = node.first();
        final var next = node.second();
        previous.second(next);
        next.first(previous);
    }

    @Override
    public void set (Iterator<T> position, T value)
    {
        if (! (position instanceof DualNodeIterator<T>(DualNode<T> node)))
            throw new RuntimeException("incompatible iterator");
        node.value(value);
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof DualNodeIterator<T>(DualNode<T> xx) && y instanceof DualNodeIterator<T>(DualNode<T> yy)))
            throw new RuntimeException("incompatible iterator");
        final T tmp = x.value();
        xx.value(yy.value());
        yy.value(tmp);
    }
}
