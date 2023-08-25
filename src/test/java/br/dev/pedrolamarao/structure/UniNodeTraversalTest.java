package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.node.UniNode;
import br.dev.pedrolamarao.structure.traversable.Traverse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UniNodeTraversalTest
{
    UniNode<Object> node = null;

    static final int size = 1024 * 1024;

    @Test
    void count ()
    {
        assertThat(Traverse.count(TraversableUniNode.empty()))
            .isEqualTo(0);

        assertThat(Traverse.count(TraversableUniNode.of(node)))
            .isEqualTo(size);
    }

    @Test
    void countIf ()
    {
        assertThat(Traverse.countIf(TraversableUniNode.empty(), Integer.class::isInstance))
            .isEqualTo(0);

        assertThat(Traverse.countIf(TraversableUniNode.of(node), Integer.class::isInstance))
            .isEqualTo(0);

        assertThat(Traverse.countIf(TraversableUniNode.of(node), Object.class::isInstance))
            .isEqualTo(size);
    }

    @Test
    void find ()
    {
        final var target = node.value();

        assertThat(Traverse.find(TraversableUniNode.empty(), target))
            .isNull();

        assertThat(Traverse.find(TraversableUniNode.of(node), new Object()))
            .isNull();

        assertThat(Traverse.find(TraversableUniNode.of(node), target))
            .isNotNull();
    }

    @Test
    void findIf ()
    {
        assertThat(Traverse.findIf(TraversableUniNode.empty(), it -> it == node.value()))
            .isNull();

        assertThat(Traverse.findIf(TraversableUniNode.of(node), it -> false))
            .isNull();

        assertThat(Traverse.findIf(TraversableUniNode.of(node), it -> true))
            .isNotNull()
            .extracting(UniIterator::value)
            .isEqualTo(node.value());

        assertThat(Traverse.findIf(TraversableUniNode.of(node), it -> it == node.value()))
            .isNotNull()
            .extracting(UniIterator::value)
            .isEqualTo(node.value());
    }

    @Test
    void visit ()
    {
        final var counter = new AtomicInteger();

        counter.set(0);
        Traverse.visit(TraversableUniNode.empty(), it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(0);

        counter.set(0);
        Traverse.visit(TraversableUniNode.of(node), it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(size);
    }

    @BeforeAll
    void fill ()
    {
        for (int i = 0; i != size; ++i) {
            node = new UniNode<>(node, new Object());
        }
    }
}
