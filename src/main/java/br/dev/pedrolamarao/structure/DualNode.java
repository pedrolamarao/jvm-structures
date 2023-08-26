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
 * Structural root with two links.
 */
public class DualNode<T>
{
    private DualNode<T> first;

    private DualNode<T> second;

    private T value;

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
