package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.traversable.Traverse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArrayTraversalTest
{
    final Object[] array = new Object[size];

    static final int size = 1024 * 1024;

    @Test
    void count ()
    {
        assertThat(Traverse.count(TraversableArray.empty()))
            .isEqualTo(0);

        assertThat(Traverse.count(TraversableArray.of(array)))
            .isEqualTo(size);
    }

    @Test
    void countIf ()
    {
        assertThat(Traverse.countIf(TraversableArray.empty(), Integer.class::isInstance))
            .isEqualTo(0);

        assertThat(Traverse.countIf(TraversableArray.of(array), Integer.class::isInstance))
            .isEqualTo(0);
    }

    @Test
    void find ()
    {
        final var target = array[size - 1];

        assertThat(Traverse.find(TraversableArray.empty(), target))
            .isNull();

        assertThat(Traverse.find(TraversableArray.of(array), target))
            .isNotNull()
            .extracting(UniIterator::value)
            .isEqualTo(target);
    }

    @Test
    void findIf ()
    {
        final var target = array[size - 1];

        assertThat(Traverse.findIf(TraversableArray.empty(), it -> it == target))
            .isNull();

        assertThat(Traverse.findIf(TraversableArray.of(array), it -> it == target))
            .isNotNull()
            .extracting(UniIterator::value)
            .isEqualTo(target);
    }

    @Test
    void visit ()
    {
        final var counter = new AtomicInteger();

        counter.set(0);
        Traverse.visit(TraversableArray.empty(), it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(0);

        counter.set(0);
        Traverse.visit(TraversableArray.of(array), it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(size);
    }

    @BeforeAll
    void fill ()
    {
        for (int i = 0, j = array.length; i != j; ++i) {
            array[i] = new Object();
        }
    }
}
