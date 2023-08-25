package br.dev.pedrolamarao.structure;

public class EditableDualNodes<T> implements EditableUniLinear<T>
{
    DualNode<T> root;

    //

    @Override
    public BiIterator<T> forward ()
    {
        return new IterableDualNode<>(root);
    }

    //

    @Override
    public void set (Iterator<T> position, T value)
    {
        if (! (position instanceof IterableDualNode<T> p))
            throw new RuntimeException("incompatible iterator");
        p.node().value(value);
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof IterableDualNode<T> xx && y instanceof IterableDualNode<T> yy))
            throw new RuntimeException("incompatible iterator");
        final T tmp = x.value();
        xx.node().value(yy.node().value());
        yy.node().value(tmp);
    }
}
