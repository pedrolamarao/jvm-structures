package br.dev.pedrolamarao.structure2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class OrderedIntegerBiTreeTest
{
    final Integer[] array = new Integer[size];

    static final int size = 15;

    @ParameterizedTest
    @MethodSource("trees")
    void find (BiBranchedCursor<Integer> node)
    {
        assertThat( BiBranched.findSorted(node, 8, Comparator.naturalOrder()) ).isNotNull();
        assertThat( BiBranched.findSorted(node, 6, Comparator.naturalOrder()) ).isNotNull();
        assertThat( BiBranched.findSorted(node, 13, Comparator.naturalOrder()) ).isNotNull();
        assertThat( BiBranched.findSorted(node, 21, Comparator.naturalOrder()) ).isNull();
    }

    List<BiBranchedCursor<Integer>> trees ()
    {
        return List.of(
            new BiBranchedArrayCursor<>(array.clone(),0)
        );
    }

    @BeforeAll
    void generate ()
    {
        array[ 0] = 8;     // 0
        array[ 1] = 3;     // 0.l
        array[ 2] = 10;    // 0.r
        array[ 3] = 2;     // 0.l.l
        array[ 4] = 6;     // 0.l.r
        array[ 5] = 9;     // 0.r.l
        array[ 6] = 14;    // 0.r.r
        array[ 7] = 0;     // 0.l.l.l
        array[ 8] = 1;     // 0.l.l.r
        array[ 9] = 4;     // 0.l.r.l
        array[10] = 7;     // 0.l.r.r
        array[11] = null;  // 0.r.l.l
        array[12] = null;  // 0.r.l.r
        array[13] = 13;    // 0.r.r.l
        array[14] = 19;    // 0.r.r.r
    }
}
