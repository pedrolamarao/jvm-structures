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
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TraverseTest
{
    static final int size = 1024 * 1024;

    @ParameterizedTest
    @MethodSource("structures")
    void accumulate (TraversableUniLinear<Object> structure)
    {
        assertThat( Traverse.accumulate( structure, (a,x) -> ++a, 0) )
            .isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void count (TraversableUniLinear<Object> structure)
    {
        assertThat(Traverse.count(structure))
            .isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void countIf (TraversableUniLinear<Object> structure)
    {
        assertThat(Traverse.countIf(structure, Integer.class::isInstance))
            .isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void find (TraversableUniLinear<Object> structure)
    {
        final var target = structure.forward().value();
        assertThat(Traverse.find(structure, target))
            .isNotNull()
            .extracting(UniIterator::value)
            .isEqualTo(target);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void findIf (TraversableUniLinear<Object> structure)
    {
        final var target = structure.forward().value();
        assertThat(Traverse.findIf(structure, it -> it == target))
            .isNotNull()
            .extracting(UniIterator::value)
            .isEqualTo(target);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void visit (TraversableUniLinear<Object> structure)
    {
        final var counter = new AtomicInteger();
        Traverse.visit(structure, it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(size);
    }

    static List<TraversableUniLinear<Object>> structures ()
    {
        final var array = new Object[size];
        for (int i = 0; i != array.length; ++i) array[i] = new Object();

        MonoNode<Object> node = null;
        for (int i = 0; i != size; ++i) node = new MonoNode<>(node, new Object());

        return List.of(
            TraversableArray.of(array),
            TraversableMonoNodes.of(node)
        );
    }
}
