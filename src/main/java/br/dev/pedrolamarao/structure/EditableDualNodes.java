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
