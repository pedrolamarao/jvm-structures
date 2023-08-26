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

import java.lang.reflect.Array;

import static java.util.Objects.requireNonNull;

public class ArrayEditor<T> implements EditableUniLinear<T>, EditableBiLinear<T>
{
    private int limit;

    private T[] root;

    private final Class<? super T> type;

    private ArrayEditor (int limit, T[] root, Class<? super T> type)
    {
        this.root = root;
        this.limit = limit;
        this.type = type;
    }

    /**
     * Create an editable structure copying from this array.
     *
     * @param type   element class
     * @param array  array
     * @return       editable strcuture
     * @param <U>    element type
     */
    public static <U> ArrayEditor<U> from (Class<? super U> type, U[] array)
    {
        return new ArrayEditor<>(array.length, array.clone(), requireNonNull(type));
    }

    /**
     * Create an editable structure copying from this array.
     *
     * @param type   element class
     * @param array  array
     * @param limit  array limit
     * @return       editable structure
     * @param <U>    element type
     */
    public static <U> ArrayEditor<U> from (Class<? super U> type, U[] array, int limit)
    {
        if (limit > array.length) throw new ArrayIndexOutOfBoundsException();
        return new ArrayEditor<>(limit, array.clone(), requireNonNull(type));
    }

    /**
     * Create an editable structure with this initial capacity.
     *
     * @param type      element class
     * @param capacity  initial capacity
     * @return          editable structure
     * @param <U>       element type
     */
    @SuppressWarnings("unchecked")
    public static <U> ArrayEditor<U> of (Class<? super U> type, int capacity)
    {
        return new ArrayEditor<>(0, (U[])Array.newInstance(type,capacity), requireNonNull(type));
    }

    //

    @Override
    public BiIterator<T> forward ()
    {
        return limit == 0 ? null : new ArrayIterator<>(root, 0, limit - 1);
    }

    @Override
    public BiIterator<T> backward ()
    {
        return limit == 0 ? null : new ArrayIterator<>(root, limit - 1, limit - 1);
    }

    //

    public T get (Iterator<T> position)
    {
        if (! (position instanceof ArrayIterator<T> p))
            throw new RuntimeException("illegal iterator");
        return get(p.position());
    }

    public T get (int position)
    {
        if (position < 0 || position > limit)
            throw new ArrayIndexOutOfBoundsException();
        return root[position];
    }

    @Override
    public void erase (Iterator<T> position)
    {
        if (! (position instanceof ArrayIterator<T> p))
            throw new RuntimeException("illegal iterator");
        erase(p.position());
    }

    public void erase (int position)
    {
        if (position < 0 || position > limit)
            throw new ArrayIndexOutOfBoundsException();
        System.arraycopy(root,position+1,root,position,limit-position-1);
        limit -= 1;
    }

    @Override
    public void set (Iterator<T> position, T value)
    {
        if (! (position instanceof ArrayIterator<T> p))
            throw new RuntimeException("illegal iterator");
        set(p.position(),value);
    }

    public void set (int position, T value)
    {
        if (position < 0 || position > limit)
            throw new ArrayIndexOutOfBoundsException();
        root[position] = value;
    }

    @Override
    public void swap (Iterator<T> x, Iterator<T> y)
    {
        if (! (x instanceof ArrayIterator<T> xx && y instanceof ArrayIterator<T> yy))
            throw new RuntimeException("illegal iterators");
        swap(xx.position(),yy.position());
    }

    public void swap (int x, int y)
    {
        final var tmp = root[x];
        root[x] = root[y];
        root[y] = tmp;
    }
}
