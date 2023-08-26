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

public record TraversableArray<T>(T[] root, int limit) implements TraversableUniLinear<T>
{
    public static <U> TraversableArray<U> empty ()
    {
        return new TraversableArray<>(null, 0);
    }

    public static <U> TraversableArray<U> of (U[] array)
    {
        requireNonNull(array);
        return new TraversableArray<>(array, array.length);
    }

    public UniIterator<T> forward ()
    {
        return limit == 0 ? null : new ArrayIterator<>(root, 0, limit - 1);
    }
}
