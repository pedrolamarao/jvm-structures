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
        assertThat( Traverse.accumulate( TraversableArray.empty(), (a,x) -> ++a, 0) )
            .isEqualTo(0);

        assertThat( Traverse.accumulate( structure, (a,x) -> ++a, 0) )
            .isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void count (TraversableUniLinear<Object> structure)
    {
        assertThat(Traverse.count(TraversableArray.empty()))
            .isEqualTo(0);

        assertThat(Traverse.count(structure))
            .isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void countIf (TraversableUniLinear<Object> structure)
    {
        assertThat(Traverse.countIf(TraversableArray.empty(), Integer.class::isInstance))
            .isEqualTo(0);

        assertThat(Traverse.countIf(structure, Integer.class::isInstance))
            .isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void find (TraversableUniLinear<Object> structure)
    {
        final var target = structure.forward().value();

        assertThat(Traverse.find(TraversableArray.empty(), target))
            .isNull();

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

        assertThat(Traverse.findIf(TraversableArray.empty(), it -> it == target))
            .isNull();

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

        counter.set(0);
        Traverse.visit(TraversableArray.empty(), it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(0);

        counter.set(0);
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
