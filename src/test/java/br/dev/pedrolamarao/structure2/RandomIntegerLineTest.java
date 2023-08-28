package br.dev.pedrolamarao.structure2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
    void distance (UniLineNode<Integer> node)
    {
        assertThat( Lines.distance(node,null) ).isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("lines")
    void find (UniLineNode<Integer> node)
    {
        assertThat( Lines.find(node,array[size-1]) ).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("lines")
    void visit (UniLineNode<Integer> node)
    {
        final var counter = new AtomicInteger();
        Lines.visit(node, it->counter.incrementAndGet());
        assertThat(counter).hasValue(size);
    }

    List<UniLineNode<Integer>> lines ()
    {
        MonoNode<Integer> node = null;
        for (int j = size - 1; j >= 0; --j) node = new MonoNode<>(node,array[j]);

        return List.of(
            new LineArrayNode<>(array.clone(),0),
            node
        );
    }

    @BeforeAll
    void generate ()
    {
        for (int i = 0; i < size; ++i) array[i] = ThreadLocalRandom.current().nextInt();
    }
}
