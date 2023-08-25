package br.dev.pedrolamarao.structure;

import br.dev.pedrolamarao.structure.iterator.UniIterator;
import br.dev.pedrolamarao.structure.node.UniNode;
import br.dev.pedrolamarao.structure.traversable.Traverse;
import br.dev.pedrolamarao.structure.traversable.UniLinearTraversable;
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
    void count (UniLinearTraversable<Object> structure)
    {
        assertThat(Traverse.count(TraversableArray.empty()))
            .isEqualTo(0);

        assertThat(Traverse.count(structure))
            .isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void countIf (UniLinearTraversable<Object> structure)
    {
        assertThat(Traverse.countIf(TraversableArray.empty(), Integer.class::isInstance))
            .isEqualTo(0);

        assertThat(Traverse.countIf(structure, Integer.class::isInstance))
            .isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("structures")
    void find (UniLinearTraversable<Object> structure)
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
    void findIf (UniLinearTraversable<Object> structure)
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
    void visit (UniLinearTraversable<Object> structure)
    {
        final var counter = new AtomicInteger();

        counter.set(0);
        Traverse.visit(TraversableArray.empty(), it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(0);

        counter.set(0);
        Traverse.visit(structure, it -> counter.incrementAndGet());
        assertThat(counter.get()).isEqualTo(size);
    }

    static List<UniLinearTraversable<Object>> structures ()
    {
        UniNode<Object> node = null;
        for (int i = 0; i != size; ++i) {
            node = new UniNode<>(node, new Object());
        }

        return List.of(
            TraversableUniNode.of(node)
        );
    }
}
