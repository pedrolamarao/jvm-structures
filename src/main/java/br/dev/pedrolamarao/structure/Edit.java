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

import java.util.Comparator;
import java.util.function.Function;

/**
 * Structure editing.
 */
public class Edit
{
    /**
     * Fill structure with a value.
     *
     * @param structure  editable structure
     * @param value      value
     * @param <T>        structure element type
     */
    public static <T> void fill (final EditableUniLinear<T> structure, final T value)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            structure.set(i,value);
        }
    }

    /**
     * Sort the structure.
     *
     * @param structure  editable structure
     * @param order      sort ordering
     * @param <T>        structure element type
     */
    public static <T> void sort (final EditableUniLinear<T> structure, final Comparator<T> order)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            for (var j = i.next(); j != null; j = j.next()) {
                if (order.compare(i.value(),j.value()) > 0)
                    structure.swap(i,j);
            }
        }
    }

    /**
     * Transform structure elements.
     *
     * @param structure  editable structure
     * @param operator   transformation
     * @param <T>        structure element type
     */
    public static <T> void transform (final EditableUniLinear<T> structure, final Function<T,T> operator)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            structure.set(i,operator.apply(i.value()));
        }
    }
}
