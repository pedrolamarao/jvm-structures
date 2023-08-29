package br.dev.pedrolamarao.structure2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class RandomIntegerLineTest
{
    final Integer[] array = new Integer[size];

    static final int size = 102400;

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
    void sorted (UniLinearCursor<Integer> cursor)
    {
        assertThat( Linear.sorted(cursor, Comparator.naturalOrder()) ).isFalse();
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
        for (int i = 0; i < size; ++i) array[i] = ThreadLocalRandom.current().nextInt();
    }
}
