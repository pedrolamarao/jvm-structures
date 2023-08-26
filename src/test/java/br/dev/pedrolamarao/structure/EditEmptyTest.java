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

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditEmptyTest
{
    static final int size = 10240;

    @ParameterizedTest
    @MethodSource("structures")
    void bubbleSort (EditableUniLinear<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.bubbleSort(structure,ordering);
        assertTrue( Traverse.sorted(structure,ordering) );
    }

    @ParameterizedTest
    @MethodSource("structures")
    void fill (EditableUniLinear<Object> structure)
    {
        final var element = new Object();
        Edit.fill(structure,element);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void selectSort (EditableUniLinear<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Object::hashCode);
        Edit.selectSort(structure,ordering);
        assertTrue( Traverse.sorted(structure,ordering) );
    }

    static List<EditableUniLinear<Object>> structures ()
    {
        return List.of(
            ArrayEditor.from(Object.class, new Object[0]),
            MonoNodeEditor.empty()
        );
    }
}
