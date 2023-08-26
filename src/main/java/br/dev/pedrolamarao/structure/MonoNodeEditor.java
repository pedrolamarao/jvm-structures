// Copyright (C) 2023 Pedro Lamarão <pedro.lamarao@gmail.com>
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

package br.dev.pedrolamarao.structure;

import static java.util.Objects.requireNonNull;

public class MonoNodeEditor<T> implements EditableUniLinear<T>
{
    private MonoNode<T> root;

    private MonoNodeEditor (MonoNode<T> root)
    {
        this.root = root;
    }

    public static <U> MonoNodeEditor<U> empty ()
    {
        return new MonoNodeEditor<>(null);
    }

    public static <U> MonoNodeEditor<U> of (MonoNode<U> root)
    {
        return new MonoNodeEditor<>( requireNonNull(root) );
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
