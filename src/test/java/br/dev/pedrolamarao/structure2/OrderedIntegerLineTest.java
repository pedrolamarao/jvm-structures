package br.dev.pedrolamarao.structure2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class OrderedIntegerLineTest
{
    final Integer[] array = new Integer[size];

    static final int size = 102400;

    @ParameterizedTest
    @MethodSource("lines")
    void any (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.any(cursor,it -> it == 1) ).isTrue();
    }

    @ParameterizedTest
    @MethodSource("lines")
    void count (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.count(cursor,16) ).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("lines")
    void countIf (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.countIf(cursor, it -> it % 2 == 0) ).isEqualTo(size/2);
    }

    @ParameterizedTest
    @MethodSource("lines")
    void distance (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.distance(cursor,null) ).isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("lines")
    void find (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.find(cursor,array[size-1]) ).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("lines")
    void maximum (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.maximum(cursor,Comparator.naturalOrder()) ).isEqualTo(array[array.length-1]);
    }

    @ParameterizedTest
    @MethodSource("lines")
    void minimum (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.minimum(cursor,Comparator.naturalOrder()) ).isEqualTo(array[0]);
    }

    @ParameterizedTest
    @MethodSource("lines")
    void sorted (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.sorted(cursor) ).isTrue();
    }

    @ParameterizedTest
    @MethodSource("lines")
    void visit (UniLinearCursor<Integer> cursor)
    {
        final var counter = new AtomicInteger();
        Linear.visit(cursor, it->counter.incrementAndGet());
        assertThat(counter).hasValue(size);
    }

    List<UniLinearCursor<Integer>> lines ()
    {
        MonoNode<Integer> node = null;
        for (int j = size - 1; j >= 0; --j) node = new MonoNode<>(node,array[j]);

        return List.of(
            new LinearArrayCursor<>(array.clone(),0),
            new LinearMonoNodeCursor<>(node)
        );
    }

    @BeforeAll
    void generate ()
    {
        for (int i = 0; i < size; ++i) array[i] = i;
    }
}
