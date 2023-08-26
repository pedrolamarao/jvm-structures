package br.dev.pedrolamarao.structure;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TraverseEmptyTest
{
    @ParameterizedTest
    @MethodSource("structures")
    void accumulate (TraversableUniLinear<Object> structure)
    {
        assertThat( Traverse.accumulate( structure, (a,x)->++a, 0) ).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void count (TraversableUniLinear<Object> structure)
    {
        assertThat( Traverse.count(structure) ).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void countIf (TraversableUniLinear<Object> structure)
    {
        assertThat( Traverse.countIf(structure,it->true) ).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void find (TraversableUniLinear<Object> structure)
    {
        assertThat( Traverse.find(structure,this) ).isNull();
    }

    @ParameterizedTest
    @MethodSource("structures")
    void findIf (TraversableUniLinear<Object> structure)
    {
        assertThat( Traverse.findIf(structure,it->true) ).isNull();
    }

    @ParameterizedTest
    @MethodSource("structures")
    void sorted (TraversableUniLinear<Object> structure)
    {
        final var ordering = Comparator.comparingInt(Objects::hashCode);
        assertTrue( Traverse.sorted(structure,ordering) );
    }

    @ParameterizedTest
    @MethodSource("structures")
    void visit (TraversableUniLinear<Object> structure)
    {
        final var counter = new AtomicInteger();
        Traverse.visit(structure,it->counter.incrementAndGet());
        assertThat(counter).hasValue(0);
    }

    static List<TraversableUniLinear<Object>> structures ()
    {
        return List.of(
            TraversableArray.empty(),
            TraversableMonoNodes.empty()
        );
    }
}
