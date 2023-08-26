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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditIntTest
{
    static final int size = 10240;

    @ParameterizedTest
    @MethodSource("structures")
    void erase (EditableUniLinear<Integer> structure)
    {
        final var position = structure.forward().next();
        assertThat(structure.forward().next()).isEqualTo(position);
        structure.erase(position);
        assertThat(structure.forward().next()).isNotEqualTo(position);
        assertThat(Traverse.count(structure)).isEqualTo(size-1);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void fill (EditableUniLinear<Integer> structure)
    {
        final var element = Integer.MAX_VALUE;
        assertFalse( Traverse.every(structure,it->it==element) );
        Edit.fill(structure,element);
        assertTrue( Traverse.every(structure,it->it==element) );
    }

    @ParameterizedTest
    @MethodSource("structures")
    void sort (EditableUniLinear<Integer> structure)
    {
        Edit.sort(structure,Comparator.naturalOrder());
        assertTrue( Traverse.sorted(structure,Comparator.naturalOrder()) );
    }

    List<EditableUniLinear<Integer>> structures ()
    {
        final var array = new Integer[size];
        for (int i = 0; i != array.length; ++i) array[i] = -i;

        MonoNode<Integer> node = null;
        for (int i = 0; i != size; ++i) node = new MonoNode<>(node,-i);

        return List.of(
            ArrayEditor.from(array),
            MonoNodeEditor.of(node)
        );
    }
}
