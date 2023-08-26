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

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TraverseIntTest
{
    static final int size = 1024 * 1024;

    @ParameterizedTest
    @MethodSource("structures")
    void accumulate (TraversableUniLinear<Integer> structure)
    {
        assertThat( Traverse.accumulate( structure, (a,x) -> 0, 0) )
            .isEqualTo(0);

        assertThat( Traverse.accumulate( structure, (a,x) -> ++a, 0) )
            .isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void any (TraversableUniLinear<Integer> structure)
    {
        assertThat( Traverse.any(structure,Objects::isNull) ).isFalse();
        assertThat( Traverse.any(structure,Objects::nonNull) ).isTrue();
    }

    @ParameterizedTest
    @MethodSource("structures")
    void count (TraversableUniLinear<Integer> structure)
    {
        assertThat(Traverse.count(structure))
            .isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void countIf (TraversableUniLinear<Integer> structure)
    {
        assertThat(Traverse.countIf(structure,it->true))
            .isEqualTo(size);
        assertThat(Traverse.countIf(structure,it->false))
            .isEqualTo(0);
        assertThat(Traverse.countIf(structure,it -> it % 2 == 0))
            .isEqualTo(size/2);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void every (TraversableUniLinear<Integer> structure)
    {
        assertThat( Traverse.every(structure,Objects::isNull) ).isFalse();
        assertThat( Traverse.every(structure,Objects::nonNull) ).isTrue();
    }

    @ParameterizedTest
    @MethodSource("structures")
    void find (TraversableUniLinear<Integer> structure)
    {
        final var target = structure.forward().value();
        assertThat(Traverse.find(structure, target))
            .isNotNull()
            .extracting(UniTraversal::value)
            .isEqualTo(target);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void findIf (TraversableUniLinear<Integer> structure)
    {
        final var target = structure.forward().value();
        assertThat(Traverse.findIf(structure,it -> Objects.equals(it, target)))
            .isNotNull()
            .extracting(UniTraversal::value)
            .isEqualTo(target);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void visit (TraversableUniLinear<Integer> structure)
    {
        final var counter = new AtomicInteger();
        Traverse.visit(structure, it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(size);
    }

    static List<TraversableUniLinear<Integer>> structures ()
    {
        final var array = new Integer[size];
        for (int i = 0; i != array.length; ++i) array[i] = -i;

        MonoNode<Integer> node = null;
        for (int i = 0; i != size; ++i) node = new MonoNode<>(node, -i);

        return List.of(
            ArrayTraveller.of(array),
            MonoNodeTraveller.of(node)
        );
    }
}
