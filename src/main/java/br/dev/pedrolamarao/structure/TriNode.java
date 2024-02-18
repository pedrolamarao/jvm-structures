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

/**
 * Structural element with tree links.
 */
public class TriNode<T>
{
    private TriNode<T> first;

    private TriNode<T> second;

    private TriNode<T> third;

    private T value;

    public TriNode (TriNode<T> first, TriNode<T> second, TriNode<T> third, T value)
    {
        this.first = first;
        this.second = second;
        this.third = third;
        this.value = value;
    }

    public TriNode<T> first ()
    {
        return first;
    }

    public void first (TriNode<T> first)
    {
        this.first = first;
    }

    public TriNode<T> second ()
    {
        return second;
    }

    public void second (TriNode<T> second)
    {
        this.second = second;
    }

    public TriNode<T> third ()
    {
        return third;
    }

    public void third (TriNode<T> second)
    {
        this.third = third;
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
