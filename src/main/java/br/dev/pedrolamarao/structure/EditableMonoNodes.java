package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public class EditableMonoNodes<T> implements EditableUniLinear<T>
{
    MonoNode<T> root;

    public EditableMonoNodes ()
    {
        this.root = null;
    }

    public EditableMonoNodes (MonoNode<T> root)
    {
        this.root = requireNonNull(root);
    }

    public static <U> EditableMonoNodes<U> of (MonoNode<U> root)
    {
        return new EditableMonoNodes<>(root);
    }

    //

    @Override
    public UniIterator<T> forward ()
    {
        return new IterableMonoNode<>(root);
    }

    //

    @Override
    public void set (Iterator<T> position, T value)
    {
        if (! (position instanceof IterableMonoNode<T> p))
            throw new RuntimeException("incompatible iterator");
        p.node().value(value);
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof IterableMonoNode<T> xx && y instanceof IterableMonoNode<T> yy))
            throw new RuntimeException("incompatible iterator");
        final T tmp = x.value();
        xx.node().value(yy.node().value());
        yy.node().value(tmp);
    }
}
