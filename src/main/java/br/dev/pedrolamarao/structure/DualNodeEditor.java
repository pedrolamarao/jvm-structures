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

public class DualNodeEditor<T> implements EditableUniLinear<T>
{
    private DualNode<T> root;

    private DualNodeEditor (DualNode<T> root)
    {
        this.root = root;
    }

    public static <U> DualNodeEditor<U> empty ()
    {
        return new DualNodeEditor<>(null);
    }

    public static <U> DualNodeEditor<U> of (DualNode<U> root)
    {
        return new DualNodeEditor<>( requireNonNull(root) );
    }

    //

    @Override
    public BiTraversal<T> forward ()
    {
        return root == null ? null : new DualNodeLinearTraversal<>(root);
    }

    //

    @Override
    public void erase (Traversal<T> position)
    {
        if (! (position instanceof DualNodeLinearTraversal<T>(DualNode<T> node)))
            throw new RuntimeException("incompatible iterator");
        final var previous = node.first();
        final var next = node.second();
        previous.second(next);
        next.first(previous);
    }

    @Override
    public void set (Traversal<T> position, T value)
    {
        if (! (position instanceof DualNodeLinearTraversal<T>(DualNode<T> node)))
            throw new RuntimeException("incompatible iterator");
        node.value(value);
    }

    @Override
    public void swap (Traversal<T> x, Traversal<T> y)
    {
        if (! (x instanceof DualNodeLinearTraversal<T>(DualNode<T> xx) && y instanceof DualNodeLinearTraversal<T>(DualNode<T> yy)))
            throw new RuntimeException("incompatible iterator");
        final T tmp = x.value();
        xx.value(yy.value());
        yy.value(tmp);
    }
}
